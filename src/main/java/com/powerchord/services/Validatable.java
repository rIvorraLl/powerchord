package com.powerchord.services;

public interface Validatable<T> {
	boolean validate(T object);
}
