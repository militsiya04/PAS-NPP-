package UnitOfWork;

import Repositories.Impl.ApartmentRepository;
import Repositories.Impl.StreetRepository;

public interface IUnitOfWork {
    ApartmentRepository getApartments();
    StreetRepository getStreets();  // Замініть IStreetRepository на інтерфейс вашого репозиторію для Street
    // Додайте інші інтерфейси репозиторіїв, якщо потрібно
    void save();
}