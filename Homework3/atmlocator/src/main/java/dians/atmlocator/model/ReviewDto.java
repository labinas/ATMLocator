package dians.atmlocator.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReviewDto {
    String username;
    String reviewText;
    String rating;

    public ReviewDto(String username, String reviewText, String rating, Long atmId) {
        this.username = username;
        this.reviewText = reviewText;
        this.rating = rating;
    }
}
