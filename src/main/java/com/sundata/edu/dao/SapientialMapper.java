package com.sundata.edu.dao;

import com.sundata.edu.domain.Sapiential;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 成人高考考场管理Mapper接口
 *
 * @author 小王
 * @date 2021-10-20
 */
public interface SapientialMapper
{

    /**
     * 批量查询
     */
    List<Sapiential> findListByIdList(@Param("list") List<String> examregistrationnumber);

    /**
     * 批量插入数据
     */
    int insertSapientialList(@Param("list") List<Sapiential> sapiential);

    /**
     * 批量更新数据
     */
    int updateSapientialList(@Param("list") List<Sapiential> sapiential);
    /**
     * 查询成人高考考场管理
     *
     * @param id 成人高考考场管理主键
     * @return 成人高考考场管理
     */
    public Sapiential selectSapientialById(Long id);

    /**
     * 查询成人高考考场管理列表
     *
     * @param sapiential 成人高考考场管理
     * @return 成人高考考场管理集合
     */
    public List<Sapiential> selectSapientialList(Sapiential sapiential);

    /**
     * 新增成人高考考场管理
     *
     * @param sapiential 成人高考考场管理
     * @return 结果
     */
    public int insertSapiential(Sapiential sapiential);

    /**
     * 修改成人高考考场管理
     *
     * @param sapiential 成人高考考场管理
     * @return 结果
     */
    public int updateSapiential(Sapiential sapiential);

    /**
     * 删除成人高考考场管理
     *
     * @param id 成人高考考场管理主键
     * @return 结果
     */
    public int deleteSapientialById(Long id);

    /**
     * 批量删除成人高考考场管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSapientialByIds(String[] ids);

    public int turntablesapiential();

}
