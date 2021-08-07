package one.digitalinnovation.parking.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import one.digitalinnovation.parking.exception.ParkingNotFoundException;
import one.digitalinnovation.parking.model.Parking;
import one.digitalinnovation.parking.repository.ParkingRepository;

@Service // representa um serviço
public class ParkingService {

    // adiciona o repository no service
    private final ParkingRepository parkingRepository;

    // faz a injeção de dependência pelo construtor (mais recomendada, em vez de fazer por @Autowired)
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    // a transação for somente leitura
    @Transactional(readOnly = true)

    // retorna uma lista de todos os objetos do arquivo do repository
    public List<Parking> findAll() {
        return parkingRepository.findAll();
    }

    // a transação for somente leitura
    @Transactional(readOnly = true)

    // caso não ache pelo id
    public Parking findById(String id) {

        // vai retornar uma mensagem de exceção
        return parkingRepository.findById(id).orElseThrow(
                () -> new ParkingNotFoundException(id));
    }

    @Transactional
    public Parking create(Parking parkingCreate) {
        String uuid = getUUID(); // usa como chave do mapa
        parkingCreate.setId(uuid); // gera um id aleatório
        parkingCreate.setEntryDate(LocalDateTime.now()); // seta a data de entrada
        parkingRepository.save(parkingCreate); // salva o parking criado
        return parkingCreate; // retorna o mesmo
    }

    @Transactional
    public void delete(String id) {
        findById(id); // pega o id
        parkingRepository.deleteById(id); // deleta o id
    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id); // pega o id
        parking.setColor(parkingCreate.getColor()); // adiciona uma color
        parking.setState(parkingCreate.getState()); // adiciona um state
        parking.setModel(parkingCreate.getModel()); // adiciona um model
        parking.setLicense(parkingCreate.getLicense()); // adiciona uma license
        parkingRepository.save(parking); // salva todos os valores
        return parking; // retorna o resultado
    }

    @Transactional
    public Parking checkOut(String id) { // faz a regra de negócio dos horários e valores
        Parking parking = findById(id); // pega o id
        parking.setExitDate(LocalDateTime.now()); // adiciona a hora que fez o checkOut
        parking.setBill(ParkingCheckOut.getBill(parking)); // adiciona o valor a cobrar
        return parkingRepository.save(parking); // retorna o resultado e salva o mesmo
    }

    // vai gerar um id aleatório substituindo o caractere - por nada
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
