package com.weblearning.domain;

import java.util.List;

/*Class to hold the information Lesson object formed from TopicDetail
 * This will return to UI a question with answers, titles and explanation
 * 
 */

public interface Lesson {
	
	public List<LessonBody> getLessonList();
	
	
}
