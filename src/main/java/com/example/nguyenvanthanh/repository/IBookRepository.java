package com.example.nguyenvanthanh.repository;

import com.example.nguyenvanthanh.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {


}
