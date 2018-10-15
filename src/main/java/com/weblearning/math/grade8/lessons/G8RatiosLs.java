package com.weblearning.math.grade8.lessons;

import java.util.LinkedList;
import java.util.List;

import com.weblearning.domain.Lesson;
import com.weblearning.domain.LessonBody;

public class G8RatiosLs implements Lesson{

	@Override
	public List<LessonBody> getLessonList() {

		List<LessonBody> lessonList = new LinkedList<LessonBody>();
		
		LessonBody ls1 = new LessonBody();
		ls1.setLessonHeader("Test1 Header");
		ls1.setLessonBody("Test1 Body");
		
		LessonBody ls2 = new LessonBody();
		ls2.setLessonHeader("Test2 Header");
		ls2.setLessonBody("Test2 Body");
		
		LessonBody ls3 = new LessonBody();
		ls3.setLessonHeader("Test3 Header");
		ls3.setLessonBody("Test3 Body");
		
		LessonBody ls4 = new LessonBody();
		ls4.setLessonHeader("Test4 Header");
		ls4.setLessonBody("Test4 Body");
		
		LessonBody ls5 = new LessonBody();
		ls5.setLessonHeader("Test5 Header");
		ls5.setLessonBody("Test5 Body");
		
		lessonList.add(ls1);
		lessonList.add(ls2);
		lessonList.add(ls3);
		lessonList.add(ls4);
		lessonList.add(ls5);
				
		return lessonList;
	}

}
