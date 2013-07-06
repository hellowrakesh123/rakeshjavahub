package com.rakeshjavahub.converter;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.util.CollectionUtils;


public abstract class AbstractConverter<T, V> implements Converter<T, V> {

	private Mapper mapper;
	private Class<T> tClazz;
	private Class<V> vClazz;
	
	
	public AbstractConverter(Mapper mapper, Class<T> tClazz, Class<V> vClazz) {
		this.mapper = mapper;
		this.tClazz = tClazz;
		this.vClazz = vClazz;
	}
	
	@Override
	public V convertTo(T t) {
		V v = null;
		if(t != null) {
			v = mapper.map(t, vClazz);
		}
		return v;
	}
	
	@Override
	public List<V> convertTo(List<T> tList) {
		List<V> vList = null;
		if(!CollectionUtils.isEmpty(tList)) {
			vList = new ArrayList<V>();
			for (T t : tList) {
				vList.add(convertTo(t));
			}
		}
		return vList;
	}
	
	@Override
	public T convertFrom(V v) {
		T t = null;
		if(v != null) {
			t = mapper.map(v, tClazz);
		}
		return t;
	}
	
	@Override
	public List<T> convertFrom(List<V> vList) {
		List<T> tList = null;
		if(!CollectionUtils.isEmpty(vList)) {
			tList = new ArrayList<T>();
			for (V v : vList) {
				tList.add(convertFrom(v));
			}
		}
		return tList;
	}
}
