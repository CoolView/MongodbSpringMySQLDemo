package com.mongospringmysql.servercenter.resultcall.domian;


public class CardIdentifyBean {
	private String id;// Object id 否 序号,mongodb自动生成或者代码生成new ObjectId()
	private String names;// string 是 姓名
	private String cardnumber;// string 是 身份证号
	private Integer results;// integer 是 识别结果 1-成功 2-失败
	private String failcode;// string 是 识别失败返回码<识别失败才有>
	private Integer identifytime;// integer 是 识别时间 10位时间戳
	private Integer usetime;// integer 是 耗时 单位：毫秒
	private String cardpics;// 身份证图片和身份证人脸图片，关联sp_cardpic表的_id字段；分别获取cardpic和facepic
	private String tablename;// string 是 身份证图片表名
	private Integer aptype;// Tinyint(4) 是 应用服务类型<项目>。1社保 2酒店 3-低保 0-其他
	private Integer devicetype;// Tinyint(4) 是 设备类型。0-app 1-终端 2-网页 3-其他
	private Integer createtime;// integer 是 创建时间 10位时间戳

	private String identifytime_date;// 识别时间
	private Integer totalNum;//统计总计
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Integer getResults() {
		return results;
	}

	public void setResults(Integer results) {
		this.results = results;
	}

	public String getFailcode() {
		return failcode;
	}

	public void setFailcode(String failcode) {
		this.failcode = failcode;
	}

	public Integer getIdentifytime() {
		return identifytime;
	}

	public void setIdentifytime(Integer identifytime) {
		this.identifytime = identifytime;
	}

	public Integer getUsetime() {
		return usetime;
	}

	public void setUsetime(Integer usetime) {
		this.usetime = usetime;
	}

	public String getCardpics() {
		return cardpics;
	}

	public void setCardpics(String cardpics) {
		this.cardpics = cardpics;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public Integer getAptype() {
		return aptype;
	}

	public void setAptype(Integer aptype) {
		this.aptype = aptype;
	}

	public Integer getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(Integer devicetype) {
		this.devicetype = devicetype;
	}

	public Integer getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public String getIdentifytime_date() {
		return identifytime_date;
	}

	public void setIdentifytime_date(String identifytime_date) {
		this.identifytime_date = identifytime_date;
	}

}
