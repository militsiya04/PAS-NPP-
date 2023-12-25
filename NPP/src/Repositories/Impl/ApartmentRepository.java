package Repositories.Impl;

import Entities.Apartment;
import Entities.Street;
import Repositories.IApartmentRepository;
import Repositories.IStreetRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Predicate;

public class ApartmentRepository extends BaseRepository<Apartment> implements IApartmentRepository {

    public ApartmentRepository(EntityManager entityManager) {
        super(Apartment.class, entityManager);
    }

    @Override
    public List<Apartment> find(Predicate<Apartment> predicate) {
        return null;
    }
}

