package comcom.invoice.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import comcom.invoice.demo.entidad.Transaccion;
import comcom.invoice.demo.service.ITransaccionService;

@RestController
@RequestMapping("/api")
public class TransaccionController {
	
	@Autowired
	private ITransaccionService iTransaccionService;
	
	@GetMapping(value="/transaccion")
	public ResponseEntity<Object> get(){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Transaccion> list  = iTransaccionService.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}
	
	@GetMapping(value="/transaccion/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id){ 
		try {
			Transaccion data  = iTransaccionService.findById(id);
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		} 
		catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
			
		} 
		}
	@PostMapping(value="/transaccion")
	public ResponseEntity<Object> create(@RequestBody Transaccion person){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Transaccion res = iTransaccionService.save(person);  
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}
	@PutMapping("/transaccion/{id}")
	public ResponseEntity<Object> update(@RequestBody Transaccion person, @PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			Transaccion currentPerson = iTransaccionService.findById(id);
			
			currentPerson.setId_transaccion(currentPerson.getId_transaccion());
			currentPerson.setMonto(person.getMonto());
			currentPerson.setFecha(person.getFecha());
			currentPerson.setTipo_transaccion(person.getTipo_transaccion());
			
			Transaccion res = iTransaccionService.save(currentPerson);
			
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}
	
	@DeleteMapping("/transaccion/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Transaccion currentPerson = iTransaccionService.findById(id); 
			iTransaccionService.delete(currentPerson);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}
	}
	
			
			
			

