package one.digitalinnovation.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.parking.model.Parking;

// com isso se ganha todas as operações de banco de dados

@Repository // indica que é um tipo Repository

// extende o JpareRository, passa a entidade e a chave primária
public interface ParkingRepository extends JpaRepository<Parking, String> {
}
