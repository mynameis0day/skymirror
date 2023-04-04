package com.vul.springboot_vul.CommandExec;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandExec {

    @RequestMapping("/commandEexc")
    public String commandEexc() {
        return "命令执行漏洞的源代码请看\"src/main/webapp/Vuls/CommandExecVuls\"目录!";
    }
}
