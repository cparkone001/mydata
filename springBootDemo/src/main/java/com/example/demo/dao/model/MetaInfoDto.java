package com.example.demo.dao.model;

import java.math.BigDecimal;
import java.sql.Date;

public class MetaInfoDto {
	String	objectName; 	/*` varchar(195) null default null comment '�ѱ۸�' collate 'utf8_general_ci',*/
	String	abbrName;		/*` varchar(195) null default null comment '������' collate 'utf8_general_ci',*/
	String	objRmk1;		/*` varchar(1500) null default null comment '����������' collate 'utf8_general_ci',*/
	BigDecimal	dataSize;		/*` double(22,0) null default null comment '�����ͱ���',*/
	BigDecimal	dataSize2;		/*` double(22,0) null default null comment '�Ҽ�������',*/
	String	trmTp;			/*` varchar(1) null default null comment 'ǥ�غ�ǥ�ر���(s:ǥ��, n: ��ǥ��)' collate 'utf8_general_ci',*/
	String	domNm;			/*` varchar(4000) null default null comment '�����θ�' collate 'utf8_general_ci',*/
	Date	createDt;		/*` datetime null default null comment '�����Ͻ�',*/
	Date	modifyDt;		/*` datetime null default null comment '�����Ͻ�'*/
	
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public String getAbbrName() {
		return abbrName;
	}
	public void setAbbrName(String abbrName) {
		this.abbrName = abbrName;
	}
	public String getObjRmk1() {
		return objRmk1;
	}
	public void setObjRmk1(String objRmk1) {
		this.objRmk1 = objRmk1;
	}
	public BigDecimal getDataSize() {
		return dataSize;
	}
	public void setDataSize(BigDecimal dataSize) {
		this.dataSize = dataSize;
	}
	public BigDecimal getDataSize2() {
		return dataSize2;
	}
	public void setDataSize2(BigDecimal dataSize2) {
		this.dataSize2 = dataSize2;
	}
	public String getTrmTp() {
		return trmTp;
	}
	public void setTrmTp(String trmTp) {
		this.trmTp = trmTp;
	}
	public String getDomNm() {
		return domNm;
	}
	public void setDomNm(String domNm) {
		this.domNm = domNm;
	}
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	public Date getModifyDt() {
		return modifyDt;
	}
	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}
}
