package com.rishiqing.dingtalk.converter.corp;

import com.rishiqing.dingtalk.dao.model.corp.CorpDO;
import com.rishiqing.dingtalk.dao.model.corp.CorpStaffDO;
import com.rishiqing.dingtalk.isv.api.model.corp.CorpCountWithCreatorVO;
import com.rishiqing.dingtalk.isv.api.model.corp.CorpVO;

/**
 * @author Wallace Mao
 * Date: 2018-12-24 14:42
 */
public class CorpConverter {
    public static CorpVO CorpDO2CorpVO(CorpDO corpDO){
        if(null == corpDO){
            return null;
        }
        CorpVO corpVO = new CorpVO();
        corpVO.setId(corpDO.getId());
        corpVO.setGmtCreate(corpDO.getGmtCreate());
        corpVO.setGmtModified(corpDO.getGmtModified());
        corpVO.setInviteCode(corpDO.getInviteCode());
        corpVO.setInviteUrl(corpDO.getInviteUrl());
        corpVO.setIndustry(corpDO.getIndustry());
        corpVO.setCorpName(corpDO.getCorpName());
        corpVO.setCorpId(corpDO.getCorpId());
        corpVO.setCorpLogoUrl(corpDO.getCorpLogoUrl());
        corpVO.setRsqId(corpDO.getRsqId());
        corpVO.setScopeVersion(corpDO.getScopeVersion());
        return corpVO;
    }

    public static CorpDO CorpVO2CorpDO(CorpVO corpVO){
        if(null == corpVO){
            return null;
        }
        CorpDO corpDO = new CorpDO();
        corpDO.setId(corpVO.getId());
        corpDO.setGmtCreate(corpVO.getGmtCreate());
        corpDO.setGmtModified(corpVO.getGmtModified());
        corpDO.setInviteCode(corpVO.getInviteCode());
        corpDO.setInviteUrl(corpVO.getInviteUrl());
        corpDO.setIndustry(corpVO.getIndustry());
        corpDO.setCorpName(corpVO.getCorpName());
        corpDO.setCorpId(corpVO.getCorpId());
        corpDO.setCorpLogoUrl(corpVO.getCorpLogoUrl());
        corpDO.setRsqId(corpVO.getRsqId());
        corpDO.setScopeVersion(corpVO.getScopeVersion());
        return corpDO;
    }

    public static CorpCountWithCreatorVO corpDO2CorpCountWithCreatorVO (CorpDO corpDO) {
        if(null == corpDO){
            return null;
        }
        CorpCountWithCreatorVO corpVO = new CorpCountWithCreatorVO();
        corpVO.setId(corpDO.getId());
        corpVO.setGmtCreate(corpDO.getGmtCreate());
        corpVO.setGmtModified(corpDO.getGmtModified());
        corpVO.setIndustry(corpDO.getIndustry());
        corpVO.setCorpName(corpDO.getCorpName());
        corpVO.setCorpId(corpDO.getCorpId());
        corpVO.setCorpLogoUrl(corpDO.getCorpLogoUrl());
        corpVO.setRsqId(corpDO.getRsqId());

        if (corpDO.getCreator() != null) {
            CorpStaffDO creatorDO = corpDO.getCreator();
            corpVO.setCreatorId(creatorDO.getId());
            corpVO.setCreatorUserId(creatorDO.getUserId());
            corpVO.setCreatorName(creatorDO.getName());
            corpVO.setCreatorIsAdmin(creatorDO.getAdmin());
            corpVO.setCreatorIsBoss(creatorDO.getBoss());
            corpVO.setCreatorAvatar(creatorDO.getAvatar());
            corpVO.setCreatorRsqUserId(creatorDO.getRsqUserId());
        }
        return corpVO;
    }
}
