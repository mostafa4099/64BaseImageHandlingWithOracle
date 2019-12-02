<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>64 Base Image Handling With Oracle</title>
</head>
<body bgcolor="silver">
<table>
<tr>Sucessfully Added</tr><br><br>
<%=session.getAttribute("id") %><br><br>
<%=session.getAttribute("firstName") %><br><br>
<%=session.getAttribute("lastName") %><br><br>
<%=session.getAttribute("userName") %><br><br>
<%=session.getAttribute("password") %><br><br>
<%=session.getAttribute("email") %><br><br>
<%=session.getAttribute("phone") %><br><br>
</table>
<% String image = (String)session.getAttribute("base64Image");%>
<img src="data:image/jpg;base64,<%=image%>" width="240" height="300"/>
</body>
</html>