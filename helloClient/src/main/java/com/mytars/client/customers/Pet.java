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
public class Pet {

	@TarsStructProperty(order = 0, isRequire = false)
	public int id = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public String name = "";
	@TarsStructProperty(order = 2, isRequire = false)
	public String birthDate = "";
	@TarsStructProperty(order = 3, isRequire = false)
	public PetType petType = null;

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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Pet() {
	}

	public Pet(int id, String name, String birthDate, PetType petType) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.petType = petType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(id);
		result = prime * result + TarsUtil.hashCode(name);
		result = prime * result + TarsUtil.hashCode(birthDate);
		result = prime * result + TarsUtil.hashCode(petType);
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
		if (!(obj instanceof Pet)) {
			return false;
		}
		Pet other = (Pet) obj;
		return (
			TarsUtil.equals(id, other.id) &&
			TarsUtil.equals(name, other.name) &&
			TarsUtil.equals(birthDate, other.birthDate) &&
			TarsUtil.equals(petType, other.petType) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(id, 0);
		if (null != name) {
			_os.write(name, 1);
		}
		if (null != birthDate) {
			_os.write(birthDate, 2);
		}
		if (null != petType) {
			_os.write(petType, 3);
		}
	}

	static PetType cache_petType;
	static { 
		cache_petType = new PetType();
	}

	public void readFrom(TarsInputStream _is) {
		this.id = _is.read(id, 0, false);
		this.name = _is.readString(1, false);
		this.birthDate = _is.readString(2, false);
		this.petType = (PetType) _is.read(cache_petType, 3, false);
	}

}
