/**
 * 
 */

function drawShape(geometryQuestions, geometryCanvas) {

	var canvas = document.getElementById('geometryCanvas');
	var ctx = canvas.getContext('2d');
	ctx.beginPath();
	
	var lineObjects = geometryQuestions.lineObject;
	var polygonObjects = geometryQuestions.polygonObject;
	

	//draw the lines- geometryobject has lineobject list; lineobjectlist has coordinatelist
	if (lineObjects !=null){
		drawLines(lineObjects, ctx);
	}

	if (polygonObjects !=null)
	{
		//if (polygonObjects.angleList != null){
		//	drawPolygon(polygonObjects, ctx);
		//}
		
		if (polygonObjects.coordinateList != null){
			drawCoordinates(polygonObjects, ctx);
		}
		
		//drawTest(ctx);
	}
}

function drawLines(lineObjects, ctx){

	for (var j=0; j<lineObjects.length; j++ ){
	
		var line = lineObjects[j];
		drawLine(line, ctx);

	}
}

function drawLine (line, ctx){
	
	var firstCoordinate = line.coordinateObject[0];
	var secondCoordinate = line.coordinateObject[1];
	
	ctx.moveTo(firstCoordinate.xCoordinate, firstCoordinate.yCoordinate);
	ctx.lineTo(secondCoordinate.xCoordinate, secondCoordinate.yCoordinate);
	
	ctx.stroke();

}

function drawPolygon(polygonObjects, ctx) {

	ctx.beginPath();
	
	var noOfSides = polygonObjects.noOfSides;
	var radius = polygonObjects.radius;
	var coordinateObject= polygonObjects.coordinateObject;
	var angleList = polygonObjects.angleObjectList;
	
	var x = coordinateObject.xCoordinate;
	var y = coordinateObject.yCoordinate;

	//convert the angle List to an array of x,y coordinates
	var arrayList = Create2DArray(angleList, x, y);
	ctx.translate(x,y);

	//move to the first x,y point
	ctx.moveTo(radius*arrayList[0][0], radius*arrayList[0][1]);
	ctx.fillText(arrayList[0][2], radius*arrayList[0][0]+5, radius*arrayList[0][1]+5);
	//create lines from the first point
	for (var i=1; i< arrayList.length; i++){
		var xi= radius*arrayList[i][0];
		var yi= radius*arrayList[i][1];
		
		var xIncr = 0;
		var yIncr = 0;
		
		ctx.lineTo(xi, yi);
		//alert(arrayList[i-1][0] );
		if (arrayList[i][0] > arrayList[i-1][0]){
			xIncr = 10;alert(xIncr);
		}
		if (arrayList[i][1]> arrayList[i][1]){
			yIncr = 10;alert(yIncr);
		}
		
		ctx.fillText(arrayList[i][2], radius*arrayList[i][0]+ xIncr, radius*arrayList[i][1] + yIncr);
		ctx.stroke();
	}
	//make the line from the last to first coordinate
	ctx.lineTo(radius*arrayList[0][0], radius*arrayList[0][1]);
	ctx.stroke();


	ctx.closePath();
}

//return PI value based on degrees
function piValue(angleList, i){
	//get the object from angle list
	angleObject = angleList[i];
	//get the degree
	angleInDegree = angleObject.degreeValue;

	//return PI value/radians
	if (angleInDegree ==0)
		return Math.PI * 2;
	if (angleInDegree ==90)
		return Math.PI * 3/2;
	if (angleInDegree ==180)
		return Math.PI;
	
}

//create list of x,y coordinates

function Create2DArray(angleList, x, y) {
	  var arr = [];

	  //initialize a two dimensional array for x and y coordinate
	  for (var i=0;i<angleList.length;i++) {
	     arr[i] = [];
	  }
	  
	  for (var i=0; i<angleList.length; i++)
	  {
		  for (var j=0; j<=2; j++){
			  if (j==0)//x coordinate
			  {
				  var xPos = Math.cos(piValue(angleList, i));
				  arr[i][0]= xPos;
			  }
			  if (j==1)//y coordinate
			  {
				  var yPos = Math.sin(piValue(angleList, i));
				  arr[i][1] = yPos;

			  }
			  if (j==2)
			  {
				  arr[i][2] = angleList[i].nameOfAngle;
			  }
		  }
		  
	  }
	 // alert(arr[0][0] + " " + arr[0][1] + " "  +arr[0][2]);
	 // alert(arr[1][0] + " " + arr[1][1] + " "  +arr[1][2]);
	 // alert(arr[2][0] + " " + arr[2][1] + " "  +arr[2][2]);
	  return arr;
	}

