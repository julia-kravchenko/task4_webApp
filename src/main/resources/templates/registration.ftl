<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    Registration
    <div class="form-group mb-4"></div>
    <form action="/registration" method="post">
        <div class="form-group row">
            <label class="col-sm-1 col-form-label">Username</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" name="username" placeholder="Username">
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-1 col-form-label">Password</label>
            <div class="col-sm-2">
                <input type="password" class="form-control" name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">
            <label  class="col-sm-1 col-form-label">Email</label>
            <div class="col-sm-2">
                <input type="email" class="form-control" name="email" placeholder="Email address">
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-group mb-4"></div>
        <button  class="btn btn-primary" type="submit"name="action" value="Sign up">Sign Up</button>
    </form>
    <#if message??>
        ${message}
    </#if>
</@c.page>
