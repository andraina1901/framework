<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" import="koursa.*"%>
<%
String s = String.valueOf(request.getAttribute("json"));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>BONJOUR <%out.print(s);%></h1>
</body>
</html>