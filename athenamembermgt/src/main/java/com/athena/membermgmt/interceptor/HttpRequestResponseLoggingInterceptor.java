package com.athena.membermgmt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

@Component
public class HttpRequestResponseLoggingInterceptor implements AsyncHandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		request.getHeaderNames().asIterator().forEachRemaining(headerName -> {
			System.out.println(headerName + ": " + request.getHeader(headerName));
		});

		return AsyncHandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		response.getHeaderNames().stream().forEach(headerName -> {
			System.out.println(headerName + ": " + response.getHeader(headerName));
		});

		AsyncHandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
