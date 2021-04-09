package com.johnmsaylor;

import com.johnmsaylor.dao.DAO;
import com.johnmsaylor.model.Country;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringVegaApplication {

	private static DAO<Country> dao;

	public SpringVegaApplication(DAO<Country> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringVegaApplication.class, args);

		System.out.println("------- INSERT ----------------------------------------");
		Country country = new Country("Pakistan", 300, 380);
		dao.create(country);

		System.out.println("------- ALL COUNTRIES ----------------------------------");
		List<Country> countries = dao.list();
		countries.forEach(System.out::println);
	}


}
