package com.bofa.demo.servlet.config;

import com.bofa.demo.servlet.controller.LegacyServlet;
import com.bofa.demo.servlet.listener.LegacyListener;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpSessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LegacyServletApplicationConfig {

    @Bean
    public ServletRegistrationBean<LegacyServlet> legacyServletBean() {
        var legacyServlet = new LegacyServlet();
        var srbean = new ServletRegistrationBean<LegacyServlet>();
        srbean.setServlet(legacyServlet);
        srbean.addUrlMappings("/legacy-servlet");

        return srbean;
        //or just return ServletRegistrationBean bean = new ServletRegistrationBean(new LegacyServlet(), "/legacy-servlet");
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> legacyServletHttpListenerBean() {
        /*ServletListenerRegistrationBean<HttpSessionListener> bean = new ServletListenerRegistrationBean();
        bean.setListener(new LegacyListener());
        return bean;*/
        return new ServletListenerRegistrationBean<HttpSessionListener>(new LegacyListener());
    }

    @Bean
     public ServletListenerRegistrationBean<ServletContextListener> legacyServletListenerBean() {
         ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean();
         bean.setListener(new LegacyListener());
         return bean;
     }

}
