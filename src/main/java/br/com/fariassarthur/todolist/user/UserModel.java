package br.com.fariassarthur.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/* Se eu quiser só os setters @setters, só os getters @getters */

@Data
@Entity(name ="tb_users")
public class UserModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    @Column(unique = true)
    private String username;
    private String name;
    private String password;
    //se não coloco nenhum modificador vira publico

    //getters - setters
    //Basicamente aqui é criado um método userName que atribui o valor de setUsername para username
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}
