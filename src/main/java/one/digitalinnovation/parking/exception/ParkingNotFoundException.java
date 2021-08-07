package one.digitalinnovation.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// em vez de criar if e else nas condições para lançar essa exceção pode simplificar apenas colocando esse código
@ResponseStatus(code = HttpStatus.NOT_FOUND)

// extende o RuntimeException para não precisar fazer try e catch, porque economiza muitas linhas de código
public class ParkingNotFoundException extends RuntimeException {

    // quando não achar o id vai retornar essa mensagem
    public ParkingNotFoundException(String id) {
        super("Parking not found with Id: " + id);
    }
}
