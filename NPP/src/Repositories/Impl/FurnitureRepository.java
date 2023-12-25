package Repositories.Impl;

import Entities.Furniture;
import Entities.Plumbing;
import Repositories.IFurnitureRepository;
import Repositories.IPlumbingRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Predicate;

public class FurnitureRepository extends BaseRepository<Furniture> implements IFurnitureRepository {

    public FurnitureRepository(EntityManager entityManager) {
        super(Furniture.class, entityManager);
    }

    @Override
    public List<Furniture> find(Predicate<Furniture> predicate) {
        return null;
    }
}


