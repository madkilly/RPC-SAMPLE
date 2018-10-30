/**
 * 
 */
package com.yonyou.cloud.ms.service;

import org.springframework.stereotype.Service;

/**
 * @author zhukai
 *
 */

@Service
public class TestNoEntity implements ITestNoEntity{

	/* getNoEntity
	 * 
	 */
	@Override
	public NoEntity getNoEntity(NoEntity entity) {
		return entity;
	}

}
