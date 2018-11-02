package com.rishiqing.dingtalk.dao.model.corp;

import java.util.Date;

/**
 * 企业访问开放平台js tickets信息
 * @author Wallace Mao
 * Date: 2018-10-31 23:59
 */
public class CorpJSAPITicketDO {
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;

    //  套件key
    private String suiteKey;
    //  钉钉平台企业id
    private String corpId;
    //  企业jsTicket
    private String corpJSAPITicket;
    //  过期时间
    private Date expiredTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getSuiteKey() {
        return suiteKey;
    }

    public void setSuiteKey(String suiteKey) {
        this.suiteKey = suiteKey;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getCorpJSAPITicket() {
        return corpJSAPITicket;
    }

    public void setCorpJSAPITicket(String corpJSAPITicket) {
        this.corpJSAPITicket = corpJSAPITicket;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    @Override
    public String toString() {
        return "CorpJSAPITicketDO{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", suiteKey='" + suiteKey + '\'' +
                ", corpId='" + corpId + '\'' +
                ", corpJSAPITicket='" + corpJSAPITicket + '\'' +
                ", expiredTime=" + expiredTime +
                '}';
    }
}
