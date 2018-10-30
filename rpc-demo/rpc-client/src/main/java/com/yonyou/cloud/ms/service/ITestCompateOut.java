/**
 * 
 */
package com.yonyou.cloud.ms.service;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.middleware.rpc.RpcMock;
import com.yonyou.cloud.ms.constants.AppInfoConstant;

/**
 * @author zhukai
 *
 */

@RemoteCall("rpc-provider-myself1-zhukai@c87e2267-1001-4c70-bb2a-ab41f3b81aa3")
public interface ITestCompateOut {
	
	public String sendHello(String name);

}
