package nl.workingtalentapp.library.service;

import nl.workingtalentapp.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cr;
	
	public void proberen() {
		Category cat = new Category();
		cat.setCat_name("Java");
		cr.save(cat);
	}	
	
	public Iterable<Category> category() {
		return cr.findAll();
	}

	public void slamaaropditding(Category cat) {
		// TODO Auto-generated method stub
		cr.save(cat);
	}
	
}
