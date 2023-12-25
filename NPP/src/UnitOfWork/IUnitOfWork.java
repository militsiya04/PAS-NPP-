package UnitOfWork;

import Repositories.*;

public interface IUnitOfWork extends AutoCloseable {
    IApartmentRepository getApartmentRepository();
    IStreetRepository getStreetRepository();
    IBuildingRepository getBuildingRepository();
    IFurnitureRepository getFurnitureRepository();
    IPlumbingRepository getPlumbingRepository();
    void save();
}