package comcom.invoice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comcom.invoice.demo.entidad.Items;

public interface ItemsDao extends JpaRepository<Items, Long> {

}
