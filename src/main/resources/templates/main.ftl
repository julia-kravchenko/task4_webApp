<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.logout />
    <div class="form-group mb-6"></div>
    <div><input type="submit" value="Block"/></div>
    <div class="form-group mb-4"></div>
    <script>
        $(function () {
            $("#selectAll").click(function () {
                $('input:checkbox:not(:disabled)').prop('checked', this.checked);
            });
        })
    </script>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        Select/unselect all
                    </label>
                </div>
            </th>
            <th scope="col">ID</th>
            <th scope="col">Username</th>
            <th scope="col">Email</th>
            <th scope="col">Date of registration</th>
            <th scope="col">Active</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <#list users as user>
            <th scope="row">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1"></label>
                </div>
            </th>
            <th scope="row">${user.id}</th>
            <td>${user.getUsername()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getDateRegistration()}</td>
            <td>${user.isActive()?string('yes','no')}</td>
        </tr>
        </tbody>

        <#else>
            No users
        </#list>
    </table>
</@c.page>
