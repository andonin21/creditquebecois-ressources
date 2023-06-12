package qc.ca.creditquebecois.ressources.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import qc.ca.creditquebecois.ressources.modele.Compte;

import java.util.List;

/**
 * The interface Compte repository.
 */
@Repository
public interface CompteRepository extends MongoRepository<Compte, ObjectId> {
}
