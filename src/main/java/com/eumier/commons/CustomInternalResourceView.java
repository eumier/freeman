package com.eumier.commons;

import java.io.File;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.InternalResourceView;

public class CustomInternalResourceView extends InternalResourceView {

	
	   public boolean checkResource(Locale locale) throws Exception {
	        HttpServletRequest servletRequest = null;
	        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
	        if(requestAttributes instanceof ServletRequestAttributes) {
	            servletRequest = ((ServletRequestAttributes)requestAttributes).getRequest();
	        }

	        System.out.println(this.getUrl()+"ssss");
	        String filePath = servletRequest.getSession().getServletContext().getRealPath(this.getUrl());
	        File file = new File(filePath);
	        return file.exists();
	    }
}
