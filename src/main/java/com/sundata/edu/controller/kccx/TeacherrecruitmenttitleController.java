package com.sundata.edu.controller.kccx;

import com.sundata.edu.domain.Teacherrecruitmenttitle;
import com.sundata.edu.framework.web.controller.BaseController;
import com.sundata.edu.framework.web.result.AjaxResult;
import com.sundata.edu.framework.web.result.TableDataInfo;
import com.sundata.edu.service.ITeacherrecruitmenttitleService;
import com.sundata.edu.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  信息操作处理
 *
 * @author shunguo
 * @date 2021-12-20
 */
@Controller
@RequestMapping("/teacherrecruitmenttitle")
public class TeacherrecruitmenttitleController extends BaseController
{
    private String prefix = "teacherrecruitmenttitle";


	@Autowired
	private ITeacherrecruitmenttitleService teacherrecruitmenttitleService;

//	@RequiresPermissions("rfsj:teacherrecruitmenttitle:view")
	@GetMapping()
	public String teacherrecruitmenttitle()
	{
	    return prefix + "/teacherrecruitmenttitle";
	}

	/**
	 * 查询列表
	 */
//	@RequiresPermissions("rfsj:teacherrecruitmenttitle:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Teacherrecruitmenttitle teacherrecruitmenttitle)
	{
		startPage();
        List<Teacherrecruitmenttitle> list = teacherrecruitmenttitleService.selectTeacherrecruitmenttitleList(teacherrecruitmenttitle);
		return getDataTable(list);
	}
	/**
	 * 查询根据查询成人高考标题
	 */
	@RequestMapping("/table/selectTitle")
	@ResponseBody
	public AjaxResult selectTitle(Integer id){
		Teacherrecruitmenttitle teacherrecruitmenttitle= teacherrecruitmenttitleService.selectTeacherrecruitmenttitleById(id);
		if(teacherrecruitmenttitle != null){
			return AjaxResult.success("获取成功").put("data",teacherrecruitmenttitle);
		}else{
			return AjaxResult.error();
		}
	}

	/**
	 * 导出列表
	 */
//	@RequiresPermissions("rfsj:teacherrecruitmenttitle:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Teacherrecruitmenttitle teacherrecruitmenttitle)
    {
    	List<Teacherrecruitmenttitle> list = teacherrecruitmenttitleService.selectTeacherrecruitmenttitleList(teacherrecruitmenttitle);
        ExcelUtil<Teacherrecruitmenttitle> util = new ExcelUtil<Teacherrecruitmenttitle>(Teacherrecruitmenttitle.class);
        return util.exportExcel(list, "teacherrecruitmenttitle");
    }

	/**
	 * 新增
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	/**
	 * 新增保存
	 */
//	@RequiresPermissions("rfsj:teacherrecruitmenttitle:add")
//	@Log(title = "新增", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Teacherrecruitmenttitle teacherrecruitmenttitle)
	{
		//teacherrecruitmenttitle.setID(cutil.Guid());

		return toAjax(teacherrecruitmenttitleService.insertTeacherrecruitmenttitle(teacherrecruitmenttitle));
	}

	/**
	 * 修改
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Teacherrecruitmenttitle teacherrecruitmenttitle = teacherrecruitmenttitleService.selectTeacherrecruitmenttitleById(id);
		mmap.put("teacherrecruitmenttitle", teacherrecruitmenttitle);
	    return prefix + "/edit";
	}

	/**
	 * 修改保存
	 */
//	@RequiresPermissions("rfsj:teacherrecruitmenttitle:edit")
//	@Log(title = "修改", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Teacherrecruitmenttitle teacherrecruitmenttitle)
	{
		return toAjax(teacherrecruitmenttitleService.updateTeacherrecruitmenttitle(teacherrecruitmenttitle));
	}

	/**
	 * 删除
	 */
//	@RequiresPermissions("rfsj:teacherrecruitmenttitle:remove")
//	@Log(title = "删除", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(teacherrecruitmenttitleService.deleteTeacherrecruitmenttitleByIds(ids));
	}

}