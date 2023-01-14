package com.amith.article_service.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.amith.article_service.util.constants.Header;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestHeaderValidationInterceptor implements HandlerInterceptor {

	Logger logger = LogManager.getFormatterLogger(RequestHeaderValidationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("Intercepting request HTTP headers ");

		boolean isHeaderValidationSuccess = true;

		if (request.getHeader(Header.CORELATION_ID.getName()) == null) {

			logger.error("Header %s is not available in the request ", Header.CORELATION_ID.getName());
			isHeaderValidationSuccess = false;

		} else if (request.getHeader(Header.AUTH.getName()) == null) {

			logger.error("Header %s is not available in the request ", Header.AUTH.getName());
			isHeaderValidationSuccess = false;
		}

		if (!isHeaderValidationSuccess) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}

		return true;
	}
}
