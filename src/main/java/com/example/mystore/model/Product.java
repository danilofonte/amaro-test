package com.example.mystore.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS", indexes = { @Index(name = "BASEPRODUCTRELIDX_1", columnList = "P_BASEPRODUCT"),
		@Index(name = "BANDRELIDX_1", columnList = "P_BAND"), @Index(name = "CATALOGIDX_1", columnList = "P_CATALOG"),
		@Index(name = "CODEVERSIONIDX_1", columnList = "P_CODE,P_CATALOGVERSION"),
		@Index(name = "VISIBILITYIDX_1", columnList = "P_APPROVALSTATUS,P_ONLINEDATE,P_OFFLINEDATE"),
		@Index(name = "PRODUCT_CODE_1", columnList = "P_CODE"),
		@Index(name = "VERSIONIDX_1", columnList = "P_CATALOGVERSION"),
		@Index(name = "SYS_IDX_SYS_PK_10657_10658", columnList = "id") })
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final Long serialVersionUID = -3302280386880265560L;

	private Long HJMPTS;
	private Date CREATEDTS;
	private Date MODIFIEDTS;
	private Long TYPEPKSTRING;
	private Long OWNERPKSTRING;
	private Long id;
	private String P_CODE;
	private Long P_UNIT;
	private Long P_THUMBNAIL;
	private Long P_PICTURE;
	private Long P_CATALOG;
	private Long P_CATALOGVERSION;
	private Date P_ONLINEDATE;
	private Date P_OFFLINEDATE;
	private String P_EAN;
	private String P_SUPPLIERALTERNATIVEAID;
	private byte[] P_BUYERIDS;
	private String P_MANUFACTURERAID;
	private String P_MANUFACTURERNAME;
	private String P_ERPGROUPBUYER;
	private String P_ERPGROUPSUPPLIER;
	private Double P_DELIVERYTIME;
	private byte[] P_SPECIALTREATMENTCLASSES;
	private Long P_ORDER;
	private Long P_APPROVALSTATUS;
	private Long P_CONTENTUNIT;
	private Double P_NUMBERCONTENTUNITS;
	private Long P_MINORDERQUANTITY;
	private Long P_MAXORDERQUANTITY;
	private Long P_ORDERQUANTITYINTERVAL;
	private Double P_PRICEQUANTITY;
	private String P_NORMAL;
	private String P_THUMBNAILS;
	private String P_DETAIL;
	private String P_LOGO;
	private String P_DATA_SHEET;
	private String P_OTHERS;
	private Long P_STARTLINENUMBER;
	private Long P_ENDLINENUMBER;
	private Long P_VARIANTTYPE;
	private Long P_EUROPE1PRICEFACTORY_PPG;
	private Long P_EUROPE1PRICEFACTORY_PTG;
	private Long P_EUROPE1PRICEFACTORY_PDG;
	private Long P_BAND;
	private Long ACLTS;
	private Long PROPTS;
	private Long P_BASEPRODUCT;
	private String P_VENUE;
	private Date P_DATE;
	private Long P_CONCERTTYPE;

	@Column(name = "HJMPTS")
	public Long getHJMPTS() {
		return HJMPTS;
	}

	public void setHJMPTS(Long hJMPTS) {
		this.HJMPTS = hJMPTS;
	}

	@Column(name = "CREATEDTS")
	public Date getCREATEDTS() {
		return CREATEDTS;
	}

	public void setCREATEDTS(Date cREATEDTS) {
		this.CREATEDTS = cREATEDTS;
	}

	@Column(name = "MODIFIEDTS")
	public Date getMODIFIEDTS() {
		return MODIFIEDTS;
	}

	public void setMODIFIEDTS(Date mODIFIEDTS) {
		this.MODIFIEDTS = mODIFIEDTS;
	}

	@Column(name = "TYPEPKSTRING")
	public Long getTYPEPKSTRING() {
		return TYPEPKSTRING;
	}

	public void setTYPEPKSTRING(Long tYPEPKSTRING) {
		this.TYPEPKSTRING = tYPEPKSTRING;
	}

	@Column(name = "OWNERPKSTRING")
	public Long getOWNERPKSTRING() {
		return OWNERPKSTRING;
	}

	public void setOWNERPKSTRING(Long oWNERPKSTRING) {
		this.OWNERPKSTRING = oWNERPKSTRING;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "P_CODE")
	public String getP_CODE() {
		return P_CODE;
	}

	public void setP_CODE(String p_CODE) {
		this.P_CODE = p_CODE;
	}

	@Column(name = "P_UNIT")
	public Long getP_UNIT() {
		return P_UNIT;
	}

	public void setP_UNIT(Long p_UNIT) {
		this.P_UNIT = p_UNIT;
	}

	@Column(name = "P_THUMBNAIL")
	public Long getP_THUMBNAIL() {
		return P_THUMBNAIL;
	}

	public void setP_THUMBNAIL(Long p_THUMBNAIL) {
		this.P_THUMBNAIL = p_THUMBNAIL;
	}

	@Column(name = "P_PICTURE")
	public Long getP_PICTURE() {
		return P_PICTURE;
	}

	@Column(name = "P_CATALOG")
	public void setP_PICTURE(Long p_PICTURE) {
		this.P_PICTURE = p_PICTURE;
	}

	public Long getP_CATALOG() {
		return P_CATALOG;
	}

	public void setP_CATALOG(Long p_CATALOG) {
		this.P_CATALOG = p_CATALOG;
	}

	@Column(name = "P_CATALOGVERSION")
	public Long getP_CATALOGVERSION() {
		return P_CATALOGVERSION;
	}

	public void setP_CATALOGVERSION(Long p_CATALOGVERSION) {
		this.P_CATALOGVERSION = p_CATALOGVERSION;
	}

	@Column(name = "P_ONLINEDATE")
	public Date getP_ONLINEDATE() {
		return P_ONLINEDATE;
	}

	public void setP_ONLINEDATE(Date p_ONLINEDATE) {
		this.P_ONLINEDATE = p_ONLINEDATE;
	}

	@Column(name = "P_OFFLINEDATE")
	public Date getP_OFFLINEDATE() {
		return P_OFFLINEDATE;
	}

	public void setP_OFFLINEDATE(Date p_OFFLINEDATE) {
		this.P_OFFLINEDATE = p_OFFLINEDATE;
	}

	@Column(name = "P_EAN")
	public String getP_EAN() {
		return P_EAN;
	}

	public void setP_EAN(String p_EAN) {
		this.P_EAN = p_EAN;
	}

	@Column(name = "P_SUPPLIERALTERNATIVEAID")
	public String getP_SUPPLIERALTERNATIVEAID() {
		return P_SUPPLIERALTERNATIVEAID;
	}

	public void setP_SUPPLIERALTERNATIVEAID(String p_SUPPLIERALTERNATIVEAID) {
		this.P_SUPPLIERALTERNATIVEAID = p_SUPPLIERALTERNATIVEAID;
	}

	@Column(name = "P_BUYERIDS")
	public byte[] getP_BUYERIDS() {
		return P_BUYERIDS;
	}

	public void setP_BUYERIDS(byte[] p_BUYERIDS) {
		this.P_BUYERIDS = p_BUYERIDS;
	}

	@Column(name = "P_MANUFACTURERAID")
	public String getP_MANUFACTURERAID() {
		return P_MANUFACTURERAID;
	}

	public void setP_MANUFACTURERAID(String p_MANUFACTURERAID) {
		this.P_MANUFACTURERAID = p_MANUFACTURERAID;
	}

	@Column(name = "P_MANUFACTURERNAME")
	public String getP_MANUFACTURERNAME() {
		return P_MANUFACTURERNAME;
	}

	public void setP_MANUFACTURERNAME(String p_MANUFACTURERNAME) {
		this.P_MANUFACTURERNAME = p_MANUFACTURERNAME;
	}

	@Column(name = "P_ERPGROUPBUYER")
	public String getP_ERPGROUPBUYER() {
		return P_ERPGROUPBUYER;
	}

	public void setP_ERPGROUPBUYER(String p_ERPGROUPBUYER) {
		this.P_ERPGROUPBUYER = p_ERPGROUPBUYER;
	}

	@Column(name = "P_ERPGROUPSUPPLIER")
	public String getP_ERPGROUPSUPPLIER() {
		return P_ERPGROUPSUPPLIER;
	}

	public void setP_ERPGROUPSUPPLIER(String p_ERPGROUPSUPPLIER) {
		this.P_ERPGROUPSUPPLIER = p_ERPGROUPSUPPLIER;
	}

	@Column(name = "P_DELIVERYTIME")
	public Double getP_DELIVERYTIME() {
		return P_DELIVERYTIME;
	}

	public void setP_DELIVERYTIME(Double p_DELIVERYTIME) {
		this.P_DELIVERYTIME = p_DELIVERYTIME;
	}

	@Column(name = "P_SPECIALTREATMENTCLASSES")
	public byte[] getP_SPECIALTREATMENTCLASSES() {
		return P_SPECIALTREATMENTCLASSES;
	}

	public void setP_SPECIALTREATMENTCLASSES(byte[] p_SPECIALTREATMENTCLASSES) {
		this.P_SPECIALTREATMENTCLASSES = p_SPECIALTREATMENTCLASSES;
	}

	@Column(name = "P_ORDER")
	public Long getP_ORDER() {
		return P_ORDER;
	}

	public void setP_ORDER(Long p_ORDER) {
		this.P_ORDER = p_ORDER;
	}

	@Column(name = "P_APPROVALSTATUS")
	public Long getP_APPROVALSTATUS() {
		return P_APPROVALSTATUS;
	}

	public void setP_APPROVALSTATUS(Long p_APPROVALSTATUS) {
		this.P_APPROVALSTATUS = p_APPROVALSTATUS;
	}

	@Column(name = "P_CONTENTUNIT")
	public Long getP_CONTENTUNIT() {
		return P_CONTENTUNIT;
	}

	public void setP_CONTENTUNIT(Long p_CONTENTUNIT) {
		this.P_CONTENTUNIT = p_CONTENTUNIT;
	}

	@Column(name = "P_NUMBERCONTENTUNITS")
	public Double getP_NUMBERCONTENTUNITS() {
		return P_NUMBERCONTENTUNITS;
	}

	public void setP_NUMBERCONTENTUNITS(Double p_NUMBERCONTENTUNITS) {
		this.P_NUMBERCONTENTUNITS = p_NUMBERCONTENTUNITS;
	}

	@Column(name = "P_MINORDERQUANTITY")
	public Long getP_MINORDERQUANTITY() {
		return P_MINORDERQUANTITY;
	}

	public void setP_MINORDERQUANTITY(Long p_MINORDERQUANTITY) {
		this.P_MINORDERQUANTITY = p_MINORDERQUANTITY;
	}

	@Column(name = "P_MAXORDERQUANTITY")
	public Long getP_MAXORDERQUANTITY() {
		return P_MAXORDERQUANTITY;
	}

	public void setP_MAXORDERQUANTITY(Long p_MAXORDERQUANTITY) {
		this.P_MAXORDERQUANTITY = p_MAXORDERQUANTITY;
	}

	@Column(name = "P_ORDERQUANTITYINTERVAL")
	public Long getP_ORDERQUANTITYINTERVAL() {
		return P_ORDERQUANTITYINTERVAL;
	}

	public void setP_ORDERQUANTITYINTERVAL(Long P_ORDERQUANTITYINTERVAL) {
		this.P_ORDERQUANTITYINTERVAL = P_ORDERQUANTITYINTERVAL;
	}

	@Column(name = "P_PRICEQUANTITY")
	public Double getP_PRICEQUANTITY() {
		return P_PRICEQUANTITY;
	}

	public void setP_PRICEQUANTITY(Double p_PRICEQUANTITY) {
		this.P_PRICEQUANTITY = p_PRICEQUANTITY;
	}

	@Column(name = "P_NORMAL")
	public String getP_NORMAL() {
		return P_NORMAL;
	}

	public void setP_NORMAL(String p_NORMAL) {
		this.P_NORMAL = p_NORMAL;
	}

	@Column(name = "P_THUMBNAILS")
	public String getP_THUMBNAILS() {
		return P_THUMBNAILS;
	}

	public void setP_THUMBNAILS(String p_THUMBNAILS) {
		this.P_THUMBNAILS = p_THUMBNAILS;
	}

	@Column(name = "P_DETAIL")
	public String getP_DETAIL() {
		return P_DETAIL;
	}

	public void setP_DETAIL(String p_DETAIL) {
		this.P_DETAIL = p_DETAIL;
	}

	@Column(name = "P_LOGO")
	public String getP_LOGO() {
		return P_LOGO;
	}

	public void setP_LOGO(String p_LOGO) {
		this.P_LOGO = p_LOGO;
	}

	@Column(name = "P_DATA_SHEET")
	public String getP_DATA_SHEET() {
		return P_DATA_SHEET;
	}

	public void setP_DATA_SHEET(String p_DATA_SHEET) {
		this.P_DATA_SHEET = p_DATA_SHEET;
	}

	@Column(name = "P_OTHERS")
	public String getP_OTHERS() {
		return P_OTHERS;
	}

	public void setP_OTHERS(String p_OTHERS) {
		this.P_OTHERS = p_OTHERS;
	}

	@Column(name = "P_STARTLINENUMBER")
	public Long getP_STARTLINENUMBER() {
		return P_STARTLINENUMBER;
	}

	public void setP_STARTLINENUMBER(Long p_STARTLINENUMBER) {
		this.P_STARTLINENUMBER = p_STARTLINENUMBER;
	}

	@Column(name = "P_ENDLINENUMBER")
	public Long getP_ENDLINENUMBER() {
		return P_ENDLINENUMBER;
	}

	public void setP_ENDLINENUMBER(Long p_ENDLINENUMBER) {
		this.P_ENDLINENUMBER = p_ENDLINENUMBER;
	}

	@Column(name = "P_VARIANTTYPE")
	public Long getP_VARIANTTYPE() {
		return P_VARIANTTYPE;
	}

	public void setP_VARIANTTYPE(Long p_VARIANTTYPE) {
		this.P_VARIANTTYPE = p_VARIANTTYPE;
	}

	@Column(name = "P_EUROPE1PRICEFACTORY_PPG")
	public Long getP_EUROPE1PRICEFACTORY_PPG() {
		return P_EUROPE1PRICEFACTORY_PPG;
	}

	public void setP_EUROPE1PRICEFACTORY_PPG(Long p_EUROPE1PRICEFACTORY_PPG) {
		this.P_EUROPE1PRICEFACTORY_PPG = p_EUROPE1PRICEFACTORY_PPG;
	}

	@Column(name = "P_EUROPE1PRICEFACTORY_PTG")
	public Long getP_EUROPE1PRICEFACTORY_PTG() {
		return P_EUROPE1PRICEFACTORY_PTG;
	}

	public void setP_EUROPE1PRICEFACTORY_PTG(Long p_EUROPE1PRICEFACTORY_PTG) {
		this.P_EUROPE1PRICEFACTORY_PTG = p_EUROPE1PRICEFACTORY_PTG;
	}

	@Column(name = "P_EUROPE1PRICEFACTORY_PDG")
	public Long getP_EUROPE1PRICEFACTORY_PDG() {
		return P_EUROPE1PRICEFACTORY_PDG;
	}

	public void setP_EUROPE1PRICEFACTORY_PDG(Long p_EUROPE1PRICEFACTORY_PDG) {
		this.P_EUROPE1PRICEFACTORY_PDG = p_EUROPE1PRICEFACTORY_PDG;
	}

	@Column(name = "P_BAND")
	public Long getP_BAND() {
		return P_BAND;
	}

	public void setP_BAND(Long p_BAND) {
		this.P_BAND = p_BAND;
	}

	@Column(name = "ACLTS")
	public Long getACLTS() {
		return ACLTS;
	}

	public void setACLTS(Long aCLTS) {
		this.ACLTS = aCLTS;
	}

	@Column(name = "PROPTS")
	public Long getPROPTS() {
		return PROPTS;
	}

	public void setPROPTS(Long pROPTS) {
		this.PROPTS = pROPTS;
	}

	@Column(name = "P_BASEPRODUCT")
	public Long getP_BASEPRODUCT() {
		return P_BASEPRODUCT;
	}

	public void setP_BASEPRODUCT(Long p_BASEPRODUCT) {
		this.P_BASEPRODUCT = p_BASEPRODUCT;
	}

	@Column(name = "P_VENUE")
	public String getP_VENUE() {
		return P_VENUE;
	}

	public void setP_VENUE(String p_VENUE) {
		this.P_VENUE = p_VENUE;
	}

	@Column(name = "P_DATE")
	public Date getP_DATE() {
		return P_DATE;
	}

	public void setP_DATE(Date p_DATE) {
		this.P_DATE = p_DATE;
	}

	@Column(name = "P_CONCERTTYPE")
	public Long getP_CONCERTTYPE() {
		return P_CONCERTTYPE;
	}

	public void setP_CONCERTTYPE(Long p_CONCERTTYPE) {
		this.P_CONCERTTYPE = p_CONCERTTYPE;
	}

}
