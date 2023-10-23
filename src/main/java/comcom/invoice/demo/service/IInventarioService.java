package comcom.invoice.demo.service;

import java.util.List;

import comcom.invoice.demo.entidad.Inventario;

public interface IInventarioService {

	public List<Inventario> findAll();

	public Inventario save(Inventario person);

	public Inventario findById(Long id);

	public void delete(Inventario person);

}
