package com.powerchord.services;

public interface Validator<T> {
	boolean validate(T object);
}
