// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.mytars.client.visits;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

@TarsStruct
public class Visits {

	@TarsStructProperty(order = 0, isRequire = false)
	public java.util.List<Visit> items = null;

	public java.util.List<Visit> getItems() {
		return items;
	}

	public void setItems(java.util.List<Visit> items) {
		this.items = items;
	}

	public Visits() {
	}

	public Visits(java.util.List<Visit> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(items);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Visits)) {
			return false;
		}
		Visits other = (Visits) obj;
		return (
			TarsUtil.equals(items, other.items) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		if (null != items) {
			_os.write(items, 0);
		}
	}

	static java.util.List<Visit> cache_items;
	static { 
		cache_items = new java.util.ArrayList<Visit>();
		Visit var_1 = new Visit();
		cache_items.add(var_1);
	}

	public void readFrom(TarsInputStream _is) {
		this.items = (java.util.List<Visit>) _is.read(cache_items, 0, false);
	}

}