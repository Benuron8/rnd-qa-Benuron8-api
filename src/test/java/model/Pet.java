package model;

public class Pet {

	String id;
	String name;
	String birthDate;
	String typeId;

	public Pet(String id, String name, String birthDate,
			String type) {

		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.typeId = type;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getTypeId() {
		return typeId;
	}


	public void setType(String typeId) {
		this.typeId = typeId;
	}
}
