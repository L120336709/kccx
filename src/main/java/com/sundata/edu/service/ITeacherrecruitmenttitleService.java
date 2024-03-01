package com.sundata.edu.service;

import com.sundata.edu.domain.Teacherrecruitmenttitle;

import java.util.List;

/**
 *  服务层
 *
 * @author shunguo
 * @date 2021-12-20
 */
public interface ITeacherrecruitmenttitleService
{
	/**
     * 查询信息
     *
     * @param id ID
     * @return 信息
     */
	public Teacherrecruitmenttitle selectTeacherrecruitmenttitleById(Integer id);

	/**
     * 查询列表
     *
     * @param teacherrecruitmenttitle 信息
     * @return 集合
     */
	public List<Teacherrecruitmenttitle> selectTeacherrecruitmenttitleList(Teacherrecruitmenttitle teacherrecruitmenttitle);

	/**
     * 新增
     *
     * @param teacherrecruitmenttitle 信息
     * @return 结果
     */
	public int insertTeacherrecruitmenttitle(Teacherrecruitmenttitle teacherrecruitmenttitle);

	/**
     * 修改
     *
     * @param teacherrecruitmenttitle 信息
     * @return 结果
     */
	public int updateTeacherrecruitmenttitle(Teacherrecruitmenttitle teacherrecruitmenttitle);

	/**
     * 删除信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeacherrecruitmenttitleByIds(String ids);

}
