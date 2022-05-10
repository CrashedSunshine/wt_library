package nl.workingtalentapp.library.domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exemplaar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id; //each defined item here is a column
	
	private String copyID;
	private String bookCode;
	private String staat;
	private boolean availability;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCopyID() {
		return copyID;
	}
	public void setCopyID(String copyID) {
		this.copyID = copyID;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookID(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getStaat() {
		return staat;
	}
	public void setStaat(String staat) {
		this.staat = staat;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	
	
	
}