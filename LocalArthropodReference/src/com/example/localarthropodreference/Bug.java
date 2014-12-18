package com.example.localarthropodreference;

public class Bug {
	private long id;
	private int img;
	private String comName;
	private String sciName;
	private String similar;
	private String descr;
	private String[] habitat;
	private String taxon;
	
	public static String strSeparator = "__|__";
	public static String convertArrayToString(String[] array){
	    String str = "";
	    for (int i = 0;i<array.length; i++) {
	        str = str+array[i];
	        // Do not append comma at the end of last element
	        if(i<array.length-1){
	            str = str+strSeparator;
	        }
	    }
	    return str;
	}
	public static String[] convertStringToArray(String str){
	    String[] arr = str.split(strSeparator);
	    return arr;
	}
	
	public Bug() {
		// TODO Auto-generated constructor stub
	}
	
	public Bug(long id,String img, String comName, String sciName, String ident, String similar,
			String descr, String habitat, String taxon) {
		super();
		this.id = id;
		this.comName = comName;
		this.sciName = sciName;
		this.similar = similar;
		this.descr = descr;
		this.habitat = convertStringToArray(habitat);
		this.taxon = taxon;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
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

	public String getSimilar() {
		return similar;
	}

	public void setSimilar(String similar) {
		this.similar = similar;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String[] getHabitat() {
		return habitat;
	}

	public void setHabitat(String[] habitat) {
		this.habitat = habitat;
	}

	public String getTaxon() {
		return taxon;
	}

	public void setTaxon(String taxon) {
		this.taxon = taxon;
	}

}
