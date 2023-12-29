package Repositories.Impl;

import Entities.Building;

public class BuildingRepository extends BaseRepository<Building> {

    public BuildingRepository() {
        super();
    }

    @Override
    protected int getItemId(Building item) {
        return item.getId();
    }
}
