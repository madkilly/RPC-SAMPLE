/**
 * 
 */
package com.yonyou.cloud.ms.server.service;

import java.util.List;

import com.yonyou.cloud.middleware.rpc.RemoteCall;

/**
 * @author zhukai
 *
 */
@RemoteCall("ms-server-zhuxun1@c87e2267-1001-4c70-bb2a-ab41f3b81aa3")
public interface ITestCompate {
	
	public List<String> getHello(String name);

}
