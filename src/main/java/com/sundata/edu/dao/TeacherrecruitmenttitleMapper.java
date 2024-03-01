package com.sundata.edu.dao;

import com.sundata.edu.domain.Teacherrecruitmenttitle;

import java.util.List;

/**
 *  数据层
 *
 * @author shunguo
 * @date 2021-12-20
 */
public interface TeacherrecruitmenttitleMapper
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
     * 删除
     *
     * @param id ID
     * @return 结果
     */
	public int deleteTeacherrecruitmenttitleById(Integer id);

	/**
     * 批量删除
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeacherrecruitmenttitleByIds(String[] ids);

}