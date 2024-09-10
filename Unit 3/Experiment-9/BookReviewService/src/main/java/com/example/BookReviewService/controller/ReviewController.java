package com.example.BookReviewService.controller;

import com.example.BookReviewService.model.BookDTO;
import com.example.BookReviewService.model.Review;
import com.example.BookReviewService.proxy.BookCatlogServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private BookCatlogServiceProxy proxy;

    @GetMapping("/book/{isbn}")
    public String getBookReview(@PathVariable String isbn) {
        // Fetch book details from the Book Catalog Service
        BookDTO book = proxy.getBookByIsbn(isbn);
        if (book != null) {
            return "Review for book: " + book.getTitle();
        } else {
            return "Book not found";
        }
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        // This example just returns the review. Implement actual review storage as needed.
        return review;
    }
}
