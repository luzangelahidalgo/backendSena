package comcom.invoice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comcom.invoice.demo.entidad.Proveedor;
import comcom.invoice.demo.repository.proveedorDao;
import jakarta.transaction.Transactional;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	private proveedorDao proveedorDao;
	
	@Override
	@Transactional
	public List<Proveedor> findAll() {
		return (List<Proveedor>) proveedorDao.findAll();
	}
	
	@Override
	@Transactional
	public Proveedor save(Proveedor person) {
		return proveedorDao.save(person);
	}

	@Override 
	public Proveedor findById(Long id) {
		return proveedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Proveedor person) {
		proveedorDao.delete(person);
		
	}
}
