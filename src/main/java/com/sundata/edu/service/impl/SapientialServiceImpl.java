package com.sundata.edu.service.impl;

import java.util.*;

import com.sundata.edu.dao.SapientialMapper;
import com.sundata.edu.domain.Sapiential;
import com.sundata.edu.framework.exception.ServiceException;
import com.sundata.edu.service.ISapientialService;
import com.sundata.edu.util.Convert;
import com.sundata.edu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


/**
 * 成人高考考场管理Service业务层处理
 *
 * @author 小王
 * @date 2021-10-20
 */
@Service
public class SapientialServiceImpl implements ISapientialService
{
   @Autowired
   private SapientialMapper sapientialMapper;
    /**
     * 查询成人高考考场管理
     *
     * @param id 成人高考考场管理主键
     * @return 成人高考考场管理
     */
    @Override
    public Sapiential selectSapientialById(Long id)
    {
        return sapientialMapper.selectSapientialById(id);
    }

    /**
     * 查询成人高考考场管理列表
     *
     * @param sapiential 成人高考考场管理
     * @return 成人高考考场管理
     */
    @Override
    public List<Sapiential> selectSapientialList(Sapiential sapiential)
    {
        return sapientialMapper.selectSapientialList(sapiential);
    }

    /**
     * 新增成人高考考场管理
     *
     * @param sapiential 成人高考考场管理
     * @return 结果
     */
    @Override
    public int insertSapiential(Sapiential sapiential)
    {
        return sapientialMapper.insertSapiential(sapiential);
    }

    /**
     * 修改成人高考考场管理
     *
     * @param sapiential 成人高考考场管理
     * @return 结果
     */
    @Override
    public int updateSapiential(Sapiential sapiential)
    {
        return sapientialMapper.updateSapiential(sapiential);
    }

    /**
     * 批量删除成人高考考场管理
     *
     * @param ids 需要删除的成人高考考场管理主键
     * @return 结果
     */
    @Override
    public int deleteSapientialByIds(String ids)
    {
        return sapientialMapper.deleteSapientialByIds(Convert.toStrArray(ids));
    }

    @Override
    public int turntablesapiential( )
    {
        return sapientialMapper.turntablesapiential();
    }


    /**
     * 删除成人高考考场管理信息
     *
     * @param id 成人高考考场管理主键
     * @return 结果
     */
    @Override
    public int deleteSapientialById(Long id)
    {

        return sapientialMapper.deleteSapientialById(id);
    }

    @Override
    public String importSapiential(List<Sapiential> sapientialList, boolean updateSupport) {
        if (StringUtils.isNull(sapientialList) || sapientialList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        List<Sapiential> sapientiallistinsert=new ArrayList<>();
        List<Sapiential> sapientiallistupdate=new ArrayList<>();

        List<String> candidateNumber=new ArrayList<>();
        for (Sapiential sapiential : sapientialList)
        {
            candidateNumber.add(sapiential.getExamregistrationnumber()); //准考证号
        }

        //查询已经存在的数据
        List<Sapiential> sapientialds=sapientialMapper.findListByIdList(candidateNumber);

        String[][] Enumbers=new String[sapientialds.size()][2];
        for (int i=0;i<sapientialds.size();i++){
            Enumbers[i][0]=sapientialds.get(i).getExamregistrationnumber();
            Enumbers[i][1]=sapientialds.get(i).getId()+"";
        }
        //把存在的和不存在的数据分别保存，进行插入和更新
        for(Sapiential sapiential : sapientialList ){
            //判断是否存在，存在放入sapientiallistupdate，不存在放入sapientiallistinsert
            boolean i=false;//用于判断是否已经放入存在的集合
            for (int j=0;j<sapientialds.size();j++){
                if(Enumbers[j][0].equals(sapiential.getExamregistrationnumber())){
                    sapiential.setId(Long.parseLong(Enumbers[j][1]));
                    sapientiallistupdate.add(sapiential);
                    i=true;
                }
            }
//            for (Sapiential sapientiald:sapientialds){
//                if(sapientiald.getExamregistrationnumber().equals(sapiential.getExamregistrationnumber())){
//                    sapiential.setId(sapientiald.getId());
//                    sapientiallistupdate.add(sapiential);
//                    i=true;
//                }
//            }
            if(i==false){
                sapientiallistinsert.add(sapiential);
            }

        }
        //分别对新增数据和更新数据进行操作
        if(sapientiallistinsert.size()>0){
            sapientialMapper.insertSapientialList(sapientiallistinsert);
            successNum=successNum+sapientiallistinsert.size();
            for(Sapiential mes : sapientiallistinsert){
                successMsg.append("<br/>" +  mes.getExamregistrationnumber() + "考生考场信息 "  + " 导入成功");
            }

        }
        if(sapientiallistupdate.size()>0){
            if(updateSupport){
                List<Sapiential> sapientiallistupdates=new ArrayList<>();
                for(int i=0;i<sapientiallistupdate.size();i++){
                    if(i%2000==0){
                        if(sapientiallistupdates.size()>0){
                            sapientialMapper.updateSapientialList(sapientiallistupdates);
                            sapientiallistupdates=new ArrayList<>();
                        }
                    }else {
                        sapientiallistupdates.add(sapientiallistupdate.get(i));
                    }
                }

               // sapientialMapper.updateSapientialList(sapientiallistupdate);
                successNum=successNum+sapientiallistupdate.size();
                for(Sapiential mes : sapientiallistupdate){
                    successMsg.append("<br/>" + mes.getExamregistrationnumber() + "考生考场信息 " + " 更新成功");
                }
            }else {
                failureNum=failureNum+sapientiallistupdate.size();
                for(Sapiential mes : sapientiallistupdate){
                    failureMsg.append("<br/>" + mes.getExamregistrationnumber() + "考生考场信息 "  + " 已存在");
                }

            }
        }

        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString(),new Throwable());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

}




