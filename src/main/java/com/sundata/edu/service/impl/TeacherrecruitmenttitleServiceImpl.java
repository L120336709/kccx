package com.sundata.edu.service.impl;

import com.sundata.edu.dao.TeacherrecruitmenttitleMapper;
import com.sundata.edu.domain.Teacherrecruitmenttitle;
import com.sundata.edu.service.ITeacherrecruitmenttitleService;
import com.sundata.edu.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务层实现
 *
 * @author shunguo
 * @date 2021-12-20
 */
@Service
public class TeacherrecruitmenttitleServiceImpl implements ITeacherrecruitmenttitleService
{
	@Autowired
	private TeacherrecruitmenttitleMapper teacherrecruitmenttitleMapper;

	/**
     * 查询信息
     *
     * @param id ID
     * @return 信息
     */
    @Override
	public Teacherrecruitmenttitle selectTeacherrecruitmenttitleById(Integer id)
	{
	    return teacherrecruitmenttitleMapper.selectTeacherrecruitmenttitleById(id);
	}

	/**
     * 查询列表
     *
     * @param teacherrecruitmenttitle 信息
     * @return 集合
     */
	@Override
	public List<Teacherrecruitmenttitle> selectTeacherrecruitmenttitleList(Teacherrecruitmenttitle teacherrecruitmenttitle)
	{
	    return teacherrecruitmenttitleMapper.selectTeacherrecruitmenttitleList(teacherrecruitmenttitle);
	}

    /**
     * 新增
     *
     * @param teacherrecruitmenttitle 信息
     * @return 结果
     */
	@Override
	public int insertTeacherrecruitmenttitle(Teacherrecruitmenttitle teacherrecruitmenttitle)
	{
	    return teacherrecruitmenttitleMapper.insertTeacherrecruitmenttitle(teacherrecruitmenttitle);
	}

	/**
     * 修改
     *
     * @param teacherrecruitmenttitle 信息
     * @return 结果
     */
	@Override
	public int updateTeacherrecruitmenttitle(Teacherrecruitmenttitle teacherrecruitmenttitle)
	{
	    return teacherrecruitmenttitleMapper.updateTeacherrecruitmenttitle(teacherrecruitmenttitle);
	}

	/**
     * 删除对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeacherrecruitmenttitleByIds(String ids)
	{
		return teacherrecruitmenttitleMapper.deleteTeacherrecruitmenttitleByIds(Convert.toStrArray(ids));
	}

}
