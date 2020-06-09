<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息</title>
</head>
<body>
     <h3>用户信息</h3>
     <hr/>
     <form action="user/saveUser" method="post">
         姓名：<input type="text" name="username" /><br/>
         密码：<input type="password" name="password" /><br/>
         金额：<input type="text" name="money" /><br/>
         <input type="submit" value="提交"/>
     </form>
</body>
</html>
