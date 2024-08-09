package com.example.services;
import java.util.List;

import com.example.entities.RoyaltyMaster;

public interface IRoyaltyServices {
   public void AddRoyalty(RoyaltyMaster master);
   public List<RoyaltyMaster> getAllRoyalty();
    public List<RoyaltyMaster> GetRoyaltyByAuthorid(long id);
    public List<RoyaltyMaster> GetRoyaltyByPublisherid(long id);
    
   
}
