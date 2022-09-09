package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloTO;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepo {

	private static Logger LOG = Logger.getLogger(VueloRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vuelo);
	}

	@Override
	public void actualizarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vuelo);
	}

	@Override
	public Vuelo buscarVueloPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vuelo.class, id);
	}

	@Override
	public void borrarVueloPorId(Integer id) {
		// TODO Auto-generated method stub
		Vuelo vue = this.buscarVueloPorId(id);
		this.entityManager.remove(vue);
	}

	@Override
	public Vuelo buscarVueloPorEstado(String estado) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Vuelo buscarPorNumeroVuelo(String numeroVuelo) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vuelo v WHERE v.numeroVuelo=:numeroVuelo", Vuelo.class);
		myQuery.setParameter("numeroVuelo", numeroVuelo);

		Vuelo vuelo = myQuery.getSingleResult();

		LOG.info(vuelo.getAvion());

		return myQuery.getSingleResult();
	}

	@Override
	public List<Vuelo> buscarVuelosDispon(String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vuelo v WHERE v.origen=:origen AND v.destino=:destino AND v.fechaVuelo>=:fechaVuelo", Vuelo.class);
		myQuery.setParameter("origen", origen);
		myQuery.setParameter("destino", destino);
		myQuery.setParameter("fechaVuelo", fechaVuelo);

		try {
		return myQuery.getResultList();
		}catch (NoResultException e) {
			return null;
		}
	}

}
