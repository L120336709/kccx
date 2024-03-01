package com.sundata.edu.service;

import java.util.List;
import com.sundata.edu.domain.Teacherstitletb;

/**
 * 教师资格证考试名称修改Service接口
 * 
 * @author whj
 * @date 2021-10-25
 */
public interface ITeacherstitletbService 
{
    /**
     * 查询教师资格证考试名称修改
     * 
     * @param id 教师资格证考试名称修改主键
     * @return 教师资格证考试名称修改
     */
    public Teacherstitletb selectTeacherstitletbById(Long id);

    /**
     * 查询教师资格证考试名称修改列表
     * 
     * @param teacherstitletb 教师资格证考试名称修改
     * @return 教师资格证考试名称修改集合
     */
    public List<Teacherstitletb> selectTeacherstitletbList(Teacherstitletb teacherstitletb);

    /**
     * 新增教师资格证考试名称修改
     * 
     * @param teacherstitletb 教师资格证考试名称修改
     * @return 结果
     */
    public int insertTeacherstitletb(Teacherstitletb teacherstitletb);

    /**
     * 修改教师资格证考试名称修改
     * 
     * @param teacherstitletb 教师资格证考试名称修改
     * @return 结果
     */
    public int updateTeacherstitletb(Teacherstitletb teacherstitletb);

    /**
     * 批量删除教师资格证考试名称修改
     * 
     * @param ids 需要删除的教师资格证考试名称修改主键集合
     * @return 结果
     */
    public int deleteTeacherstitletbByIds(String ids);

    /**
     * 删除教师资格证考试名称修改信息
     * 
     * @param id 教师资格证考试名称修改主键
     * @return 结果
     */
    public int deleteTeacherstitletbById(Long id);
}
