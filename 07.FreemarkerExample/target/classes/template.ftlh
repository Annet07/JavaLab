Hello, ${user.name}, your id is ${user.id},

<#if user.age??>
    Age is ${user.age}
<#else>
    Age is undefined
</#if>

Other users:

<#list users as listUser>
    Name: ${listUser.name}
    Age: ${listUser.age}
</#list>