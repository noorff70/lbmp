package com.weblearning.math.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;


import org.springframework.core.io.Resource;

import com.weblearning.domain.GeometryObject;

public class GeometryParser {

	static String configFile;
	static GeometryObject gObject;


	public static List<GeometryObject> getQuestions(Resource resource, Resource picResource) {

		List<GeometryObject> gObjectList = null;
		String tagContent = null;

		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			configFile = resource.getFile().getAbsolutePath();

			InputStream in = new FileInputStream(configFile);
			XMLStreamReader reader = inputFactory.createXMLStreamReader(in);

			GeometryObject gObj = null;

			while (reader.hasNext()) {
				
				int event = reader.next();

				switch (event) {
				case XMLStreamConstants.START_ELEMENT:
					if ("problems".equals(reader.getLocalName())) {
						gObjectList = new ArrayList<GeometryObject>();
					}

					if ("problem".equals(reader.getLocalName())) {
						gObj = new GeometryObject();
					}
					break;

				case XMLStreamConstants.CHARACTERS:
					tagContent = reader.getText().trim();
					break;

				case XMLStreamConstants.END_ELEMENT:
					switch (reader.getLocalName()) {
					case "problem":
						gObjectList.add(gObj);
						break;
					case "slNo":
						gObj.setSlNo(tagContent);
						break;
					case "question":
						gObj.setQuestion(tagContent);
						break;
					case "pathToPicture":
						gObj.setPathToPicture(tagContent);
						break;
					
					}
					break;

				case XMLStreamConstants.START_DOCUMENT:
					gObjectList = new ArrayList<>();
					break;
				}

			}
		} catch (Exception e) {
		//	System.out.println(e);;
		}

		return gObjectList;
	}

}
