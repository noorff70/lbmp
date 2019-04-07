<%-- <%@ page import="com.weblearning.controller.MenuController" %>
<%@ page import="com.weblearning.domain.*" %>
<%@ page import="java.util.*" %>

<%
	List gradeList = new ArrayList();
	
    MenuController mc = new MenuController();
    gradeList = mc.getdata();
%>
<div id="menu">
	<% for (int i=0; i< gradeList.size(); i++) {
		Grade grade = new Grade();
		grade = (Grade)gradeList.get(i);%>
		<ul id="accordion">
			<li><%=grade.getGradeName() %></li>
			<% if(grade.getSubjects()!= null){
				List subjectList = new ArrayList(); 
				subjectList.addAll(grade.getSubjects());
					for(int j=0; j< subjectList.size(); j++) {
						Subject subject = new Subject();
						subject = (Subject)subjectList.get(j); %>
						<ul>
							<li><a href="topics?GRADEID=<%=grade.getGradeId()%>&SUBJECTID=<%=subject.getSubjectId()%>"><%=subject.getSubjectName() %></a> </li>
						</ul>
				<%}
			}%>
		</ul>	
	<%} %>
</div> --%>