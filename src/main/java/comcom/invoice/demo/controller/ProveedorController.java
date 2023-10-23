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


import comcom.invoice.demo.entidad.Proveedor;
import comcom.invoice.demo.service.IProveedorService;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	private IProveedorService iProveedorService;

	@GetMapping(value="/proveedor")
	public ResponseEntity<Object> get(){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Proveedor> list  = iProveedorService.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}

	@GetMapping(value="/proveedor/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id){ 
		try {
			Proveedor data  = iProveedorService.findById(id);
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		} 
		catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}

	@PostMapping(value="/proveedor")
	public ResponseEntity<Object> create(@RequestBody Proveedor person){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Proveedor res = iProveedorService.save(person);  
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}

	@PutMapping("/proveedor/{id}")
	public ResponseEntity<Object> update(@RequestBody Proveedor person, @PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			Proveedor currentPerson = iProveedorService.findById(id);
			
			currentPerson.setId(currentPerson.getId());
			currentPerson.setNitProveedor(person.getNitProveedor());
			
			/*currentPerson.setDescripcion(person.getDescripcion());
			currentPerson.setCantidad(person.getCantidad());
			currentPerson.setPrecio(person.getPrecio());*/
			
			Proveedor res = iProveedorService.save(currentPerson);
			
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}

	@DeleteMapping("/proveedor/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Proveedor currentPerson = iProveedorService.findById(id); 
			iProveedorService.delete(currentPerson);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}

}
