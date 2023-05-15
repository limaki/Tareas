package com.proyect.practica.service;

import java.util.List;

import com.proyect.practica.model.Tarea;

//FuncionesCrud
public interface TareaService {

	public List<Tarea> findAll();
	public Tarea save(Tarea tarea);
	public Tarea findById(Integer id);
	public void delete(Integer id);
}
