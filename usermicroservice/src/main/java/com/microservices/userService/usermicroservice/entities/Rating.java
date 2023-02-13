package com.microservices.userService.usermicroservice.entities;

public class Rating {
    
    private String ratingId;
    private String useId;
    private String hotelId;
    private String rating;
    private String feedback;
    private String remark;

    public String getRatingId() {
        return ratingId;
    }
    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }
    public String getUseId() {
        return useId;
    }
    public void setUseId(String useId) {
        this.useId = useId;
    }
    public String getHotelId() {
        return hotelId;
    }
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    


}
