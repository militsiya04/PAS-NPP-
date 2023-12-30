package Repositories.Impl;

import Entities.Furniture;
import Entities.Plumbing;
import Entities.Street;

public class FurnitureRepository extends BaseRepository<Furniture> {

    public FurnitureRepository() {
        super();
    }

    @Override
    protected int getItemId(Furniture item) {
        return item.getId();
    }
}

