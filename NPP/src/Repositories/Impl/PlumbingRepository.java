package Repositories.Impl;

import Entities.Plumbing;
import Repositories.IPlumbingRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Predicate;

public class PlumbingRepository extends BaseRepository<Plumbing> implements IPlumbingRepository {

    public PlumbingRepository(EntityManager entityManager) {
        super(Plumbing.class, entityManager);
    }

    @Override
    public List<Plumbing> find(Predicate<Plumbing> predicate) {
        return null;
    }
}
