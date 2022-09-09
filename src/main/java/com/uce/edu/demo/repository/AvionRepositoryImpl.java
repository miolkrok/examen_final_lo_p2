package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Avion;

@Repository
@Transactional
public class AvionRepositoryImpl implements IAvionRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarAvion(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.persist(avion);
	}

	@Override
	public void actualizarAvion(Avion avion) {
		// TODO Auto-generated method stub
		this.entityManager.merge(avion);
	}

	@Override
	public Avion buscarAvionPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Avion.class, id);
	}

	@Override
	public void borrarAvionPorId(Integer id) {
		// TODO Auto-generated method stub
		Avion avi = this.buscarAvionPorId(id);
		this.entityManager.remove(avi);
	}

	@Override
	public Avion buscarPorNombre(String nombreAvion) {
		// TODO Auto-generated method stub
		TypedQuery<Avion> myQuery = this.entityManager
				.createQuery("SELECT a FROM Avion a WHERE a.nombreAvion =:nombreAvion", Avion.class);
		myQuery.setParameter("nombreAvion", nombreAvion);


		return myQuery.getSingleResult();
	}

}
