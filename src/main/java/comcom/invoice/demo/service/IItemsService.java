package comcom.invoice.demo.service;

import java.util.List;

import comcom.invoice.demo.entidad.Items;

public interface IItemsService {
	

	public List<Items> findAll();

	public Items save(Items person);

	public Items findById(Long id);

	public void delete(Items person);

}
