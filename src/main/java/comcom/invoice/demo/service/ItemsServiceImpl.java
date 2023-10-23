package comcom.invoice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comcom.invoice.demo.entidad.Items;
import comcom.invoice.demo.repository.ItemsDao;
import jakarta.transaction.Transactional;

@Service
public class ItemsServiceImpl implements IItemsService {
	
	@Autowired
	private ItemsDao itemsDao;
	
	@Override
	@Transactional
	public List<Items> findAll() {
	return (List<Items>) itemsDao.findAll();

	}


	@Override
	@Transactional
	public Items save(Items person) {
	return itemsDao.save(person);

	}


	@Override 
	public Items findById(Long id) {
	return itemsDao.findById(id).orElse(null);

	}


	@Override
	@Transactional
	public void delete(Items person) {
	itemsDao.delete(person);


	}

}
