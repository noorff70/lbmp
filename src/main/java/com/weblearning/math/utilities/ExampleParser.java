package com.weblearning.math.utilities;

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
	private static LessonBody lesson;
	static List<LessonBody> lessonList;

	public static List<LessonBody> getLessons(Resource resource/*, Resource path*/) {

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
						lessonList = new ArrayList<LessonBody>();
					}
					if ("lesson".equals(reader.getLocalName())) {
						lesson = new LessonBody();
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					tagContent = reader.getText().trim();
					break;

				case XMLStreamConstants.END_ELEMENT:
					switch (reader.getLocalName()) {
					case "lesson":
						lessonList.add(lesson);
						break;
					case "LessonHeader":
						lesson.setLessonHeader(tagContent);
						break;
					case "LessonBody":
						lesson.setLessonBody(tagContent);
						break;
					case "PicturePath":
						lesson.setPicturePath(tagContent);
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
