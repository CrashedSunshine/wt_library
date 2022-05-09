package nl.workingtalentapp.library.persistance;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.workingtalentapp.library.domein.Boek;
import nl.workingtalentapp.library.domein.Category;
import nl.workingtalentapp.library.exception.BoeknotFoundException;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cr;
	
	public void createCat() {
		Category cat = new Category();
//		cat.setCat_name("Java");
		cr.save(cat);
	}	
	
	public void deleteCat(long id) {
		cr.deleteCatById(id);
	}
	
	public Category addCategory(Category category) {
        return cr.save(category);
    }
	
	public Category updateCategory(Category category) {
        return cr.save(category);
    }
	
	public Optional<?> findCat(long id) {
		return cr.findCatById(id);//.orElseThrow(() -> new BoeknotFoundException("Boek met id: " + id + " was niet gevonden"));
	}
	
	public Iterable<Category> category() {
		return cr.findAll();
	}

	public void slamaaropditding(Category cat) {
		// TODO Auto-generated method stub
		cr.save(cat);
	}
	
}
