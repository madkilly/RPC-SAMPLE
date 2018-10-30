/**
 * 
 */
package com.yonyou.test;

import org.junit.Test;

import com.yonyou.cloud.ms.service.NoEntity;
import com.yonyou.cloud.utils.GsonUtilHolder;

/**
 * @author zhukai
 *
 */
public class TestMyNeed {
	
	@Test
	public void test1() {
		String paramtype = NoEntity.class.getName();
		
		NoEntity e= new NoEntity();
		e.setName("zhukai");
		
		String argument = GsonUtilHolder.toJson(e);
		
		System.out.println(paramtype);
		System.out.println(argument);
		
	}

}
