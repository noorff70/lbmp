package com.weblearning.service;


import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public interface MessageResolveService{
	
    MessageSource getMessageSource(String grade);
}
