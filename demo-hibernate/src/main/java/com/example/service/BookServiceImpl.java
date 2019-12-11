package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BookDao;
import com.example.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;
	@Override
	public long save(Book book) {
		return bookDao.save(book);
	}

	@Override
	public Book get(long id) {
		return bookDao.get(id);
	}

	@Override
	public List<Book> list() {
		return bookDao.list();
	}

	@Override
	public void update(long id, Book book) {
		bookDao.update(id, book);
	}

	@Override
	public void delete(long id) {
		bookDao.delete(id);
		
	}

}
