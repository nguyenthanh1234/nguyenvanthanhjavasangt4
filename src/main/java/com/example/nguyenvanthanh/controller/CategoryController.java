package com.example.nguyenvanthanh.controller;

import com.example.nguyenvanthanh.entity.Book;
import com.example.nguyenvanthanh.entity.Category;
import com.example.nguyenvanthanh.services.BookService;
import com.example.nguyenvanthanh.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
        @Autowired
        private CategoryService categoryService;
        @GetMapping
        public String showAllCategories(Model model){
            List<Category> categories = categoryService.getAllCategories();
            model.addAttribute("categories",categories );
            return "category/list";
        }

        @GetMapping("/add")
        public String addCategoryForm(Model model){
            model.addAttribute("category", new Category());
            model.addAttribute("categories",categoryService.getAllCategories());
            return "category/add";
        }

        @PostMapping("/add")
        public String addCategory(@Valid  @ModelAttribute("category") Category category, BindingResult bindingResult, Model model){
            if(bindingResult.hasErrors()){
                return "category/add";
            }
            categoryService.saveCategory(category);
            return "redirect:/categories";
        }


        @GetMapping("/edit/{id}")
        public String editCategoryForm(@PathVariable("id") Long id, Model model){
            Category editCategory = null;
            for(Category category : categoryService.getAllCategories()){
                if(category.getId().equals(id)){
                    editCategory = category;
                }
            }
            if(editCategory!= null){
                model.addAttribute("category",editCategory);
                return "category/edit";
            }else{
                return "not-found";
            }
        }

        @PostMapping("/edit")
        public String editCategory(@Valid @ModelAttribute("category") Category updatedCategory, BindingResult bindingResult){
            if(bindingResult.hasErrors()){
                return "category/edit";
            }
            for(int i = 0; i<categoryService.getAllCategories().size();i++){
                Category category = categoryService.getAllCategories().get(i);
                if(category.getId() == updatedCategory.getId()){
                    categoryService.getAllCategories().set(i,updatedCategory);
                    categoryService.saveCategory(updatedCategory);
                    break;
                }
            }
            return "redirect:/categories";
        }
        @GetMapping("/delete/{id}")
        public String deleteCategory(@PathVariable("id") Long id){
            Iterator<Category> iterator = categoryService.getAllCategories().iterator();
            while (iterator.hasNext()){
                Category category = iterator.next();
                if(category.getId() == id){
//                iterator.remove();
                  categoryService.deleteCategory(id);
                    break;
                }
            }
            return "redirect:/categories";
        }
}
