package com.sundata.edu.controller.kccx;

import java.util.List;

import com.sundata.edu.domain.Adulttitletable;
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
import com.sundata.edu.domain.Teacherstitletb;
import com.sundata.edu.service.ITeacherstitletbService;


/**
 * 教师资格证考试名称修改Controller
 *
 * @author whj
 * @date 2021-10-25
 */
@Controller
@RequestMapping("/teacherstitletb")
public class TeacherstitletbController extends BaseController
{
    private String prefix = "/teacherstitletb";
    @Autowired
    private ITeacherstitletbService teacherstitletbService;
   // @RequiresPermissions("system:teacherstitletb:view")
    @GetMapping()
    public String teacherstitletb()
    {
        return prefix + "/list";
    }

    /**
     * 查询教师资格证考试名称修改列表
     */
 //   @RequiresPermissions("system:teacherstitletb:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Teacherstitletb teacherstitletb)
    {
        startPage();
        List<Teacherstitletb> list = teacherstitletbService.selectTeacherstitletbList(teacherstitletb);
        return getDataTable(list);
    }

 /*   *//**
     * 导出教师资格证考试名称修改列表
     *//*
   //@RequiresPermissions("system:teacherstitletb:export")
   // @Log(title = "教师资格证考试名称修改", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Teacherstitletb teacherstitletb)
    {
        List<Teacherstitletb> list = teacherstitletbService.selectTeacherstitletbList(teacherstitletb);
        ExcelUtil<Teacherstitletb> util = new ExcelUtil<Teacherstitletb>(Teacherstitletb.class);
        return util.exportExcel(list, "教师资格证考试名称修改数据");
    }*/

    /**
     * 新增教师资格证考试名称修改
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教师资格证考试名称修改
     */
   // @RequiresPermissions("system:teacherstitletb:add")
   // @Log(title = "教师资格证考试名称修改", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Teacherstitletb teacherstitletb)
    {
        return toAjax(teacherstitletbService.insertTeacherstitletb(teacherstitletb));
    }

    /**
     * 修改教师资格证考试名称修改
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Teacherstitletb teacherstitletb = teacherstitletbService.selectTeacherstitletbById(id);
        mmap.put("teacherstitletb", teacherstitletb);
        return prefix + "/edit";
    }

    /**
     * 修改保存教师资格证考试名称修改
     */
   // @RequiresPermissions("system:teacherstitletb:edit")
    //@Log(title = "教师资格证考试名称修改", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Teacherstitletb teacherstitletb)
    {
        return toAjax(teacherstitletbService.updateTeacherstitletb(teacherstitletb));
    }

    /**
     * 查询根据查询成人高考标题
     */
    @RequestMapping("/table/selectEndurance")
    @ResponseBody
    public AjaxResult selectEndurance(Long id){
        Teacherstitletb teacherstitletb = new Teacherstitletb();
        teacherstitletb.setId(id);
        List<Teacherstitletb> list = teacherstitletbService.selectTeacherstitletbList(teacherstitletb);
        if(list != null){
            return AjaxResult.success("获取成功").put("data",list.get(0));
        }else{
            return AjaxResult.error();
        }
    }


    /**
     * 删除教师资格证考试名称修改
     */
   // @RequiresPermissions("system:teacherstitletb:remove")
   // @Log(title = "教师资格证考试名称修改", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(teacherstitletbService.deleteTeacherstitletbByIds(ids));
    }
}
