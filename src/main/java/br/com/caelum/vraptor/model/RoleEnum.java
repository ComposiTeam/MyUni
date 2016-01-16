package br.com.caelum.vraptor.model;

public enum RoleEnum {
	STUDENT("Stundents"),
	PROFESSOR("Professor");
	
	private final String role;
	
	private RoleEnum(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return role;
	}
}
