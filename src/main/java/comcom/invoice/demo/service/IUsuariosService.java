package comcom.invoice.demo.service;

import java.util.List;

import comcom.invoice.demo.entidad.Usuarios;

public interface IUsuariosService {
	

	public List<Usuarios> findAll();

	public Usuarios save(Usuarios person);

	public Usuarios findById(Long id);

	public void delete(Usuarios person);

}

