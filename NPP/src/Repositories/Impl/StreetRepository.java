package Repositories.Impl;

import Entities.Building;
import Entities.Street;
import Repositories.IBuildingRepository;
import Repositories.IStreetRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Predicate;

public class StreetRepository extends BaseRepository<Street> implements IStreetRepository {

    public StreetRepository(EntityManager entityManager) {
        super(Street.class, entityManager);
    }

    @Override
    public List<Street> find(Predicate<Street> predicate) {
        return null;
    }
}

