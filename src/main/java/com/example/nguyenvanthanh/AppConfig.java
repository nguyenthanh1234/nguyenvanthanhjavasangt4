//package com.example.nguyenvanthanh;
//
//
//import com.example.nguyenvanthanh.entity.Book;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class AppConfig {
//    @Bean
//    public List<Book> getBooks(){
//        List<Book> books = new ArrayList<>();
//
//        Book book1 = new Book();
//        book1.setId(1L);
//        book1.setTitle("Những bí quyết giảm cân");
//        book1.setAuthor("Nguyễn Văn Thanh");
//        book1.setPrice(10.99);
//        book1.setCategory("Sức khỏe");
//        books.add(book1);
//
//        Book book2 = new Book();
//        book2.setId(2L);
//        book2.setTitle("Công thức làm món trứng chiên");
//        book2.setAuthor("Nguyễn Thị Thanh Trà");
//        book2.setPrice(12.99);
//        book2.setCategory("Nấu ăn");
//        books.add(book2);
//
//        Book book3 = new Book();
//        book3.setId(3L);
//        book3.setTitle("Làm đẹp tại nhà đơn giản");
//        book3.setAuthor("Dương Kỳ Quý");
//        book3.setPrice(15.99);
//        book3.setCategory("Sức khỏe");
//        books.add(book3);
//
//        Book book4 = new Book();
//        book4.setId(4L);
//        book4.setTitle("Kiến thức chứng khoán cơ bản");
//        book4.setAuthor("Nguyễn Nhật Hào");
//        book4.setPrice(15.99);
//        book4.setCategory("Chứng khoán");
//        books.add(book4);
//
//        return books;
//
//    }
//}