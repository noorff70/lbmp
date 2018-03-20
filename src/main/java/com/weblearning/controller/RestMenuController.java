package com.weblearning.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weblearning.domain.MenuObject;
import com.weblearning.domain.MenuSubject;
import com.weblearning.domain.Subject;
import com.weblearning.domain.Grade;
import com.weblearning.service.MenuService;

@RestController
public class RestMenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public List<MenuObject> menus () {
		
		List<MenuObject> menuList = new ArrayList<MenuObject>();
		
		List<Grade> gradeList = menuService.getGradeList();
		
		for (int i=0; i< gradeList.size(); i++) {
			MenuObject mObject = new MenuObject();
			
			Grade g = gradeList.get(i);
			mObject.setGradeName(g.getGradeName());;
			mObject.setGradeId(g.getGradeId());
			
			List<Subject> subjectList = new ArrayList<Subject>();
			subjectList.addAll(g.getSubjects());
			
			List<MenuSubject> menuSubjectList = new ArrayList<MenuSubject>();
			for (int j =0; j< subjectList.size(); j++) {
				MenuSubject ms = new MenuSubject();
				Subject s = subjectList.get(j);
				ms.setSubjectName(s.getSubjectName());
				ms.setId(s.getSubjectId());
				menuSubjectList.add(ms);
			}
			
			mObject.setSubjects(menuSubjectList);
			
			menuList.add(mObject);
		}
		
		return menuList;
	}

}
