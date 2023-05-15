package com.proyect.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.practica.model.Tarea;
import com.proyect.practica.service.TareaService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class TareaController {

	@Autowired
	private TareaService tareaservice ; //llamandoTareaService
	
	@GetMapping("/tareas")
	public List<Tarea> listar(){
		
		return tareaservice.findAll();
	}
	
	@PostMapping("/tareas")
	public Tarea guardar(@RequestBody Tarea tarea) {
		return tareaservice.save(tarea);
	}
	
	@GetMapping("/tareas/{id}")
	public Tarea getUnaTarea(@PathVariable Integer id) {
		return tareaservice.findById(id);
	}
	
	@PutMapping("/tareas/{id}")
	public Tarea modificar(@RequestBody Tarea tarea,@PathVariable Integer id) {
		
		Tarea tareaActual = tareaservice.findById(id); //SeleccionarTarea
		tareaActual.setTarea(tarea.getTarea());        //ModificarTareaSeleccionada
		tareaActual.setFinalizado(tarea.getFinalizado()); //ModificarTareaSeleccionada
		
		return tareaservice.save(tareaActual);
	}
	
	@DeleteMapping("/tareas/{id}")
	public void eliminar(@PathVariable Integer id) {
		tareaservice.delete(id);
	}
}
