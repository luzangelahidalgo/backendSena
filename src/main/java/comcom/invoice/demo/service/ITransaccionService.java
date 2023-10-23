package comcom.invoice.demo.service;

import java.util.List;

import comcom.invoice.demo.entidad.Transaccion;

public interface ITransaccionService {
	
	public List<Transaccion> findAll();

	public Transaccion save(Transaccion person);

	public Transaccion findById(Long id);

	public void delete(Transaccion person);

}
