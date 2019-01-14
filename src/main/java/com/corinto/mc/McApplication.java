package com.corinto.mc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.corinto.mc.domain.Categoria;
import com.corinto.mc.repositories.CategoriaRepository;

@SpringBootApplication
public class McApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriarepository;

	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
	}

}

