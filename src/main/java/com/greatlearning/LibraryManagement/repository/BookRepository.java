package com.greatlearning.LibraryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.LibraryManagement.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByNameContainsAndAuthorContainsAllIgnoreCase(String name,String author);
}
