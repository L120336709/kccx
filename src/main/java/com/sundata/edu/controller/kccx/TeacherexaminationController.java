package com.sundata.edu.controller.kccx;

import java.util.List;

import com.sundata.edu.framework.web.controller.BaseController;
import com.sundata.edu.framework.web.result.AjaxResult;
import com.sundata.edu.framework.web.result.TableDataInfo;
import com.sundata.edu.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sundata.edu.domain.Teacherexamination;
import com.sundata.edu.service.ITeacherexaminationService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 教师资格证考场管理Controller
 *
 * @author whj
 * @date 2021-10-25
 */
@Controller
@RequestMapping("/teacherexamination")
public class TeacherexaminationController extends BaseController {
    private String prefix = "/teacherexamination";

    @Autowired
    private ITeacherexaminationService teacherexaminationService;

    // @RequiresPermissions("system:teacherexamination:view")
    @GetMapping()
    public String teacherexamination() {
        return prefix + "/list";
    }

    /**
     * 查询教师资格证考场管理列表
     */
    // @RequiresPermissions("system:teacherexamination:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Teacherexamination teacherexamination) {
        startPage();
        List<Teacherexamination> list = teacherexaminationService.selectTeacherexaminationList(teacherexamination);
        return getDataTable(list);
    }

    /**
     * 根据考生姓名和准考证号查询教师资格证考场管理列表
     */
    @RequestMapping("/table/selectEndurance")
    @ResponseBody
    public AjaxResult selectEndurance(String examineename, String examregistrationnumber) {
        Teacherexamination teacherexamination = new Teacherexamination();
        teacherexamination.setExamineename(examineename);
        teacherexamination.setExamregistrationnumber(examregistrationnumber);
        List<Teacherexamination> list = teacherexaminationService.selectTeacherexaminationList(teacherexamination);
        if (list != null) {
            return AjaxResult.success("获取成功").put("data", list.get(0));
        } else {
            return AjaxResult.error();
        }
    }


    /**
     * 导出教师资格证考场管理列表
     */
    // @RequiresPermissions("system:teacherexamination:export")
    //@Log(title = "教师资格证考场管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Teacherexamination teacherexamination) {
        List<Teacherexamination> list = teacherexaminationService.selectTeacherexaminationList(teacherexamination);
        ExcelUtil<Teacherexamination> util = new ExcelUtil<Teacherexamination>(Teacherexamination.class);
        return util.exportExcel(list, "教师资格证考场管理数据");
    }

    /**
     * 下载教师资格证考场管理导入模板
     */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate() {
        ExcelUtil<Teacherexamination> util = new ExcelUtil<Teacherexamination>(Teacherexamination.class);
        return util.importTemplateExcel("用户数据");
    }

    /**
     * 导入教师资格证考场管理列表
     */
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<Teacherexamination> util = new ExcelUtil<Teacherexamination>(Teacherexamination.class);
        List<Teacherexamination> teacherexaminationList = util.importExcel(file.getInputStream());
        String message = teacherexaminationService.Teacherexamination(teacherexaminationList, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增教师资格证考场管理
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存教师资格证考场管理
     */
    //@RequiresPermissions("system:teacherexamination:add")
    //@Log(title = "教师资格证考场管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Teacherexamination teacherexamination) {
        return toAjax(teacherexaminationService.insertTeacherexamination(teacherexamination));
    }

    /**
     * 修改教师资格证考场管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Teacherexamination teacherexamination = teacherexaminationService.selectTeacherexaminationById(id);
        mmap.put("teacherexamination", teacherexamination);
        return prefix + "/edit";
    }

    /**
     * 修改保存教师资格证考场管理
     */
    // @RequiresPermissions("system:teacherexamination:edit")
    // @Log(title = "教师资格证考场管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Teacherexamination teacherexamination) {
        return toAjax(teacherexaminationService.updateTeacherexamination(teacherexamination));
    }

    /**
     * 删除教师资格证考场管理
     */
    // @RequiresPermissions("system:teacherexamination:remove")
    // @Log(title = "教师资格证考场管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(teacherexaminationService.deleteTeacherexaminationByIds(ids));
    }


    @PostMapping("/turntable")
    @ResponseBody
    public AjaxResult turntable() {
        int x = teacherexaminationService.turntablesapiential();
        return toAjax(x);
    }

}
