package comcom.invoice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comcom.invoice.demo.entidad.Proveedor;

public interface proveedorDao extends JpaRepository<Proveedor, Long> { 

}
