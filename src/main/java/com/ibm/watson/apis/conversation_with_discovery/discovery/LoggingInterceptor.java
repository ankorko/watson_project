package com.ibm.watson.apis.conversation_with_discovery.discovery;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ibm.watson.apis.conversation_with_discovery.rest.ProxyResource;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class LoggingInterceptor implements Interceptor {
	  private static final Logger logger = LogManager.getLogger(ProxyResource.class.getName());

	  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
	    Request request = chain.request();

	    long t1 = System.nanoTime();
	    logger.info(String.format("Sending request %s on %s%n%s",
	        request.url(), chain.connection(), request.headers()));

	    Response response = chain.proceed(request);

	    long t2 = System.nanoTime();
	    logger.info(String.format("Received response for %s in %.1fms%n%s",
	        response.request().url(), (t2 - t1) / 1e6d, response.headers()));

	    return response;
	  }
	}