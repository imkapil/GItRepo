package com.sogeti.coe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sogeti.coe.model.Category;

@Repository("categoryRepository")
@Transactional(propagation = Propagation.REQUIRED)

public class CategoryRepositoryImpl implements CategoryRepository {

	private static final String SELECT_QUERY = "select c from Category c";

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void addCategory(Category category) {

		em.persist(category);

	}

	public List<Category> findAll() {
		Query query = em.createQuery(SELECT_QUERY);

		@SuppressWarnings("unchecked")
		List<Category> category = (List<Category>) query.getResultList();
		System.out.println("Size of List in repo" + category.size());
		return category;
	}

	@Override
	public void editCategory(Category category, Long categoryId) {
		category.setCategoryId(categoryId);
		em.merge(category);
	}

	@Override
	public Category findById(Long categoryId) {
		return em.find(Category.class, categoryId);

	}

	@Override
	public void removeCategory(Long categoryId) {
		Category catgeory = em.find(Category.class, categoryId);
		em.remove(catgeory);
	}

}
