package com.sogeti.coe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;






import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.coe.model.Category;
import com.sogeti.coe.model.Product;
@Repository("productRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductRepositoryImpl implements ProductRepository {

	private static final String SELECT_QUERY = "select p from Product p";

	@PersistenceContext
	private EntityManager em;

	@Override
	public void addProduct(Product product) {
		System.out.println("Inside of Product Persist");
		em.persist(product);

	}

	@Override
	public List<Product> findAll() {
		Query query = em.createQuery(SELECT_QUERY);

		@SuppressWarnings("unchecked")
		List<Product> product = (List<Product>) query.getResultList();
		System.out.println("Size of List in repo" + product.size());
		return product;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void editProduct(Product product, Long productId) {
		product.setProductId(productId);
		em.merge(product);
	}

	@Override
	public Product findById(Long productId) {
		return em.find(Product.class, productId);

	}

	@Override
	public void removeProduct(Long productId) {
		Product product = em.find(Product.class, productId);
		em.remove(product);

	}

}
