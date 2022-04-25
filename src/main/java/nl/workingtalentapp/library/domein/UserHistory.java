package nl.workingtalentapp.library.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	int status;
}