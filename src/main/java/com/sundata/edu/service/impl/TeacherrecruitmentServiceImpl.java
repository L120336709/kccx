package com.sundata.edu.service.impl;

import com.sundata.edu.dao.TeacherrecruitmentMapper;
import com.sundata.edu.domain.Teacherrecruitment;
import com.sundata.edu.framework.exception.ServiceException;
import com.sundata.edu.service.ITeacherrecruitmentService;
import com.sundata.edu.util.Convert;
import com.sundata.edu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *  服务层实现
 *
 * @author shunguo
 * @date 2021-12-20
 */
@Service
public class TeacherrecruitmentServiceImpl implements ITeacherrecruitmentService
{
	@Autowired
	private TeacherrecruitmentMapper teacherrecruitmentMapper;

	/**
     * 查询信息
     *
     * @param examid ID
     * @return 信息
     */
    @Override
	public Teacherrecruitment selectTeacherrecruitmentById(String examid)
	{
	    return teacherrecruitmentMapper.selectTeacherrecruitmentById(examid);
	}

	/**
     * 查询列表
     *
     * @param teacherrecruitment 信息
     * @return 集合
     */
	@Override
	public List<Teacherrecruitment> selectTeacherrecruitmentList(Teacherrecruitment teacherrecruitment)
	{
	    return teacherrecruitmentMapper.selectTeacherrecruitmentList(teacherrecruitment);
	}

    /**
     * 新增
     *
     * @param teacherrecruitment 信息
     * @return 结果
     */
	@Override
	public int insertTeacherrecruitment(Teacherrecruitment teacherrecruitment)
	{
	    return teacherrecruitmentMapper.insertTeacherrecruitment(teacherrecruitment);
	}

	/**
     * 修改
     *
     * @param teacherrecruitment 信息
     * @return 结果
     */
	@Override
	public int updateTeacherrecruitment(Teacherrecruitment teacherrecruitment)
	{
	    return teacherrecruitmentMapper.updateTeacherrecruitment(teacherrecruitment);
	}

	/**
     * 删除对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTeacherrecruitmentByIds(String ids)
	{
		return teacherrecruitmentMapper.deleteTeacherrecruitmentByIds(Convert.toStrArray(ids));
	}

	@Override
	public int turntablesapiential( )
	{
		return teacherrecruitmentMapper.turntablesapiential();
	}
	/**
	 * 导入研考考生信息
	 * @param TeacherrecruitmentList
	 * @param updateSupport
	 * @return
	 */
	public String TeacherrecruitmentImport(List<Teacherrecruitment> TeacherrecruitmentList, boolean updateSupport){
		if (StringUtils.isNull(TeacherrecruitmentList) || TeacherrecruitmentList.size() == 0)
		{
			throw new ServiceException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		List<Teacherrecruitment> teacherrecruitmentlistinsert=new ArrayList<>();
		List<Teacherrecruitment> teacherrecruitmentlistupdate=new ArrayList<>();
		List<String> examnumber=new ArrayList<>();

		//取出所有数据的准考证号，用户判断该条数据是否已经存在。不存在插入，存在更新
		for (Teacherrecruitment teacherrecruitment : TeacherrecruitmentList)
		{
			examnumber.add(teacherrecruitment.getExamnumber());
		}

		//查询已经存在的数据
		List<Teacherrecruitment> teacherrecruitments=teacherrecruitmentMapper.findUserListByExamnumberList(examnumber);

		//把存在的和不存在的数据分别保存，进行插入和更新
		for(Teacherrecruitment teacherrecruitment : TeacherrecruitmentList ){
			//判断是否存在，存在放入exaPostgraduatelistupdate，不存在放入exaPostgraduatelistinsert
			boolean i=false;//用于判断是否已经放入存在的集合
			for (Teacherrecruitment teacherrecruitmented:teacherrecruitments){
				if(teacherrecruitmented.getExamnumber().equals(teacherrecruitment.getExamnumber())){
					teacherrecruitment.setExamid(teacherrecruitmented.getExamid());
					teacherrecruitmentlistupdate.add(teacherrecruitment);
					i=true;
				}
			}
			if(i==false){
				String uuid = UUID.randomUUID().toString().replaceAll("-","");
				teacherrecruitment.setExamid(uuid);
				teacherrecruitmentlistinsert.add(teacherrecruitment);
			}

		}
		//分别对新增数据和更新数据进行操作
		if(teacherrecruitmentlistinsert.size()>0){
			teacherrecruitmentMapper.insertTeacherRecruitmentList(teacherrecruitmentlistinsert);
			successNum=successNum+teacherrecruitmentlistinsert.size();
			for(Teacherrecruitment mes : teacherrecruitmentlistinsert){
				successMsg.append("<br/>" +  mes.getExamnumber() + "考生考场信息 "  + " 导入成功");
			}

		}
		if(teacherrecruitmentlistupdate.size()>0){
			if(updateSupport){
				teacherrecruitmentMapper.updateTeacherRecruitmentList(teacherrecruitmentlistupdate);
				successNum=successNum+teacherrecruitmentlistupdate.size();
				for(Teacherrecruitment mes : teacherrecruitmentlistupdate){
					successMsg.append("<br/>" + mes.getExamnumber() + "考生考场信息 " + " 更新成功");
				}
			}else {
				failureNum=failureNum+teacherrecruitmentlistupdate.size();
				for(Teacherrecruitment mes : teacherrecruitmentlistupdate){
					failureMsg.append("<br/>" + mes.getExamnumber() + "考生考场信息 "  + " 已存在");
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
