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

import comcom.invoice.demo.entidad.Usuarios;
import comcom.invoice.demo.service.IUsuariosService;

@RestController
@RequestMapping("/api")
public class UsuariosController {

	@Autowired
	private IUsuariosService iUsuariosService;

	@GetMapping(value="/usuarios")
	public ResponseEntity<Object> get(){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Usuarios> list  = iUsuariosService.findAll();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}

	@GetMapping(value="/usuarios/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id){ 
		try {
			Usuarios data  = iUsuariosService.findById(id);
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		} 
		catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}

	@PostMapping(value="/usuarios")
	public ResponseEntity<Object> create(@RequestBody Usuarios person){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Usuarios res = iUsuariosService.save(person);  
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> update(@RequestBody Usuarios person, @PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			Usuarios currentPerson = iUsuariosService.findById(id);
			
			currentPerson.setId(currentPerson.getId());
			currentPerson.setNombre(person.getNombre());
			currentPerson.setApellido(person.getApellido());
			currentPerson.setCorreo(person.getCorreo());
			currentPerson.setPassword(person.getPassword());
			currentPerson.setTelefono(person.getTelefono());
			currentPerson.setCargo(person.getCargo());
			
			Usuarios res = iUsuariosService.save(currentPerson);
			
			return new ResponseEntity<Object>(res,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}

	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Usuarios currentPerson = iUsuariosService.findById(id); 
			iUsuariosService.delete(currentPerson);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		}
}
