package com.sundata.edu.service.impl;

import com.sundata.edu.dao.ExaPostgraduateDao;
import com.sundata.edu.domain.ExaPostgraduate;
import com.sundata.edu.framework.core.AbstractService;
import com.sundata.edu.framework.exception.ServiceException;
import com.sundata.edu.service.ExaPostgraduateService;
import com.sundata.edu.util.StringUtils;
import com.sundata.edu.vo.ExaPostgraduateVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *  服务层实现
 * 
 * @author ljg
 * @date 2021-11-30 10:36:39
 */
@Service("exaPostgraduateService")
//@Transactional
public class ExaPostgraduateServiceImpl extends AbstractService<ExaPostgraduate> implements ExaPostgraduateService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
	private ExaPostgraduateDao exaPostgraduateDao;

    @Override
    public List<ExaPostgraduate> getExaPostgraduates(ExaPostgraduateVo exaPostgraduateVo) {
        Example example = new Example(ExaPostgraduate.class);
        Example.Criteria criteria = example.createCriteria();
        if(exaPostgraduateVo.getStuname()!=null&&exaPostgraduateVo.getStuname()!=""){
            criteria.andEqualTo("stuname",exaPostgraduateVo.getStuname());
        }
        if(exaPostgraduateVo.getCandidateNumber()!=null&&exaPostgraduateVo.getCandidateNumber()!=""){
            criteria.andEqualTo("candidateNumber",exaPostgraduateVo.getCandidateNumber());
        }

        //criteria.andEqualTo("", "");
        return exaPostgraduateDao.selectByExample(example);

    }

    @Override
    public List<ExaPostgraduate> selectExaPostgraduateList(ExaPostgraduate exaPostgraduate) {
        return exaPostgraduateDao.selectExaPostgraduateList(exaPostgraduate);
    }

    /**
     * 导入数据时查询是否有相同数据（只查姓名和考场编号）
     * @param exaPostgraduate
     * @return
     */
    public List<ExaPostgraduate> selectExaPostgraduateExi(ExaPostgraduate exaPostgraduate) {
        return exaPostgraduateDao.selectExaPostgraduateExi(exaPostgraduate);
    }

    @Override
    public int turntablesapiential( )
    {
        return exaPostgraduateDao.turntablesapiential();
    }

    @Override
    public int removes(String ids) {
//        Example example = new Example(ExaPostgraduate.class);
//        Example.Criteria criteria = example.createCriteria();
//        List<Object> idArray = new ArrayList<>();
//        for (String id : ids.split(",")) {
//            idArray.add(id);
//        }
//        criteria.andIn("id", idArray);
//        ExaPostgraduate exaPostgraduate = new ExaPostgraduate();
        //exaPostgraduate.setIsdelete(1);
        //return exaPostgraduateDao.updateByExampleSelective(exaPostgraduate, example);
        List<String> idlist = new ArrayList<>();
       // System.err.println("删除-----------------");
        for (String id : ids.split(",")) {
            idlist.add(id);
            //System.err.println(id);
        }
        return exaPostgraduateDao.deleteExaPostgraduateByIds(idlist);
    }
    /**
     * 新增研究生考试考场信息
     *
     * @param exaPostgraduate 研究生考试考场信息管理
     * @return 结果
     */
    public int insertExaPostgraduate(ExaPostgraduate exaPostgraduate){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        exaPostgraduate.setId(uuid);
        return  exaPostgraduateDao.insertExaPostgraduate(exaPostgraduate);
    }

    /**
     * 修改研究生考试考场信息
     *
     * @param exaPostgraduate 研究生考试考场信息管理
     * @return 结果
     */
    public int updateExaPostgraduate(ExaPostgraduate exaPostgraduate){
        return  exaPostgraduateDao.updateExaPostgraduate(exaPostgraduate);
    }

    /**
     * 导入研考考生信息
     * @param ExaPostgraduateList
     * @param updateSupport
     * @return
     */
    public String ExaPostgraduateImport(List<ExaPostgraduate> ExaPostgraduateList, boolean updateSupport){
        if (StringUtils.isNull(ExaPostgraduateList) || ExaPostgraduateList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        List<ExaPostgraduate> exaPostgraduatelistinsert=new ArrayList<>();
        List<ExaPostgraduate> exaPostgraduatelistupdate=new ArrayList<>();

        List<String> candidateNumber=new ArrayList<>();
        for (ExaPostgraduate exaPostgraduate : ExaPostgraduateList)
        {
            candidateNumber.add(exaPostgraduate.getCandidateNumber());
        }

        //查询已经存在的数据
        List<ExaPostgraduate> exaPostgraduateds=exaPostgraduateDao.findUserListByIdList(candidateNumber);

        //把存在的和不存在的数据分别保存，进行插入和更新
        for(ExaPostgraduate exaPostgraduate : ExaPostgraduateList ){
            //判断是否存在，存在放入exaPostgraduatelistupdate，不存在放入exaPostgraduatelistinsert
            boolean i=false;//用于判断是否已经放入存在的集合
            for (ExaPostgraduate exaPostgraduated:exaPostgraduateds){
               if(exaPostgraduated.getCandidateNumber().equals(exaPostgraduate.getCandidateNumber())){
                   exaPostgraduate.setId(exaPostgraduated.getId());
                    exaPostgraduatelistupdate.add(exaPostgraduate);
                    i=true;
               }
            }
            if(i==false){
                String uuid = UUID.randomUUID().toString().replaceAll("-","");
                exaPostgraduate.setId(uuid);
                exaPostgraduatelistinsert.add(exaPostgraduate);
            }

        }
        //分别对新增数据和更新数据进行操作
        if(exaPostgraduatelistinsert.size()>0){
            exaPostgraduateDao.insertExaPostgraduateList(exaPostgraduatelistinsert);
            successNum=successNum+exaPostgraduatelistinsert.size();
            for(ExaPostgraduate mes : exaPostgraduatelistinsert){
                successMsg.append("<br/>" +  mes.getCandidateNumber() + "考生考场信息 "  + " 导入成功");
            }

        }
        if(exaPostgraduatelistupdate.size()>0){
            if(updateSupport){
                exaPostgraduateDao.updateExaPostgraduateList(exaPostgraduatelistupdate);
                successNum=successNum+exaPostgraduatelistupdate.size();
                for(ExaPostgraduate mes : exaPostgraduatelistupdate){
                    successMsg.append("<br/>" + mes.getCandidateNumber() + "考生考场信息 " + " 更新成功");
                }
            }else {
                failureNum=failureNum+exaPostgraduatelistupdate.size();
                for(ExaPostgraduate mes : exaPostgraduatelistupdate){
                    failureMsg.append("<br/>" + mes.getCandidateNumber() + "考生考场信息 "  + " 已存在");
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
