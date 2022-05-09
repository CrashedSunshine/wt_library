package nl.workingtalentapp.library.rest;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.workingtalentapp.library.domein.Category;
import nl.workingtalentapp.library.persistance.CategoryService;

@RestController
public class CategoryEndpoint {
	
	@Autowired
	CategoryService cs;
	
	
	@GetMapping("/nieuwecategory")
	public ResponseEntity<?> testCategory() {
		cs.createCat();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/categories/add")
    public ResponseEntity<Category> addCat(Category category) {
        Category newCategory = cs.addCategory(category);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }
	
	@GetMapping("/categories/all")
	public Iterable<Category> category() {
		return cs.category();
	}
	
	
	@GetMapping("/categories/find/{id}")
	public ResponseEntity<?> getCategoryById (@PathVariable("id") Long id) {
        Optional<?> cat = cs.findCat(id);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }
   
    @PutMapping("/categories/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category updateCategory = cs.updateCategory(category);
        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }
    
    
    @Transactional
    @DeleteMapping("/categories/delete/{id}")
//	public String deleteCat(@PathVariable("id") long id) {
	public ResponseEntity<?> deleteCat(@PathVariable("id") Long id) {
        cs.deleteCat(id);
        return new ResponseEntity<>(HttpStatus.OK);
	}

    
    	
}

