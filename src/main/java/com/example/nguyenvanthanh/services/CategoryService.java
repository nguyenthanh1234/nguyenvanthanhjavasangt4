package com.example.nguyenvanthanh.services;


import com.example.nguyenvanthanh.entity.Book;
import com.example.nguyenvanthanh.entity.Category;
import com.example.nguyenvanthanh.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }else {
            throw new RuntimeException("Category not found");
        }
    }
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
//    public void addCategory(Category category){
//        categoryRepository.save(category);
//    }
//
//    public void updateBook(Book book){
//        bookRepository.save(book);
//    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}
