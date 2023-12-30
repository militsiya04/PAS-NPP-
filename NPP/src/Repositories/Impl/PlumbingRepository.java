package Repositories.Impl;

import Entities.Plumbing;

public class PlumbingRepository extends BaseRepository<Plumbing> {

    public PlumbingRepository() {
        super();
    }

    @Override
    protected int getItemId(Plumbing item) {
        return item.getId();
    }
}
