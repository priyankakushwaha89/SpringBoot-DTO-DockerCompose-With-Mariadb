package com.example.springboot_Mariadb_DTO_DTO2_Interface_ModelMapper;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>
{
	//BookInterface getById(int id);


	@Query("SELECT new com.example.springboot_Mariadb_DTO_DTO2_Interface_ModelMapper.BookDTO2(b.id, b.title, b.author, b.bookno) FROM Book b WHERE b.id = :id")
	BookDTO2 getById(@Param("id") int id);
	
}
