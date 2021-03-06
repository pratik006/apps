package com.ju.it.pratik.img.test.watermark;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import com.ju.it.pratik.img.Image;
import com.ju.it.pratik.img.WMConsts;
import com.ju.it.pratik.img.util.ImageMatcher;
import com.ju.it.pratik.img.util.ImageUtils;
import com.ju.it.pratik.img.util.NoiseAnalysisResult;
import com.ju.it.pratik.img.util.NoiseAnalysisUtil;
import com.ju.it.pratik.img.util.Sobel;
import com.ju.it.pratik.img.util.TransformUtils;
import com.ju.it.pratik.img.util.WatermarkUtils;
import com.ju.it.pratik.img.util.WaveletTransformer;

public class AbstractWatermarkTester implements WMConsts {

	private static final Logger LOG = Logger.getLogger(AbstractWatermarkTester.class.getName());
	
	protected String inputImage;
	protected String outputImage;
	protected String watermarkedImageName;
	protected WatermarkUtils watermarkUtils;
	protected NoiseAnalysisUtil noiseAnalysisUtil;
	protected NoiseAnalysisResult result;
	protected int level = 2;
	protected double dwt2Doriginal[][];
	protected Image origLogo;
	protected Image src;
	protected String folderName;
	private String cname;
	
	public void setUp(String inputImage) {
		this.inputImage = inputImage;
		folderName = inputImage.substring(0, inputImage.indexOf("_"))+"/";
		outputImage = inputImage.substring(0, inputImage.lastIndexOf("."))+"_wm";
		watermarkUtils = new WatermarkUtils();
		noiseAnalysisUtil = new NoiseAnalysisUtil();
		cname = this.getClass().getName();
		cname = cname.substring(cname.lastIndexOf(".")+1, cname.lastIndexOf("Watermark")).toLowerCase()+"/";
		try {
			origLogo = new Image(WMConsts.WATERMARK_LOGO);
			src = new Image(RESOURCE_IMAGES + inputImage);
			dwt2Doriginal = WaveletTransformer.discreteWaveletTransform(src.getU(), level);
			//int[] recoveredImage = watermarkUtils.toBWImageArray(watermarkStr, origLogo.getWidth(), origLogo.getHeight());
			//ImageUtils.saveImage(recoveredImage, origLogo.getWidth(), origLogo.getHeight(), new File(WMConsts.WATERMARK_LOGO.replace(".bmp", "1.bmp")), "bmp");
			LOG.info("watermarkStr len: "+origLogo.getBinaryImage1D().length+"\twatermarkStr: "+Arrays.toString(origLogo.getBinaryImage1D()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void postWatermark(int[][] idwt2D) throws IOException {
		int[][] resYUV = ImageUtils.mergeChannels(src.getY(), idwt2D, src.getV());
		int[] resYUV1D = ImageUtils.to1D(resYUV);
		
		/** converting YUV to RGB starts */
		int convertedRgb[] = new int[resYUV1D.length];
		for(int i=0;i<convertedRgb.length;i++) {
			convertedRgb[i] = TransformUtils.yuv2rgb(resYUV1D[i]);
		}
		/** converting YUV to RGB ends */
		
		/** saving the image */
		new File(WATERMARKED_IMAGES +cname+outputImage + ".jpg").delete();
		new File(WATERMARKED_IMAGES +cname+outputImage + ".bmp").delete();
		BufferedImage outputBufferedImage = ImageUtils.toBufferedImage(convertedRgb, src.getWidth(), src.getHeight());
		ImageIO.write(outputBufferedImage, "jpg", new File(WATERMARKED_IMAGES +cname+folderName+outputImage + ".jpg"));
		ImageIO.write(outputBufferedImage, "BMP", new File(WATERMARKED_IMAGES + cname+folderName+outputImage + ".bmp"));
		LOG.info("saving watermarked file to "+WATERMARKED_IMAGES +cname+folderName+outputImage + ".bmp");
		
		NoiseAnalysisResult noiseAnalysisResult = noiseAnalysisUtil.calculatePSNR(RESOURCE_IMAGES + inputImage, 
				WATERMARKED_IMAGES + cname+folderName+inputImage.replace(".bmp", "_wm.bmp"));
		LOG.info("noiseAnalysisResult: "+noiseAnalysisResult);
		//testRecoverWaveletWatermark();
	}
	
	protected void postWMRetrieval(int[] recoveredLogo) throws IOException {
		System.out.println("Original: "+Arrays.toString(origLogo.getBinaryImage1D()));
		System.out.println("Recoverd: "+Arrays.toString(recoveredLogo));
		recoveredLogo = watermarkUtils.toBWImageArray(recoveredLogo, origLogo.getWidth(), origLogo.getHeight());		
		String recWMFileName = WATERMARKED_IMAGES+cname+folderName+"recovered/"+watermarkedImageName.replaceFirst(".jpg",  ".bmp");
		ImageUtils.saveImage(recoveredLogo, origLogo.getWidth(), origLogo.getHeight(), new File(recWMFileName), "bmp");
		result = noiseAnalysisUtil.calculatePSNR(WATERMARK_LOGO, recWMFileName);
		LOG.info(result+"");
	}
	
	protected Image recoverCrop(String target) throws IOException, InterruptedException {
		ImageMatcher m = new ImageMatcher();
		m.getStartingPixel(WATERMARKED_IMAGES + cname + folderName + target.replace("_crop.jpg", ".jpg"), WATERMARKED_IMAGES + cname + folderName + target);
		return new Image(WATERMARKED_IMAGES+cname+folderName+target.replace(".jpg", "_recovered.bmp"));
	}
	
	protected Image recoverRotatedImage(String fileName) throws IOException {
		int threshold = 100;
		Image imgSrc = new Image(RESOURCE_IMAGES+inputImage, 64, 64, 448, 448);
		Image rotatedImage = new Image(WATERMARKED_IMAGES+cname+folderName+fileName, 64, 64, 448, 448);
		Sobel edgeDetector = new Sobel();		
		edgeDetector.setThreshold(threshold);
		
		int[] gradImgSrc = new int[imgSrc.getWidth()*imgSrc.getHeight()];
		edgeDetector.init(imgSrc.getBlue(), imgSrc.getWidth(), imgSrc.getHeight());
		gradImgSrc = edgeDetector.process();
		ImageUtils.saveImage(gradImgSrc, imgSrc.getWidth(), imgSrc.getWidth(), new File("src/test/resources/test1.bmp"), "BMP");
		edgeDetector.init(rotatedImage.getBlue(), rotatedImage.getWidth(), rotatedImage.getHeight());
		int[] gradImgTarget = edgeDetector.process();
		ImageUtils.saveImage(gradImgTarget, rotatedImage.getWidth(), rotatedImage.getWidth(), new File("src/test/resources/test2.bmp"), "BMP");		
		int angle = new ImageMatcher().getBestRotationMatch(gradImgSrc, imgSrc.getHeight(), imgSrc.getWidth(), gradImgTarget, rotatedImage.getHeight(), rotatedImage.getWidth());
		System.out.println("angle: "+angle);
		
		rotatedImage = new Image(WATERMARKED_IMAGES+cname+folderName+watermarkedImageName);
		rotatedImage.rotate(angle);
		rotatedImage.save(new File("src/test/resources/test3.jpg"), "jpg");
		return rotatedImage;
	}
	
}
