package org.kaistinea.user.service;

import org.kaistinea.user.dto.CreateUserRequest;
import org.kaistinea.user.dto.UpdateUserRequest;
import org.kaistinea.user.dto.UserDTO;

import java.util.List;

public interface UserService {
    Long createUser(CreateUserRequest createUserRequest);

    UserDTO getUserById(Long id);

    List<UserDTO> getUsers();

    void deleteUserById(Long id);

    void updateUser(UpdateUserRequest updateUserRequest, Long id);
}
