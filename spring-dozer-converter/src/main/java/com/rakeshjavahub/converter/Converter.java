package com.rakeshjavahub.converter;

import java.util.List;

public interface Converter<T, V> {

	public V convertTo(T t);
	
	public List<V> convertTo(List<T> tList);
	
	public T convertFrom(V v);
	
	public List<T> convertFrom(List<V> vList);
}
