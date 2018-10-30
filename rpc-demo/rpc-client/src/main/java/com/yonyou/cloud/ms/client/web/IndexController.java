package com.yonyou.cloud.ms.client.web;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cloud.middleware.iris.ExecuteResult;
import com.yonyou.cloud.middleware.iris.RPCInvocationInfoProxy;
import com.yonyou.cloud.middleware.iris.RemoteInvocation;
import com.yonyou.cloud.middleware.rpc.DynStub;
import com.yonyou.cloud.middleware.rpc.transport.CodecAdapterFactory;
import com.yonyou.cloud.ms.constants.AppInfoConstant;
import com.yonyou.cloud.ms.entity.BasicEntity;
import com.yonyou.cloud.ms.entity.ResultEntity;
import com.yonyou.cloud.ms.server.service.ITestCompate;
import com.yonyou.cloud.ms.service.ITestCompateOut;
import com.yonyou.cloud.ms.service.ITestResultObject;
import com.yonyou.cloud.utils.GsonUtilHolder;
import com.yonyou.cloud.utils.JacksonUtilHolder;

@RestController
@RequestMapping(value = "/")
public class IndexController {
	
	@Autowired
	private ITestResultObject Service;
	
	
	@Autowired
	private ITestCompateOut compateService;
	
	@Autowired
	private ITestCompate service1;
	
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		String str = Service.getHello();
		
