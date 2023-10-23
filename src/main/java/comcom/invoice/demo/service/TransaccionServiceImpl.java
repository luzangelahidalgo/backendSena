package comcom.invoice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comcom.invoice.demo.entidad.Transaccion;
import comcom.invoice.demo.repository.TransaccionDao;
import jakarta.transaction.Transactional;

@Service
public class TransaccionServiceImpl implements ITransaccionService {
	
	@Autowired
	private TransaccionDao transaccionDao;
	
	@Override
	@Transactional
	public List<Transaccion> findAll() {
	return (List<Transaccion>) transaccionDao.findAll();

	}

	@Override
	@Transactional
	public Transaccion save(Transaccion person) {
	return transaccionDao.save(person);

	}
	
	@Override 
	public Transaccion findById(Long id) {
	return transaccionDao.findById(id).orElse(null);

	}
	
	@Override
	@Transactional
	public void delete(Transaccion person) {
	transaccionDao.delete(person);


	}
	
	

}
