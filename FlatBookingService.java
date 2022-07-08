package com.cg.ofr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;

import com.cg.ofr.repository.IFlatBookingRepository;

@Service
public class FlatBookingService {
	
	
	@Autowired
	private IFlatBookingRepository flatbookingrepository;
	
	public String addFlatBooking(FlatBooking flat) {
		flatbookingrepository.save(flat);
		return "Added";
	}
	
	public List<FlatBooking> viewAllFlatBooking(){
   	 return flatbookingrepository.findAll();
}

	
	
	  public List<FlatBooking> updateFlatBooking(int bookingNo, Flat flat) throws
	  FlatBookingNotFoundException{
	  if(!flatbookingrepository.existsById(bookingNo)) { 
		  throw new FlatBookingNotFoundException(); } 
	  FlatBooking flatbooking=flatbookingrepository.findById(bookingNo).get();
	  
	  flatbooking.setFlat(flat); flatbookingrepository.flush(); return
	  flatbookingrepository.findAll(); }
	  
	  public List<FlatBooking> deleteFlatBooking(int bookingNo, Flat flat) throws
	  FlatBookingNotFoundException{
	  if(!flatbookingrepository.existsById(bookingNo)) { throw new
	  FlatBookingNotFoundException(); } FlatBooking
	   flatbooking=flatbookingrepository.findById(bookingNo).get();
	  flatbooking.setFlat(flat);
	  
	  return flatbookingrepository.findAll(); }
	  
	  
	  public List<FlatBooking> viewFlatBooking(int bookingNo, Flat flat) throws
	  FlatBookingNotFoundException{
	  if(!flatbookingrepository.existsById(bookingNo)) { throw new
	  FlatBookingNotFoundException(); } FlatBooking
	  flatbooking=flatbookingrepository.findById(bookingNo).get();
	  flatbooking.setFlat(flat);
	  
	  return flatbookingrepository.findAll(); }
	 
     
     
     
     

	
	}

	

		
//	public Flat updateFlatBooking(Flat flat) throws FlatBookingNotFoundException;
//	public Flat deleteFlatBooking(Flat flat) throws FlatBookingNotFoundException;
//	public Flat viewFlatBooking(int id) throws FlatBookingNotFoundException;
//	public List<FlatBooking> viewAllFlatBooking();

	


