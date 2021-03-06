package com.rishiqing.dingtalk.manager.suite;

import com.rishiqing.dingtalk.isv.api.model.suite.CorpSuiteAuthDeptVO;
import com.rishiqing.dingtalk.isv.api.model.suite.CorpSuiteAuthUserVO;
import com.rishiqing.dingtalk.isv.api.model.suite.CorpSuiteAuthVO;

/**
 * @author Wallace Mao
 * Date: 2018-11-03 20:25
 */
public interface CorpSuiteAuthManager {
    void saveOrUpdateCorpSuiteAuth(CorpSuiteAuthVO corpSuiteAuthVO);

    CorpSuiteAuthVO getCorpSuiteAuth(String corpId);

    CorpSuiteAuthDeptVO getCorpSuiteAuthDeptByCorpIdAndDeptId(
            String corpId, Long deptId);

    CorpSuiteAuthUserVO getCorpSuiteAuthUserByCorpIdAndUserId(
            String corpId, String userId);
}
