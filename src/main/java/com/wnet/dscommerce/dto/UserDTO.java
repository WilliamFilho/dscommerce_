package com.wnet.dscommerce.dto;

import com.wnet.dscommerce.entities.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private List<String> roles = new ArrayList<>();

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        phone = entity.getPhone();
        birthDate = entity.getBirthDate();
        for (GrantedAuthority role : entity.getAuthorities()) {
            roles.add(role.getAuthority());
        }
    }
}
