package com.weblearning.math.grade8.lessons;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.weblearning.domain.Lesson;
import com.weblearning.domain.LessonBody;
import com.weblearning.math.utilities.ExampleParser;

public class G8RatiosLs implements Lesson{
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	public List<LessonBody> getLessonList() {
		resourceLoader = new FileSystemResourceLoader();
	    Resource baseresource = resourceLoader.getResource( "classpath:/locale/math/grade8/lessons/G8Ratios.xml" );
	   // Resource picturePath = resourceLoader.getResource("classpath:/locale/math/grade8/lessons/");

	    List<LessonBody> lessonList = ExampleParser.getLessons(baseresource/*, picturePath*/);
	    
	    return lessonList;
	}

	/*@Override
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
	}*/

}
