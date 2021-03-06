package com.rishiqing.dingtalk.manager.suite.impl;

import com.rishiqing.dingtalk.converter.suite.AppConverter;
import com.rishiqing.dingtalk.dao.mapper.suite.AppDao;
import com.rishiqing.dingtalk.isv.api.model.suite.AppVO;
import com.rishiqing.dingtalk.manager.suite.AppManager;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Wallace Mao
 * Date: 2018-11-08 19:10
 */
public class AppManagerImpl implements AppManager {
    @Autowired
    private AppDao appDao;

    @Override
    public AppVO getDefaultAppVO(){
        return AppConverter.appDO2AppVO(
                appDao.getAppListLimit(1L)
        );
    }
}
