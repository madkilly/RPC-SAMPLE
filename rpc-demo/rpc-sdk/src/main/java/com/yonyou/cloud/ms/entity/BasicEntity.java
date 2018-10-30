/**
 * 
 */
package com.yonyou.cloud.ms.entity;

import java.io.Serializable;

/**
 * @author zhukai
 *
 */
public class BasicEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean[] booleanField;

	public boolean[] isBooleanField() {
		return booleanField;
	}

	public void setBooleanField(boolean[] booleanField) {
		this.booleanField = booleanField;
	}
	

}
