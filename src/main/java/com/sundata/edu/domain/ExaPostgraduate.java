package com.sundata.edu.domain;

import com.sundata.edu.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 表 exa_postgraduate
 * 
 * @author zz
 * @date 2021-11-30 10:36:39
 */
@Table(name = "`exa_postgraduate`")
public class ExaPostgraduate {
	/**
	 * id
	 */
	@Id
	@Column(name = "`id`")
	private String id;
	/**
	 * 姓名
	 */
	@Column(name = "`stuname`")
	@Excel(name = "姓名")
	private String stuname;
	/**
	 * 考生编号
	 */
	@Column(name = "`candidate_number`")
	@Excel(name = "考生编号")
	private String candidateNumber;
	/**
	 * 报考单位
	 */
	@Column(name = "`apply_school`")
	@Excel(name = "报考单位")
	private String applySchool;
	/**
	 * 考场号
	 */
	@Column(name = "`exa_room_num`")
	@Excel(name = "考场号")
	private String exaRoomNum;
	/**
	 * 座位号
	 */
	@Column(name = "`seat_number`")
	@Excel(name = "座位号")
	private String seatNumber;
	/**
	 * 楼栋
	 */
	@Column(name = "`building`")
	@Excel(name = "楼栋")
	private String building;
	/**
	 * 教室
	 */
	@Column(name = "`classroom`")
	@Excel(name = "教室")
	private String classroom;
	/**
	 * 楼层
	 */
	@Column(name = "`floor`")
	@Excel(name = "楼层")
	private String floor;
	/**
	 * 考点
	 */
	@Column(name = "`exa_site`")
	@Excel(name = "考点")
	private String exaSite;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStuname() {
		return stuname;
	}

	public void setCandidateNumber(String candidateNumber) {
		this.candidateNumber = candidateNumber;
	}

	public String getCandidateNumber() {
		return candidateNumber;
	}

	public void setApplySchool(String applySchool) {
		this.applySchool = applySchool;
	}

	public String getApplySchool() {
		return applySchool;
	}

	public void setExaRoomNum(String exaRoomNum) {
		this.exaRoomNum = exaRoomNum;
	}

	public String getExaRoomNum() {
		return exaRoomNum;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getBuilding() {
		return building;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getFloor() {
		return floor;
	}

	public void setExaSite(String exaSite) {
		this.exaSite = exaSite;
	}

	public String getExaSite() {
		return exaSite;
	}

	@Override
    public String toString() {
        return "ExaPostgraduate{" +
        		"id=" + id +
        		"stuname=" + stuname +
        		"candidateNumber=" + candidateNumber +
        		"applySchool=" + applySchool +
        		"exaRoomNum=" + exaRoomNum +
        		"seatNumber=" + seatNumber +
        		"building=" + building +
        		"classroom=" + classroom +
        		"floor=" + floor +
        		"exaSite=" + exaSite +
				"}";
    }
}
