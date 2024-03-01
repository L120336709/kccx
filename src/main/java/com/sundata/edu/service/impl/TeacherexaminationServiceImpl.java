package com.sundata.edu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sundata.edu.dao.TeacherexaminationMapper;
import com.sundata.edu.framework.exception.ServiceException;
import com.sundata.edu.util.Convert;
import com.sundata.edu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sundata.edu.domain.Teacherexamination;
import com.sundata.edu.service.ITeacherexaminationService;
import org.springframework.util.CollectionUtils;


/**
 * 教师资格证考场管理Service业务层处理
 *
 * @author whj
 * @date 2021-10-25
 */
@Service
public class TeacherexaminationServiceImpl implements ITeacherexaminationService
{
    @Autowired
    private TeacherexaminationMapper teacherexaminationMapper;

    /**
     * 查询教师资格证考场管理
     *
     * @param id 教师资格证考场管理主键
     * @return 教师资格证考场管理
     */
    @Override
    public Teacherexamination selectTeacherexaminationById(Long id)
    {
        return teacherexaminationMapper.selectTeacherexaminationById(id);
    }

    /**
     * 查询教师资格证考场管理列表
     *
     * @param teacherexamination 教师资格证考场管理
     * @return 教师资格证考场管理
     */
    @Override
    public List<Teacherexamination> selectTeacherexaminationList(Teacherexamination teacherexamination)
    {
        return teacherexaminationMapper.selectTeacherexaminationList(teacherexamination);
    }

    /**
     * 新增教师资格证考场管理
     *
     * @param teacherexamination 教师资格证考场管理
     * @return 结果
     */
    @Override
    public int insertTeacherexamination(Teacherexamination teacherexamination)
    {
        return teacherexaminationMapper.insertTeacherexamination(teacherexamination);
    }

    /**
     * 修改教师资格证考场管理
     *
     * @param teacherexamination 教师资格证考场管理
     * @return 结果
     */
    @Override
    public int updateTeacherexamination(Teacherexamination teacherexamination)
    {
        return teacherexaminationMapper.updateTeacherexamination(teacherexamination);
    }

    /**
     * 批量删除教师资格证考场管理
     *
     * @param ids 需要删除的教师资格证考场管理主键
     * @return 结果
     */
    @Override
    public int deleteTeacherexaminationByIds(String ids)
    {
        return teacherexaminationMapper.deleteTeacherexaminationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教师资格证考场管理信息
     *
     * @param id 教师资格证考场管理主键
     * @return 结果
     */
    @Override
    public int deleteTeacherexaminationById(Long id)
    {
        return teacherexaminationMapper.deleteTeacherexaminationById(id);
    }

    @Override
    public int turntablesapiential( )
    {
        return teacherexaminationMapper.turntablesapiential();
    }
    /**
     *
     * 导出教师资格证考场管理信息
     *
     *
     */
    @Override
    public String Teacherexamination(List<Teacherexamination> TeacherexaminationList, boolean updateSupport) {
        if (StringUtils.isNull(TeacherexaminationList) || TeacherexaminationList.size() == 0)
        {
            throw new ServiceException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<Teacherexamination> teacherexaminationlistinsert=new ArrayList<>();
        List<Teacherexamination> teacherexaminationlistupdate=new ArrayList<>();

        List<String> candidateNumber=new ArrayList<>();
        for (Teacherexamination teacherexamination : TeacherexaminationList)
        {
            candidateNumber.add(teacherexamination.getExamregistrationnumber());
        }

        //查询已经存在的数据
        List<Teacherexamination> teacherexaminationds=teacherexaminationMapper.findListByIdList(candidateNumber);


        String[][] Enumbers=new String[teacherexaminationds.size()][2];
        for (int i=0;i<teacherexaminationds.size();i++){
            Enumbers[i][0]=teacherexaminationds.get(i).getExamregistrationnumber();
            Enumbers[i][1]=teacherexaminationds.get(i).getId()+"";
        }

        //把存在的和不存在的数据分别保存，进行插入和更新
        for(Teacherexamination teacherexamination : TeacherexaminationList ){
            //判断是否存在，存在放入teacherexaminationlistupdate，不存在放入teacherexaminationlistinsert
            boolean i=false;//用于判断是否已经放入存在的集合
            for (int j=0;j<teacherexaminationds.size();j++){
                if(Enumbers[j][0].equals(teacherexamination.getExamregistrationnumber())){
                    teacherexamination.setId(Long.parseLong(Enumbers[j][1]));
                    teacherexaminationlistupdate.add(teacherexamination);
                    i=true;
                }
            }
//            for (Teacherexamination teacherexaminationd:teacherexaminationds){
//                if(teacherexaminationd.getExamregistrationnumber().equals(teacherexamination.getExamregistrationnumber())){
//                    teacherexamination.setId(teacherexaminationd.getId());
//                    teacherexaminationlistupdate.add(teacherexamination);
//                    i=true;
//                }
//            }
            if(i==false){ 
                teacherexaminationlistinsert.add(teacherexamination);
            }
        }

        //分别对新增数据和更新数据进行操作
        if(teacherexaminationlistinsert.size()>0){
            teacherexaminationMapper.insertTeacherexaminationList(teacherexaminationlistinsert);
            successNum=successNum+teacherexaminationlistinsert.size();
            for(Teacherexamination mes : teacherexaminationlistinsert){
                successMsg.append("<br/>" +  mes.getExamregistrationnumber() + "考生考场信息 "  + " 导入成功");
            }

        }
        if(teacherexaminationlistupdate.size()>0){
            if(updateSupport){
                List<Teacherexamination> teacherexaminationlistupdates=new ArrayList<>();
                for(int i=0;i<teacherexaminationlistupdate.size();i++){
                    if(i%2000==0){
                        if(teacherexaminationlistupdates.size()>0){
                            teacherexaminationMapper.updateTeacherexaminationList(teacherexaminationlistupdates);
                            teacherexaminationlistupdates=new ArrayList<>();
                        }
                    }else {
                        teacherexaminationlistupdates.add(teacherexaminationlistupdate.get(i));
                    }
                }

                //teacherexaminationMapper.updateTeacherexaminationList(teacherexaminationlistupdate);


                successNum=successNum+teacherexaminationlistupdate.size();
                for(Teacherexamination mes : teacherexaminationlistupdate){
                    successMsg.append("<br/>" + mes.getExamregistrationnumber() + "考生考场信息 " + " 更新成功");
                }
            }else {
                failureNum=failureNum+teacherexaminationlistupdate.size();
                for(Teacherexamination mes : teacherexaminationlistupdate){
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
