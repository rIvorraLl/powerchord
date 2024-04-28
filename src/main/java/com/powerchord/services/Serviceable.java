package com.powerchord.services;

import java.util.List;

public interface Serviceable<T> {
	boolean create(T model);
	List<T> getAll();
	T getOne(int id);
	boolean update(T model);
	boolean delete(int id);
}
