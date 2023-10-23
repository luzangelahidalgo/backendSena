package comcom.invoice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import comcom.invoice.demo.entidad.Transaccion;

public interface TransaccionDao extends JpaRepository<Transaccion, Long> {

}
