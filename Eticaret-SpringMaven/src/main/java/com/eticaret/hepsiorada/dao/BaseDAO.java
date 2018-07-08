package com.eticaret.hepsiorada.dao;

import java.util.List;

import com.eticaret.hepsiorada.modal.BaseEntity;

public interface BaseDAO<T extends BaseEntity> {

	public void create(T varlik);

	public T read(Long id);

	public void update(T varlik);

	public void delete(Long id);

	public List<T> readAll();
	
	public void delete(T varlik);

	
	
}
