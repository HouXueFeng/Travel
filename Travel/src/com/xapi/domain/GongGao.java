package com.xapi.domain;
//公告信息bean
public class GongGao {
	private int gongGaoNo;
	private String gongGaoTitle;
	private String gongGaoContent;
	private String gongGaoTime;
	private String gongGaoPic;
	private Integer jingdianNo;
	public GongGao(int gongGaoNo, String gongGaoTitle, String gongGaoContent, String gongGaoTime, String gongGaoPic,
			Integer jingdianNo) {
		super();
		this.gongGaoNo = gongGaoNo;
		this.gongGaoTitle = gongGaoTitle;
		this.gongGaoContent = gongGaoContent;
		this.gongGaoTime = gongGaoTime;
		this.gongGaoPic = gongGaoPic;
		this.jingdianNo = jingdianNo;
	}
	public int getGongGaoNo() {
		return gongGaoNo;
	}
	public void setGongGaoNo(int gongGaoNo) {
		this.gongGaoNo = gongGaoNo;
	}
	public String getGongGaoTitle() {
		return gongGaoTitle;
	}
	public void setGongGaoTitle(String gongGaoTitle) {
		this.gongGaoTitle = gongGaoTitle;
	}
	public String getGongGaoContent() {
		return gongGaoContent;
	}
	public void setGongGaoContent(String gongGaoContent) {
		this.gongGaoContent = gongGaoContent;
	}
	public String getGongGaoTime() {
		return gongGaoTime;
	}
	public void setGongGaoTime(String gongGaoTime) {
		this.gongGaoTime = gongGaoTime;
	}
	public String getGongGaoPic() {
		return gongGaoPic;
	}
	public void setGongGaoPic(String gongGaoPic) {
		this.gongGaoPic = gongGaoPic;
	}
	public Integer getJingdianNo() {
		return jingdianNo;
	}
	public void setJingdianNo(Integer jingdianNo) {
		this.jingdianNo = jingdianNo;
	}
	@Override
	public String toString() {
		return "GongGao [gongGaoNo=" + gongGaoNo + ", gongGaoTitle=" + gongGaoTitle + ", gongGaoContent="
				+ gongGaoContent + ", gongGaoTime=" + gongGaoTime + ", gongGaoPic=" + gongGaoPic + ", jingdianNo="
				+ jingdianNo + "]";
	}

	

}
