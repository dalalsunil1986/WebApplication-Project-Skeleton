package com.oneous.webapp.filter;

import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Sharafat Ibn Mollah Mosharraf (www.sharafat.co.uk)
 */
public class MDCFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //ignored
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        if (sessionId.length() > 8) {
            sessionId = sessionId.substring(0, 8);  //first 8 chars from session ID is sufficient to identify the session
        }
        MDC.put("sessionId", sessionId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            MDC.put("username", authentication.getName());
        }

        try {
            chain.doFilter(req, resp);
        } finally {
            MDC.remove("sessionId");
            if (authentication != null) {
                MDC.remove("username");
            }
        }
    }

    @Override
    public void destroy() {
        //ignored
    }
}
