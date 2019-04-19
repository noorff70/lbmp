package com.weblearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weblearning.domain.Grade;

@Service
public interface MenuService {
	
	public List<Grade> getGradeList();
	
}
