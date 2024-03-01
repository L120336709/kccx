package com.sundata.edu.service;

import com.sundata.edu.domain.Teacherrecruitment;

import java.util.List;

/**
 *  服务层
 *
 * @author shunguo
 * @date 2021-12-20
 */
public interface ITeacherrecruitmentService
{
	/**
     * 查询信息
     *
     * @param examid ID
     * @return 信息
     */
	public Teacherrecruitment selectTeacherrecruitmentById(String examid);

	/**
     * 查询列表
     *
     * @param teacherrecruitment 信息
     * @return 集合
     */
	public List<Teacherrecruitment> selectTeacherrecruitmentList(Teacherrecruitment teacherrecruitment);

	/**
     * 新增
     *
     * @param teacherrecruitment 信息
     * @return 结果
     */
	public int insertTeacherrecruitment(Teacherrecruitment teacherrecruitment);

	/**
     * 修改
     *
     * @param teacherrecruitment 信息
     * @return 结果
     */
	public int updateTeacherrecruitment(Teacherrecruitment teacherrecruitment);

	/**
     * 删除信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeacherrecruitmentByIds(String ids);


	/**
	 * 导入研究生考试考场信息
	 */

	public String TeacherrecruitmentImport(List<Teacherrecruitment> TeacherrecruitmentList, boolean updateSupport);

	int turntablesapiential();
}
