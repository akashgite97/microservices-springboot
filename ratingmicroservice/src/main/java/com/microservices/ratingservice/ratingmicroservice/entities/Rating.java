
package com.microservices.ratingservice.ratingmicroservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ratings")
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ratingId;

    private String userId;
    private String hotelId;
    private String ratings;
    private String feedback;
    private String remark;

    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String useId) {
        this.userId = useId;
    }
    public String getHotelId() {
        return hotelId;
    }
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    public String getRatings() {
        return ratings;
    }
    public void setRatings(String ratings) {
        this.ratings = ratings;
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
    public int getRatingId() {
        return ratingId;
    }
    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }
    


}
