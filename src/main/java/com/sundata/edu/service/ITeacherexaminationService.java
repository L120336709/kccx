package com.sundata.edu.service;

import java.util.List;
import com.sundata.edu.domain.Teacherexamination;

/**
 * 教师资格证考场管理Service接口
 *
 * @author whj
 * @date 2021-10-25
 */
public interface ITeacherexaminationService
{
    /**
     * 查询教师资格证考场管理
     *
     * @param id 教师资格证考场管理主键
     * @return 教师资格证考场管理
     */
    public Teacherexamination selectTeacherexaminationById(Long id);

    /**
     * 查询教师资格证考场管理列表
     *
     * @param teacherexamination 教师资格证考场管理
     * @return 教师资格证考场管理集合
     */
    public List<Teacherexamination> selectTeacherexaminationList(Teacherexamination teacherexamination);

    /**
     * 新增教师资格证考场管理
     *
     * @param teacherexamination 教师资格证考场管理
     * @return 结果
     */
    public int insertTeacherexamination(Teacherexamination teacherexamination);

    /**
     * 修改教师资格证考场管理
     *
     * @param teacherexamination 教师资格证考场管理
     * @return 结果
     */
    public int updateTeacherexamination(Teacherexamination teacherexamination);

    /**
     * 批量删除教师资格证考场管理
     *
     * @param ids 需要删除的教师资格证考场管理主键集合
     * @return 结果
     */
    public int deleteTeacherexaminationByIds(String ids);

    /**
     * 删除教师资格证考场管理信息
     *
     * @param id 教师资格证考场管理主键
     * @return 结果
     */
    public int deleteTeacherexaminationById(Long id);
    /**
     * 导入教师资格证考场管理信息
     */

    public String Teacherexamination(List<Teacherexamination> teacherexaminationList, boolean updateSupport);

    int turntablesapiential();

}
