// **********************************************************************
// This file was generated by a TARS parser!
// TARS version 1.0.1.
// **********************************************************************

package com.mytars.client.visits;

import com.qq.tars.protocol.annotation.*;
import com.qq.tars.protocol.tars.annotation.*;
import com.qq.tars.common.support.Holder;

@Servant
public interface VisitResourcePrx {

	public Visit create(Visit visit, int petId);

	public Visit create(Visit visit, int petId, @TarsContext java.util.Map<String, String> ctx);

	public void async_create(@TarsCallback VisitResourcePrxCallback callback, Visit visit, int petId);

	public void async_create(@TarsCallback VisitResourcePrxCallback callback, Visit visit, int petId, @TarsContext java.util.Map<String, String> ctx);

	public java.util.List<Visit> visits(int petId);

	public java.util.List<Visit> visits(int petId, @TarsContext java.util.Map<String, String> ctx);

	public void async_visits(@TarsCallback VisitResourcePrxCallback callback, int petId);

	public void async_visits(@TarsCallback VisitResourcePrxCallback callback, int petId, @TarsContext java.util.Map<String, String> ctx);

	public Visits visitsMultiGet(java.util.List<java.lang.Integer> petIds);

	public Visits visitsMultiGet(java.util.List<java.lang.Integer> petIds, @TarsContext java.util.Map<String, String> ctx);

	public void async_visitsMultiGet(@TarsCallback VisitResourcePrxCallback callback, java.util.List<java.lang.Integer> petIds);

	public void async_visitsMultiGet(@TarsCallback VisitResourcePrxCallback callback, java.util.List<java.lang.Integer> petIds, @TarsContext java.util.Map<String, String> ctx);
}
