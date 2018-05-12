<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 2018/4/12
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>登陆</title>
</head>
<body>

    <form action="/loginsubmit" method="post">
        <table>
            <tr>
                <td>用户名:<input type="text" name="username" id="username"/></td>
            </tr>
            <tr>
                <td>密码：<input type="password" name="pwd"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="登陆"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
