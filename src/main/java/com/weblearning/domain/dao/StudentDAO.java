package com.weblearning.domain.dao;

import com.weblearning.domain.MessageReturned;
import com.weblearning.domain.Student;

public interface StudentDAO {
	public MessageReturned saveStudent(Student student) ;
}
