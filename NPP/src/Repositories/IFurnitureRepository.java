package Repositories;

import Entities.Furniture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IFurnitureRepository implements IRepository<Furniture> {

    private HashMap<Integer, Furniture> furnitureItems;

    public IFurnitureRepository() {
        furnitureItems = new HashMap<>();
    }

    @Override
    public List<Furniture> getAll() {
        return new ArrayList<>(furnitureItems.values());
    }

    @Override
    public Furniture get(int id) {
        return furnitureItems.get(id);
    }

    @Override
    public List<Furniture> find(java.util.function.Predicate<Furniture> predicate) {
        List<Furniture> result = new ArrayList<>();
        for (Furniture furniture : furnitureItems.values()) {
            if (predicate.test(furniture)) {
                result.add(furniture);
            }
        }
        return result;
    }

    @Override
    public void create(Furniture item) {
        furnitureItems.put(item.getId(), item);
    }

    @Override
    public void update(Furniture item) {
        furnitureItems.put(item.getId(), item);
    }

    @Override
    public void delete(int id) {
        furnitureItems.remove(id);
    }
}
