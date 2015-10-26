package br.com.caelum.vraptor.dao;


public interface DAOInterface<Entity> {

	public void create(Entity entity);
	
	public boolean update(Entity entity);
	
	public boolean destroy(Entity entity);
	
	public Entity getEntityByField(String field, Object object);
	
	public Entity searchByID(Long id);
}
