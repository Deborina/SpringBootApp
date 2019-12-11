package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	   private SessionFactory sessionFactory;

	   @Override
	   public long save(Book book) {
	     Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
	     sessionFactory.getCurrentSession().save(book);
	     tx.commit();
	      return book.getId();
	   }

	   @Override
	   public Book get(long id) {
	      return sessionFactory.getCurrentSession().get(Book.class, id);
	   }

	   @Override
	   public List<Book> list() {
	      Session session = sessionFactory.getCurrentSession();
	      List<Book> bookList = session.createQuery("from Book", Book.class).list();
	      return bookList;
	   }

	   @Override
	   public void update(long id, Book book) {
	      Session session = sessionFactory.getCurrentSession();
	      Transaction tx = session.beginTransaction();
	      Book book2 = session.byId(Book.class).load(id);
	      book2.setName(book.getName());
	      book2.setAuthor(book.getAuthor());
	      session.saveOrUpdate(book2);
	      tx.commit();
	   }

	   @Override
	   public void delete(long id) {
	      Session session = sessionFactory.getCurrentSession();
	      Transaction tx = session.beginTransaction();
	      Book book = session.byId(Book.class).load(id);
	      session.delete(book);
	      tx.commit();
	   }

}
