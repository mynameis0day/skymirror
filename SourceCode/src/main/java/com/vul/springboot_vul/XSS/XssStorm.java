package com.vul.springboot_vul.XSS;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/XSS")
public class XssStorm {

    //    第一关：熟悉XSS漏洞
    @RequestMapping("/XSS1")
    public ModelAndView testXss1(@RequestParam("context") String context) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", context);
        modelAndView.setViewName("/Vuls/XSSVuls/xss_result");
        return modelAndView;
    }

    //    第二关：叠堆绕过
    @RequestMapping("/XSS2")
    public ModelAndView testXss2(@RequestParam("context") String context) {
        ModelAndView modelAndView = new ModelAndView();
        String s = context.toLowerCase();//把大写全部转化为小写
        String s1 = s.replaceAll("<script>", "");
        String s2 = s1.replaceAll("</script>", "");
        modelAndView.addObject("msg", s2);
        modelAndView.setViewName("/Vuls/XSSVuls/xss_result");
        return modelAndView;
    }

    //    第三关：事件绕过
    @RequestMapping("/XSS3")
    public String testXss3(@RequestParam("context") String context, Model model) {
        String s = context.toLowerCase();
        String s1 = s.replaceAll("script", "?");//过滤<script>和</script>标签
        model.addAttribute("msg", s1);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第四关：html实体编码绕过
    @RequestMapping("/XSS4")
    public String testXss4(@RequestParam("context") String context, Model model) {
        String s = context.toLowerCase();
        String s1 = s.replaceAll("script", "?");
        String s2 = s1.replaceAll("alert", "?");
        String s3 = s2.replaceAll("confirm", "?");
        String s4 = s3.replaceAll("prompt", "?");
        String s5 = s4.replaceAll("document.write", "?");
        String s6 = s5.replaceAll("vascr", "?");//过滤伪协议
        model.addAttribute("msg", s6);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第五关：URL编码绕过
    @RequestMapping("/XSS5")
    public String testXss5(@RequestParam("context") String context, Model model) {
        String s1 = context.toLowerCase();
        String s2 = s1.replaceAll("alert", "?");
        String s3 = s2.replaceAll("confirm", "?");
        String s4 = s3.replaceAll("prompt", "?");
        String s5 = s4.replaceAll("document.write", "?");
        String s6 = s5.replaceAll("&", "?");
        String s7 = s6.replaceAll("#", "?");
        String s8 = s7.replaceAll(";", "?");
        model.addAttribute("msg", s8);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第六关：js编码绕过
    @RequestMapping("/XSS6")
    public String testXss6(@RequestParam("context") String context, Model model) {
        while (context.contains("<script>")) {
            context = context.replaceAll("<script>", "");
        }
        String s1 = context.toLowerCase();
        String s2 = s1.replaceAll("alert", "?");
        String s3 = s2.replaceAll("confirm", "?");
        String s4 = s3.replaceAll("prompt", "?");
        String s5 = s4.replaceAll("document.write", "?");
        String s6 = s5.replaceAll("&", "?");
        String s7 = s6.replaceAll("#", "?");
        String s8 = s7.replaceAll(";", "?");
        while (s8.contains("javascript")) {
            s8 = s8.replaceAll("javascript", "");
        }
        model.addAttribute("msg", s8);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第七关：混合编码绕过
    @RequestMapping("/XSS7")
    public String testXss7(@RequestParam("context") String context, Model model) {
        context = context.toLowerCase();
        while (context.contains("<script>")) {
            context = context.replaceAll("<script>", "");
        }
        context = context.replaceAll("on", "?");//过滤事件
        String s = context.replaceAll("javascript", "?");
        String s1 = s.replaceAll("alert", "?");
        String s2 = s1.replaceAll("confirm", "?");
        String s3 = s2.replaceAll("prompt", "?");
        String s4 = s3.replaceAll("document.write", "?");
        model.addAttribute("msg", s4);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第八关：base64编码绕过
    @RequestMapping("/XSS8")
    public String testXss8(@RequestParam("context") String context, Model model) {
        while (context.contains("<script>")) {
            context = context.replaceAll("<script>", "");
        }
        context = context.replaceAll("on", "?");//过滤事件
        String s = context.replaceAll("javascript", "?");
        String s1 = s.replaceAll("alert", "?");
        String s2 = s1.replaceAll("confirm", "?");
        String s3 = s2.replaceAll("prompt", "?");
        String s4 = s3.replaceAll("document.write", "?");
        String s5 = s4.replaceAll("&", "?");
        String s6 = s5.replaceAll("#", "?");
        String s7 = s6.replaceAll("%", "?");
        model.addAttribute("msg", s7);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第九关：ASCII编码绕过
    @RequestMapping("/XSS9")
    public String testXss9(@RequestParam("context") String context, Model model) {
        while (context.contains("<script>")) {
            context = context.replaceAll("<script>", "");
        }
        context = context.replaceAll("on", "?");//过滤事件
        String s1 = context.replaceAll("alert", "?");
        String s2 = s1.replaceAll("confirm", "?");
        String s3 = s2.replaceAll("prompt", "?");
        String s4 = s3.replaceAll("document.write", "?");
        String s5 = s4.replaceAll("&", "?");
        String s6 = s5.replaceAll("#", "?");
        String s7 = s6.replaceAll(";", "?");
        String s8 = s7.replaceAll("%", "?");
        String s9 = s8.replaceAll("u00", "?");
        model.addAttribute("msg", s9);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第十关：函数拼接绕过
    @RequestMapping("/XSS10")
    public String testXss10(@RequestParam("context") String context, Model model) {
        context = context.toLowerCase();
        while (context.contains("<script>")) {
            context = context.replaceAll("<script>", "");
        }
        String s2 = context.replaceAll("alert", "?");
        String s3 = s2.replaceAll("confirm", "?");
        String s4 = s3.replaceAll("prompt", "?");
        String s5 = s4.replaceAll("document.write", "?");
        String s6 = s5.replaceAll("&", "?");
        String s7 = s6.replaceAll("#", "?");
        String s8 = s7.replaceAll(";", "?");
        String s9 = s8.replaceAll("%", "?");
        String s10 = s9.replaceAll("u00", "?");
        String s11 = s10.replaceAll("javascript", "?");
        model.addAttribute("msg", s11);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第十一关：赋值拼接绕过
    @RequestMapping("/XSS11")
    public String testXss11(@RequestParam("context") String context, Model model) {
        while (context.contains("<script>")) {
            context = context.replaceAll("<script>", "");
        }
        String s = context.replaceAll("javascript", "?");
        String s2 = s.replaceAll("alert", "?");
        String s3 = s2.replaceAll("confirm", "?");
        String s4 = s3.replaceAll("prompt", "?");
        String s5 = s4.replaceAll("document.write", "?");
        String s6 = s5.replaceAll("&", "?");
        String s7 = s6.replaceAll("#", "?");
        String s8 = s7.replaceAll(";", "?");
        String s9 = s8.replaceAll("%", "?");
        String s10 = s9.replaceAll("u00", "?");
        String s11 = s10.replaceAll("eval", "?");
        String s12 = s11.replaceAll("top", "");
        String s13 = s12.replaceAll("window", "?");
        String s14 = s13.replaceAll("self", "?");
        String s15 = s14.replaceAll("parent", "");
        String s16 = s15.replaceAll("frames", "");
        model.addAttribute("msg", s16);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第十二关：火狐IE专属
    @RequestMapping("/XSS12")
    public String testXss12(@RequestParam("context") String context, Model model) {
        if (context.contains("<marquee")) {
            model.addAttribute("msg", context);
        } else {
            context = context.replaceAll("\"", "&quot;");
            context = context.replaceAll("&", "&amp;");
            context = context.replaceAll("\\(", "&#40;");
            context = context.replaceAll("<", "&lt;");
            context = context.replaceAll(">", "&gt;");
            context = context.replaceAll("\'", "&#39;");
            context = context.replaceAll("\\)", "&#41;");
            model.addAttribute("msg1", context);
        }
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第十三关：throw绕过
    @RequestMapping("/XSS13")
    public String testXss13(@RequestParam("context") String context, Model model) {
        if (context.contains("throw")) {
            model.addAttribute("msg", context);
        } else {
            context = context.replaceAll("\"", "&quot;");
            context = context.replaceAll("&", "&amp;");
            context = context.replaceAll("\\(", "&#40;");
            context = context.replaceAll("<", "&lt;");
            context = context.replaceAll(">", "&gt;");
            context = context.replaceAll("\'", "&#39;");
            context = context.replaceAll("\\)", "&#41;");
            model.addAttribute("msg1", context);
        }
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第十四关：大小写绕过
    @RequestMapping("/XSS14")
    public String testXss14(@RequestParam("context") String context, Model model) {
        while (context.contains("<script>")) {
            context = context.replaceAll("<script>", "");
        }
        while (context.contains("javascript")) {
            context = context.replaceAll("javascript", "");
        }
        model.addAttribute("msg", context);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第十五关：空格/回车（换行符）/Tab绕过
    @RequestMapping("/XSS15")
    public String testXss15(@RequestParam("context") String context, Model model) {
        while (context.contains("<script>")) {
            context = context.replaceAll("<script>", "");
        }
        while (context.contains("javascript:alert")) {
            context = context.replaceAll("javascript:alert", "");
        }
        while (context.contains("javascript:confirm")) {
            context = context.replaceAll("javascript:confirm", "");
        }
        while (context.contains("javascript:prompt")) {
            context = context.replaceAll("javascript:prompt", "");
        }
        while (context.contains("document.write")) {
            context = context.replaceAll("document.write", "?");
        }
        while (context.contains("console.log")) {
            context = context.replaceAll("console.log", "?");
        }
        model.addAttribute("msg", context);
        return "/Vuls/XSSVuls/xss_result";
    }

    //    第十六关：alert被过滤
    @RequestMapping("/XSS16")
    public String testXss16(@RequestParam("context") String context, Model model) {
        while (context.contains("alert")) {
            context = context.replaceAll("alert", "");
        }
        model.addAttribute("msg", context);
        return "/Vuls/XSSVuls/xss_result";
    }

}