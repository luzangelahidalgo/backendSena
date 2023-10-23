package comcom.invoice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comcom.invoice.demo.entidad.Inventario;

public interface InventarioDao extends JpaRepository<Inventario, Long> {

}
