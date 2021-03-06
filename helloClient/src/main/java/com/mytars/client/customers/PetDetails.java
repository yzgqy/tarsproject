// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.mytars.client.customers;

import com.qq.tars.protocol.util.*;
import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.*;
import com.qq.tars.protocol.tars.annotation.*;

@TarsStruct
public class PetDetails {

	@TarsStructProperty(order = 0, isRequire = false)
	public int id = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public String name = "";
	@TarsStructProperty(order = 2, isRequire = false)
	public String owner = "";
	@TarsStructProperty(order = 3, isRequire = false)
	public String birthDate = "";
	@TarsStructProperty(order = 4, isRequire = false)
	public PetType type = null;

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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public PetDetails() {
	}

	public PetDetails(int id, String name, String owner, String birthDate, PetType type) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.birthDate = birthDate;
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(id);
		result = prime * result + TarsUtil.hashCode(name);
		result = prime * result + TarsUtil.hashCode(owner);
		result = prime * result + TarsUtil.hashCode(birthDate);
		result = prime * result + TarsUtil.hashCode(type);
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
		if (!(obj instanceof PetDetails)) {
			return false;
		}
		PetDetails other = (PetDetails) obj;
		return (
			TarsUtil.equals(id, other.id) &&
			TarsUtil.equals(name, other.name) &&
			TarsUtil.equals(owner, other.owner) &&
			TarsUtil.equals(birthDate, other.birthDate) &&
			TarsUtil.equals(type, other.type) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(id, 0);
		if (null != name) {
			_os.write(name, 1);
		}
		if (null != owner) {
			_os.write(owner, 2);
		}
		if (null != birthDate) {
			_os.write(birthDate, 3);
		}
		if (null != type) {
			_os.write(type, 4);
		}
	}

	static PetType cache_type;
	static { 
		cache_type = new PetType();
	}

	public void readFrom(TarsInputStream _is) {
		this.id = _is.read(id, 0, false);
		this.name = _is.readString(1, false);
		this.owner = _is.readString(2, false);
		this.birthDate = _is.readString(3, false);
		this.type = (PetType) _is.read(cache_type, 4, false);
	}

}
