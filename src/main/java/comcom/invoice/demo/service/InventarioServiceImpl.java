package comcom.invoice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comcom.invoice.demo.entidad.Inventario;
import comcom.invoice.demo.repository.InventarioDao;
import jakarta.transaction.Transactional;

@Service
public class InventarioServiceImpl implements IInventarioService {

	@Autowired
	private InventarioDao inventarioDao;
	
	@Override
	@Transactional
	public List<Inventario> findAll() {
	return (List<Inventario>) inventarioDao.findAll();

	}


	@Override
	@Transactional
	public Inventario save(Inventario person) {
	return inventarioDao.save(person);

	}


	@Override 
	public Inventario findById(Long id) {
	return inventarioDao.findById(id).orElse(null);

	}


	@Override
	@Transactional
	public void delete(Inventario person) {
	inventarioDao.delete(person);


	}

}


