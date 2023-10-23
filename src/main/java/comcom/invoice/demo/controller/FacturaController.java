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

import comcom.invoice.demo.dto.FacturaDto;
import comcom.invoice.demo.dto.FacturaRequestDto;
import comcom.invoice.demo.entidad.Factura;
import comcom.invoice.demo.entidad.Items;
import comcom.invoice.demo.service.IFacturaService;

@RestController
@RequestMapping("/api")
public class FacturaController {

	@Autowired
	private IFacturaService iFacturaService;

	@GetMapping(value = "/factura")
	public ResponseEntity<Object> get() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Factura> list = iFacturaService.findAll();
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listadofactura")
	public ResponseEntity<Object> listadoFactura() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<FacturaDto> list = iFacturaService.facturasConTotal();
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/listadoitemsfactura/{id}")
	public ResponseEntity<Object> listadoItemsPorFactura(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Items> list = iFacturaService.listadoItemsPorFactura(id);
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/factura/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		try {
			Factura data = iFacturaService.findById(id);
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/factura", consumes = "application/json")
	public ResponseEntity<Object> create(@RequestBody FacturaRequestDto person) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			 iFacturaService.save(person);
			return new ResponseEntity<Object>("", HttpStatus.OK);
		} catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/factura/{id}")
	public ResponseEntity<Object> update(@RequestBody Factura person, @PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			Factura currentPerson = iFacturaService.findById(id);

			currentPerson.setId_factura(currentPerson.getId_factura());
			currentPerson.setId_proveedor(person.getId_proveedor());
			currentPerson.setNumero_factura(person.getNumero_factura());
			currentPerson.setFecha(person.getFecha());

			//Factura res = iFacturaService.save(currentPerson);

			return new ResponseEntity<Object>("", HttpStatus.OK);
		} catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/factura/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			Factura currentPerson = iFacturaService.findById(id);
			iFacturaService.delete(currentPerson);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		} catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
