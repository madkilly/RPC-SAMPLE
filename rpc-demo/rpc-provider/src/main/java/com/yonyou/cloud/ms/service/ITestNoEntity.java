/**
 * 
 */
package com.yonyou.cloud.ms.service;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.ms.constants.AppInfoConstant;

/**
 * @author zhukai
 *
 */

@RemoteCall(AppInfoConstant.APP_INF_SERVER)
public interface ITestNoEntity {
	
	public NoEntity getNoEntity(NoEntity entity);

}
