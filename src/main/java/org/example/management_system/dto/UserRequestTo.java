package org.example.management_system.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserRequestTo {
    private String email;
    private String password;
}
