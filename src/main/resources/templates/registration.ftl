<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    Registration
    <div class="form-group mb-4"></div>
    <form action="/registration" method="post">
        <div><label> Username:<input type="text" name="username"/> </label></div>
        <div><label> Password :<input type="password" name="password"/> </label></div>
        <div><label> Your email:<input type="text" name="email"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-group mb-4"></div>
        <div><input type="submit" value="Sign Up"/></div>
    </form>
    <#if message??>
        ${message}
    </#if>
</@c.page>
