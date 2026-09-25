package org.fooddelivery.userservice.user.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class UserResponse {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String userType;


// Constructor
    public UserResponse(Long userId, String firstName, String lastName,
                        String email, String mobileNo, String userType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNo = mobileNo;
        this.userType = userType;
    }

    // Getters
    public Long getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getMobileNo() { return mobileNo; }
    public String getUserType() { return userType; }

}
