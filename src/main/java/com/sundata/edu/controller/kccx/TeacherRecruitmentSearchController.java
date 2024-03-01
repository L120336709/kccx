package com.sundata.edu.controller.kccx;

import com.sundata.edu.framework.web.controller.BaseController;
import com.sundata.edu.util.PcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/jszp")
@Controller
public class TeacherRecruitmentSearchController extends BaseController {
    @Autowired
    private HttpServletRequest request;
    @GetMapping("/yjsk")
    public String index(){
        //System.err.println("====jszp/yjsk");
        boolean isMoblie= PcUtils.JudgeIsMoblie(request);
        if(isMoblie){
            return "/kccx/jszp/search_mob";//手机端
        }else {
            return "/kccx/jszp/search";
        }
    }
}
