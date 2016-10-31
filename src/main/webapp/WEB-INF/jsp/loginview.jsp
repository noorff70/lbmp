<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<form:form id="logindetailform" action="/lbmp/loginview" method="post" modelAttribute="logininfo">


Please provide User Name and Password to access:
<br>
	<br>
	<br>
	<div class="col-xs-4">
		<div class="form-group-horizontal">
			<label for="usr"><spring:message code="lbl.user" ></spring:message></label> 
			<input type="text" class="form-control" id="username" name="username">
		</div>
		<div class="form-group-horizontal">
			<label for="pwd"><spring:message code="lbl.password" ></spring:message></label> 
			<input type="password" class="form-control" id="password" name = "password">
	 		<form:errors path="password"/>
		</div>
		<div>
			<br> <br> <br> 
			<input type="submit" class="btn btn-info" value="Submit">
		</div>
	</div>

</form:form>