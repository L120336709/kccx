package com.sundata.edu.dao;

import java.util.List;
import com.sundata.edu.domain.Teacherexamination;
import org.apache.ibatis.annotations.Param;

/**
 * 教师资格证考场管理Mapper接口
 *
 * @author whj
 * @date 2021-10-25
 */
public interface TeacherexaminationMapper
{

    /**
     * 批量查询
     */
    List<Teacherexamination> findListByIdList(@Param("list") List<String> examregistrationnumber);

    /**
     * 批量插入数据
     */
    int insertTeacherexaminationList(@Param("list") List<Teacherexamination> teacherexamination);

    /**
     * 批量更新数据
     */
    int updateTeacherexaminationList(@Param("list") List<Teacherexamination> teacherexamination);


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
     * 删除教师资格证考场管理
     *
     * @param id 教师资格证考场管理主键
     * @return 结果
     */
    public int deleteTeacherexaminationById(Long id);
    public int turntablesapiential();
    /**
     * 批量删除教师资格证考场管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeacherexaminationByIds(String[] ids);
}