		return str;
	}
	
	
	@RequestMapping(value = "/testnewe")
	public String testnewe() throws Exception {
		
		String[] paramsTypes =new String[] {}; 
		String[] params =new String[] {};
		String tmp  ="rpc-provider-myself1-zhukai@c87e2267-1001-4c70-bb2a-ab41f3b81aa3";
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		ExecuteResult result = DynStub.invokerExact("com.yonyou.cloud.ms.service.ITestResultObject",tmp, null, "getHello",paramsTypes,params);
		return String.valueOf(result);
	}
	
	@RequestMapping(value = "/testlist",method = RequestMethod.GET)
	public String testlist() {
		
		List<ResultEntity> result = new ArrayList<ResultEntity>();
		
		ResultEntity o1 = new ResultEntity();
		o1.setIntge(10);
		o1.setStr("zhu");
		
		ResultEntity o2 = new ResultEntity();
		o2.setIntge(11);
		o2.setStr("kai");
		
		result.add(o1);
		result.add(o2);
		
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		
		List<ResultEntity> str = Service.getHelloParam(new String[]{"zhu","kai"}, result);
		
		return str.get(1).getStr();
	}
	
	@RequestMapping(value = "/testmap",method = RequestMethod.GET)
	public String testmap() {
		
		List<ResultEntity> result = new ArrayList<ResultEntity>();
		
		ResultEntity o1 = new ResultEntity();
		o1.setIntge(10);
		o1.setStr("zhu");
		
		ResultEntity o2 = new ResultEntity();
		o2.setIntge(11);
		o2.setStr("kai");
		
		result.add(o1);
		result.add(o2);
		
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		
		Map<String, ResultEntity> str = Service.testMap(new String[]{"zhu","kai"}, result);
		
		return str.get("zhu").getStr();
	}
		
	
	@RequestMapping(value = "/dynTestDate")
	public String dynTestDate() throws Exception {
		
		String[] paramsTypes =new String[] {Date.class.getName()}; 
		
		Date date1 = new Date();
		
		String pram_str = JacksonUtilHolder.toJson(date1);
		
		String[] params =new String[] {pram_str};
		
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		String tmp  ="rpc-provider-myself1-zhukai";
		ExecuteResult result = DynStub.invokerExact("com.yonyou.cloud.ms.service.ITestResultObject",tmp, null, "testDate",paramsTypes,params);
		System.out.println(result.getValue());
		return result.getValue().toString();
	}
	
	@RequestMapping(value = "/TestDate")
	public String testDate() throws Exception {
		
		
		Date date1 = new Date();
		Date result;
		
		
		
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		String tmp  ="rpc-provider-myself1-zhukai";
		result=Service.testDate(date1);
		System.out.println(result);
		return result.toString();
	}
	
	
	@RequestMapping(value = "/dynresult")
	public String dynresult() throws Exception {
		
		String[] paramsTypes =new String[] {}; 
		String[] params =new String[] {};
		
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		String tmp  ="rpc-provider-myself1-zhukai";
		ExecuteResult result = DynStub.invokerExact("com.yonyou.cloud.ms.service.ITestResultObject",tmp, null, "dynStubResult",paramsTypes,params);
		ResultEntity entity = (ResultEntity)result.getValue();
		System.out.println(entity.getStr());
		return entity.getStr();
	}
	
	@RequestMapping(value = "/nomalresult")
	public String nomalresult() throws Exception {
		ResultEntity entity = Service.dynStubResult();
		System.out.println(entity.getStr());
		return entity.getStr();
	}
	
	@RequestMapping(value = "/testNoEntity")
	public String testNoEntity() throws Exception {
		
		String[] paramsTypes =new String[] {"com.yonyou.cloud.ms.service.NoEntity"}; 
		String[] params =new String[] {"{\"name\":\"zhukai\"}"};
		
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		String tmp  ="rpc-provider-myself1-zhukai";
		ExecuteResult result = DynStub.invokerExact("com.yonyou.cloud.ms.service.ITestNoEntity",tmp, null, "getNoEntity",paramsTypes,params);
		String entity = GsonUtilHolder.toJson(result.getValue());
		return entity;
	}
	
	
	@RequestMapping(value = "/testchararrayinterface")
	public String testchararray() throws Exception {
		//hessian序列化支持不了
		char[] para = new char[] {'z','k','i'};
		
		//RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		String tmp  ="rpc-provider-myself1-zhukai";
		char[] result = Service.getchararray(para);
		for (char c :result) {
			System.out.println(c);
		}
		return String.valueOf(result[0]);
	}
	
	
	@RequestMapping(value = "/testchararray")
	public String testchararrayinterface() throws Exception {
		//hessian序列化支持不了
		char[] para = new char[] {'z','k','i'};
		String raw =  GsonUtilHolder.toJson(para);
		
		String[] paramsTypes =new String[] {char[].class.getName()}; 
		String[] params =new String[] {raw};
		
		String tmp  ="rpc-provider-myself1-zhukai";
		ExecuteResult result = DynStub.invokerExact("com.yonyou.cloud.ms.service.ITestResultObject",tmp, null, "getchararray",paramsTypes,params);
		char[] entity = (char[])result.getValue();
		for (char c :entity) {
			System.out.println(c);
		}
		return String.valueOf(entity[0]);
	}
	
	
	@RequestMapping(value = "/testbytearray")
	public String testbytearray() throws Exception {
		
		String[] paramsTypes =new String[] {byte[].class.getName()}; 
		byte[] bytearray = new byte[] {1,2,3};
		String arguments = GsonUtilHolder.toJson(bytearray);
		String[] params =new String[] {arguments};
		
		//RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		String tmp  ="rpc-provider-myself1-zhukai";
		ExecuteResult result = DynStub.invokerExact("com.yonyou.cloud.ms.service.ITestResultObject",tmp, null, "getbyte",paramsTypes,params);
		byte[] entity = (byte[])result.getValue();
		for (byte c :entity) {
			System.out.println(c);
		}
		return String.valueOf(entity[0]);
	}
	
	
	@RequestMapping(value = "/testAlias")
	public String testAlias() throws Exception {
		Method m = ITestResultObject.class.getMethod("getHello",new Class<?>[] {});
		RemoteInvocation invocation = new RemoteInvocation(m.getName(), m.getParameterTypes(), null);
		String tmp  ="rpc-provider-myself1-zhukai";
		ExecuteResult result = DynStub.invokerWithInvocation("com.yonyou.cloud.ms.service.ITestResultObject", tmp, "TestAlias", invocation);
		String entity = (String)result.getValue();
		return entity;
	}
	
	
	@RequestMapping(value = "/testdirect")
	@SuppressWarnings("deprecation")
	public String testdirect() throws Exception {
		Method m = ITestResultObject.class.getMethod("getHello",new Class<?>[] {});
		RemoteInvocation invocation = new RemoteInvocation(m.getName(), m.getParameterTypes(), null);
		String tmp  ="rpc-provider-myself1-zhukai";
		ExecuteResult result = DynStub.invokerWithInvocation("com.yonyou.cloud.ms.service.ITestResultObject", tmp, null, invocation);
		String entity = (String)result.getValue();
		return entity;
	}
	
	@RequestMapping(value = "/compate")
	public String compate() throws Exception {
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		String result = compateService.sendHello("2222");
		return result;
	}
	
	@RequestMapping(value = "/testcompate")
	public String testcompate() throws Exception {
		List<String> result = service1.getHello("2222");
		return result.get(0);
	}
	
	@RequestMapping(value = "/dynobj")
	public String dynobj() throws Exception {
		
		String[] paramsTypes =new String[] {}; 
		String[] params =new String[] {};
		
		RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		ExecuteResult result = DynStub.invokerExact("com.yonyou.cloud.ms.service.ITestResultObject",AppInfoConstant.APP_INF_SERVER, null, "dynStubObject",paramsTypes,params);
		ResultEntity entity = (ResultEntity)result.getValue();
		System.out.println(entity.getStr());
		return entity.getStr();
	}
	
	
	@RequestMapping(value = "/basicnull")
	public String basicnull() throws Exception {
		
		String[] paramsTypes =new String[] {BasicEntity.class.getName()}; 
		BasicEntity entity = new BasicEntity();
		String param = GsonUtilHolder.toJson(entity);
		param = "{\"booleanField\":[]}";
		String[] params =new String[] {param};
		
		
		//RPCInvocationInfoProxy.setProto(CodecAdapterFactory.APPLICATION_JSON_UTF8_VALUE);
		ExecuteResult result = DynStub.invokerExact("com.yonyou.cloud.ms.service.ITestResultObject",AppInfoConstant.APP_INF_SERVER, null, "testBasic",paramsTypes,params);
		BasicEntity reentity = (BasicEntity)result.getValue();
		System.out.println(reentity.isBooleanField());
		return String.valueOf(reentity.isBooleanField());
	}
	
	
	@RequestMapping(value = "/qicen")
	public String qicen() throws Exception {
		
		String[] paramsTypes =new String[] {String.class.getName()}; 
		String[] params =new String[] {"222"};
		String service_appcode = "rpc-yangweigang1@c87e2267-1001-4c70-bb2a-ab41f3b81aa3";
		ExecuteResult result = DynStub.invokerExact("com.ywg.TestMicro",service_appcode, null, "set",paramsTypes,params);
		ResultEntity entity = (ResultEntity)result.getValue();
		System.out.println(entity.getStr());
		return entity.getStr();
/*		String num = "2222";
		String num_json =  GsonUtilHolder.toJson(num);
		Object obj = GsonUtilHolder.fromJson(num_json, Object.class);
		System.out.println(obj);
		return obj.toString();*/
	}
	
	
	@RequestMapping(value = "/113")
	public String test113() throws Exception {
		
		String[] paramsTypes =new String[] {Integer.class.getName()}; 
		String[] params =new String[] {"222"};
		String service_appcode = "ms-middle-cf@c87e2267-1001-4c70-bb2a-ab41f3b81aa3";
		ExecuteResult result = DynStub.invokerExact("com.yonyou.cloud.ms.service.IMsMiddleService",service_appcode, null, "getRemoteDigit",paramsTypes,params);
		String entity = (String)result.getValue();
		//System.out.println(entity.getStr());
		return entity;
/*		String num = "2222";
		String num_json =  GsonUtilHolder.toJson(num);
		Object obj = GsonUtilHolder.fromJson(num_json, Object.class);
		System.out.println(obj);
		return obj.toString();*/
	}
}