package com.mongospringmysql.servercenter.resultcall.domian;

public class ResultCallStatBean {
	private Integer aptype;// Tinyint(4) 是 应用服务类型<项目>。1社保 2酒店 3-低保 0-其他
	private Integer results;// integer 是 识别结果 1-成功 2-失败
	private Integer totalNum;// 统计总计

	public Integer getAptype() {
		return aptype;
	}

	public void setAptype(Integer aptype) {
		this.aptype = aptype;
	}

	public Integer getResults() {
		return results;
	}

	public void setResults(Integer results) {
		this.results = results;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

}
