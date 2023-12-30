package tests.repositories;

import Entities.Apartment;
import Entities.Building;
import Entities.Street;
import Repositories.IRepository;
import Repositories.Impl.BaseRepository;

import java.util.List;

public class ApartmentRepositoryTest {
    public static void main(String[] args) {
        IRepository<Apartment> ApartmentRepository = new BaseRepository<Apartment>() {
            @Override
            protected int getItemId(Apartment item) {
                return item.getId();
            }
        };
        Street street = new Street(12, "Test");
        Building building = new Building(13, 2);
        Street street2 = new Street(14, "Test2");
        Building building2 = new Building(15, 6);

        //create
        ApartmentRepository.create(new Apartment(1,23, street, building));
        ApartmentRepository.create(new Apartment(2, 24, street2, building2));

        //getAll
        List<Apartment> allApartments = ApartmentRepository.getAll();
        System.out.println("All Apartments: " + allApartments);

        //getbyid
        Apartment apartmentById = ApartmentRepository.get(1);
        System.out.println("Apartments by ID: " + apartmentById);

        //find
        List<Apartment> apartmentWithNameTest = ApartmentRepository.find(apartment -> apartment.getStreet().getName().equals("Test"));
        System.out.println("Apartments with name Test: " + apartmentWithNameTest);

        // Update
        Apartment updatedApartment = new Apartment(1, 25, street, building);
        ApartmentRepository.update(updatedApartment);
        List<Apartment> allApartmentsAfterUpdate = ApartmentRepository.getAll();
        System.out.println("All Apartments after update: " + allApartmentsAfterUpdate);

        //delete
        ApartmentRepository.delete(1);
        apartmentById = ApartmentRepository.get(1);
        System.out.println("Apartments by ID: " + apartmentById);
    }
}