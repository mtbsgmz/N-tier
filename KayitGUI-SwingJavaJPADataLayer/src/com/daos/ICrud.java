package com.daos;

import java.util.List;

public interface ICrud<T extends Object> {

	public Boolean create(T varlik);

	public T read(Long id);

	public List<T> readAll();

	public Boolean update(T varlik);

	public Boolean update(T varlik, Long id);

	public Boolean delete(Long id);

}
