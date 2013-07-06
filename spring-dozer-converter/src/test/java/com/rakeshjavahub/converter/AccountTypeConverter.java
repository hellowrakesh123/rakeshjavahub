package com.rakeshjavahub.converter;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakeshjavahub.pojo.AccountType;


/**
 * @author hellowrakesh123
 *
 */
@Component
public class AccountTypeConverter extends AbstractConverter<AccountType, com.rakeshjavahub.schema.beans.AccountType> {

	@Autowired
	public AccountTypeConverter(Mapper mapper) {
		super(mapper, AccountType.class, com.rakeshjavahub.schema.beans.AccountType.class);
	}
}