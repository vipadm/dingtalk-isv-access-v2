package com.rishiqing.dingtalk.dingpush.handler.impl;

import com.rishiqing.dingtalk.dingpush.handler.SyncActionHandler;
import com.rishiqing.dingtalk.isv.api.model.dingpush.OpenSyncBizDataVO;

/**
 * @author Wallace Mao
 * Date: 2018-11-10 14:33
 */
public class OrgMicroAppStopSyncActionHandler implements SyncActionHandler {
    /**
     subscribe_id  ： 套件suiteid加下划线0
     copp_id : 开通套件微应用的企业corpid
     biz_id             ： 微应用的appid
     biz_data         ：数据为如下3种Json格式
     * @param data
     */
    @Override
    public void handleSyncAction(OpenSyncBizDataVO data) {
        //  暂时不会做任何处理
    }
}
