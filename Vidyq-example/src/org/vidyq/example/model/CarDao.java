package org.vidyq.example.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.vidyq.JPAQueryBuilder.QueryBuilder;
import org.vidyq.business.ModelQuery;


public class CarDao {

	private EntityManager em;
	
	public List<Car> search(ModelQuery modelquery){
		QueryBuilder qb = new QueryBuilder(modelquery);
		Query query = em.createQuery(qb.getJPAQuery());
		qb.setConditions(query);
		return query.getResultList();
	}
}
