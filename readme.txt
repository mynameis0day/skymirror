一、靶场搭建环境
基于Java的springboot框架开发的，一键启动，方便快捷~

二、靶场覆盖的漏洞类型
目前1.0版本覆盖的漏洞类型是暴力破解、命令执行、反序列化、文件下载、SpEL注入、SSRF、文件上传、URL跳转、XSS、XEE，
共计10种类型。后续还会继续加入其他的漏洞类型，如SQL注入、XPATH注入、SSTI注入、身份认证与会话管理等等，敬请期待！

三、如何启动靶场呢？
靶场启动特别简单，资源文件夹中包含了项目的源代码“SourceCode”和它的jar包文件“skymirror.jar”，大家可以根据自己的喜好来启动靶场。
下面说明一下如何启动靶场：
1、利用jar包来启动该靶场：
(1)来到skymirror.jar的本地目录下
(2)运行命令“java -jar skymirror.jar”
(3)浏览器访问“本机IP:8080/interface/index.html”即可访问靶场。
2、利用idea启动靶场
 用idea导入源代码“SourceCode”，直接启动，然后浏览器访问“本机IP:8080/interface/index.html”即可访问靶场。
