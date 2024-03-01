package com.sundata.edu.dao;

import com.sundata.edu.domain.ExaPostgraduate;
import com.sundata.edu.framework.core.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  数据层
 * 
 * @author zz
 * @date 2021-11-30 10:36:39
 */
public interface ExaPostgraduateDao extends Mapper<ExaPostgraduate> {

    public List<ExaPostgraduate> selectExaPostgraduateList(ExaPostgraduate exaPostgraduate);

    /**
     * 导入数据时查询是否已经录入过数据
     * @param exaPostgraduate
     * @return
     */
    public List<ExaPostgraduate> selectExaPostgraduateExi(ExaPostgraduate exaPostgraduate);
    public int turntablesapiential();
    /**
     * 新增教师资格证考场管理
     *
     * @param exaPostgraduate 教师资格证考场管理
     * @return 结果
     */
    public int insertExaPostgraduate(ExaPostgraduate exaPostgraduate);

    /**
     * 修改教师资格证考场管理
     *
     * @param exaPostgraduate 教师资格证考场管理
     * @return 结果
     */
    public int updateExaPostgraduate(ExaPostgraduate exaPostgraduate);

    /**
     * 批量插入数据
     * @param ExaPostgraduate
     * @return
     */
    int insertExaPostgraduateList(@Param("list") List<ExaPostgraduate> ExaPostgraduate);

    /**
     * 批量更新数据
     * @param ExaPostgraduate
     * @return
     */
    int updateExaPostgraduateList(@Param("list") List<ExaPostgraduate> ExaPostgraduate);

    /**
     * 批量查询
     * @param candidateNumber
     * @return
     */
    List<ExaPostgraduate> findUserListByIdList(@Param("list") List<String> candidateNumber);


    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteExaPostgraduateByIds(List<String> ids);


}