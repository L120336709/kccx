package com.sundata.edu.service;

import com.sundata.edu.domain.ExaPostgraduateTitle;

import java.util.List;

/**
 *  服务层
 * 
 * @author zz
 * @date 2021-11-30 11:54:15
 */
public interface ExaPostgraduateTitleService  {
    /**
     * 查询研考考试名称修改列表
     *
     * @param exaPostgraduateTitle 研考考试名称修改列表
     * @return 研考考试名称修改集合
     */
    List<ExaPostgraduateTitle> selectExaPostgraduateTitleList (ExaPostgraduateTitle exaPostgraduateTitle);

    /**
     * 修改教师资格证考试名称修改
     *
     * @param exaPostgraduateTitle 教师资格证考试名称修改
     * @return 结果
     */
    public int updateExaPostgraduateTitle(ExaPostgraduateTitle exaPostgraduateTitle);

}
