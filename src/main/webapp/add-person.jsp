<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@ page import="com.mostafa.sna.entity.UserInfo"%> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>64 Base Image Handling With Oracle</title>
</head>
<body bgcolor="silver">
<html:html>
    <div style="color:red">
    <html:errors />
    </div>
	<html:form action="/add" method="POST" enctype="multipart/form-data">
		First Name:
		<html:text property="person.firstName" size="50" /><br><br>
		Last Name:
		<html:text property="person.lastName" size="50" /><br><br>
		User Name:
		<html:text property="person.userName" size="50" /><br><br>
		Password:
		<html:text property="person.password" size="50" /><br><br>
		Email:
		<html:text property="person.email" size="50" /><br><br>
		Phone No:
		<html:text property="person.phone" size="50" /><br><br>
		Browse File:
		<html:file property="person.file"></html:file><br><br>
		<html:submit>Submit</html:submit>
		<br><br>
	</html:form>
</html:html>
</body>
</html>
