package com.sundata.edu.domain;

import com.sundata.edu.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 教师资格证考试名称修改对象 teacherstitletb
 *
 * @author whj
 * @date 2021-10-25
 */
public class Teacherstitletb
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 教师资格证考试名称 */
    @Excel(name = "教师资格证考试名称")
    private String teacherstitle;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTeacherstitle(String teacherstitle)
    {
        this.teacherstitle = teacherstitle;
    }

    public String getTeacherstitle()
    {
        return teacherstitle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherstitle", getTeacherstitle())
            .toString();
    }
}
