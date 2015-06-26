package com.sogeti.coe.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-06-25T12:44:51.276+0530")
@StaticMetamodel(Category.class)
public class Category_ {
	public static volatile SingularAttribute<Category, Long> categoryId;
	public static volatile SingularAttribute<Category, String> categoryName;
	public static volatile SingularAttribute<Category, String> categoryDescription;
	public static volatile ListAttribute<Category, Product> productList;
}
