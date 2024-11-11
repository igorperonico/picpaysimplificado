package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "users")
@Table(schema = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.document = data.document();
        this.email = data.email();
        this.password = data.password();
        this.balance = data.balance();
        this.userType = data.userType();
    }
}
