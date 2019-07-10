package com.spring.gwt.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public interface IBasic extends Serializable, IsSerializable {
	Object Id();
	void setLastUpdate(Long lastUpdate);
	void setCreateDate(Long createDate);
}
