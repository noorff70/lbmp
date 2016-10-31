package com.weblearning.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import com.weblearning.service.MessageResolveService;


@Service("messageResolveService")
public class MessageResolverServiceImpl implements MessageResolveService{
    
	private static final Logger logger = Logger.getLogger(MessageResolverServiceImpl.class);


	@Override
	public MessageSource getMessageSource(String grade) {
		
		String path= getPath(grade);
		String baseName = "classpath://locale//math//" + path ;
        
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(baseName);
        
        logger.info("Message Path is {0}, baseName+path");
        
        //messageSource.setBasenames("classpath:/locale/math/grade6/mgrade6");
        return messageSource;
	}
	
	public String getPath(String gradeId){
		
		if (Integer.parseInt(gradeId)==6){
			return "grade6//mgrade6";
		}
		
		return null;
		
	}


}
