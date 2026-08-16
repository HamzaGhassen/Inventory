package tn.ghassen.inventory.mapper;

import org.springframework.stereotype.Component;
import tn.ghassen.inventory.dto.user.UserCreateDTO;
import tn.ghassen.inventory.dto.user.UserResponseDTO;
import tn.ghassen.inventory.dto.user.UserUpdateDTO;
import tn.ghassen.inventory.entity.User;

@Component
public class UserMapper {

    public User toEntity(UserCreateDTO dto) {
        User user = new User();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        user.setRole(dto.getRole());
        user.setStatus(dto.getEmployeeStatus());

        return user;
    }

    public UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        dto.setEmployeeStatus(user.getStatus());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        return dto;
    }

    public void updateEntity(User user, UserUpdateDTO dto) {
        if (dto.getFirstName() != null) {
            user.setFirstName(dto.getFirstName());
        }

        if (dto.getLastName() != null) {
            user.setLastName(dto.getLastName());
        }

        if (dto.getPhone() != null) {
            user.setPhone(dto.getPhone());
        }
    }
}