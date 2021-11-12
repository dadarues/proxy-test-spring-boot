package com.leantech.proxytest;

import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimpleFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

	private RequestContext contextRequest;

	public SimpleFilter() {
		contextRequest = RequestContext.getCurrentContext();
	}

	public SimpleFilter(RequestContext contextRequest) {
		this.contextRequest = contextRequest;
	}

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

		contextRequest = (contextRequest.getRequest() == null) ? RequestContext.getCurrentContext() : contextRequest;
		StringBuffer strLog = new StringBuffer();
		Enumeration<String> enume;
		String header;

		strLog.append("\n------ REQUEST DATA ------\n");
		strLog.append(String.format("Server: %s Metodo: %s Path: %s \n", contextRequest.getRequest().getServerName(),
				contextRequest.getRequest().getMethod(), contextRequest.getRequest().getRequestURI()));
		enume = contextRequest.getRequest().getHeaderNames();
		while (enume.hasMoreElements()) {
			header = enume.nextElement();
			strLog.append(String.format("Headers: %s = %s \n", header, contextRequest.getRequest().getHeader(header)));
		}
		;

		log.info(strLog.toString());

		return null;
	}
}