package com.vul.springboot_vul.Deserialization;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectInputStream;

public class Deserialization {
    @ResponseBody
    @RequestMapping("/deserialization")
    public String deserializationVuln(HttpServletRequest request, HttpServletResponse response) throws Exception {
        java.io.InputStream inputStream = request.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            String a = objectInputStream.readObject().toString();
            System.out.println(a);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Hello,SkyMirror!";
    }

    @ResponseBody
    @RequestMapping("/demo")
    public String demo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "This is SkyMirror!";
    }
}
