/*package com.weblearning.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.weblearning.domain.dao.GradeDAO;

@Component
public class MenuController implements ApplicationContextAware{
	
	private GradeDAO gradeDAO;
	
	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;
   	
	Returns a list of grades from DB
	 * 
			
	@SuppressWarnings("unchecked")
	public List<?> getdata(){
		
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("root-context.xml");  
		gradeDAO = (GradeDAO) appContext.getBean("gradeDAO"); 

		@SuppressWarnings("rawtypes")
		List gradelist = new ArrayList();
		gradelist.addAll(gradeDAO.findAllGrades());

		return gradelist;
	
	}

	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		this.applicationContext = appContext;
		
	}
	
}
*/