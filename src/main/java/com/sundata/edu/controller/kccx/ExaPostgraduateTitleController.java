package com.sundata.edu.controller.kccx;

import com.sundata.edu.domain.ExaPostgraduateTitle;
import com.sundata.edu.framework.web.controller.BaseController;
import com.sundata.edu.framework.web.result.AjaxResult;
import com.sundata.edu.framework.web.result.TableDataInfo;
import com.sundata.edu.service.ExaPostgraduateTitleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  信息操作处理
 * 
 * @author zz
 * @date 2021-11-30 11:54:15
 */
@Controller
@RequestMapping("/exaPostgraduateTitle")
public class ExaPostgraduateTitleController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String prefix = "exaPostgraduateTitle";
	
	@Autowired
	private ExaPostgraduateTitleService exaPostgraduateTitleService;
	
	//@RequiresPermissions("exaPostgraduateTitle:view")
	@GetMapping()
	public String exaPostgraduateTitle()
	{
	    return prefix + "/list";
	}


	/**
	 * 查询根据查询成人高考标题
	 */
	@RequestMapping("/table/selectTitle")
	@ResponseBody
	public AjaxResult selectEndurance(Integer id){
		ExaPostgraduateTitle exaPostgraduateTitle=new ExaPostgraduateTitle();
		exaPostgraduateTitle.setId(id);
		List<ExaPostgraduateTitle> list = exaPostgraduateTitleService.selectExaPostgraduateTitleList(exaPostgraduateTitle);
		if(list != null){
			return AjaxResult.success("获取成功").put("data",list.get(0));
		}else{
			return AjaxResult.error();
		}
	}


	/**
	 * 查询列表
	 */
	//@RequiresPermissions("exaPostgraduateTitle:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ExaPostgraduateTitle exaPostgraduateTitle)
	{
        startPage();
		List<ExaPostgraduateTitle> list=exaPostgraduateTitleService.selectExaPostgraduateTitleList(exaPostgraduateTitle);
        return getDataTable(list);
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
	//@RequiresPermissions("exaPostgraduateTitle:add")
	//@Log(title = "", action = BusinessType.INSERT)
//	@PostMapping("/add")
//	@ResponseBody
//	public AjaxResult add(ExaPostgraduateTitle exaPostgraduateTitle)
//	{
//		return toAjax(exaPostgraduateTitleService.insertSelective(exaPostgraduateTitle));
//	}

	/**
	 * 修改
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap model)
	{
        ExaPostgraduateTitle exaPostgraduateTitle=new ExaPostgraduateTitle();
        exaPostgraduateTitle.setId(id);
        model.put("exaPostgraduateTitle", exaPostgraduateTitleService.selectExaPostgraduateTitleList(exaPostgraduateTitle).get(0));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存
	 */
	//@RequiresPermissions("exaPostgraduateTitle:edit")
	//@Log(title = "", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(ExaPostgraduateTitle exaPostgraduateTitle)
	{
		return toAjax(exaPostgraduateTitleService.updateExaPostgraduateTitle(exaPostgraduateTitle));
	}
	
	/**
	 * 删除
	 */
	//@RequiresPermissions("exaPostgraduateTitle:remove")
	//@Log(title = "", action = BusinessType.DELETE)
//	@PostMapping( "/remove")
//	@ResponseBody
//	public AjaxResult remove(String ids)
//	{
//		return toAjax(exaPostgraduateTitleService.removes(ids));
//	}
//
}
