package com.rakeshjavahub.converter;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rakeshjavahub.pojo.Account;
import com.rakeshjavahub.pojo.AccountType;
import com.rakeshjavahub.pojo.Person;

/**
 * @author hellowrakesh123
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/application-context.xml")
public class PersonConverterTest {

	@Autowired
	private PersonConverter personConverter;
	
	@Test
	public void testConvertTo() {
		try {
			Person person = new Person();
			person.setId(10);
			person.setName("Rakesh Sinha");
			person.setAge(30);
			person.setAddress("XYZ");
			person.setCity("ABC");
			person.setCountry("USA");
			person.setEmail("hellowrakesh123@gmail.com");
			person.setPhone("1234567891");
			person.setSex("Male");
			person.setAccounts(new ArrayList<Account>());
			Account account = new Account();
			account.setId(100);
			account.setAccountNumber(123);
			account.setBank("ICICI");
			account.setBalance(1000);
			account.setType(AccountType.PERSONAL);
			person.getAccounts().add(account);
			account = new Account();
			account.setId(200);
			account.setAccountNumber(456);
			account.setBank("CHASE");
			account.setBalance(10000);
			account.setType(AccountType.CHECKING);
			person.getAccounts().add(account);
			account = new Account();
			account.setId(300);
			account.setAccountNumber(789);
			account.setBank("HDFC");
			account.setBalance(10000);
			account.setType(AccountType.LOANS);
			person.getAccounts().add(account);
			com.rakeshjavahub.schema.beans.Person personXsdBean = personConverter.convertTo(person);
			Assert.assertEquals("Incorrect id returned", person.getId(), personXsdBean.getId());
			Assert.assertEquals("Incorrect account size", person.getAccounts().size(), personXsdBean.getAccounts().size());
			Assert.assertEquals("Incorrect address conversion", "XYZ,ABC,USA", personXsdBean.getAddress());
		} catch(Exception exception) {
			exception.printStackTrace();
			Assert.assertFalse("Error while converting person entity to beans: " + exception.getLocalizedMessage(), true);
		}
	}
}
