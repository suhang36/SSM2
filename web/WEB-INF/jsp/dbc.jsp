<%--
  Created by IntelliJ IDEA.
  User: 苏航
  Date: 2019/3/5
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<html>
<head>
    <title>Title</title>
    <style type="test/css">
        h1{
            color: rgb(255,255,0);
        }
        form span{
            vertical-align: 1px;
        }
    </style>
</head>
<body>
<h1>hello</h1>
<h3>${errorMsg}</h3>
    <span>用户名</span><input type="text" id="name" name="name">
<p id="msg" style="display: none">用户名不存在</p><br>
    <span>密码</span><input type="password" name="password">
    <input type="submit" id="sub" value="登陆">
<script>

    function checkUserName() {
        $.ajax({
            url:"/VUName",
            data:{name:$("#name").val()},
            dataType:"json",
            success:function (data) {
                if (data&&data.check==1){
                    $("#msg").css("display","block")
                }else {
                    $("#msg").css("display","none")
                }
            }
        })
    }
    $("#name").blur(checkUserName)
    function login() {
        $.ajax({
            url:"/VUName",
            type:"post",
            data:{name:$("#name").val(),
            password:$('[type="password"]').val()},
            dataType:"json",
            success:function (data) {
                if(data.name!==null){
                    console.log(data)
                    // window.location.href="/login"
                }else {
                    console.log(data)
                    $("#msg").css("display","block")
                }
            }
        })
    }
    $("#sub").click(login)
</script>
</body>
</html>
