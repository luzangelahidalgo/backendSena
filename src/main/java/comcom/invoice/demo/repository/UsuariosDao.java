package comcom.invoice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comcom.invoice.demo.entidad.Usuarios;


public interface UsuariosDao extends JpaRepository<Usuarios, Long> {

}
