package comcom.invoice.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import comcom.invoice.demo.dto.FacturaDto;
import comcom.invoice.demo.entidad.Factura;
import comcom.invoice.demo.entidad.Items;

public interface FacturaDao extends JpaRepository<Factura, Long> {

	@Query(value= "SELECT new comcom.invoice.demo.dto.FacturaDto(f.id_factura as idFactura, f.fecha, p.razonSocial as nombreProveedor, "
			+ "sum(i.precio * i.cantidad) total, ef.nombre  estado, p.nitProveedor  nitProveedor  ) FROM Factura f  inner join Items i on f.id_factura  = i.idFactura  "
			+ "inner JOIN Proveedor p on p.id = f.id_proveedor inner join EstadoFactura ef on ef.id = f.idEstado "
			+ "GROUP BY f.id_factura order by f.id_factura" )
	List<FacturaDto> facturasConTotal();
	
	@Query(value= "SELECT i FROM  Items i where i.idFactura = :idFactura" )
	List<Items> listadoItemsPorFactura(@Param("idFactura") Long idFactura);
}
