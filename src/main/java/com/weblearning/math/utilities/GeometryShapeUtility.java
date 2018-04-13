package com.weblearning.math.utilities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.weblearning.domain.GeometryObject;
import com.weblearning.domain.utility.AngleObject;
import com.weblearning.domain.utility.CoordinateObject;
import com.weblearning.domain.utility.LineObject;
import com.weblearning.domain.utility.PolygonObject;
import com.weblearning.domain.utility.geometry.Triangle;

/*
 * This class reads an xml file and creates the coordinates and geometric object
 */
public class GeometryShapeUtility {
	
	
	
	public static List<GeometryObject> listOfTriangles(Document doc, int precision)
	{
		
		List<GeometryObject> geometryList = new ArrayList<GeometryObject>();
		
		
		Element docEle = doc.getDocumentElement();
		NodeList nodeList = docEle.getElementsByTagName("problem");
		

		for (int i = 0; i < nodeList.getLength(); i++) {
			
			//create a new GeometryObject
			GeometryObject geoObject = new GeometryObject();
			PolygonObject pObj = new PolygonObject();
			Triangle triangle = new Triangle();
			
			Node node = nodeList.item(i);

			if (null != node.getAttributes() && node.getAttributes().getNamedItem("type").getNodeValue().equals("Triangle"))
			{
				 if (node.getNodeType() == Node.ELEMENT_NODE) {
					 
					 int radius = MathUtilities.getRandomNumber(50, 100);
					 
					 Element e = (Element) node;
					 
					 NodeList basecoordinatesList = e.getElementsByTagName("basecoordinates");
					 for (int j=0; j<basecoordinatesList.getLength(); j++ ){
						 CoordinateObject baseCoordinate = new CoordinateObject();
						 Node baseNode = basecoordinatesList.item(j);
						 Element baseNodeElement = (Element) baseNode;
						 
						 NodeList xcoordinatenode = baseNodeElement.getElementsByTagName("xcoordinate");
						 NodeList ycoordinatenode = baseNodeElement.getElementsByTagName("ycoordinate");
						// String firstcoordinateValue = firstcoordinate.item(0).getChildNodes().item(0).getNodeValue();
						 
						 String xcoordinate = xcoordinatenode.item(0).getChildNodes().item(0).getNodeValue();
						 String ycoordinate = ycoordinatenode.item(0).getChildNodes().item(0).getNodeValue();
						 baseCoordinate.setxCoordinate(Double.valueOf(xcoordinate));
						 baseCoordinate.setyCoordinate(Double.valueOf(ycoordinate));
						 pObj.setCoordinateObject(baseCoordinate);
					 }
					 
					//create a list of coordinate objects
					 List<CoordinateObject> coordinateList = new ArrayList<CoordinateObject>();
					 
					 NodeList coordinatePointList = e.getElementsByTagName("coordinatePoint");
					 for (int j=0; j<coordinatePointList.getLength(); j++ )
					 {
						 
						 //Create a new CoordinateObject
						 CoordinateObject cObj = new CoordinateObject();
						 
						 Node coordinateNode = coordinatePointList.item(j);
						 Element coordinateElement = (Element) coordinateNode;
						 
						 //get the point name i.e A, B or C
						 String angleName = coordinateNode.getAttributes().getNamedItem("name").getNodeValue();
						 cObj.setPoint(angleName);
						 
						 NodeList radiusList = coordinateElement.getElementsByTagName("radius");
						 int radiusType = Integer.parseInt(radiusList.item(0).getChildNodes().item(0).getNodeValue());
						 
						 //set the coordinate points
						 NodeList angleNodeList = coordinateElement.getElementsByTagName("angle");
						 String angle = angleNodeList.item(0).getChildNodes().item(0).getNodeValue();
						 cObj.setxCoordinate(MathUtilities.setPrecision(radiusType* radius*Math.cos(MathUtilities.convertToRadian(Float.parseFloat(angle))), precision));
						 cObj.setyCoordinate(MathUtilities.setPrecision(radiusType *radius*Math.sin(MathUtilities.convertToRadian(Float.parseFloat(angle))), precision));
						 
						 //set the direction i.e line_to or move_to
						 NodeList directionList = coordinateElement.getElementsByTagName("direction");
						 String direction = directionList.item(0).getChildNodes().item(0).getNodeValue();
						 cObj.setDirection(direction);
						 
						 coordinateList.add(cObj);
						 
						 pObj.setCoordinateList(coordinateList);
						 geoObject.setPolygonObject(pObj);
					 }
					 
					 //get all the elements for angleobjects
					 List<AngleObject> angleObjectList = new ArrayList<AngleObject>();

						 //now gt the angleList
						 NodeList angleList = e.getElementsByTagName("anglepoint");
						 
						 for(int ang=0; ang<angleList.getLength(); ang++)
						 {
							 AngleObject angleObj = new AngleObject();
							 
							 Node angleNode = angleList.item(ang);
							 Element angleElement = (Element) angleNode;
							 String angleName = angleNode.getAttributes().getNamedItem("name").getNodeValue();
							 
							 NodeList anglev = angleElement.getElementsByTagName("anglevalue");
							 String anglevalue = anglev.item(0).getChildNodes().item(0).getNodeValue();
							
							 
							 NodeList anglelLeft = angleElement.getElementsByTagName("anglelocationleft");
							 String anglelocationleft = anglelLeft.item(0).getChildNodes().item(0).getNodeValue();
							 
							 NodeList anglelRight = angleElement.getElementsByTagName("anglelocationright");
							 String anglelocationright = anglelRight.item(0).getChildNodes().item(0).getNodeValue();
							 
							 CoordinateObject cObj = new CoordinateObject();
							 CoordinateObject cObjl = new CoordinateObject();
							 CoordinateObject cObjr = new CoordinateObject();
							 
							 List<?> cList = pObj.getCoordinateList();
							 for (int m=0; m<cList.size(); m++)
							 {
								 CoordinateObject cOrdinate = (CoordinateObject) cList.get(m);
								 if (cOrdinate.getPoint().equals(angleName))
								 {
									 cObj.setxCoordinate(cOrdinate.getxCoordinate());
									 cObj.setyCoordinate(cOrdinate.getyCoordinate());
									 //cObj.setxCoordinate(MathUtilities.setPrecision(radius*Math.cos(MathUtilities.convertToRadian(Float.parseFloat(anglevalue))), precision));
									 //cObj.setyCoordinate(MathUtilities.setPrecision(radius*Math.sin(MathUtilities.convertToRadian(Float.parseFloat(anglevalue))), precision));
									 angleObj.setDegreeValue(Float.parseFloat(anglevalue));
									 angleObj.setCenterC(cObj);
					
								 
									 cObjl.setxCoordinate(MathUtilities.setPrecision(radius/4*Math.cos(MathUtilities.convertToRadian(Float.parseFloat(anglelocationleft))), precision));
									 cObjl.setyCoordinate(MathUtilities.setPrecision(radius/4*Math.sin(MathUtilities.convertToRadian(Float.parseFloat(anglelocationleft))), precision));
									 angleObj.setLeftC(cObjl);
									
									 cObjr.setxCoordinate(MathUtilities.setPrecision(radius/4*Math.cos(MathUtilities.convertToRadian(Float.parseFloat(anglelocationright))), precision));
									 cObjr.setyCoordinate(MathUtilities.setPrecision(radius/4*Math.sin(MathUtilities.convertToRadian(Float.parseFloat(anglelocationright))), precision));
									 angleObj.setRightC(cObjr);
								 }
								 
							 } 
							
							 angleObj.setNameOfAngle(angleName);
							 angleObjectList.add(angleObj); 
							 
						 }
						 //angleObjectList.add(angleObj);	 
						 pObj.setAngleObjectList(angleObjectList);
						 
						 List <LineObject>lineObjectList = new ArrayList<LineObject>();
						 NodeList displaylabelList = e.getElementsByTagName("displaylabel");

						 for(int j=0; j< displaylabelList.getLength(); j++){
							 NodeList childList = e.getElementsByTagName("displaycoordinates");
							 for (int k = 0; k < childList.getLength(); k++) {
								 LineObject lineObj = new LineObject();
								 CoordinateObject cObj = new CoordinateObject();
								 
								 List<?> cList = pObj.getCoordinateList();
								 
								 Node displayNode = childList.item(k);
								 Element displayElement = (Element) displayNode;
								 
								 NodeList firstcoordinate = displayElement.getElementsByTagName("firstcoordinate");
								 String firstcoordinateValue = firstcoordinate.item(0).getChildNodes().item(0).getNodeValue();
								 																 
								 NodeList secondcoordinate = displayElement.getElementsByTagName("secondcoordinate");
								 String secondcoordinateValue = secondcoordinate.item(0).getChildNodes().item(0).getNodeValue();
								 
								 NodeList lengthtype = displayElement.getElementsByTagName("lengthtype");
								 String lengthtypeValue = lengthtype.item(0).getChildNodes().item(0).getNodeValue();
						         
								 CoordinateObject c1 = new CoordinateObject();
								 CoordinateObject c2 = new CoordinateObject();
								 for (int m=0; m<cList.size(); m++){
									 
									 
									 CoordinateObject cOrdinate = (CoordinateObject) cList.get(m);
									 
									 if (firstcoordinateValue.equals(cOrdinate.getPoint())){
										 c1.setxCoordinate(cOrdinate.getxCoordinate());
										 c1.setyCoordinate(cOrdinate.getyCoordinate());
									 }
									 
									 if (secondcoordinateValue.equals(cOrdinate.getPoint())){
										 c2.setxCoordinate(cOrdinate.getxCoordinate());
										 c2.setyCoordinate(cOrdinate.getyCoordinate());
									 }
									 
								 }
								 cObj.setxCoordinate((c1.getxCoordinate()+c2.getxCoordinate())/2);
								 cObj.setyCoordinate((c1.getyCoordinate()+c2.getyCoordinate())/2);
								 
								 lineObj.setCoordinateObject(cObj);
								 lineObj.setDistance(getDistanceBetweenCoordinates(c1, c2));
								 
								 if (lengthtypeValue.equals("base"))
									 triangle.setBase(Float.valueOf(getDistanceBetweenCoordinates(c1, c2)));
								 else if (lengthtypeValue.equals("height"))
									 triangle.setHeight(Float.valueOf(getDistanceBetweenCoordinates(c1, c2)));
								 

								 
								 lineObjectList.add(lineObj);
								 System.out.println();
							 }
						 }
						 
						 float area = (triangle.getBase()* triangle.getHeight())/2;
						 triangle.setArea(area);
						 
						 pObj.setLineObjectList(lineObjectList);
						 geoObject.setPolygonObject(pObj);
						 geoObject.setTriangle(triangle);
						 geometryList.add(geoObject);
				 }
				
			}

		}
		return geometryList;
	}
	
	public static String getDistanceBetweenCoordinates(CoordinateObject c1, CoordinateObject c2)
	{
		
		double xDiffSquare = Math.pow(c1.getxCoordinate()-c2.getxCoordinate(),2);
		double yDiffSquare = Math.pow(c1.getyCoordinate()-c2.getyCoordinate(),2);
		
		BigDecimal distance = new BigDecimal(Math.sqrt(xDiffSquare + yDiffSquare)).setScale(0,RoundingMode.HALF_EVEN);
		
		return distance.toString();
		
	}
}
