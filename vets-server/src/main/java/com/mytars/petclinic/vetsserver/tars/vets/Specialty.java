// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.mytars.petclinic.vetsserver.tars.vets;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

@TarsStruct
public class Specialty {

	@TarsStructProperty(order = 0, isRequire = false)
	public int id = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public String name = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Specialty() {
	}

	public Specialty(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(id);
		result = prime * result + TarsUtil.hashCode(name);
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
		if (!(obj instanceof Specialty)) {
			return false;
		}
		Specialty other = (Specialty) obj;
		return (
			TarsUtil.equals(id, other.id) &&
			TarsUtil.equals(name, other.name)
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(id, 0);
		if (null != name) {
			_os.write(name, 1);
		}
	}


	public void readFrom(TarsInputStream _is) {
		this.id = _is.read(id, 0, false);
		this.name = _is.readString(1, false);
	}

}
