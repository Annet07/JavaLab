<%@ page import="ru.itis.javalab.models.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.itis.javalab.models.Student" %><%--
  Created by IntelliJ IDEA.
  User: 79534
  Date: 18.11.2020
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: ${cookie.get("color").value}">USERS</h1>
<form action="/students" method="post">
    <select name="color">
        <option value="blueviolet">BLUEVIOLET</option>
        <option value="plum">PLUM</option>
        <option value="lightcoral">LIGHTCORAL</option>
    </select>
    <input type="submit" value="OK">
</form>
<table>
    <th>ID</th>
    <th>FIRST NAME</th>
    <th>LAST NAME</th>
    <th>AGE</th>
    <%
        List<Student> students = (List<Student>) request.getAttribute("usersForJsp");
        for(int i = 0; i < students.size(); i++){
    %>
    <tr>
        <td><%=students.get(i).getId()%></td>
        <td><%=students.get(i).getFirstName()%></td>
        <td><%=students.get(i).getLastName()%></td>
        <td><%=students.get(i).getAge()%></td>
    </tr>
        <%}
    %>
</table>
</body>
</html>
