<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="control" prefix="control"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>章节练习 | C Help</title>
</head>
<body>
<%@ include file = "banner.jsp" %>	
	<div class="container">
	  <div class="content">
	  
	  <table align=center>
	  <tr><td><h1>章节练习</h1></td></tr>
	  <tr><td align="left" ><control:papers paper_type="chapter" view_type="paper" count="100" /></td></tr>
	  </table>
	  <br><br><br><br><br><br><br><br><br><br><br><br>
      <!-- end .content --></div>
    <!-- end .container --></div>
<%@ include file = "footer.jsp" %>	  
</body>
</html>