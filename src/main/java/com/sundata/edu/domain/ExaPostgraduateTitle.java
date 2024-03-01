package com.sundata.edu.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 表 exa_postgraduate_title
 * 
 * @author zz
 * @date 2021-11-30 11:54:15
 */
@Table(name = "`exa_postgraduate_title`")
public class ExaPostgraduateTitle {
	/**
	 * 
	 */
	@Id
	@Column(name = "`id`")
	private Integer id;
	/**
	 * 研考标题
	 */
	@Column(name = "`title`")
	private String title;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	@Override
    public String toString() {
        return "ExaPostgraduateTitle{" +
        		"id=" + id +
        		"title=" + title +
				"}";
    }
}
