
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<div style="text-align:center;vertical-align:middle;">
    <h1>文件上传漏洞</h1>
    <h2>第一关：content-type白名单绕过</h2>
    <form action="http://127.0.0.1:8080/upload/fileUpload1" method="post" enctype="multipart/form-data">
        <input type="file" name="myfile" multiple>
        <input type="submit" value="上传"/>
    </form>
</div>
</body>
</html>
