package com.sundata.edu.controller.kccx;

import com.sundata.edu.domain.Teacherrecruitment;
import com.sundata.edu.framework.web.controller.BaseController;
import com.sundata.edu.framework.web.result.AjaxResult;
import com.sundata.edu.framework.web.result.TableDataInfo;
import com.sundata.edu.service.ITeacherrecruitmentService;
import com.sundata.edu.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 *  信息操作处理
 *
 * @author shunguo
 * @date 2021-12-20
 */
@Controller
@RequestMapping("/teacherrecruitment")
public class TeacherrecruitmentController extends BaseController
{
    private String prefix = "teacherrecruitment";


	@Autowired
	private ITeacherrecruitmentService teacherrecruitmentService;

//	@RequiresPermissions("rfsj:teacherrecruitment:view")
	@GetMapping()
	public String teacherrecruitment()
	{
	    return prefix + "/teacherrecruitment";
	}

	/**
	 * 查询列表
	 */
//	@RequiresPermissions("rfsj:teacherrecruitment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Teacherrecruitment teacherrecruitment)
	{
		startPage();
        List<Teacherrecruitment> list = teacherrecruitmentService.selectTeacherrecruitmentList(teacherrecruitment);
		return getDataTable(list);
	}

	/**
	 * 根据考生姓名和准考证号查询研考考场管理列表
	 */
	@RequestMapping("/table/selectEndurance")
	@ResponseBody
	public AjaxResult selectEndurance(String stuname, String examNumber){
		Teacherrecruitment teacherrecruitment = new Teacherrecruitment();
		teacherrecruitment.setExamname(stuname);
		teacherrecruitment.setExamnumber(examNumber);
		List<Teacherrecruitment> list = teacherrecruitmentService.selectTeacherrecruitmentList(teacherrecruitment);
		if(list != null){
			return AjaxResult.success("获取成功").put("data",list.get(0));
		}else{
			return AjaxResult.error();
		}
	}
	/**
	 * 下载教师资格证考场管理导入模板
	 */
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate()
	{
		ExcelUtil<Teacherrecruitment> util = new ExcelUtil<Teacherrecruitment>(Teacherrecruitment.class);
		return util.importTemplateExcel("用户数据");
	}
	/**
	 * 导入教师资格证考场管理列表
	 */
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
	{
		ExcelUtil<Teacherrecruitment> util = new ExcelUtil<Teacherrecruitment>(Teacherrecruitment.class);
		List<Teacherrecruitment> TeacherrecruitmentList = util.importExcel(file.getInputStream());
		String message = teacherrecruitmentService.TeacherrecruitmentImport(TeacherrecruitmentList, updateSupport);
		return AjaxResult.success(message);
	}



	/**
	 * 导出列表
	 */
//	@RequiresPermissions("rfsj:teacherrecruitment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Teacherrecruitment teacherrecruitment)
    {
    	List<Teacherrecruitment> list = teacherrecruitmentService.selectTeacherrecruitmentList(teacherrecruitment);
        ExcelUtil<Teacherrecruitment> util = new ExcelUtil<Teacherrecruitment>(Teacherrecruitment.class);
        return util.exportExcel(list, "教师招聘考试考生信息");
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
//	@RequiresPermissions("rfsj:teacherrecruitment:add")
//	@Log(title = "新增", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Teacherrecruitment teacherrecruitment)
	{
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		teacherrecruitment.setExamid(uuid);
		return toAjax(teacherrecruitmentService.insertTeacherrecruitment(teacherrecruitment));
	}

	/**
	 * 修改
	 */
	@GetMapping("/edit/{examid}")
	public String edit(@PathVariable("examid") String examid, ModelMap mmap)
	{
		Teacherrecruitment teacherrecruitment = teacherrecruitmentService.selectTeacherrecruitmentById(examid);
		mmap.put("teacherrecruitment", teacherrecruitment);
	    return prefix + "/edit";
	}

	/**
	 * 修改保存
	 */
//	@RequiresPermissions("rfsj:teacherrecruitment:edit")
//	@Log(title = "修改", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Teacherrecruitment teacherrecruitment)
	{
		return toAjax(teacherrecruitmentService.updateTeacherrecruitment(teacherrecruitment));
	}

	/**
	 * 删除
	 */
//	@RequiresPermissions("rfsj:teacherrecruitment:remove")
//	@Log(title = "删除", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(teacherrecruitmentService.deleteTeacherrecruitmentByIds(ids));
	}



	@PostMapping("/turntable")
	@ResponseBody
	public AjaxResult turntable() {
		int x = teacherrecruitmentService.turntablesapiential();
		return toAjax(x);
	}

}