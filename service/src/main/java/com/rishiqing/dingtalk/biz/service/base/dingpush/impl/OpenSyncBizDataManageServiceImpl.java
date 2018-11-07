package com.rishiqing.dingtalk.biz.service.base.dingpush.impl;

import com.rishiqing.dingtalk.biz.converter.dingpush.OpenSyncBizDataConverter;
import com.rishiqing.dingtalk.dao.mapper.dingpush.OpenSyncBizDataDao;
import com.rishiqing.dingtalk.isv.api.model.dingpush.OpenSyncBizDataVO;
import com.rishiqing.dingtalk.isv.api.service.base.dingpush.OpenSyncBizDataManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Wallace Mao
 * Date: 2018-11-06 21:48
 */
public class OpenSyncBizDataManageServiceImpl implements OpenSyncBizDataManageService {
    @Autowired
    private OpenSyncBizDataDao openSyncBizDataDao;


    @Override
    public List<OpenSyncBizDataVO> getOpenSyncBizDataListByStatus(Long status) {
        return OpenSyncBizDataConverter.openSyncBizDataDOList2openSyncBizDataVOList(
                openSyncBizDataDao.getOpenSyncBizDataListByStatus(status)
        );
    }

    @Override
    public void updateStatus(OpenSyncBizDataVO data) {
        openSyncBizDataDao.updateStatus(
                OpenSyncBizDataConverter.openSyncBizDataVO2openSyncBizDataDO(data)
        );
    }
}
