package nl.workingtalentapp.library.persistance;
import nl.workingtalentapp.library.domein.Category;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepository  extends CrudRepository<Category, Long> {
    void deleteCatById(long id);
    Optional <Category> findCatById(long id);
}
