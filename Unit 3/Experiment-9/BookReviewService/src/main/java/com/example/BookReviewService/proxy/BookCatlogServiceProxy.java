package com.example.BookReviewService.proxy;

import com.example.BookReviewService.model.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-catalog-service", url = "http://localhost:8080")
public interface BookCatlogServiceProxy {

    @GetMapping("/books/{isbn}")
    BookDTO getBookByIsbn(@PathVariable String isbn);
}
