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

import comcom.invoice.demo.entidad.Items;
import comcom.invoice.demo.service.IItemsService;

@RestController
@RequestMapping("/api")
public class ItemsController {

@Autowired
private IItemsService iItemsService;

@GetMapping(value="/items")
public ResponseEntity<Object> get(){ 
	Map<String, Object> map = new HashMap<String, Object>();
	try {
		List<Items> list  = iItemsService.findAll();
		return new ResponseEntity<Object>(list,HttpStatus.OK);
	} 
	catch (Exception e) {
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}

@GetMapping(value="/items/{id}")
public ResponseEntity<Object> getById(@PathVariable Long id){ 
	try {
		Items data  = iItemsService.findById(id);
		return new ResponseEntity<Object>(data,HttpStatus.OK);
	} 
	catch (Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}

@PostMapping(value="/items")
public ResponseEntity<Object> create(@RequestBody Items person){ 
	Map<String, Object> map = new HashMap<String, Object>();
	try {
		Items res = iItemsService.save(person);  
		return new ResponseEntity<Object>(res,HttpStatus.OK);
	} 
	catch (Exception e) {
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}

@PutMapping("/items/{id}")
public ResponseEntity<Object> update(@RequestBody Items person, @PathVariable Long id){ 
	Map<String, Object> map = new HashMap<String, Object>();
	try {
		
		Items currentPerson = iItemsService.findById(id);
		
		currentPerson.setId(currentPerson.getId());
		currentPerson.setDescripcion(person.getDescripcion());
		currentPerson.setCantidad(person.getCantidad());
		currentPerson.setPrecio(person.getPrecio());
		
		Items res = iItemsService.save(currentPerson);
		
		return new ResponseEntity<Object>(res,HttpStatus.OK);
	} 
	catch (Exception e) {
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}

@DeleteMapping("/items/{id}")
public ResponseEntity<Object> delete(@PathVariable Long id){ 
	Map<String, Object> map = new HashMap<String, Object>();
	try { 
		Items currentPerson = iItemsService.findById(id); 
		iItemsService.delete(currentPerson);
		map.put("deleted", true);
		return new ResponseEntity<Object>(map,HttpStatus.OK);
	} 
	catch (Exception e) {
		map.put("message", e.getMessage());
		return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
	} 
	}
}


