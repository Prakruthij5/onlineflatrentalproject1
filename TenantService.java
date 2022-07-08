package com.cg.ofr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;

@Service
public class TenantService  {
	@Autowired
	private ITenantRepository itenantrepository;
	
	public String addTenant(Tenant tenant) {
		itenantrepository.save(tenant);
		return "Added";
	}
	
public List<Tenant> updateTenant(int tenant_id,int age) throws TenantNotFoundException {
		if(!itenantrepository.existsById(tenant_id)) {
			throw new TenantNotFoundException();
		
		}
	Tenant tenant=itenantrepository.findById(tenant_id).get();
	
	tenant.setAge(tenant_id);
	itenantrepository.flush();
	return itenantrepository.findAll();
}

public List<Tenant> deleteTenant(int tenant_id) throws TenantNotFoundException {
		if(!itenantrepository.existsById(tenant_id)) {
			throw new TenantNotFoundException();
	    }	
		itenantrepository.deleteById(tenant_id);	
			return itenantrepository.findAll();
}
	
public Tenant viewTenant(int tenant_id) throws TenantNotFoundException{
	    if(!itenantrepository.existsById(tenant_id)) {
	    	
			throw new TenantNotFoundException();
	    }	
			return itenantrepository.findById(tenant_id).get();
	}	

public List<Tenant> viewAllTenant(){
	return itenantrepository.findAll();
}



public List<Tenant> validateTenantById(int tenant_Id) {
	return itenantrepository.findAll();
}	
}



