package comcom.invoice.demo.service;

import java.util.List;

import comcom.invoice.demo.dto.FacturaDto;
import comcom.invoice.demo.dto.FacturaRequestDto;
import comcom.invoice.demo.entidad.Factura;
import comcom.invoice.demo.entidad.Items;

public interface IFacturaService {
	
	public List<Factura> findAll();

	public void save(FacturaRequestDto person);

	public Factura findById(Long id);

	public void delete(Factura person);
	
	public List<FacturaDto> facturasConTotal();

	public List<Items> listadoItemsPorFactura(Long id);
	
}
