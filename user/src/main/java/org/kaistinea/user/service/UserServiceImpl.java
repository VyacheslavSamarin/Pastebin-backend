package org.kaistinea.user.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.kaistinea.user.dto.CreateUserRequest;
import org.kaistinea.user.dto.UpdateUserRequest;
import org.kaistinea.user.dto.UserDTO;
import org.kaistinea.user.entity.UserEntity;
import org.kaistinea.user.entity.UserSettingsEntity;
import org.kaistinea.user.mapper.CreateUserMapper;
import org.kaistinea.user.mapper.UpdateUserMapper;
import org.kaistinea.user.mapper.UserMapper;
import org.kaistinea.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final CreateUserMapper createUserMapper;
    private final UpdateUserMapper updateUserMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public Long createUser(CreateUserRequest createUserRequest) {
        UserEntity entity = createUserMapper.toEntity(createUserRequest);
        UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
        userSettingsEntity.setUser(entity);
        entity.setUserSettings(userSettingsEntity);
        return userRepository.save(entity).getId();
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void updateUser(UpdateUserRequest updateUserRequest, Long id) {
        if (userRepository.existsById(id)) {
            updateUserMapper.updateUser(userRepository.findById(id).get(), updateUserRequest);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
