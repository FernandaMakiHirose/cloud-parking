package one.digitalinnovation.parking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.parking.controller.dto.ParkingDTO;
import one.digitalinnovation.parking.controller.mapper.ParkingMapper;
import one.digitalinnovation.parking.model.Parking;
import one.digitalinnovation.parking.service.ParkingService;

@RestController // // faz a aplicação ler todos os métodos
@RequestMapping("/parking") // o request vai fazer feito nesse path
@Api(tags = "Parking Controller") // é o nome que vai aparecer no navegador de subtítulo
public class ParkingController {

    // cria as variáveis
    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    // construtor
    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }


    @GetMapping // requisição get
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll() { // acha todos os parkings na lista
        List<Parking> parkingList = parkingService.findAll(); // acha todos os parkings no service
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList); // transforma o parkingMapper em uma lista dto
        return ResponseEntity.ok(result); // retorna a ação acima
    }

    @GetMapping("/{id}") // requisição get
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) { // vai pegar o parking pelo id
        Parking parking = parkingService.findById(id); // pega o parking do service pelo id
        ParkingDTO result = parkingMapper.toParkingDTO(parking); // transforma o parkingMapper em dto
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}") // delete
    public ResponseEntity delete(@PathVariable String id) { // ResponseEntity é vazio, porque o recurso não vai existir mais
        parkingService.delete(id); // deleta o id
        return ResponseEntity.noContent().build(); // retorna nenhum conteúdo que foi excluído
    }

    @PostMapping // post
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) { // vai fazer o post
        var parkingCreate = parkingMapper.toParkingCreate(dto); // cria o parkingMapper
        var parking = parkingService.create(parkingCreate); // cria o parkingService
        var result = parkingMapper.toParkingDTO(parking); // transforma o parkingMapper em dto
        return ResponseEntity.status(HttpStatus.CREATED).body(result); // cria o corpo da requisição
    }

    @PutMapping("/{id}") // put
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO parkingCreteDTO) {
        Parking parkingUpdate = parkingMapper.toParkingCreate(parkingCreteDTO); // cria o parkingMapper
        Parking parking = parkingService.update(id, parkingUpdate); // faz update do service de um id
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking)); // retorna o parking como ok
    }

    @PostMapping("/{id}/exit") // post
    public ResponseEntity<ParkingDTO> checkOut(@PathVariable String id) { // faz o checkout
        Parking parking = parkingService.checkOut(id); // verifica se ja não está fechado e lanças uma exceção
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking)); // retornar o parking como ok
    }

}
