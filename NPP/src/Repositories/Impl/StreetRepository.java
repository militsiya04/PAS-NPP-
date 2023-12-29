package Repositories.Impl;

import Entities.Street;

public class StreetRepository extends BaseRepository<Street> {

    public StreetRepository() {
        super();
    }

    @Override
    protected int getItemId(Street item) {
        return item.getId();
    }
}
