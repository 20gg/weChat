package com.team.weChat.common.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 信息实体
 * 
 * @author cl
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NON_PRIVATE)
public class WeChat implements Cloneable, Serializable {

	private static final long serialVersionUID = -7880331156566396021L;

	/** 访问主页 */
	public static final Integer GOFIRSTPAGE_YES = 0;
	/** 不访问主页 */
	public static final Integer GOFIRSTPAGE_NO = -1;

	// 入库id 忽略属性
	
	private Long id;
	// solr 设置别名
	
	private String solrid;
	// 公众号名字
	private String name;
	// 公众号账号
	private String weChat;
	// 公众号usrname
	
	private String usrname;
	// 公众号id
	private String openid;
	// 公众号简介
	private String desc;
	// 公众号主体
	private String source = "【无公司信息】";
	// 公众号图片url
	@JsonProperty("img_url")  
	private String imgUrl;
	// 公众号二维码url
	@JsonProperty("qr_code_url")  
	private String qrCodeUrl;
	// 频道id(tx新闻客户端)
	
	private String chlid;
	// 订阅数/粉丝数
	@JsonProperty("fan_num")
	private Integer fanNum;
	// 分享数
	@JsonProperty("share_num")
	private Integer shareNum;
	// 收藏数
	@JsonProperty("collection_num")
	private Integer collectionNum=0;
	// 阅读数
	@JsonProperty("read_num")
	private Integer readNum=0;
	// 所属地区
	private String area;
	// 最新发表
	@JsonProperty("update_time")
	private Long updateTime;
	@JsonProperty("update_article")
	private String updateArticle;
	// 公众号首页所有文章发表时间
	private List<Long> posttimes = new ArrayList<Long>();
	// 收录时间
	
	private Long birthTime = System.currentTimeMillis();
	// 采集该公众号时,是否访问公众号主页
	private Integer goFirstPage = GOFIRSTPAGE_NO;

	public WeChat() {
		super();
	}

	@Override
	public WeChat clone() {
		WeChat instance = null;
		try {
			instance = (WeChat) super.clone();
			instance.collectionNum = null;
			instance.desc = null;
			instance.chlid = null;
			instance.fanNum = null;
			instance.id = null;
			instance.solrid = null;
			instance.imgUrl = null;
			instance.name = null;
			instance.qrCodeUrl = null;
			instance.readNum = null;
			instance.shareNum = null;
			instance.source = "【无公司信息】";
			instance.weChat = null;
			instance.usrname = null;
			instance.openid = null;
			instance.area = null;
			instance.updateTime = null;
			instance.updateArticle = null;
			instance.posttimes = new ArrayList<Long>();
			instance.birthTime = System.currentTimeMillis();
			instance.goFirstPage = GOFIRSTPAGE_NO;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return instance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSolrid() {
		return solrid;
	}

	public void setSolrid(String solrid) {
		this.solrid = solrid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getQrCodeUrl() {
		return qrCodeUrl;
	}

	public void setQrCodeUrl(String qrCodeUrl) {
		this.qrCodeUrl = qrCodeUrl;
	}

	public String getChlid() {
		return chlid;
	}

	public void setChlid(String chlid) {
		this.chlid = chlid;
	}

	public Integer getFanNum() {
		return fanNum;
	}

	public void setFanNum(Integer fanNum) {
		this.fanNum = fanNum;
	}

	public Integer getShareNum() {
		return shareNum;
	}

	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}

	public Integer getCollectionNum() {
		return collectionNum;
	}

	public void setCollectionNum(Integer collectionNum) {
		this.collectionNum = (collectionNum==null?0:collectionNum);
	}

	public Integer getReadNum() {
		return readNum;
	}

	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateArticle() {
		return updateArticle;
	}

	public void setUpdateArticle(String updateArticle) {
		this.updateArticle = updateArticle;
	}

	public List<Long> getPosttimes() {
		return posttimes;
	}

	public void setPosttimes(List<Long> posttimes) {
		this.posttimes = posttimes;
	}

	public Long getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(Long birthTime) {
		this.birthTime = birthTime;
	}

	public Integer getGoFirstPage() {
		return goFirstPage;
	}

	public void setGoFirstPage(Integer goFirstPage) {
		this.goFirstPage = goFirstPage;
	}

	@Override
	public String toString() {
		return "WeChat [id=" + id + ", solrid=" + solrid + ", name=" + name + ", weChat=" + weChat + ", usrname="
				+ usrname + ", openid=" + openid + ", desc=" + desc + ", source=" + source + ", imgUrl=" + imgUrl
				+ ", qrCodeUrl=" + qrCodeUrl + ", fanNum=" + fanNum + ", shareNum=" + shareNum + ", collectionNum="
				+ collectionNum + ", readNum=" + readNum + ", area=" + area + ", updateTime=" + updateTime
				+ ", updateArticle=" + updateArticle + ", posttimes=" + posttimes + ", birthTime=" + birthTime
				+ ", goFirstPage=" + goFirstPage + "]";
	}

	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		WeChat[] list = mapper.readValue(new File("D:/hsnn/CX_program/com.hsnn.trade/src/main/resources/55.json"),WeChat[].class );
		System.out.println(list[0]);
	}
}
