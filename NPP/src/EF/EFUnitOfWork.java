package EF;

import Repositories.Impl.ApartmentRepository;
import Repositories.Impl.StreetRepository;
import UnitOfWork.IUnitOfWork;

public class EFUnitOfWork implements IUnitOfWork {

    private ApartmentRepository apartmentRepository;

    public EFUnitOfWork() {
        apartmentRepository = new ApartmentRepository();
    }

    @Override
    public ApartmentRepository getApartments() {
        return apartmentRepository;
    }

    @Override
    public StreetRepository getStreets() {
        return null;
    }


    @Override
    public void save() {
        // Якщо ви працюєте із хешем та списками, можливо, зберігання тут не потрібне
        // Проте, ви можете викликати методи збереження з ваших репозиторіїв, якщо це потрібно
    }
}