package com.example.mvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.model.Planet;

@Transactional
@Repository("planetRepo")
public class PlanetRepository {

	private SessionFactory sesFac;
	
	@Autowired
	public PlanetRepository(SessionFactory sesFac) {
		this.sesFac = sesFac;
	}
	
	public void insert(Planet p) {
		sesFac.getCurrentSession().save(p);
	}
	
	public void update(Planet p) {
		sesFac.getCurrentSession().saveOrUpdate(p);
	}
	
	public void delete(Planet p) {
		sesFac.getCurrentSession().delete(p);
	}
	
	public Planet getById(int id) {
		return sesFac.getCurrentSession().get(Planet.class, id);
	}
	
	public List<Planet> getAll() {
		return sesFac.getCurrentSession().createQuery("from Planet", Planet.class).list();
	}
	
}
