// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.mytars.client.tars.customers;

import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.annotation.*;
import com.qq.tars.common.support.Holder;

@Servant
public interface OwnerResourcePrx {

	public Owner createOwner(Owner owner);

	public Owner createOwner(Owner owner, @TarsContext java.util.Map<String, String> ctx);

	public void async_createOwner(@TarsCallback OwnerResourcePrxCallback callback, Owner owner);

	public void async_createOwner(@TarsCallback OwnerResourcePrxCallback callback, Owner owner, @TarsContext java.util.Map<String, String> ctx);

	public Owner findOwner(int ownerId);

	public Owner findOwner(int ownerId, @TarsContext java.util.Map<String, String> ctx);

	public void async_findOwner(@TarsCallback OwnerResourcePrxCallback callback, int ownerId);

	public void async_findOwner(@TarsCallback OwnerResourcePrxCallback callback, int ownerId, @TarsContext java.util.Map<String, String> ctx);

	public java.util.List<Owner> findAll();

	public java.util.List<Owner> findAll(@TarsContext java.util.Map<String, String> ctx);

	public void async_findAll(@TarsCallback OwnerResourcePrxCallback callback);

	public void async_findAll(@TarsCallback OwnerResourcePrxCallback callback, @TarsContext java.util.Map<String, String> ctx);

	public void updateOwner(int ownerId, Owner ownerRequest);

	public void updateOwner(int ownerId, Owner ownerRequest, @TarsContext java.util.Map<String, String> ctx);

	public void async_updateOwner(@TarsCallback OwnerResourcePrxCallback callback, int ownerId, Owner ownerRequest);

	public void async_updateOwner(@TarsCallback OwnerResourcePrxCallback callback, int ownerId, Owner ownerRequest, @TarsContext java.util.Map<String, String> ctx);
}
