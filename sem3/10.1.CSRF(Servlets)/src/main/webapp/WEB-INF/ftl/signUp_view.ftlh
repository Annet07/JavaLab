<html lang="en">
<head>
    <title>Registration</title>
</head>
<body>
<h1>Register on our website! </h1>
<input type="hidden" value="&{csrf_token}" name="csrf_token">
<div>
    <fieldset>
        <legend>REGISTRATION</legend>
        <form method="POST" action="/signUp">
            <p><input name="name" type="text" maxlength="25" size="40" placeholder="Your name"></p>
            <p><input name="surname" type="text" maxlength="25" size="40" placeholder="Your surname"></p>
            <p><input name="age" type="text" maxlength="25" size="40" placeholder="Your age"></p>
            <p><input name="aboutMe" type="text" maxlength="256" size="40" placeholder="Tell about yourself"></p>
            <p><input name="login" type="text" maxlength="25" size="40" placeholder="Your login"></p>
            <p><input name="password" type="password" maxlength="25" size="40" placeholder="Your password"></p>
            <button type="submit" value="submit">Sign Up</button>
        </form>
    </fieldset>
</div>
</body>
</html>