package com.prapps.core.web.transformer;

import java.util.List;

import org.springframework.integration.Message;
import org.springframework.stereotype.Component;

import com.prapps.core.vo.Wrapper;

@Component
public class JsonWrapperTransformer {

	public Wrapper transform(Message<List<?>> message) {
		List collection = message.getPayload();
		if(null != collection && !collection.isEmpty()) {
			return new Wrapper(collection, 1);
		}
		return new Wrapper(collection);
	}
}
