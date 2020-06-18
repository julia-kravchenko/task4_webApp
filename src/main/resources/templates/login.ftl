<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    Authorization
    <div class="form-group mb-4"></div>
    <@l.login "/login" />
    <div class="form-group mb-4"></div>
    <a href="/registration">Sign Up</a>
    <div class="form-group mb-4"></div>
</@c.page>