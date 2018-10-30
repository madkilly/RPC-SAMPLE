/**
 * 
 */
package com.yonyou.cloud.ms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yonyou.cloud.ms.entity.BasicEntity;
import com.yonyou.cloud.ms.entity.ResultEntity;

/**
 * @author zhukai
 *
 */
@Service
public class TestResultObjectImpl implements ITestResultObject{
private static int retrytime = 0;
	/* dynStubResult
	 * 
	 */
	@Override
	public ResultEntity dynStubResult() {
		
		ResultEntity result = new ResultEntity();
		result.setStr("kaizhuv");
		result.setIntge(10);
		
		return result;
	}

	/* getHello
	 * 
	 */
	@Override
	public String getHello() {
		System.out.println(retrytime+1);
		return "2222";
	}

	/* dynStubObject
	 * 
	 */
	@Override
	public Object dynStubObject() {
		
		ResultEntity result = new ResultEntity();
		result.setStr("zhuobject");
		result.setIntge(12);
		return result;
	}

	/* getHelloParam
	 * 
	 */
	@Override
	public List<ResultEntity> getHelloParam(String[] strarr, List<ResultEntity> test) {
		StringBuilder sb = new StringBuilder();
		for(String s : strarr) {
			sb.append(s);
			sb.append("#");
		}
		
		for(ResultEntity s : test) {
			sb.append(s.getStr());
			sb.append("#");
		}
		
		List<ResultEntity> result = new ArrayList<ResultEntity>();
		
		ResultEntity o1 = new ResultEntity();
		o1.setIntge(10);
		o1.setStr("zhu");
		
		ResultEntity o2 = new ResultEntity();
		o2.setIntge(11);
		o2.setStr(sb.toString());
		
		result.add(o1);
		result.add(o2);
		
		return result;
	}

	/* testBasic
	 * 
	 */
	@Override
	public BasicEntity testBasic(BasicEntity entity) {
		return entity;
	}

	/* getchararray
	 * 
	 */
	@Override
	public char[] getchararray(char[] chararray) {
		//char[] result = new char[] {'z','k'};
		return chararray;
	}

	/* getbyte
	 * 
	 */
	@Override
	public byte[] getbyte(byte[] array) {
		return array;
	}

	/* testDate
	 * 
	 */
	@Override
	public Date testDate(Date date) {
		return date;
	}

	/* testMap
	 * 
	 */
	@Override
	public Map<String, ResultEntity> testMap(String[] strarr, List<ResultEntity> test) {
		HashMap<String, ResultEntity> resultmap = new HashMap<String, ResultEntity>();
		
		for(int i=0;i<strarr.length;i++) {
			resultmap.put(strarr[i], test.get(i));
		}
		return resultmap;
	}

}
