package com.sundata.edu.dao;

import com.sundata.edu.domain.Teacherrecruitment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  数据层
 *
 * @author shunguo
 * @date 2021-12-20
 */
public interface TeacherrecruitmentMapper
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
     * 删除
     *
     * @param examid ID
     * @return 结果
     */
	public int deleteTeacherrecruitmentById(String examid);

	/**
     * 批量删除
     *
     * @param examids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTeacherrecruitmentByIds(String[] examids);
	public int turntablesapiential();


	/**
	 * 根据准考证号批量查询
	 * @param examnumber
	 * @return
	 */
	List<Teacherrecruitment> findUserListByExamnumberList(@Param("list") List<String> examnumber);

	/**
	 * 批量插入数据
	 * @param teacherrecruitmentList
	 * @return
	 */
	int insertTeacherRecruitmentList(@Param("list") List<Teacherrecruitment> teacherrecruitmentList);

	/**
	 * 批量更新数据
	 * @param teacherrecruitmentList
	 * @return
	 */
	int updateTeacherRecruitmentList(@Param("list") List<Teacherrecruitment> teacherrecruitmentList);

}