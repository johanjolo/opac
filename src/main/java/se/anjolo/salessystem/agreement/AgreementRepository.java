package se.anjolo.salessystem.agreement;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgreementRepository extends CrudRepository<Agreement, UUID>{

}
