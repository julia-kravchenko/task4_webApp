<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.logout />
    <div class="form-group mb-4"></div>
    <form action="/user/action" method = "post">
        <div class="form-group mb-6">
            <button class="btn btn-primary" type="submit" name="action" value="delete">Delete</button>
            <button class="btn btn-primary" type="submit" name="action" value="block">Block</button>
            <button  class="btn btn-primary" type="submit"name="action" value="unblock">Unblock</button>
        </div>

        <div class="form-group mb-4"></div>

        <table border="1" valign="center">
            <thead>
            <tr align="center" valign="center">
                <th width="100"><label><input type="checkbox" name="selectAll" id="selectAll"
                                              autocomplete="off" onclick="selectAll(this)">Select/unselect all
                <th width = "60">ID</th>
                <th width = "80">Role</th>
                <th width = "120">Username</th>
                <th width = "120">Email</th>
                <th width = "120">Date of registration</th>
                <th width = "120">Status</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <#if users??><#list users as user>
            <tr align="center" valign="middle">
                <input type="hidden" value="${_csrf.token}" name="_csrf">
                <td><input type="checkbox" id="select" value="${user.id!}" name="userId"></td>
                <td>${user.id!}</td>
                <td><#list user.roles as role>${role!}<#sep>,</#list></td>
                <td>${user.username!}</td>
                <td>${user.email!}</td>
                <td>${user.dateRegistration!}</td>
                <td>${user.isActive()?string('active','blocked')}</td>
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
