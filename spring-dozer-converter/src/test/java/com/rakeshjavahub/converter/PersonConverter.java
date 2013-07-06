package com.rakeshjavahub.converter;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rakeshjavahub.pojo.Person;


/**
 * @author hellowrakesh123
 *
 */
@Component
public class PersonConverter extends AbstractConverter<Person, com.rakeshjavahub.schema.beans.Person> {

	@Autowired
	public PersonConverter(Mapper mapper) {
		super(mapper, Person.class, com.rakeshjavahub.schema.beans.Person.class);
	}
	
	@Override
	public com.rakeshjavahub.schema.beans.Person convertTo(Person t) {
		com.rakeshjavahub.schema.beans.Person person = super.convertTo(t);
		person.setAddress(t.getAddress() + "," + t.getCity() + "," + t.getCountry());
		return person;
	}
	
	@Override
	public Person convertFrom(com.rakeshjavahub.schema.beans.Person v) {
		Person person = super.convertFrom(v);
		if(!StringUtils.isEmpty(v.getAddress())) {
			String[] add = v.getAddress().split(",");
			int size = add.length;
			if(size == 3) {
				person.setCountry(add[size-1]);
				person.setCity(add[size-2]);
				person.setAddress(v.getAddress().substring(0, v.getAddress().indexOf(",")));
			} else {
				person.setAddress(v.getAddress());
			}
		}
		return person;
	}
}
