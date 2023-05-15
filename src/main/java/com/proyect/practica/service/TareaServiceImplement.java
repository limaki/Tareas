package com.proyect.practica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyect.practica.dao.Dao;
import com.proyect.practica.model.Tarea;



@Service
public class TareaServiceImplement implements TareaService{

	@Autowired
	private Dao tareaDao;  //UtilizamosFuncionesDaoDeInterface
	
	@Override
	@Transactional(readOnly=true)
	public List<Tarea> findAll(){
		return (List<Tarea>) tareaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=false)
	public Tarea save(Tarea tarea) {
		return tareaDao.save(tarea);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Tarea findById(Integer id) {
		
		return tareaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		 tareaDao.deleteById(id);
	}


}
	

