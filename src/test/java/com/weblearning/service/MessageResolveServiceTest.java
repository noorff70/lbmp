package com.weblearning.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:root-context.xml"})
public class MessageResolveServiceTest {
	
	@Autowired
	MessageResolveService mService;

	
	@Before
	public void setup(){
		
	}
	
	@Test
	public void testGetMessageSource(){
		
		MessageSource source = mService.getMessageSource("6");
		
		assertNotNull(source);
	}

}
