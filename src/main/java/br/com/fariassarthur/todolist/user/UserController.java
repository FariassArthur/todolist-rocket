package br.com.fariassarthur.todolist.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Modificador - guarda os tipos de acesso
 * public
 * private
 * protected
 */

 @RestController
 @RequestMapping("/users")
public class UserController {
    /**
     * Tipos:
     * String (Texto)
     * Integer (int) numeros inteiros
     * Double (double) Números com casas decimais
     * Float (float) Se diferencia do double por números de caracteres
     * Char (A C) Aceita um caractere
     * Date (data)
     * void - Quando não temos um retorno para o nosso método
     */
    @Autowired //essa spring gerencia todo o ciclo de vida
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            System.out.println("Usuário já existe");
            //mensagem de error
            //status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
