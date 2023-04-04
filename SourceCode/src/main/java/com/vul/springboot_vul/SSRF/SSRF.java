package com.vul.springboot_vul.SSRF;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Controller
@RequestMapping("/SSRF")
public class SSRF {

    @RequestMapping("/ssrf")
    public String testSSRF(HttpServletRequest request) {
        String line = null;
        try {
            String urlString = request.getParameter("url");
            URL url = new URL(urlString); //代表了一个网址
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream(); //获得网页的内容
            //将InputStream转换为Reader，并使用缓冲读取，提高效率，同时可以按行
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            while ((line = br.readLine()) != null) {
                request.setAttribute("msg", line);
                System.out.println(line);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/Vuls/SSRFVuls/ssrf_rf_1";
    }
}
