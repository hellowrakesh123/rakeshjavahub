package com.rakeshjavahub.converter;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rakeshjavahub.pojo.Account;


/**
 * @author hellowrakesh123
 *
 */
@Component
public class AccountConverter extends AbstractConverter<Account, com.rakeshjavahub.schema.beans.Account> {

	@Autowired
	public AccountConverter(Mapper mapper) {
		super(mapper, Account.class, com.rakeshjavahub.schema.beans.Account.class);
	}
}
