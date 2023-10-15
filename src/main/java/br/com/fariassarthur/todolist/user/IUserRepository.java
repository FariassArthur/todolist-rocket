package br.com.fariassarthur.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IUserRepository extends JpaRepository<UserModel, UUID>{
    /* Interface é um contrato dentro da aplicação
     * onde temos os nossos métodos e não temos a
     * implementação dos métodos, pra isso precisamos 
     * de uma class para fazer a implementação
     */

     /* <> Uma configuração de dados mais dinâmicos que nesse caso
      * entrega a interface para um determinado arquivo, no caso o
      * banco de dados
      */

      UserModel findByUsername(String username);
    

}
