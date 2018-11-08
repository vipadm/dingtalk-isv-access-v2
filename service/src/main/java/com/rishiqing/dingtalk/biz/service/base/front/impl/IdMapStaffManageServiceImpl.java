package com.rishiqing.dingtalk.biz.service.base.front.impl;

import com.rishiqing.dingtalk.biz.converter.front.IdMapStaffConverter;
import com.rishiqing.dingtalk.dao.mapper.front.IdMapStaffDao;
import com.rishiqing.dingtalk.isv.api.model.front.IdMapStaffVO;
import com.rishiqing.dingtalk.isv.api.service.base.front.IdMapStaffManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Wallace Mao
 * Date: 2018-11-08 11:56
 */
public class IdMapStaffManageServiceImpl implements IdMapStaffManageService {
    @Autowired
    private IdMapStaffDao idMapStaffDao;

    @Override
    public List<IdMapStaffVO> getUserIdFromRsqId(String corpId, String[] rsqIds) {
        return IdMapStaffConverter.idMapStaffDOList2IdMapStaffVOList(
                idMapStaffDao.getUserIdFromRsqId(corpId, rsqIds)
        );
    }

    @Override
    public List<IdMapStaffVO> getRsqIdFromUserId(String corpId, String[] userIds) {
        return IdMapStaffConverter.idMapStaffDOList2IdMapStaffVOList(
                idMapStaffDao.getRsqIdFromUserId(corpId, userIds)
        );
    }
}
