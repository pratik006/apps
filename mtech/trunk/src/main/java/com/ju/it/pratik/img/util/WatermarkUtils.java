package com.ju.it.pratik.img.util;

import java.io.IOException;
import java.util.logging.Logger;

import com.ju.it.pratik.img.WMConsts;

public class WatermarkUtils {
	
	private static final Logger LOG = Logger.getLogger(WatermarkUtils.class.getName());

	public double[] blockWatermark(double[] input,int height, int width, int[] watermark) {
		double[][] modInput = new double[width][height];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				modInput[i][j] = input[i*width+j];
			}
		}
		double[][] result =  blockWatermark(modInput, watermark);
		double[] finalResult = new double[input.length];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				finalResult[i*width+j] = result[i][j];
			}
		}
		return finalResult;
	}
	
	public double[][] blockWatermark(double[][] input, int[] watermark) {
		double[][] result = new double[input.length][input[0].length];
		for(int i=0;i<input.length;i=i+8) {
			for(int j=0;j<input[0].length;j=j+8) {
				blockWatermark(input, i, j, watermark, result);
			}
		}
		return result;
	}
	
	public void blockWatermark(double[][] input,int startX, int startY, int[] watermark, double[][] result) {
		int wmch;
		for(int i=startX;i<startX+8;i++) {
			wmch = watermark[(i+startY)%watermark.length];
			//LOG.fine(""+(char)wmch);
			for(int j=startY;j<startY+8;j++) {
				int iPart = (int) input[i][j];
				double fPart = input[i][j] - (double)iPart;
				int intValInput = (int)Double.doubleToRawLongBits(input[i][j]);
				//System.out.println(Integer.toBinaryString(iPart)+" --------- ");
				int intValWatermark = 0;
				switch(j-startY) {
				case 0:intValWatermark = wmch & 0x01;
					break;
				case 1:intValWatermark = (wmch >> 1 ) & 0x01;
					break;
				case 2:intValWatermark = (wmch >> 2 ) & 0x01;
					break;
				case 3:intValWatermark = (wmch >> 3 ) & 0x01;
					break;
				case 4:intValWatermark = (wmch >> 4 ) & 0x01;
					break;
				case 5:intValWatermark = (wmch >> 5 ) & 0x01;
					break;
				case 6:intValWatermark = (wmch >> 6 ) & 0x01;
					break;
				case 7:intValWatermark = (wmch >> 7 ) & 0x01;
					break;
				}
				
				/*intValWatermark = wmch<<31-j;
				intValWatermark = intValWatermark>>31;*/
				/*System.out.println(Integer.toBinaryString(intValWatermark)+" --------- ");
				System.out.println(((intValInput ^ intValWatermark)&0x01)+" ");*/
				int xor_res = 0;
				
				if(input[i][j] < 0) {
					iPart = ~iPart + 1;
					//xor_res = ((iPart&0x01) + intValWatermark) & 0x01;
					if(startY<8 && startX<8) {
						LOG.fine((iPart&0x01)+"\t"+intValWatermark+"\t"+xor_res+"\t"+(char)wmch);
					}
					result[i][j] = (float)(~((iPart & 0xFFFFFFFE) | (intValWatermark & 0x01))+1)+fPart;
				}
				else {
					xor_res = ((iPart&0x01) + intValWatermark) & 0x01;
					if(startY<8 && startX<8) {
						LOG.fine((iPart&0x01)+"\t"+intValWatermark+"\t"+xor_res+"\t"+(char)wmch);
					}
					result[i][j] = (float)((iPart & 0xFFFFFFFE) | (intValWatermark & 0x01))+fPart;
				}
				
				//LOG.fine(input[i][j]+" >> "+result[i][j]);
				/*if(input[i][j] - result[i][j] > 0)
					System.out.println("diff = "+(input[i][j] - result[i][j]));*/
				/*System.out.println(Integer.toBinaryString(intValInput ^ intValWatermark));*/
				//System.out.println();
			}
		}
	}
	
	public int[] recoverBlockWatermark(double[] input,int height, int width, int[] watermark) {
		double[][] modInput = new double[width][height];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				modInput[i][j] = input[i*width+j];
			}
		}
		return recoverBlockWatermark(modInput, watermark);
	}
	
	public int[] recoverBlockWatermark(double[][] input, int[] watermark) {
		int[] result = new int[input.length*input[0].length/8];
		for(int i=0;i<input.length;i=i+8) {
			for(int j=0;j<input[0].length;j=j+8) {
				recoverBlockWatermark(input, i, j, watermark, result);
			}
		}
		return result;
	}
	
	public void recoverBlockWatermark(double[][] input,int startX, int startY, int[] watermark, int[] result) {
		//int wmch;
		for(int i=startX;i<startX+8;i++) {
			int tmp = 0, ctr=0;
			//wmch = watermark[(i+startY)%watermark.length];
			//LOG.fine(""+(char)wmch);
			for(int j=startY+7;j>=startY;j--) {				
				int iPart = (int) input[i][j];
				/*double fPart = input[i][j] - (double)iPart;

				int intValInput = (int)Double.doubleToLongBits(input[i][j]);				
				int intValWatermark = 0;
				
				switch(j-startY) {
					case 0:intValWatermark = wmch & 0x01;
						break;
					case 1:intValWatermark = (wmch >> 1 ) & 0x01;
						break;
					case 2:intValWatermark = (wmch >> 2 ) & 0x01;
						break;
					case 3:intValWatermark = (wmch >> 3 ) & 0x01;
						break;
					case 4:intValWatermark = (wmch >> 4 ) & 0x01;
						break;
					case 5:intValWatermark = (wmch >> 5 ) & 0x01;
						break;
					case 6:intValWatermark = (wmch >> 6 ) & 0x01;
						break;
					case 7:intValWatermark = (wmch >> 7 ) & 0x01;
						break;
				}*/
				//int xor_res = (intValInput & 0x01) ^ intValWatermark;
				
				
				/*int xor_res = 0;				
				if(input[i][j] < 0) {
					iPart = ~iPart + 1;
					xor_res = ((iPart&0x01) + intValWatermark) & 0x01;
					if(startY<8 && startX<8) {
						LOG.fine((iPart&0x01)+"\t"+intValWatermark+"\t"+xor_res+"\t"+(char)wmch);
					}
				}
				else {
					xor_res = ((iPart&0x01) + intValWatermark) & 0x01;
					if(startY<8 && startX<8) {
						LOG.fine((iPart&0x01)+"\t"+intValWatermark+"\t"+xor_res+"\t"+(char)wmch);
					}
				}*/
				//System.out.print(iPart & 0x01);
				tmp = (tmp | iPart & 0x01);
				
				/*int xor_res = (iPart - intValWatermark) & 0x01;
				if(startY<8 && startX<8)
					LOG.fine((iPart&0x01)+"\t"+intValWatermark+"\t"+xor_res+"\t"+(char)wmch);
				tmp = (tmp | xor_res);*/
				if(ctr++<7) {
					tmp = tmp<<1;
				}
				
			}
			result[i+startY] = tmp;
			
		}
		//System.out.println();
	}
	
	public double checkWatermarkRecovery(double[] input,int height, int width, int[] watermark, int startX, int startY) {
		double[][] modInput = new double[width][height];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				modInput[i][j] = input[i*width+j];
			}
		}
		return checkWatermarkRecovery(modInput, startX, startY, watermark);
	}
	
	public double checkWatermarkRecovery(double[][] input,int startX, int startY, int[] watermark) {
		double score = 0d;
		double maxScore = 0d;
		int[] res = new int[8];
		
		for(int i=startX;i<startX+8;i++) {
			int tmp = 0, ctr=0;
			for(int j=startY+7;j>=startY;j--) {				
				int iPart = (int) input[i][j];				
				tmp = (tmp | iPart & 0x01);
				if(ctr++<7) {
					tmp = tmp<<1;
				}				
			}
			res[i-startX] = tmp;
		}
			
		for(int k=0;k<watermark.length;k++) {
			score = 0d;
			for(int i=0;i<8;i++) {
				if(watermark[(k+i)%watermark.length] == res[i]) {
					score++;
				}
			}
			score = score/8;
			if(score > 0.125) {
				System.out.println(res);
			}
			if(maxScore < score)
				maxScore = score;
		}		
		return maxScore;
	}
	
	
	
	
	
	
	
	public String readWatermark(int[] watermark) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<watermark.length;i++) {
			int avg = ((watermark[i] & 0xFF) + (watermark[i]>>8 & 0xFF) + (watermark[i]>>16 & 0xFF))/3;
			sb.append(String.format("%8s", Integer.toBinaryString(avg)).replace(' ', '0'));
		}
		return sb.toString();
	}
	
	public String readBinaryWatermark(int[] watermark) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<watermark.length;i++) {
			int avg = ((watermark[i] & 0xFF) + (watermark[i]>>8 & 0xFF) + (watermark[i]>>16 & 0xFF))/3;
			if(avg>=128) {
				sb.append(1);
			}
			else {
				sb.append(0);
			}
		}
		return sb.toString();
	}
	
	public int[] readBinaryWatermark1(int[] watermark) {
		int[] result = new int[watermark.length];
		for(int i=0;i<watermark.length;i++) {
			int avg = ((watermark[i] & 0xFF) + (watermark[i]>>8 & 0xFF) + (watermark[i]>>16 & 0xFF))/3;
			if(avg>=128) {
				result[i] = 1;
			}
			else {
				result[i] = 0;
			}
		}
		return result;
	}
	
	public void writeWatermark(String str) {
		int[] image = new int[str.length()/8];
		int ctr = 0, tmp;		
		for(int i=0;i<str.length();i=i+8) {
			tmp = Integer.parseInt(str.substring(i, i+8), 2);
			image[ctr++] = (tmp<<16) | tmp<<8 | tmp;
		}
		try {
			ImageUtils.saveRGBImage(16, 32, image, WMConsts.RESOURCE_IMAGES + "output/" + "recoveredWatermark.bmp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeBinaryWatermark(String str) {
		int[] image = new int[str.length()];
		int ctr = 0;		
		for(int i=0;i<str.length();i++) {
			if(Character.getNumericValue(str.charAt(i)) == 1) {
				image[ctr++] = 0xFFFFFF;
			}
			else {
				image[ctr++] = 0;
			}
		}
		try {
			ImageUtils.saveRGBImage(16, 32, image, WMConsts.RESOURCE_IMAGES + "output/" + "recoveredWatermark.bmp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeBinaryWatermark(String str, int width, int height) {
		int[] image = new int[str.length()];
		int ctr = 0;		
		for(int i=0;i<str.length();i++) {
			if(Character.getNumericValue(str.charAt(i)) == 1) {
				image[ctr++] = 0xFFFFFF;
			}
			else {
				image[ctr++] = 0;
			}
		}
		try {
			ImageUtils.saveRGBImage(width, height, image, WMConsts.RESOURCE_IMAGES + "output/" + "recoveredWatermark.bmp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] toBWImageArray(String str, int width, int height) {
		int[] image = new int[str.length()];
		int ctr = 0;		
		for(int i=0;i<str.length();i++) {
			if(Character.getNumericValue(str.charAt(i)) == 1) {
				image[ctr++] = 0xFFFFFF;
			}
			else {
				image[ctr++] = 0;
			}
		}
		return image;
	}
	
	public int[] toBWImageArray(int[] arr, int width, int height) {
		int ctr = 0;		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == 1) {
				arr[ctr++] = 0xFFFFFF;
			}
			else {
				arr[ctr++] = 0;
			}
		}
		return arr;
	}
	
	public String byteToBinaryString(byte byt) {
		return String.format("%8s", Integer.toBinaryString(byt & 0xFF)).replace(' ', '0');
	}
}
