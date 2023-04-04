<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>执行结果</title>
</head>
<body>
<%
    String command = request.getParameter("command");
    String exec = "/bin/sh%-c%ping -c 3 " + command;
    String[] s = exec.split("%");//把exec字符串转化为数组,以%作为分割标准
    Runtime runtime = Runtime.getRuntime();
    Process process = null;
    try {
        process = runtime.exec(s);
        String line;
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((line = in.readLine()) != null) {
            out.println(line);
        }
    } catch (Exception e) {
        String err = "\'" + command + "\'" + "不是合法命令，请重新输入！";
        out.println(err);
    }
%>
</body>
</html>
