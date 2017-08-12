package com.mongospringmysql.servercenter.resultcall.domian;

public class CardPicBean {
	private String id;
	private String cardpic;// string 是 身份证图片base64
	private String facepic;// string 是 身份证人脸图片 base64
	private Integer createtime;// integer 是 创建时间 10位时间戳

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCardpic() {
		return cardpic;
	}

	public void setCardpic(String cardpic) {
		this.cardpic = cardpic;
	}

	public String getFacepic() {
		return facepic;
	}

	public void setFacepic(String facepic) {
		this.facepic = facepic;
	}

	public Integer getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}

}
