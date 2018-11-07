package com.dingtalk.api.request;

import com.taobao.api.internal.util.RequestCheckUtils;
import java.util.Map;
import java.util.List;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.dingtalk.api.DingTalkConstants;
import com.taobao.api.Constants;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.internal.util.TaobaoUtils;

import com.dingtalk.api.response.OapiCcoserviceServicegroupIsignoreproblemcheckResponse;

/**
 * TOP DingTalk-API: dingtalk.oapi.ccoservice.servicegroup.isignoreproblemcheck request
 * 
 * @author top auto create
 * @since 1.0, 2018.07.25
 */
public class OapiCcoserviceServicegroupIsignoreproblemcheckRequest extends BaseTaobaoRequest<OapiCcoserviceServicegroupIsignoreproblemcheckResponse> {
	
	

	/** 
	* 用户dingtalk加密id
	 */
	private String dingtalkId;

	/** 
	* 群id
	 */
	private String openConversationId;

	public void setDingtalkId(String dingtalkId) {
		this.dingtalkId = dingtalkId;
	}

	public String getDingtalkId() {
		return this.dingtalkId;
	}

	public void setOpenConversationId(String openConversationId) {
		this.openConversationId = openConversationId;
	}

	public String getOpenConversationId() {
		return this.openConversationId;
	}

	public String getApiMethodName() {
		return "dingtalk.oapi.ccoservice.servicegroup.isignoreproblemcheck";
	}

	private String topResponseType = Constants.RESPONSE_TYPE_DINGTALK_OAPI;

     public String getTopResponseType() {
        return this.topResponseType;
     }

     public void setTopResponseType(String topResponseType) {
        this.topResponseType = topResponseType;
     }

     public String getTopApiCallType() {
        return DingTalkConstants.CALL_TYPE_OAPI;
     }

     private String topHttpMethod = DingTalkConstants.HTTP_METHOD_POST;

     public String getTopHttpMethod() {
     	return this.topHttpMethod;
     }

     public void setTopHttpMethod(String topHttpMethod) {
        this.topHttpMethod = topHttpMethod;
     }

     public void setHttpMethod(String httpMethod) {
         this.setTopHttpMethod(httpMethod);
     }

	public Map<String, String> getTextParams() {		
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("dingtalk_id", this.dingtalkId);
		txtParams.put("open_conversation_id", this.openConversationId);
		if(this.udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public Class<OapiCcoserviceServicegroupIsignoreproblemcheckResponse> getResponseClass() {
		return OapiCcoserviceServicegroupIsignoreproblemcheckResponse.class;
	}

	public void check() throws ApiRuleException {
		RequestCheckUtils.checkNotEmpty(dingtalkId, "dingtalkId");
		RequestCheckUtils.checkNotEmpty(openConversationId, "openConversationId");
	}
	

}