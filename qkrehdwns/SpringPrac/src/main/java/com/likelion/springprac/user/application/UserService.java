package com.likelion.springprac.user.application;

import com.likelion.springprac.user.api.UserDto;
import com.likelion.springprac.user.domain.User;
import com.likelion.springprac.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private static Long sequence = 0L;

    public void saveUser(UserDto userDto) {
        User user = User.builder()
            .id(++sequence)
            .name(userDto.name())
            .email(userDto.email())
            .build();
        userRepository.save(user);
    }

    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("해당하는 고객이 없습니다. id = " + id);
        }
        return toDto(user);
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public User updateUserById(Long id, UserDto requestDto) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("해당하는 고객이 없습니다. id = " + id);
        }

        user.update(requestDto.name(), requestDto.email());
        userRepository.updateById(id, user);
        return user;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    private UserDto toDto(User user) {
        return UserDto.builder()
            .id(user.getId())
            .name(user.getName())
            .email(user.getEmail())
            .build();
    }
}
