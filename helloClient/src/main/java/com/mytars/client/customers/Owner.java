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
public class Owner {

	@TarsStructProperty(order = 0, isRequire = false)
	public int id = 0;
	@TarsStructProperty(order = 1, isRequire = false)
	public String firstName = "";
	@TarsStructProperty(order = 2, isRequire = false)
	public String lastName = "";
	@TarsStructProperty(order = 3, isRequire = false)
	public String address = "";
	@TarsStructProperty(order = 4, isRequire = false)
	public String city = "";
	@TarsStructProperty(order = 5, isRequire = false)
	public String telephone = "";
	@TarsStructProperty(order = 6, isRequire = false)
	public java.util.List<Pet> pets = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public java.util.List<Pet> getPets() {
		return pets;
	}

	public void setPets(java.util.List<Pet> pets) {
		this.pets = pets;
	}

	public Owner() {
	}

	public Owner(int id, String firstName, String lastName, String address, String city, String telephone, java.util.List<Pet> pets) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.pets = pets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TarsUtil.hashCode(id);
		result = prime * result + TarsUtil.hashCode(firstName);
		result = prime * result + TarsUtil.hashCode(lastName);
		result = prime * result + TarsUtil.hashCode(address);
		result = prime * result + TarsUtil.hashCode(city);
		result = prime * result + TarsUtil.hashCode(telephone);
		result = prime * result + TarsUtil.hashCode(pets);
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
		if (!(obj instanceof Owner)) {
			return false;
		}
		Owner other = (Owner) obj;
		return (
			TarsUtil.equals(id, other.id) &&
			TarsUtil.equals(firstName, other.firstName) &&
			TarsUtil.equals(lastName, other.lastName) &&
			TarsUtil.equals(address, other.address) &&
			TarsUtil.equals(city, other.city) &&
			TarsUtil.equals(telephone, other.telephone) &&
			TarsUtil.equals(pets, other.pets) 
		);
	}

	public void writeTo(TarsOutputStream _os) {
		_os.write(id, 0);
		if (null != firstName) {
			_os.write(firstName, 1);
		}
		if (null != lastName) {
			_os.write(lastName, 2);
		}
		if (null != address) {
			_os.write(address, 3);
		}
		if (null != city) {
			_os.write(city, 4);
		}
		if (null != telephone) {
			_os.write(telephone, 5);
		}
		if (null != pets) {
			_os.write(pets, 6);
		}
	}

	static java.util.List<Pet> cache_pets;
	static { 
		cache_pets = new java.util.ArrayList<Pet>();
		Pet var_1 = new Pet();
		cache_pets.add(var_1);
	}

	public void readFrom(TarsInputStream _is) {
		this.id = _is.read(id, 0, false);
		this.firstName = _is.readString(1, false);
		this.lastName = _is.readString(2, false);
		this.address = _is.readString(3, false);
		this.city = _is.readString(4, false);
		this.telephone = _is.readString(5, false);
		this.pets = (java.util.List<Pet>) _is.read(cache_pets, 6, false);
	}

}