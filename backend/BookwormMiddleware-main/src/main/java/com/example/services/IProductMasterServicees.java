package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.example.entities.ProductMaster;

public interface IProductMasterServicees {
   public void addBooks(ProductMaster products);
   public List<ProductMaster> getallproducts();
   public ProductMaster getproductbyId(long productId);
   public List<ProductMaster> getproductbylanguageid( long language_id);
public int updatequantiydecrement(long quantity,long productid);
public long getequantity(long id);
}
