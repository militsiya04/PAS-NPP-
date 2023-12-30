package EF;
import Entities.Apartment;
import Repositories.IRepository;
import Repositories.Impl.ApartmentRepository;
import Repositories.Impl.StreetRepository;
import UnitOfWork.IUnitOfWork;

public class EFUnitOfWork implements IUnitOfWork {

    private ApartmentRepository apartmentRepository;

    public EFUnitOfWork() {
        apartmentRepository = new ApartmentRepository();
    }

    @Override
    public Apartment getApartment(IRepository<Apartment> apartmentRepository, int id) {
        return apartmentRepository.get(id);
    }

    @Override
    public StreetRepository getStreets() {
        return null;
    }

    @Override
    public void save() {

    }
}