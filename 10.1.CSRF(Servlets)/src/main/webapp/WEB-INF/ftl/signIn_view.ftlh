<html lang="en">
<head>
    <title>Sign in</title>
</head>
<body>
<h1>Sign in to our website!! </h1>
<div>
    <fieldset>
        <legend>ENTRANCE</legend>
        <form name="user" method="POST">
            <p><input name="login" type="text" maxlength="25" size="40" placeholder="Your login"></p>
            <p><input name="password" type="password" maxlength="25" size="40" placeholder="Your password"></p>
            <input type="hidden" value="&{csrf_token}" name="csrf_token">
            <button type="submit" value="submit">Sign In</button>
        </form>
    </fieldset>
</div>
</body>
</html>