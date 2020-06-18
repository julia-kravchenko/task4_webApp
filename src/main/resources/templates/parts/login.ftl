<#macro login path>
    <form action="${path}" method="post">
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
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit" name="action" value="Log In">Log In</button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group mb-4"></div>
        <button class="btn btn-primary" type="submit"name="action" value="Sign out">Sign Out</button>
    </form>
</#macro>