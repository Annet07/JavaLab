<html lang="en">
<body>
<h1>Hello, ${user.name}! </h1>
<h2>Your id is ${user.id}</h2>

<#if user.age??>
    <h3>Age is ${user.age}</h3>
<#else>
    <h3>Age is undefined</h3>
</#if>

<table>
    <tr>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <#list  users as listUser>
        <tr>
            <td>${listUser.name}</td>
            <td>${listUser.age}</td>
        </tr>
    </#list>
</table>
</body>
</html>