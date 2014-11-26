package com.example.localarthropodreference;

public class Bug {
	private long id;
	private String comName;
	private String sciName;
	private String ident;
	private String similar;
	private String size;
	private String habitat;
	private String status; 
	
	public Bug() {
		// TODO Auto-generated constructor stub
	}
	
	public Bug(long id, String comName, String sciName, String ident, String similar,
			String size, String habitat, String status) {
		super();
		this.id = id;
		this.comName = comName;
		this.sciName = sciName;
		this.ident = ident;
		this.similar = similar;
		this.size = size;
		this.habitat = habitat;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getSciName() {
		return sciName;
	}

	public void setSciName(String sciName) {
		this.sciName = sciName;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getSimilar() {
		return similar;
	}

	public void setSimilar(String similar) {
		this.similar = similar;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
