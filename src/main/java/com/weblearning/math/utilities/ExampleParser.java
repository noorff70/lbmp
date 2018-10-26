package com.weblearning.math.utilities;

import com.weblearning.domain.Lesson;
import com.weblearning.domain.LessonBody;

import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import org.springframework.core.io.Resource;

public class ExampleParser {

	private static String configFile;
	//private static String configPicPath;
	private static Lesson lesson;
	private static List<Lesson> lessonList;
	private static LessonBody lessonBody;
	private static List<LessonBody> lessonBodyList;

	public static List<Lesson> getLessons(Resource resource/*, Resource path*/) {

		lessonList = null;
		lesson = null;
		String tagContent = null;

		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			configFile = resource.getFile().getAbsolutePath();
			//configPicPath = path.getFile().getAbsolutePath();

			InputStream in = new FileInputStream(configFile);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(in);
			
			while (reader.hasNext()) {
				int event = reader.next();

				switch (event) {

				case XMLStreamConstants.START_ELEMENT:
					if ("lessons".equals(reader.getLocalName())) {
						lessonList = new ArrayList<Lesson>();
					}
					if ("lesson".equals(reader.getLocalName())) {
						lesson = new Lesson();
						lessonBodyList = new ArrayList<LessonBody>();
					}
					if ("LessonBodies".equals(reader.getLocalName())) {
						lessonBody = new LessonBody();
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					tagContent = reader.getText().trim();
					break;

				case XMLStreamConstants.END_ELEMENT:
					switch (reader.getLocalName()) {

					case "lesson":
						lesson.setLessonBodyList(lessonBodyList);
						lessonList.add(lesson);
						break;
					case "LessonBodies":
						lessonBodyList.add(lessonBody);
						break;
					case "LessonHeader":
						lessonBody.setLessonHeader(tagContent);
						break;
					case "LessonBody":
						lessonBody.setLessonBody(tagContent);
						break;
					case "PicturePath":
						lessonBody.setPicturePath(tagContent);
						break;
					}
					
					break;
				case XMLStreamConstants.START_DOCUMENT:
					lessonList = new ArrayList<>();
					break;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return lessonList;
	}

}
