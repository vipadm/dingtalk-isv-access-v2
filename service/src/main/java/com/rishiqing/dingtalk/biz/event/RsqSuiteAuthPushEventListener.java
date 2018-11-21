package com.rishiqing.dingtalk.biz.event;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.rishiqing.dingtalk.isv.api.event.CorpOrgCreatedEvent;
import com.rishiqing.dingtalk.isv.api.event.EventListener;
import com.rishiqing.dingtalk.isv.api.service.base.corp.CorpDepartmentManageService;
import com.rishiqing.dingtalk.isv.api.service.base.corp.CorpStaffManageService;
import com.rishiqing.dingtalk.isv.api.service.biz.FailBizService;
import com.rishiqing.self.api.service.RsqAccountBizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Wallace Mao
 * Date: 2018-11-07 2:14
 */
public class RsqSuiteAuthPushEventListener implements EventListener {
    private static final Logger bizLogger = LoggerFactory.getLogger("LSN_RSQ_SUITE_AUTH_LOGGER");

    @Autowired
    private RsqAccountBizService rsqAccountBizService;
    @Autowired
    private CorpDepartmentManageService corpDepartmentManageService;
    @Autowired
    private CorpStaffManageService corpStaffManageService;
    @Autowired
    private FailBizService failBizService;

    @Subscribe
    @AllowConcurrentEvents //  event并行执行
    public void listenCorpOrgCreatedEvent(CorpOrgCreatedEvent corpOrgCreatedEvent) {
        try{
            String corpId = corpOrgCreatedEvent.getCorpId();
            Long scopeVersion = corpOrgCreatedEvent.getScopeVersion();
            rsqAccountBizService.syncAllCreated(corpId);
            //  再将本地删除
            corpDepartmentManageService.deleteCorpDepartmentByCorpIdAndScopeVersionLessThan(corpId, scopeVersion);
            corpStaffManageService.deleteCorpStaffByCorpIdAndScopeVersionLessThan(corpId, scopeVersion);
        }catch (Exception e){
            //  加入失败job,失败任务会重试
            failBizService.saveCorpOrgSyncFail(corpOrgCreatedEvent);
            bizLogger.error("corpOrgCreatedEvent: " + corpOrgCreatedEvent, e);
        }
    }
}
