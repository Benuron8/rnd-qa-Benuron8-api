package model;

import java.util.List;

public class Vet {
	    private int id;
	    private String firstName;
	    private String lastName;
	    private List<Specialty> specialties;
	    private int nrOfSpecialties;

	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getFirstName() { return firstName; }
	    public void setFirstName(String firstName) { this.firstName = firstName; }

	    public String getLastName() { return lastName; }
	    public void setLastName(String lastName) { this.lastName = lastName; }

	    public List<Specialty> getSpecialties() { return specialties; }
	    public void setSpecialties(List<Specialty> specialties) { this.specialties = specialties; }

	    public int getNrOfSpecialties() { return nrOfSpecialties; }
	    public void setNrOfSpecialties(int nrOfSpecialties) { this.nrOfSpecialties = nrOfSpecialties; }
}
