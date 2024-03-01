package com.sundata.edu.controller.kccx;

import com.sundata.edu.domain.ExaPostgraduate;
import com.sundata.edu.framework.web.controller.BaseController;
import com.sundata.edu.framework.web.result.AjaxResult;
import com.sundata.edu.framework.web.result.TableDataInfo;
import com.sundata.edu.service.ExaPostgraduateService;
import com.sundata.edu.util.ExcelUtil;
import com.sundata.edu.vo.ExaPostgraduateVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 *  研究生考试
 * 
 * @author zz
 * @date 2021-11-30 10:36:39
 */
@Controller
@RequestMapping("/exaPostgraduate")
public class ExaPostgraduateController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String prefix = "exaPostgraduate";
	
	@Autowired
	private ExaPostgraduateService exaPostgraduateService;
	
	//@RequiresPermissions("exaPostgraduate:view")
	@GetMapping()
	public String exaPostgraduate()
	{
	    return prefix + "/list";
	}



	/**
	 * 根据考生姓名和准考证号查询研考考场管理列表
	 */
	@RequestMapping("/table/selectEndurance")
	@ResponseBody
	public AjaxResult selectEndurance(String stuname, String candidateNumber){
		ExaPostgraduate exaPostgraduate = new ExaPostgraduate();
		exaPostgraduate.setStuname(stuname);
		exaPostgraduate.setCandidateNumber(candidateNumber);

		List<ExaPostgraduate> list = exaPostgraduateService.selectExaPostgraduateList(exaPostgraduate);

		if(list != null){
			return AjaxResult.success("获取成功").put("data",list.get(0));
		}else{
			return AjaxResult.error();
		}
	}

	/**
	 * 查询列表
	 */
	//@RequiresPermissions("exaPostgraduate:list")

	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExaPostgraduateVo exaPostgraduateVo)
	{
        startPage();
		List<ExaPostgraduate> list=exaPostgraduateService.getExaPostgraduates(exaPostgraduateVo);
        return getDataTable(list);
	}

	/**
	 * 导入研究生考试考场管理列表
	 */
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
	{
		ExcelUtil<ExaPostgraduate> util = new ExcelUtil<ExaPostgraduate>(ExaPostgraduate.class);
		List<ExaPostgraduate> ExaPostgraduateList = util.importExcel(file.getInputStream());
		String message = exaPostgraduateService.ExaPostgraduateImport(ExaPostgraduateList, updateSupport);
		return AjaxResult.success(message);
	}

	/**
	 * 下载研究生考试考场管理导入模板
	 */
	@GetMapping("/importTemplate")
	@ResponseBody
	public AjaxResult importTemplate()
	{
		ExcelUtil<ExaPostgraduate> util = new ExcelUtil<ExaPostgraduate>(ExaPostgraduate.class);
		return util.importTemplateExcel("研究生考试数据");
	}

	/**
	 * 导出研究生考试列表
	 */
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult export(ExaPostgraduate exaPostgraduate)
	{
		List<ExaPostgraduate> list = exaPostgraduateService.selectExaPostgraduateList(exaPostgraduate);
		ExcelUtil<ExaPostgraduate> util = new ExcelUtil<ExaPostgraduate>(ExaPostgraduate.class);
		return util.exportExcel(list, "研究生考试考生信息");
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
	//@RequiresPermissions("exaPostgraduate:add")
	//@Log(title = "", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult add(ExaPostgraduate exaPostgraduate)
	{
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		exaPostgraduate.setId(uuid);
		return toAjax(exaPostgraduateService.insertSelective(exaPostgraduate));
	}

	/**
	 * 修改
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id, ModelMap model)
	{
        model.put("exaPostgraduate", exaPostgraduateService.selectByPrimaryKey(id));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存
	 */
	//@RequiresPermissions("exaPostgraduate:edit")
	//@Log(title = "", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(ExaPostgraduate exaPostgraduate)
	{		
		return toAjax(exaPostgraduateService.updateByPrimaryKeySelective(exaPostgraduate));
	}
	
	/**
	 * 删除
	 */
	//@RequiresPermissions("exaPostgraduate:remove")
	//@Log(title = "", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(exaPostgraduateService.removes(ids));
	}


	@PostMapping( "/turntable")
	@ResponseBody
	public AjaxResult turntable()
	{
		int  x=exaPostgraduateService.turntablesapiential();
		return toAjax(x);
	}
}
