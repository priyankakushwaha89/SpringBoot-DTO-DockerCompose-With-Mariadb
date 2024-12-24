package com.example.springboot_Mariadb_DTO_DTO2_Interface_ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController 
{
	@Autowired
	BookRepository brepo;

	@Autowired
	ModelMapper modelmapper;
	
	@RequestMapping("/test")
	public String test()
	{
		return "Hello from project AllInOne";
	}
	/* CRUD operation using DTO class */
	
	/*
	//C->Create
	@PostMapping("/save")
	public String saveData(@RequestBody BookDTO bdto)
	{
		Book b=new Book();
		b.setId(bdto.getId());
		b.setTitle(bdto.getTitle());
		b.setAuthor(bdto.getAuthor());
		b.setBookno(bdto.getBookno());
		b.setLanguage(bdto.getLanguage());
		b.setAgender(bdto.getAgender());
		brepo.save(b);
		return "Data is saved into database";
	}
	//R->Read
	
	@GetMapping("/all")
	public List<BookDTO> allData()
	{

		return brepo.findAll()
				    .stream()
				    .map(b->{
				    	BookDTO bdto=new BookDTO();
				    	bdto.setId(b.getId());
						bdto.setTitle(b.getTitle());
						bdto.setAuthor(b.getAuthor());
						bdto.setBookno(b.getBookno());
						bdto.setLanguage(b.getLanguage());
						bdto.setAgender(b.getAgender());
						return bdto;
		                 })
				    .collect(Collectors.toList());
	}
	//U->Update
	
	@PutMapping("/upd/{id}")
	public String updateById(@RequestBody BookDTO bdto,@PathVariable int id)
	{
		Book b=brepo.findById(id).get();
		b.setId(bdto.getId());
		b.setTitle(bdto.getTitle());
		b.setAuthor(bdto.getAuthor());
		b.setBookno(bdto.getBookno());
		b.setLanguage(bdto.getLanguage());
		b.setAgender(bdto.getAgender());
		brepo.save(b);
		return "Data is updated";
	}
	//D->Delete
	
	@DeleteMapping("/del/{id}")
	public String deleteDataById(@PathVariable int id)
	{
		Book b=brepo.findById(id).get();
		brepo.deleteById(id);
		return "Data is deleted";
	}
	*/
	
	/* CRUD operation by using Model mapper
	 * 
	 * ModelMapper->In a Spring Boot project, a model mapper is typically used to map data between 
	 * different object models. This is especially useful when converting data transfer objects (DTOs) to entities 
	 * and vice versa.
	 *  One popular library for this purpose is ModelMapper. 
	 */
	
	@PostMapping("/save")
	public String saveData(@RequestBody BookDTO bdto)
	{
		Book b=new Book();
		modelmapper.map(bdto, b);
		brepo.save(b);
		return "Data is saved into the database";
	}
	
	@GetMapping("/all")
	public List<BookDTO> allData()
	{
		return brepo.findAll().stream().map(b->modelmapper.map(b,BookDTO.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public BookDTO byId(@PathVariable int id)
	{
		Book b=brepo.findById(id).get();
		BookDTO bdto=new BookDTO();
		BeanUtils.copyProperties(b, bdto);
		return bdto;
	}
	/*
	@GetMapping("/id/{id}")
	public BookInterface byInterfaceId(@PathVariable int id)
	{
		 return brepo.getById(id);
	}
	*/
	@GetMapping("/dto/id/{id}")
	public BookDTO2 byDtoId(@PathVariable int id)
	{
		return brepo.getById(id);
	}
}

