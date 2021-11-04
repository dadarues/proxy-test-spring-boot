package com.leantech.proxytest;

import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimpleFilter extends ZuulFilter {

	final static String SALTOLINEA = "\n";
	private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext contextRequest = RequestContext.getCurrentContext();

		StringBuffer strLog = new StringBuffer();
		Enumeration<String> enume;
		String header;

		strLog.append(SALTOLINEA + "------ REQUEST RECEIVED ------" + SALTOLINEA);
		strLog.append(String.format("Server: %s Method: %s Path: %s \n", contextRequest.getRequest().getServerName(),
				contextRequest.getRequest().getMethod(), contextRequest.getRequest().getRequestURI()));
		strLog.append(SALTOLINEA + "----- HEADERS -----" + SALTOLINEA);
		enume = contextRequest.getRequest().getHeaderNames();
		while (enume.hasMoreElements()) {
			header = enume.nextElement();
			Enumeration<String> valueHeaders = contextRequest.getRequest().getHeaders(header);
			while (valueHeaders.hasMoreElements()) {
				String value = valueHeaders.nextElement();
				strLog.append("Name:" + header + " Value: " + value + SALTOLINEA);
			}
		}

		log.info(strLog.toString());

		return null;
	}

}