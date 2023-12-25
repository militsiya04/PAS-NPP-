package Repositories.Impl;

import Entities.Building;
import Entities.Furniture;
import Repositories.IBuildingRepository;
import Repositories.IFurnitureRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Predicate;

public class BuildingRepository extends BaseRepository<Building> implements IBuildingRepository {

    public BuildingRepository(EntityManager entityManager) {
        super(Building.class, entityManager);
    }

    @Override
    public List<Building> find(Predicate<Building> predicate) {
        return null;
    }
}


