<%--
  Created by IntelliJ IDEA.
  User: Damien
  Date: 05/10/2016
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<%@ include file="header.jspf"%>
<head>
    <title>MaJSP</title>
</head>
<body>
    <h1>Hello from FIL classroom</h1>
    <h2>Value attribute test : ${test} </h2>
    <% incrementCount(); %>
    <h2>Incrémentation : <%= count%></h2>
</body>
<%@ include file="footer.jspf"%>
</html>
