package com.vul.springboot_vul.XXE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;


@Controller
@RequestMapping("/XXE")
public class DamnXXE {

    @RequestMapping("/XXE1")
    public ModelAndView testXXE(@RequestParam("context") String context) {
        ModelAndView modelAndView = new ModelAndView();
        DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder domBuilder = domfac.newDocumentBuilder();
            ByteArrayInputStream xmlStream = new ByteArrayInputStream(context.getBytes());//把字符串转化为输入流
            Document doc = domBuilder.parse(xmlStream);
            Element root = doc.getDocumentElement();
            NodeList books = root.getChildNodes();
            if (books != null) {
                for (int i = 0; i < books.getLength(); i++) {
                    Node book = books.item(i);
                    if (book.getNodeType() == Node.ELEMENT_NODE) {
                        String email = book.getAttributes().getNamedItem("email").getNodeValue();
                        modelAndView.addObject("email", email);
                        System.out.println(email);
                        for (Node node = book.getFirstChild(); node != null; node = node.getNextSibling()) {
                            if (node.getNodeType() == Node.ELEMENT_NODE) {
                                if (node.getNodeName().equals("name")) {
                                    String name = node.getNodeValue();
                                    String name1 = node.getFirstChild().getNodeValue();
                                    modelAndView.addObject("name", name);
                                    System.out.println(name);
                                    modelAndView.addObject("name1", name1);
                                    System.out.println(name1);
                                }
                                if (node.getNodeName().equals("price")) {
                                    String price = node.getFirstChild().getNodeValue();
                                    modelAndView.addObject("price", price);
                                    System.out.println(price);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/Vuls/XXEVuls/xxe_rf_1");
        return modelAndView;
    }
}
