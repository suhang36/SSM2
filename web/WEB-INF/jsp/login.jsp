<%--
  Created by IntelliJ IDEA.
  User: 苏航
  Date: 2019/4/25
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/css" src="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap-grid.css"></script>
</head>
<body>
<h1>欢迎: ${username}</h1>
<h4>${fileRelationPath}</h4>
<a href=${downloadUrl}>下载</a>
    <form action="file/upload" name="upload"
          enctype="multipart/form-data"
          method="post">
        文件:<input type="file" name="file"/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
