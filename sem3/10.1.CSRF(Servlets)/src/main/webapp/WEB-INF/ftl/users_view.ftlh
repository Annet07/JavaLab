<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form method="post" action="/users">
    <input type="text" name="name">
    <input type="text" name="surname">
    <input type="hidden" value="&{csrf_token}" name="csrf_token">
    <input type="submit" name="Add">
</form>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>&{csrf_token}</td>
        </tr>
    </#list>
</table>
</body>
</html>