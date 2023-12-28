package Repositories;

import Entities.Building;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IBuildingRepository implements IRepository<Building> {

    private HashMap<Integer, Building> buildings;

    public IBuildingRepository() {
        buildings = new HashMap<>();
    }

    @Override
    public List<Building> getAll() {
        return new ArrayList<>(buildings.values());
    }

    @Override
    public Building get(int id) {
        return buildings.get(id);
    }

    @Override
    public List<Building> find(java.util.function.Predicate<Building> predicate) {
        List<Building> result = new ArrayList<>();
        for (Building building : buildings.values()) {
            if (predicate.test(building)) {
                result.add(building);
            }
        }
        return result;
    }

    @Override
    public void create(Building item) {
        buildings.put(item.getId(), item);
    }

    @Override
    public void update(Building item) {
        buildings.put(item.getId(), item);
    }

    @Override
    public void delete(int id) {
        buildings.remove(id);
    }
}
