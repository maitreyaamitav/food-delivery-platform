package org.fooddelivery.userservice.user.service;

import org.fooddelivery.userservice.user.api.dto.UserRegistrationRequest;
import org.fooddelivery.userservice.user.api.dto.UserResponse;
import org.fooddelivery.userservice.user.exception.UserNotFoundException;
import org.fooddelivery.userservice.user.persistent.domain.User;
import org.fooddelivery.userservice.user.persistent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

     @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse registerUser(UserRegistrationRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setMobileNo(request.getMobileNo());
        user.setPasswordHash(request.getPassword()); // plain for now
        user.setUserType(request.getUserType());
        user.setStatus("ACTIVE");
        userRepository.save(user);
        return toResponse(user);
    }


    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return toResponse(user);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getMobileNo(),
                user.getUserType()
        );
    }
}
