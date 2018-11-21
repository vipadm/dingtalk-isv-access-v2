package com.workbei.listener.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.rishiqing.dingtalk.biz.event.SolutionEvent;
import com.rishiqing.dingtalk.isv.api.exception.BizRuntimeException;
import com.workbei.listener.SolutionListener;
import com.workbei.service.SolutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Wallace Mao
 * Date: 2018-11-21 15:29
 */
public class SolutionListenerAlimqImpl implements MessageListener, SolutionListener {
    private static final Logger logger = LoggerFactory.getLogger("LSN_RSQ_CORP_CHANGE_LOGGER");

    @Autowired
    private SolutionService solutionService;

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        try{
            SolutionEvent event = JSON.parseObject(message.getBody(), SolutionEvent.class);
            String teamId = event.getTeamId();
            String userId = event.getUserId();
            String type = event.getType();

            if("team".equals(type)){
                solutionService.generateTeamSolution(teamId, userId);
            }else if("staff".equals(type)){
                solutionService.generateUserSolution(teamId, userId);
            }else{
                throw new BizRuntimeException("invalid solution type: " + type + ", teamId: " + teamId + ", userId: " + userId);
            }
            return Action.CommitMessage;
        } catch (Exception e) {
            logger.error("solution generate error: ", e);
            //消费失败
            return Action.ReconsumeLater;
        }
    }
}
