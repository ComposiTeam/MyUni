package br.com.caelum.vraptor.model;

public enum MentionEnum {
	SS("SS"),
	MS("MS"),
	MM("MM"),
	SR("SR"),
	MI("II");
	
	private final String abbreviation;
	
	private MentionEnum(String abbreviation){
		this.abbreviation = abbreviation;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.abbreviation;
	}
	
	
}
