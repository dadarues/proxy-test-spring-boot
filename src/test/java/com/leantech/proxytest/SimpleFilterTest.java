package com.leantech.proxytest;
import com.netflix.zuul.context.RequestContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class SimpleFilterTest {


    private SimpleFilter simpleFilter;

    @Mock
    private RequestContext requestContext;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private Enumeration<String> headers;

    private static final String SERVER_NAME = "my-server";
    private static final String GET_METHOD = "GET";
    private static final String URI = "/lean";
    private static final String HEADER_HOST = "/lean";


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        Mockito.when(requestContext.getRequest()).thenReturn(httpServletRequest);
        Mockito.when(httpServletRequest.getServerName()).thenReturn(SERVER_NAME);
        Mockito.when(httpServletRequest.getMethod()).thenReturn(GET_METHOD);
        Mockito.when(httpServletRequest.getRequestURI()).thenReturn(URI);
        Mockito.when(httpServletRequest.getHeaderNames()).thenReturn(headers);
        Mockito.when(headers.hasMoreElements()).thenReturn(true,false);
        Mockito.when(headers.nextElement()).thenReturn(HEADER_HOST);
        Mockito.when(httpServletRequest.getHeader(HEADER_HOST)).thenReturn("HEADER_HOST");

        simpleFilter = new SimpleFilter(requestContext);
    }

    @Test
    public void testRun(){
        Object response = simpleFilter.run();
        Assert.assertNull(response);
    }


}
