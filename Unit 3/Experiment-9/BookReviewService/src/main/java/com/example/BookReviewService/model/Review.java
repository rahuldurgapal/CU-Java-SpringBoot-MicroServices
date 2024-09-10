package com.example.BookReviewService.model;

public class Review {

    private String isbn;
    private String reviewText;

    // Constructors
    public Review() {}

    public Review(String isbn, String reviewText) {
        this.isbn = isbn;
        this.reviewText = reviewText;
    }

    // Getters and setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
