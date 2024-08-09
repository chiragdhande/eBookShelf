package com.example.services;

import java.util.List;

import com.example.entities.ProductTypeMaster;

public interface IProductTypeMasterServices {
   public void Addtype(ProductTypeMaster type);
   public List<ProductTypeMaster> getalltype();
}
