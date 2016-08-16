package com.ych.oc.web;

import com.ych.oc.data.OutliersDBCreator;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by ricyang on 16-7-27.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Resource
    private OutliersDBCreator dbCreator;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // GolfingAppConfig defines beans that would be in root-context.xml
        return new Class<?>[] {com.ych.oc.SpringAppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // GolfingWebConfig defines beans that would be in golfing-servlet.xml
        return new Class[] { WebConfig.class };
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
//        dbCreator.createTables();
//        dbCreator.insertDefaultValues();
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/rest/*" };
    }
}
