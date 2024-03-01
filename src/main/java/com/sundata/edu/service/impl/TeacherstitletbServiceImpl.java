package com.sundata.edu.service.impl;

import java.util.List;

import com.sundata.edu.dao.TeacherstitletbMapper;
import com.sundata.edu.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundata.edu.domain.Teacherstitletb;
import com.sundata.edu.service.ITeacherstitletbService;

/**
 * 教师资格证考试名称修改Service业务层处理
 *
 * @author whj
 * @date 2021-10-25
 */
@Service
public class TeacherstitletbServiceImpl implements ITeacherstitletbService
{
    @Autowired
    private TeacherstitletbMapper teacherstitletbMapper;

    /**
     * 查询教师资格证考试名称修改
     *
     * @param id 教师资格证考试名称修改主键
     * @return 教师资格证考试名称修改
     */
    @Override
    public Teacherstitletb selectTeacherstitletbById(Long id)
    {
        return teacherstitletbMapper.selectTeacherstitletbById(id);
    }

    /**
     * 查询教师资格证考试名称修改列表
     *
     * @param teacherstitletb 教师资格证考试名称修改
     * @return 教师资格证考试名称修改
     */
    @Override
    public List<Teacherstitletb> selectTeacherstitletbList(Teacherstitletb teacherstitletb)
    {
        return teacherstitletbMapper.selectTeacherstitletbList(teacherstitletb);
    }

    /**
     * 新增教师资格证考试名称修改
     *
     * @param teacherstitletb 教师资格证考试名称修改
     * @return 结果
     */
    @Override
    public int insertTeacherstitletb(Teacherstitletb teacherstitletb)
    {
        return teacherstitletbMapper.insertTeacherstitletb(teacherstitletb);
    }

    /**
     * 修改教师资格证考试名称修改
     *
     * @param teacherstitletb 教师资格证考试名称修改
     * @return 结果
     */
    @Override
    public int updateTeacherstitletb(Teacherstitletb teacherstitletb)
    {
        return teacherstitletbMapper.updateTeacherstitletb(teacherstitletb);
    }

    /**
     * 批量删除教师资格证考试名称修改
     *
     * @param ids 需要删除的教师资格证考试名称修改主键
     * @return 结果
     */
    @Override
    public int deleteTeacherstitletbByIds(String ids)
    {
        return teacherstitletbMapper.deleteTeacherstitletbByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教师资格证考试名称修改信息
     *
     * @param id 教师资格证考试名称修改主键
     * @return 结果
     */
    @Override
    public int deleteTeacherstitletbById(Long id)
    {
        return teacherstitletbMapper.deleteTeacherstitletbById(id);
    }
}
