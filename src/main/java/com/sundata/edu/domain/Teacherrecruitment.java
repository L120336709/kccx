package com.sundata.edu.domain;

import com.sundata.edu.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 表 teacherrecruitment
 *
 * @author shunguo
 * @date 2021-12-20
 */
public class Teacherrecruitment
{
	private static final long serialVersionUID = 1L;

	/** id */
//	@Excel(name = "id")
	private String examid;
	/** 姓名 */
	@Excel(name = "姓名")
	private String examname;
	/** 准考证号 */
	@Excel(name = "准考证号")
	private String examnumber;
	/** 考点代码 */
	@Excel(name = "考点代码")
	private String tsitecode;
	/** 考点名称 */
	@Excel(name = "考点名称")
	private String tsitename;
	/** 考点地址 */
	@Excel(name = "考点地址")
	private String tsiteaddress;
	/** 考场号 */
	@Excel(name = "考场号")
	private String examroomnum;
	/** 座位号 */
	@Excel(name = "座位号")
	private String examseatnumber;
	/** 楼栋 */
	@Excel(name = "楼栋")
	private String exambuilding;
	/** 楼层 */
	@Excel(name = "楼层")
	private String examfloor;
	/** 教室号 */
	@Excel(name = "教室号")
	private String examclassroom;

	public void setExamid(String examid)
	{
		this.examid = examid;
	}

	public String getExamid()
	{
		return examid;
	}
	public void setExamname(String examname)
	{
		this.examname = examname;
	}

	public String getExamname()
	{
		return examname;
	}
	public void setExamnumber(String examnumber)
	{
		this.examnumber = examnumber;
	}

	public String getExamnumber()
	{
		return examnumber;
	}
	public void setTsitecode(String tsitecode)
	{
		this.tsitecode = tsitecode;
	}

	public String getTsitecode()
	{
		return tsitecode;
	}
	public void setTsitename(String tsitename)
	{
		this.tsitename = tsitename;
	}

	public String getTsitename()
	{
		return tsitename;
	}
	public void setTsiteaddress(String tsiteaddress)
	{
		this.tsiteaddress = tsiteaddress;
	}

	public String getTsiteaddress()
	{
		return tsiteaddress;
	}
	public void setExamroomnum(String examroomnum)
	{
		this.examroomnum = examroomnum;
	}

	public String getExamroomnum()
	{
		return examroomnum;
	}
	public void setExamseatnumber(String examseatnumber)
	{
		this.examseatnumber = examseatnumber;
	}

	public String getExamseatnumber()
	{
		return examseatnumber;
	}
	public void setExambuilding(String exambuilding)
	{
		this.exambuilding = exambuilding;
	}

	public String getExambuilding()
	{
		return exambuilding;
	}
	public void setExamfloor(String examfloor)
	{
		this.examfloor = examfloor;
	}

	public String getExamfloor()
	{
		return examfloor;
	}
	public void setExamclassroom(String examclassroom)
	{
		this.examclassroom = examclassroom;
	}

	public String getExamclassroom()
	{
		return examclassroom;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("examid", getExamid())
            .append("examname", getExamname())
            .append("examnumber", getExamnumber())
            .append("tsitecode", getTsitecode())
            .append("tsitename", getTsitename())
            .append("tsiteaddress", getTsiteaddress())
            .append("examroomnum", getExamroomnum())
            .append("examseatnumber", getExamseatnumber())
            .append("exambuilding", getExambuilding())
            .append("examfloor", getExamfloor())
            .append("examclassroom", getExamclassroom())
            .toString();
    }
}
