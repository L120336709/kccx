package com.sundata.edu.controller.kccx;
import com.sundata.edu.framework.web.controller.BaseController;
import com.sundata.edu.util.PcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
@RequestMapping("/jzgz")
@Controller
public class TeacherSearchmobController extends BaseController {
    @Autowired
    private HttpServletRequest request;
    @GetMapping("/kccx")
    public String idex(){
        boolean isMoblie= PcUtils.JudgeIsMoblie(request);
        if(isMoblie){
            return "/kccx/jzgz/searchation_mob";
        }else {
            return "/kccx/jzgz/searchation";
        }
    }
}
