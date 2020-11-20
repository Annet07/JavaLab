<%--
  Created by IntelliJ IDEA.
  User: 79534
  Date: 19.11.2020
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MY PAGE</title>
</head>
<body>
<section>
    <jsp:useBean id="user" scope="session" type="ru.itis.javalab.models.User"/>
    <form method="post">
        <h1>MY PAGE</h1>
        <p> name: ${user.name}</p>
        <p> surname: ${user.surname}</p>
        <p> age: ${user.age}</p>
        <p> aboutMe: ${user.aboutMe}</p>
        <button type="submit" value="submit">log off</button>
    </form>
</section>

</body>
</html>
