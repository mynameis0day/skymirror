
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<div style="text-align:center;vertical-align:middle;">
    <h1>文件上传漏洞</h1>
    <h2>第二关：前端js校验</h2>
    <form action="http://127.0.0.1:8080/upload/fileUpload2" method="post" enctype="multipart/form-data">
        <input id="file" type="file" name="myfile" onchange="pictype(this)" multiple>
        <input type="submit" value="上传"/>
    </form>
</div>
</body>
<script>
    function pictype(file) {
        var fileTypes = [".jpg", ".png"];
        var filePath = file.value;
        if (filePath) {
            var isNext = false;
            var fileEnd = filePath.substring(filePath.indexOf("."));
            for (var i = 0; i < fileTypes.length; i++) {
                if (fileTypes[i] == fileEnd) {
                    isNext = true;
                    break;
                }
            }
            if (!isNext) {
                alert("不允许上传此文件类型！");
                file.value = "";
                return false;
            }
        } else {
            return false;
        }

    }

</script>
</html>
