package com.rishiqing.dingtalk.manager.corp;

import com.rishiqing.dingtalk.constant.CorpLockType;
import com.rishiqing.dingtalk.dao.model.corp.CorpDO;
import com.rishiqing.dingtalk.dao.model.corp.CorpLockDO;
import com.rishiqing.dingtalk.isv.api.model.corp.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Wallace Mao
 * Date: 2018-11-03 15:23
 */
public interface CorpManager {
    void saveOrUpdateCorp(CorpVO corpVO);

    void saveOrUpdateCorpJSTicket(CorpJSAPITicketVO corpJSAPITicketVO);

    CorpDO getCorpById(Long id);

    CorpVO getCorpByCorpId(String corpId);

    void updateRsqInfo(CorpVO corpVO);

    CorpTokenVO getCorpTokenByCorpId(String corpId);

    CorpJSAPITicketVO getCorpJSAPITicketByCorpId(String corpId);

    CorpChargeStatusVO getCorpChargeStatusByCorpId(String corpId);

    CorpStaffVO findATeamCreator(String corpId);

    void deleteCorpSuiteAuthByCorpId(String corpId);

    void deleteCorpAppByCorpId(String corpId, Long appId);

    void deleteCorpTokenByCorpId(String corpId);

    void deleteCorpJSAPITicketByCorpId(String corpId);

    void saveOrUpdateCorpStatisticUserCount(String corpId, Long userCount);

    void saveOrUpdateCorpStatistic(CorpStatisticVO corpStatisticVO);

    CorpStatisticVO getCorpStatisticByCorpId(String corpId);

    CorpStatisticVO getCorpStatisticByCorpIdForUpdate(String corpId);

    List<CorpDO> listPageCorpWithCreator(Long pageSize, Long offset, Map<String, Object> clause);

    Long countCorp();

    Long countCorpSuiteAuth(Map<String, Object> clause);

    @Transactional
    CorpLockDO requireLock(String corpId, CorpLockType lockType);

    @Transactional
    CorpLockDO releaseLock(String corpId, CorpLockType lockType);

    List<CorpDO> listCorpBetweenDate(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);
}
