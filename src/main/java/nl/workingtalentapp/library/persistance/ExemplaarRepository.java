package nl.workingtalentapp.library.persistance;

import nl.workingtalentapp.library.domein.Exemplaar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ExemplaarRepository  extends JpaRepository<Exemplaar, Long> {
	
	void deleteExemplaarById(Long id);
	
}
