<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="gb2312"%>
    <%@ page import="java.io.*, java.util.*" import="com.DBQuery.DataProcess" import="java.sql.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>����ģ������ | C Help</title>
</head>

<SCRIPT language="javascript">
function CheckForm() {
	if (document.create_paper.paper_title.value == "") {
		alert("��������⣡");
		return false;
	}
	document.create_paper.submit();
}
</SCRIPT>

<body>

<%
if (session.getAttribute("adminname") == null || "".equals(session.getAttribute("adminname"))) {
	response.sendRedirect("login.jsp");
}
%>

<%
String paper_type = request.getParameter("paper_type");
session.setAttribute("paper_type", paper_type);
%>

<%@ include file = "../banner.jsp" %>
	<div class="container">
	  <div class="content">
	  
	  <h2>����ģ������</h2>
	  
	  <form name="create_paper" action="/CTest2.4/create_paper" method="post">
	  	���⣺<input type="text" size="70" name=paper_title ><br>
	  	<input type="button" name="Submit" value="����" onClick="CheckForm()">
	  </form>	  
	  
	  
      <!-- end .content --></div>
    <!-- end .container --></div>
<%@ include file = "../footer.jsp" %>	  
</body>
</html>