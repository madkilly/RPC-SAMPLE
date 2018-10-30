/**
 * 
 */
package com.yonyou.cloud.ms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yonyou.cloud.middleware.rpc.RemoteCall;
import com.yonyou.cloud.ms.constants.AppInfoConstant;
import com.yonyou.cloud.ms.entity.BasicEntity;
import com.yonyou.cloud.ms.entity.ResultEntity;

/**
 * @author zhukai
 *
 */
@RemoteCall(AppInfoConstant.APP_INF_SERVER)
public interface ITestResultObject {
	public ResultEntity dynStubResult();
	
	public BasicEntity testBasic(BasicEntity entity);
	
	public Object dynStubObject();
	
	public String getHello();
	
	public Date testDate(Date date);
	
	public char[] getchararray(char[] chararray);
	
	public byte[] getbyte(byte[] array);
	
	public List<ResultEntity> getHelloParam(String[] strarr,List<ResultEntity>test);
	
	public Map<String,ResultEntity> testMap(String[] strarr,List<ResultEntity>test);
}
