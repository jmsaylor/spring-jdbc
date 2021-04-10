package com.johnmsaylor;

import com.johnmsaylor.dao.DAO;
import com.johnmsaylor.model.Country;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

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

		System.out.println("------- UPDATE ----------------------------------------");
		Optional<Country> countryToUpdate = dao.get(5);
		country = countryToUpdate.get();
		country.setPopulation(175);
		dao.update(country, country.getId());

		System.out.println("------- DELETE ----------------------------------------");
		dao.delete(4);

		System.out.println("------- ALL COUNTRIES ----------------------------------");
		List<Country> countries = dao.list();
		countries.forEach(System.out::println);
	}


}
