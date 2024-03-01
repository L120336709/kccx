package com.sundata.edu.domain;

import com.sundata.edu.annotation.Excel;
import com.sundata.edu.vo.BaseVo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 教师资格证考场管理对象 teacherexamination
 *
 * @author whj
 * @date 2021-10-25
 */
public class Teacherexamination implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String examineename;

    /** 准考证号 */
    @Excel(name = "准考证号")
    private String examregistrationnumber;

    /** 考点名称 */
    @Excel(name = "考点名称")
    private String theexaminationsitename;

    /** 考点地址 */
    @Excel(name = "考点地址")
    private String theexaminationsiteaddress;

    /** 第一场考场代码 */
    @Excel(name = "第一场考场代码")
    private String thefirstsession;

    /** 第一场教室号 */
    @Excel(name = "第一场教室号")
    private String classroomnumberone;

    /** 第二场考场代码 */
    @Excel(name = "第二场考场代码")
    private String thefirstgame;

    /** 第二场教室号 */
    @Excel(name = "第二场教室号")
    private String classroomnumbertwo;

    /** 第三场考场代码 */
    @Excel(name = "第三场考场代码")
    private String thethirdsession;

    /** 第三场教室号 */
    @Excel(name = "第三场教室号")
    private String classroomnumberthree;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setExamineename(String examineename)
    {
        this.examineename = examineename;
    }

    public String getExamineename()
    {
        return examineename;
    }
    public void setExamregistrationnumber(String examregistrationnumber)
    {
        this.examregistrationnumber = examregistrationnumber;
    }

    public String getExamregistrationnumber()
    {
        return examregistrationnumber;
    }
    public void setTheexaminationsitename(String theexaminationsitename)
    {
        this.theexaminationsitename = theexaminationsitename;
    }

    public String getTheexaminationsitename()
    {
        return theexaminationsitename;
    }
    public void setTheexaminationsiteaddress(String theexaminationsiteaddress)
    {
        this.theexaminationsiteaddress = theexaminationsiteaddress;
    }

    public String getTheexaminationsiteaddress()
    {
        return theexaminationsiteaddress;
    }
    public void setThefirstsession(String thefirstsession)
    {
        this.thefirstsession = thefirstsession;
    }

    public String getThefirstsession()
    {
        return thefirstsession;
    }
    public void setClassroomnumberone(String classroomnumberone)
    {
        this.classroomnumberone = classroomnumberone;
    }

    public String getClassroomnumberone()
    {
        return classroomnumberone;
    }
    public void setThefirstgame(String thefirstgame)
    {
        this.thefirstgame = thefirstgame;
    }

    public String getThefirstgame()
    {
        return thefirstgame;
    }
    public void setClassroomnumbertwo(String classroomnumbertwo)
    {
        this.classroomnumbertwo = classroomnumbertwo;
    }

    public String getClassroomnumbertwo()
    {
        return classroomnumbertwo;
    }
    public void setThethirdsession(String thethirdsession)
    {
        this.thethirdsession = thethirdsession;
    }

    public String getThethirdsession()
    {
        return thethirdsession;
    }
    public void setClassroomnumberthree(String classroomnumberthree)
    {
        this.classroomnumberthree = classroomnumberthree;
    }

    public String getClassroomnumberthree()
    {
        return classroomnumberthree;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("examineename", getExamineename())
            .append("examregistrationnumber", getExamregistrationnumber())
            .append("theexaminationsitename", getTheexaminationsitename())
            .append("theexaminationsiteaddress", getTheexaminationsiteaddress())
            .append("thefirstsession", getThefirstsession())
            .append("classroomnumberone", getClassroomnumberone())
            .append("thefirstgame", getThefirstgame())
            .append("classroomnumbertwo", getClassroomnumbertwo())
            .append("thethirdsession", getThethirdsession())
            .append("classroomnumberthree", getClassroomnumberthree())
            .toString();
    }
}
