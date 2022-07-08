package com.cg.ofr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;
import com.cg.ofr.service.IFlatService;
@Service
public class FlatService implements IFlatService{
	
	@Autowired
	private IFlatRepository iflatrepository;
	
	
	
	public List<Flat> addFlat(Flat flat) {
		iflatrepository.saveAndFlush(flat);
		return iflatrepository.findAll();
	}
	
	public List<Flat> updateFlat(Integer flatId, Double cost) throws FlatNotFoundException{
		if(!iflatrepository.existsById(flatId)) {
			throw new FlatNotFoundException();
	}
	Flat flat=iflatrepository.findById(flatId).get();
	  flat.setCost(cost);
		iflatrepository.flush();
		return iflatrepository.findAll();
		
		}
	public List<Flat> deleteFlat(Integer flatId) throws FlatNotFoundException{ 
		if(!iflatrepository.existsById(flatId)) {
			throw new FlatNotFoundException();
		}
		iflatrepository.deleteById(flatId);
		return iflatrepository.findAll();
	}
	 public Flat viewFlat(Integer flatId) throws FlatNotFoundException{
		 if(!iflatrepository.existsById(flatId)) {
		 throw new FlatNotFoundException();
		 }
		
	   return iflatrepository.findById(flatId).get();
	 }
	 public List<Flat> viewAllFlat(){
		 return iflatrepository.findAll();
	 }
		
		/* public Flat viewAllFlatIdAndAvailability(Integer flatId,String availability) throws FlatNotFoundException{
			 if(!iflatrepository.existsById(flatId)) {
				 throw new FlatNotFoundException();
			 }
			return iflatrepository.findById(flatId).get();
			 }
			 */
		 
		 public List<Flat> findByCostAndAvailability(Double cost,String availability){
	         return iflatrepository.findByCostAndAvailability(cost,availability);
	     }
			
		 
}


/*public Flat addFlat(Flat flat);
public Flat updateFlat(Flat flat) throws FlatNotFoundException;
public Flat deleteFlat(Flat flat) throws FlatNotFoundException;
public Flat viewFlat(int id) throws FlatNotFoundException;
public List<Flat> viewAllFlat();
public List<Flat> viewAllFlatByCost(float cost,String availability);
*/
	 
