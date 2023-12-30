package UnitOfWork;

import Entities.Apartment;
import Repositories.IRepository;
import Repositories.Impl.ApartmentRepository;
import Repositories.Impl.StreetRepository;

public interface IUnitOfWork {

    Apartment getApartment(IRepository<Apartment> apartmentRepository, int id);

    StreetRepository getStreets();
    void save();
}