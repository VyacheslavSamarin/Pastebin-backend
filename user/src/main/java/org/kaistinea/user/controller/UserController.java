package org.kaistinea.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.kaistinea.user.dto.CreateUserRequest;
import org.kaistinea.user.dto.UpdateUserRequest;
import org.kaistinea.user.dto.UserDTO;
import org.kaistinea.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ResponseEntity<Long> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return ResponseEntity.ok(userService.createUser(createUserRequest));
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            path = {"/{id}"}
    )
    public ResponseEntity<Void> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest, @PathVariable Long id) {
        userService.updateUser(updateUserRequest, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}"
    )
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/{id}"
    )
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
