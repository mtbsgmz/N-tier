package tr.com.deneme.interfaces;

import java.util.List;

public interface ICRUD<T> {
	
	public boolean create(T varlik);

	public T read(Long id);

	public boolean update(T varlik, Long id);

	public boolean update(T varlik);
	
	public boolean delete(Long id);
	
	public List<T> readAll();
	
}