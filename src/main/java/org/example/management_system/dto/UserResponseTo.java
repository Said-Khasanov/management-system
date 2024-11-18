package org.example.management_system.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserResponseTo {
    private Long id;
    private String email;
    private String password;
}
