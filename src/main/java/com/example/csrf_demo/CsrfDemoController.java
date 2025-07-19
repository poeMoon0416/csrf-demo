package com.example.csrf_demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CsrfDemoController {

    List<Content> contents = new ArrayList<Content>();

    @GetMapping("/")
    public ModelAndView listContents(ModelAndView mav) {
        System.out.println(String.format("listContents: %s", contents));
        mav.addObject("contents", contents);
        mav.setViewName("listContents");
        return mav;
    }
    
    @PostMapping("/")
    public /* String */ ModelAndView createContents(@RequestParam String content, HttpServletRequest req,
            ModelAndView mav) {
        Content contentObj = new Content(content, req.getRemoteUser());
        System.out.println(String.format("createContents: %s", contentObj));
        contents.add(contentObj);
        return listContents(mav);
        // return "redirect:/";
    }
}
