<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户信息</title>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
        //页面加载
        $(function () {
             $("#btn1").click(function () {
                 alert("发送了Ajax请求");
             })
        })

        $(function () {
            $("#btn2").click(function () {
                $.ajax({
                    //编写Json格式，设置属性和值
                    url:"user/testJson",
                    type:"post",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"张三","password":"123456","money":"200.0"}',
                    dataType:"json",
                    success:function (data) {
                        //data服务器端响应的json的数据，进行解析
                        alert(data);//返回的对象
                        alert(data.userName);
                        alert(data.password);
                        alert(data.money);
                    }
                })
            })
        })
    </script>
</head>
<body>
     <h3>用户信息</h3>
     <hr/>
     <%--
     <form action="user/saveUser" method="post">
         姓名：<input type="text" name="username" /><br/>
         密码：<input type="password" name="password" /><br/>
         金额：<input type="text" name="money" /><br/>
         <input type="submit" value="提交"/>
     </form>
     --%>
     <%--
      获取Servlet原生API
     <form action="user/testServletAPI" method="post">
         姓名：<input type="text" name="username" /><br/>
         密码：<input type="password" name="password" /><br/>
         金额：<input type="text" name="money" /><br/>
         <input type="submit" value="提交"/>
     </form>
     --%>
     <%--获取请求体内容--%>
     <%--<form action="user/getRequestBody" method="post">--%>
         <%--姓名：<input type="text" name="username" /><br/>--%>
         <%--密码：<input type="password" name="password" /><br/>--%>
         <%--金额：<input type="text" name="money" /><br/>--%>
         <%--<input type="submit" value="提交"/>--%>
     <%--</form>--%>

     <a href="user/testString">返回值字符串String类型</a>
     <br/>
     <a href="user/testVoid">返回值void类型</a>
     <br/>
     <a href="user/testModelAndView">返回值ModelAndView类型</a>
     <br/>
     <button id="btn1">发送ajax的请求</button>
     <br/>
     <button id="btn2">返回Json</button>

</body>
</html>
