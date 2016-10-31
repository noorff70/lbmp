package com.weblearning.service;


import org.springframework.context.MessageSource;


public interface MessageResolveService{
	
    MessageSource getMessageSource(String grade);
}
