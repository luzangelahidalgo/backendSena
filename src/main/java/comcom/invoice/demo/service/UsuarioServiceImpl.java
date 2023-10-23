package comcom.invoice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comcom.invoice.demo.entidad.Usuarios;
import comcom.invoice.demo.repository.UsuariosDao;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuariosService {

	@Autowired
	private UsuariosDao usuariosDao;
	
	@Override
	@Transactional
	public List<Usuarios> findAll() {
	return (List<Usuarios>) usuariosDao.findAll();

	}


	@Override
	@Transactional
	public Usuarios save(Usuarios person) {
	return usuariosDao.save(person);

	}


	@Override 
	public Usuarios findById(Long id) {
	return usuariosDao.findById(id).orElse(null);

	}


	@Override
	@Transactional
	public void delete(Usuarios person) {
	usuariosDao.delete(person);


	}
}
