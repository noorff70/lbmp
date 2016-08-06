<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE html>
<html>

<head>
	<title>Learn Now To Build Your Future</title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<link href="<c:url value="/resources/css/template.css" />" rel="stylesheet" />

</head>
<body>
	<div class="container-fluid">
		
	<!-- Header -->
	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12" >
			<tiles:insertAttribute name="header" />
 		</div>
	</div>
	
	<!-- Menu and Main Body -->
	<div class="row">
		<!-- Menu -->
		<div class="col-xs-4 col-sm-2 col-md-2">
			<tiles:insertAttribute name="menu" />
  		</div>
  		<!-- Main Body -->
  		<div class="col-xs-8 col-sm-10 col-md-10">
			<tiles:insertAttribute name="body" />
 		</div>
 	</div>
 </div>
 <div class="clearfooter"></div>
 <!-- Footer -->
 	<div class="row">
		<div class="col-xs-12 col-sm-12 col-md-12">
			<tiles:insertAttribute name="footer" />
 		</div>
 	</div>
 
</body>

</html>