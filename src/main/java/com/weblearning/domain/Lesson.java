package com.weblearning.domain;

import java.util.List;

/*Class to hold the information Lesson object formed from TopicDetail
 * This will return to UI a question with answers, titles and explanation
 * 
 */

public class Lesson {
	
	List<LessonBody> lessonBodyList;

	public List<LessonBody> getLessonBodyList() {
		return lessonBodyList;
	}

	public void setLessonBodyList(List<LessonBody> lessonBodyList) {
		this.lessonBodyList = lessonBodyList;
	}
	
	
}
