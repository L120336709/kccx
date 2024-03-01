package com.sundata.edu.dao;

import com.sundata.edu.domain.ExaPostgraduateTitle;

import java.util.List;

/**
 * 教师资格证考试名称修改Mapper接口
 *
 * @author whj
 * @date 2021-10-25
 */
public interface ExaPostgraduteMapper
{



    /**
     * 查询研考考试名称修改列表
     *
     * @param exaPostgraduateTitle 研考考试名称修改
     * @return 教研考考试名称修改集合
     */
    public List<ExaPostgraduateTitle> selectExaPostgraduateTitleList(ExaPostgraduateTitle exaPostgraduateTitle);


    /**
     * 修改教师资格证考试名称修改
     *
     * @param exaPostgraduateTitle 教师资格证考试名称修改
     * @return 结果
     */
    public int updateExaPostgraduateTitle(ExaPostgraduateTitle exaPostgraduateTitle);


}
