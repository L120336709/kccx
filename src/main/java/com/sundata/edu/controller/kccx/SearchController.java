package com.sundata.edu.controller.kccx;


import com.sundata.edu.framework.web.controller.BaseController;
import com.sundata.edu.util.PcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/crgk")
@Controller
public class SearchController extends BaseController {
    @Autowired
    private  HttpServletRequest request;
    @GetMapping("/index")
    public String index(){
        System.err.println("==========crgk/index");
        boolean isMoblie= PcUtils.JudgeIsMoblie(request);
        if(isMoblie){
            return "/kccx/crgk/mobile_query";
        }else {
            return "/kccx/crgk/search";
        }
    }

}
