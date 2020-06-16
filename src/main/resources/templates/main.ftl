<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.logout />
    <div class="form-group mb-4"></div>
    <form action="/user/action" method = "post">
        <div class="form-group mb-6">
            <input type="submit" name="activity" value="delete"/>
            <input type="submit" name="activity" value="block"/>
            <input type="submit" name="activity" value="unlock"/>
        </div>

        <div class="form-group mb-4"></div>

        <table valign="center" class="table table-hover table-bordered">
            <thead>
            <tr align="center" valign="center">
                <th width="100"><label><input type="checkbox" name="selectAll" id="selectAll"
                                              autocomplete="off" onclick="selectAll(this)">Select/unselect all
                <th scope="col">ID</th>
                <th scope="col">Role</th>
                <th scope="col">Username</th>
                <th scope="col">Email</th>
                <th scope="col">Date of registration</th>
                <th scope="col">Active</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <#if users??><#list users as user>
            <tr align="center" valign="middle">
                <td><input type="checkbox" id="select" value="${user.id!}" name="userId"></td>
                <td>${user.id!}</td>
                <td><#list user.roles as role>${role!}<#sep>,</#list></td>
                <td>${user.username!}</td>
                <td>${user.email!}</td>
                <td>${user.dateRegistration!}</td>
                <td>${user.isActive()?string('yes','no')}</td>
            </tr>
            </tbody>
            </#list>
            </#if>
        </table>
    </form>

</@c.page>
<script>
    $(function () {
        $("#selectAll").click(function () {
            $('input:checkbox:not(:disabled)').prop('checked', this.checked);
        });
    })
</script>