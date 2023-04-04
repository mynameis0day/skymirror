package com.vul.springboot_vul.URLjump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UrlJump {

    @RequestMapping("/jump")
    public ModelAndView urlJump(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = request.getParameter("url");
        String u = "redirect:" + url;
        return new ModelAndView(u);

    }
}
