<html lang="en">
<head>
    <title>MY PAGE</title>
</head>
<body>
<h1>Hello, ${user.name} ${user.surname}! </h1>
<h2>Your age is ${user.age}</h2>
<h3>About Me: ${user.aboutMe}</h3>
<button type="submit" value="submit">log off</button>
<form action="/users?action=delete&userId=${user.id}" method="post">
    <input type="submit" value="Delete">
    <input type="hidden" value="&{csrf_token}" name="csrf_token">
</form>
</body>
</html>