function drawCoordinates(polygonObjects, ctx)
{
	
	ctx.beginPath();
	
	coordinateList = polygonObjects.coordinateList;

	var noOfSides = polygonObjects.noOfSides;
	var radius = polygonObjects.radius;
	var coordinateObject= polygonObjects.coordinateObject;
	var angleList = polygonObjects.angleObjectList;
	var lineObjectList = polygonObjects.lineObjectList;

	var x = coordinateObject.xCoordinate;
	var y = coordinateObject.yCoordinate;
	
	ctx.translate(x,y);


	ctx.moveTo(coordinateList[0].xCoordinate, coordinateList[0].yCoordinate);
	ctx.fillText(coordinateList[0].point, coordinateList[0].xCoordinate, coordinateList[0].yCoordinate);
	
	for (var i=1; i<coordinateList.length; i++)
	{
		var xIncr=0;
		var yIncr =0;
		
		if (coordinateList[i].direction=="lineTo")
		{
			ctx.lineTo(coordinateList[i].xCoordinate, coordinateList[i].yCoordinate);
			ctx.stroke();
			if (showDistance(coordinateList, i)){
			//	writeDistance(coordinateList, i, ctx);
			}
		}
		else if (coordinateList[i].direction=="moveTo"){
			ctx.moveTo(coordinateList[i].xCoordinate, coordinateList[i].yCoordinate);
		}
		
		//position of x and y coordinate to be incremented
		xIncr = CoordinateIncrementForText(coordinateList, i);
		yIncr = CoordinateIncrementForText(coordinateList, i);
		ctx.fillText(coordinateList[i].point, coordinateList[i].xCoordinate +xIncr , coordinateList[i].yCoordinate + yIncr);
		
	}
	
	ctx.lineTo(coordinateList[0].xCoordinate, coordinateList[0].yCoordinate);
	ctx.stroke();
	
	for (var i=0; i<angleList.length; i++)
	{
		var leftC = angleList[i].leftC;
		var rightC = angleList[i].rightC;
		var centerC = angleList[i].centerC;
		//alert(leftC.xCoordinate + "  " + rightC.xCoordinate + " "  + centerC.xCoordinate);
		var midxPoint = centerC.xCoordinate - (leftC.xCoordinate + rightC.xCoordinate)/2;
		var midyPoint = centerC.yCoordinate + (leftC.yCoordinate + rightC.yCoordinate)/2;

		ctx.fillText(angleList[i].degreeValue,midxPoint, midyPoint );
		
	}
	

	if (lineObjectList != null) {

		for (var i = 0; i < lineObjectList.length; i++) {
			var cObj = lineObjectList[i].coordinateObject;
			var distance = lineObjectList[i].distance;
			ctx.fillText(distance, cObj.xCoordinate + 5, cObj.yCoordinate + 5);
		}
	}
	
	
	ctx.closePath();
	
}

function CoordinateIncrementForText(coordinateList, i)
{
	if (coordinateList[i].xCoordinate < coordinateList[i-1].xCoordinate){
		return -5;
	}
	if (coordinateList[i].xCoordinate > coordinateList[i-1].xCoordinate){
		return 5;
	}
	if (coordinateList[i].yCoordinate < coordinateList[i-1].yCoordinate){
		return -5;
	}
	if (coordinateList[i].yCoordinate > coordinateList[i-1].yCoordinate){
		return 5;
	}
	
}

function showDistance(coordinateList, i)
{
	if (coordinateList[i].showDistance == coordinateList[i-1].showDistance)
	{
		return true;
	}
	return false;
}


