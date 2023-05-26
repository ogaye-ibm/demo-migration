package com.bofa.demo.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LegacyFilter extends HttpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        System.out.println(" ***** Before filter, PreProcessing.....");
        // some authentication if required
        chain.doFilter(request, response);
        System.out.println(" ***** After filter, PostProcessing.....");
    }

}
