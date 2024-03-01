package com.sundata.edu.service;

import com.sundata.edu.domain.ExaPostgraduate;
import com.sundata.edu.framework.core.Service;
import com.sundata.edu.vo.ExaPostgraduateVo;

import java.util.List;

/**
 *  服务层
 * 
 * @author zz
 * @date 2021-11-30 10:36:39
 */
public interface ExaPostgraduateService extends Service<ExaPostgraduate> {

    /**
    * 根据条件查询列表
    * @param exaPostgraduateVo
    * @return
    */
    List<ExaPostgraduate> getExaPostgraduates(ExaPostgraduateVo exaPostgraduateVo);

    /**
    * 逻辑删除 修改isdelete字段
    *
    * @param ids
    * @return
    */
    int removes(String ids);

    int turntablesapiential();
    /**
     * 条件查询考场信息
     * @param exaPostgraduate
     * @return
     */
    public List<ExaPostgraduate> selectExaPostgraduateList(ExaPostgraduate exaPostgraduate);
    /**
     * 导入研究生考试考场信息
     */

    public String ExaPostgraduateImport(List<ExaPostgraduate> ExaPostgraduateList, boolean updateSupport);

    /**
     * 新增研究生考试考场信息
     *
     * @param exaPostgraduate 研究生考试考场信息管理
     * @return 结果
     */
    public int insertExaPostgraduate(ExaPostgraduate exaPostgraduate);

    /**
     * 修改研究生考试考场信息
     *
     * @param exaPostgraduate 研究生考试考场信息管理
     * @return 结果
     */
    public int updateExaPostgraduate(ExaPostgraduate exaPostgraduate);

}
