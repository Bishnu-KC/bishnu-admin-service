package com.idexcel.bishnuadminservice.service;

import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.idexcel.adminservice.dao.LenderRepo;
import com.idexcel.adminservice.entity.Address;
import com.idexcel.adminservice.entity.Lender;
import com.idexcel.adminservice.entity.PrimaryContact;
import com.idexcel.adminservice.enums.LenderStatus;
import com.idexcel.adminservice.exception.LenderAlreadyExistsException;
import com.idexcel.adminservice.exception.LenderNotFoundException;
import com.idexcel.adminservice.service.LenderService;
import com.idexcel.adminservice.service.impl.LenderServiceImpl;

@RunWith(SpringRunner.class)
public class LenderServiceImplTest {

	@TestConfiguration
	static class LenderServiceTestConfig {

		@Bean
		public LenderService getService() {
			return new LenderServiceImpl();
		}

	}

	@Autowired
	private LenderService service;

	@MockBean
	private LenderRepo repo;

	private java.util.List<Lender> lenders;

	@Before
	public void setup() {
		Lender lender = new Lender("fdsfsdf123", "John Doe", new Address("PKY", "Tysons", "VA", "USA", 21223),
				new PrimaryContact("Mary Jane", "mj@idexcel.net", "757-663-2122"), LenderStatus.ACTIVE, "Bishnu K C",
				Calendar.getInstance().getTime(), "Bishnu K C", Calendar.getInstance().getTime());

		Lender lender2 = new Lender("user111", "Jack Willis", new Address("PKYWAY", "Ashburn", "VA", "USA", 21224),
				new PrimaryContact("Mary Louis", "ml@idexcel.net", "755-663-2122"), LenderStatus.SUSPENDED,
				"Bishnu K C", Calendar.getInstance().getTime(), "Bishnu K C", Calendar.getInstance().getTime());

		Lender lender3 = new Lender("users121", "Jay Z", new Address("Herndon", "Ashburn", "VA", "USA", 21224),
				new PrimaryContact("Lee Louis", "ll@idexcel.net", "745-663-2122"), LenderStatus.ACTIVE, "Bishnu K C",
				Calendar.getInstance().getTime(), "Bishnu K C", Calendar.getInstance().getTime());

		lenders = Arrays.asList(lender, lender2, lender3);

		Mockito.when(repo.findAll()).thenReturn(lenders);

		Mockito.when(repo.findById(lender.getId())).thenReturn(Optional.of(lender));

		// to check for suspended lender
		Mockito.when(repo.findById(lender2.getId())).thenThrow(LenderNotFoundException.class);

		Mockito.when(repo.findByName(lender.getName())).thenThrow(LenderAlreadyExistsException.class);

		// Mockito.when(repo.findByName(lender3.getName())).thenReturn(null);

		Mockito.when(repo.save(lender2)).thenReturn(lender2);

	}

	@Test(expected = LenderAlreadyExistsException.class)
	public void create() {
		service.create(lenders.get(0));
	}
	/*
	 * @Test(expected = NullPointerException.class) public void createNewNull() {
	 * service.create(lenders.get(2)); }
	 * 
	 */

	@Test
	public void createNew() {
		Assert.assertEquals("Lender created", lenders.get(1).getId(), service.create(lenders.get(1)));
	}

	@Test
	public void findAll() {
		List lenderList = (List) service.findAll();
		Assert.assertEquals("Employee list should match", lenders, lenderList);
	}

	@Test
	public void findById() {
		Lender foundLender = service.findById(lenders.get(0).getId());
		Assert.assertEquals("Lender should match", lenders.get(0).getId(), foundLender.getId());
	}

	@Test(expected = LenderNotFoundException.class)
	public void findByIdNotFound() {
		service.findById("jhjgjg");
	}

	@Test(expected = LenderNotFoundException.class)
	public void findByIdStatus() {
		service.findById(lenders.get(1).getId());
	}

	@Test(expected = LenderNotFoundException.class)
	public void updateByIdNotFound() {
		service.updateById("seseer");
	}

	@Test
	public void updateById() {
		Lender foundLender = service.updateById(lenders.get(0).getId());
		Assert.assertEquals("Lender should match", lenders.get(0).getId(), foundLender.getId());
	}

	@Test(expected = LenderNotFoundException.class)
	public void delete() {
		service.delete("hhggfh");
	}

}