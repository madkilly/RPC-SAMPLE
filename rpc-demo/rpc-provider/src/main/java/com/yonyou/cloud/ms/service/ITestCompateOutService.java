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
public class ITestCompateOutService implements ITestCompateOut{

	/* sendHello
	 * 
	 */
	@Override
	public String sendHello(String kaizhu) {
		return kaizhu;
	}

}
