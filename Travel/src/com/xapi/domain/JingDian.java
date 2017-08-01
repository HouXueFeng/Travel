package com.xapi.domain;
//景点
public class JingDian {
	
	private Integer jingdianNo;
	private String jingdianTitle;
	private String jingdianAddress;
	private Integer jingdianPrice;
	private String jingdianDesc;
	private String jingdianDetail;
	private String jingdianPic;
	private String jingdianTime;
	
	
	public JingDian() {
		super();
	}
	public JingDian(Integer jingdianNo, String jingdianTitle, String jingdianAddress, Integer jingdianPrice,
			String jingdianDesc, String jingdianDetail, String jingdianPic, String jingdianTime) {
		super();
		this.jingdianNo = jingdianNo;
		this.jingdianTitle = jingdianTitle;
		this.jingdianAddress = jingdianAddress;
		this.jingdianPrice = jingdianPrice;
		this.jingdianDesc = jingdianDesc;
		this.jingdianDetail = jingdianDetail;
		this.jingdianPic = jingdianPic;
		this.jingdianTime = jingdianTime;
	}
	public Integer getJingdianNo() {
		return jingdianNo;
	}
	public void setJingdianNo(Integer jingdianNo) {
		this.jingdianNo = jingdianNo;
	}
	public String getJingdianTitle() {
		return jingdianTitle;
	}
	public void setJingdianTitle(String jingdianTitle) {
		this.jingdianTitle = jingdianTitle;
	}
	public String getJingdianAddress() {
		return jingdianAddress;
	}
	public void setJingdianAddress(String jingdianAddress) {
		this.jingdianAddress = jingdianAddress;
	}
	public Integer getJingdianPrice() {
		return jingdianPrice;
	}
	public void setJingdianPrice(Integer jingdianPrice) {
		this.jingdianPrice = jingdianPrice;
	}
	public String getJingdianDesc() {
		return jingdianDesc;
	}
	public void setJingdianDesc(String jingdianDesc) {
		this.jingdianDesc = jingdianDesc;
	}
	public String getJingdianDetail() {
		return jingdianDetail;
	}
	public void setJingdianDetail(String jingdianDetail) {
		this.jingdianDetail = jingdianDetail;
	}
	public String getJingdianPic() {
		return jingdianPic;
	}
	public void setJingdianPic(String jingdianPic) {
		this.jingdianPic = jingdianPic;
	}
	public String getJingdianTime() {
		return jingdianTime;
	}
	public void setJingdianTime(String jingdianTime) {
		this.jingdianTime = jingdianTime;
	}
	@Override
	public String toString() {
		return "JingDian [jingdianNo=" + jingdianNo + ", jingdianTitle=" + jingdianTitle + ", jingdianAddress="
				+ jingdianAddress + ", jingdianPrice=" + jingdianPrice + ", jingdianDesc=" + jingdianDesc
				+ ", jingdianDetail=" + jingdianDetail + ", jingdianPic=" + jingdianPic + ", jingdianTime="
				+ jingdianTime + "]";
	}
	
}
