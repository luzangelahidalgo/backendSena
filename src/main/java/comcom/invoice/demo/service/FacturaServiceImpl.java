package comcom.invoice.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comcom.invoice.demo.dto.FacturaDto;
import comcom.invoice.demo.dto.FacturaRequestDto;
import comcom.invoice.demo.dto.ItemsRequestDto;
import comcom.invoice.demo.entidad.Factura;
import comcom.invoice.demo.entidad.Items;
import comcom.invoice.demo.repository.FacturaDao;
import comcom.invoice.demo.repository.ItemsDao;
import jakarta.transaction.Transactional;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private FacturaDao facturaDao;

	@Autowired
	private ItemsDao itemsDao;
	
	@Override
	@Transactional
	public List<Factura> findAll() {
		return (List<Factura>) facturaDao.findAll();

	}

	@Override
	@Transactional
	public void save(FacturaRequestDto person) {
		//facturaDao.save(person);
		 // Obtener la fecha actual
        Date fechaActual = new Date();

		Factura factura = new Factura();
		factura.setNumero_factura(person.getNumeroFactura());
		factura.setId_proveedor(person.getProveedor());
		factura.setFecha(fechaActual);
		factura.setIdEstado(1);					
		factura = facturaDao.save(factura);

		for (int i = 0; i < person.getItems().size(); i++) {
			ItemsRequestDto key = person.getItems().get(i);
			Items item = new Items();
			item.setCantidad(key.getCantidad());
			item.setPrecio(key.getPrecio());
			item.setDescripcion(key.getProducto());
			item.setIdFactura(factura.getId_factura());
			
			itemsDao.save(item);
		}
	}

	@Override
	public Factura findById(Long id) {
		return facturaDao.findById(id).orElse(null);

	}

	@Override
	@Transactional
	public void delete(Factura person) {
		facturaDao.delete(person);

	}

	@Override
	@Transactional
	public List<FacturaDto> facturasConTotal() {
		return (List<FacturaDto>) facturaDao.facturasConTotal();		
	}
	
	@Override
	@Transactional
	public List<Items> listadoItemsPorFactura(Long id) {
		return (List<Items>) facturaDao.listadoItemsPorFactura(id);		
	}
}
