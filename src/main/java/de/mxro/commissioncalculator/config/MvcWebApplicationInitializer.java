package de.mxro.commissioncalculator.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * <p>Entry point for bootstrapping web server.
 * @author Max
 *
 */
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[] {AppConfig.class};
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { MvcWebConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
  
}
