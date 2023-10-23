package comcom.invoice.demo.service;

import java.util.List;



import comcom.invoice.demo.entidad.Proveedor;


public interface IProveedorService  {
    public List<Proveedor> findAll();
	public Proveedor save(Proveedor person);
	public Proveedor findById(Long id);
	public void delete(Proveedor person);

}
