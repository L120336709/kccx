package com.sundata.edu.domain;

import com.sundata.edu.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 表 teacherrecruitmenttitle
 *
 * @author shunguo
 * @date 2021-12-20
 */
public class Teacherrecruitmenttitle
{
	private static final long serialVersionUID = 1L;

	/**  */
	@Excel(name = "")
	private Integer id;
	/**  */
	@Excel(name = "")
	private String title;

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getTitle()
	{
		return title;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .toString();
    }
}
