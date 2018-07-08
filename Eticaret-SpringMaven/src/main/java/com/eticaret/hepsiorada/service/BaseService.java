package com.eticaret.hepsiorada.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.eticaret.hepsiorada.modal.BaseEntity;

@Service
public interface BaseService<T> {

	public void create(T varlik);

	public T read(Long id);

	public void update(T varlik);

	public void delete(Long id);

	public List<T> readAll();
	
	public void delete(T varlik);

	
	
}
