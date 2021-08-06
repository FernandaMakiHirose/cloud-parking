package one.digitalinnovation.parking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

@RestController // faz a aplicação ler todos os métodos
@RequestMapping("/") // o request vai fazer feito nesse path
@ApiIgnore
public class HelloController {

    // faz fazer uma requisição do tipo get que retorna essa frase
    @GetMapping
    public String hello(){
        return "Hello Fernanda Maki Hirose!";
    }

}
