package com.sogeti.coe.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-24T12:16:39.512+0530")
@StaticMetamodel(Product.class)
public class Product_ {
	public static volatile SingularAttribute<Product, Long> productId;
	public static volatile SingularAttribute<Product, String> productName;
	public static volatile SingularAttribute<Product, String> productDescription;
	public static volatile SingularAttribute<Product, Double> productPrice;
	public static volatile SingularAttribute<Product, Integer> productStock;
	public static volatile SingularAttribute<Product, Category> category;
}
