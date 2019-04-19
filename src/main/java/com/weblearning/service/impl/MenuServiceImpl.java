package com.weblearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weblearning.domain.Grade;
import com.weblearning.domain.dao.GradeDAO;
import com.weblearning.service.MenuService;


@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService{

	
	@Autowired 
	GradeDAO gradeDAO;
	@Override
	@Transactional
	public List<Grade> getGradeList() {
		
		return gradeDAO.findAllGrades();
	}

}
