package com.vul.springboot_vul.SpEL;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpEL {

    //    SpEL注入
    @RequestMapping("/sqel")
    public String sqel(@RequestParam("param") String param, Model model) {
        ExpressionParser parser = new SpelExpressionParser();
        String result = parser.parseExpression(param).getValue().toString();
        System.out.println(result);
        model.addAttribute("msg", result);
        return "/Vuls/SpELVuls/sqel_rf_1";
    }
}
