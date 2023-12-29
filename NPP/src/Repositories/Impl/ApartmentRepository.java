package Repositories.Impl;

import Entities.Apartment;

public class ApartmentRepository extends BaseRepository<Apartment> {

    public ApartmentRepository() {
        super();
    }

    @Override
    protected int getItemId(Apartment item) {
        return item.getId();
    }
}
