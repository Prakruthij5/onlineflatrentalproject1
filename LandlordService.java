package com.cg.ofr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;


@Service
public class LandlordService  {
	
	@Autowired
	private ILandlordRepository ilandlordrepository;
	

	public List<Landlord> addLandlord(Landlord landlord) {
		ilandlordrepository.save(landlord);
		return ilandlordrepository.findAll();
	}
	
	public List<Landlord> updateLandlord(Integer landlordId,String landlordName) throws LandlordNotFoundException{
		
		if(!ilandlordrepository.existsById(landlordId)) {
			throw new LandlordNotFoundException();
		}
		Landlord landlord = ilandlordrepository.findById(landlordId).get();
	
		landlord.setLandlordName(landlordName);
		ilandlordrepository.flush();
		return ilandlordrepository.findAll();
	}


	public List<Landlord> deleteLandlord(Integer landlordId)throws LandlordNotFoundException{
		if(!ilandlordrepository.existsById(landlordId)) {
			throw new LandlordNotFoundException();
		}
		ilandlordrepository.deleteById(landlordId);
		return ilandlordrepository.findAll();
	
	}


	public Landlord viewLandlord(Integer landlordId) throws LandlordNotFoundException{

	if(!ilandlordrepository.existsById(landlordId)) {
		throw new LandlordNotFoundException();
	}
	return ilandlordrepository.findById(landlordId).get();
	}


	public List<Landlord> viewAllLandlord(){
		return ilandlordrepository.findAll();
		}	
}





	/*
	 * public Landlord updateLandlord(Landlord landlord) throws
	 * LandlordNotFoundException; public Landlord deleteLandlord(Landlord landlord)
	 * throws LandlordNotFoundException; public Landlord viewLandlord(int id) throws
	 * LandlordNotFoundException; public List<Landlord> viewAllLandlord();
	 */

