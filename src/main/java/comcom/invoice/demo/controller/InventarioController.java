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

import comcom.invoice.demo.entidad.Inventario;
import comcom.invoice.demo.service.IInventarioService;

@RestController
@RequestMapping("/api")
public class InventarioController {

@Autowired
private IInventarioService iInventarioService;

@GetMapping(value="/inventario")
public ResponseEntity<Object> get(){ 
	Map<String, Object> map = new HashMap<String, Object>();
	try {
		List<Inventario> list  = iInventarioService.findAll();
		return new ResponseEntity<Object>(list,HttpStatus.OK);
	} 
	catch (Exception e) {
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}

@GetMapping(value="/inventario/{id}")
public ResponseEntity<Object> getById(@PathVariable Long id){ 
	try {
		Inventario data  = iInventarioService.findById(id);
		return new ResponseEntity<Object>(data,HttpStatus.OK);
	} 
	catch (Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}

@PostMapping(value="/inventario")
public ResponseEntity<Object> create(@RequestBody Inventario person){ 
	Map<String, Object> map = new HashMap<String, Object>();
	try {
		Inventario res = iInventarioService.save(person);  
		return new ResponseEntity<Object>(res,HttpStatus.OK);
	} 
	catch (Exception e) {
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}

@PutMapping("/inventario/{id}")
public ResponseEntity<Object> update(@RequestBody Inventario person, @PathVariable Long id){ 
	Map<String, Object> map = new HashMap<String, Object>();
	try {
		
		Inventario currentPerson = iInventarioService.findById(id);
		
		currentPerson.setId_inventario(currentPerson.getId_inventario());
		currentPerson.setFecha(person.getFecha());
		currentPerson.setId_factura(person.getId_factura());
	
		
		Inventario res = iInventarioService.save(currentPerson);
		
		return new ResponseEntity<Object>(res,HttpStatus.OK);
	} 
	catch (Exception e) {
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}

@DeleteMapping("/inventario/{id}")
public ResponseEntity<Object> delete(@PathVariable Long id){ 
	Map<String, Object> map = new HashMap<String, Object>();
	try { 
		Inventario currentPerson = iInventarioService.findById(id); 
		iInventarioService.delete(currentPerson);
		map.put("deleted", true);
		return new ResponseEntity<Object>(map,HttpStatus.OK);
	} 
	catch (Exception e) {
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}
}


