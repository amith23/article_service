package com.amith.article_service.interceptors;

import java.util.Enumeration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import com.amith.article_service.util.constants.Header;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestLoggingInterceptor implements HandlerInterceptor {

	Logger logger = LogManager.getFormatterLogger(RequestLoggingInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (logger.isInfoEnabled()) {

			logger.info("Request Method : %s | Request URI : %s | Request Parameters : %s ", request.getMethod(),
					request.getRequestURI(), getParameters(request));
		}

		return true;
	}

	private String getParameters(HttpServletRequest request) {

		StringBuffer posted = new StringBuffer();
		Enumeration<?> e = request.getParameterNames();

		if (e != null) {
			posted.append("?");
		}

		while (e.hasMoreElements()) {

			if (posted.length() > 1) {
				posted.append("&");
			}

			String curr = (String) e.nextElement();
			posted.append(curr + "=");
			posted.append(request.getParameter(curr));
		}

		String ip = request.getHeader(Header.X_FORWARDED_FOR.getName());
		String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;

		if (ipAddr != null && !ipAddr.equals("")) {
			posted.append("&requester ip =" + ipAddr);
		}
		return posted.toString();

	}

	private String getRemoteAddr(HttpServletRequest request) {

		String ipFromHeader = request.getHeader(Header.X_FORWARDED_FOR.getName());

		if (ipFromHeader != null && ipFromHeader.length() > 0) {

			logger.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
			return ipFromHeader;
		}
		return request.getRemoteAddr();
	}

}
