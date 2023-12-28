package Repositories;

import Entities.Apartment;
import Entities.Building;
import Entities.Street;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IRepository<Apartment> ApartmentRepository = new IApartmentRepository();
        Street street = new Street(12, "Test");
        Building building = new Building(13, 2);
        Street street2 = new Street(14, "Test2");
        Building building2 = new Building(15, 6);
        // Используйте методы из интерфейса IRepository
        ApartmentRepository.create(new Apartment(1,23, street, building));
        ApartmentRepository.create(new Apartment(2, 24, street2, building2));

        List<Apartment> allStudents = ApartmentRepository.getAll();
        System.out.println("All Apartments: " + allStudents);

        Apartment apartmentById = ApartmentRepository.get(1);
        System.out.println("Apartments by ID: " + apartmentById);

        List<Apartment> apartmentWithNameTest = ApartmentRepository.find(apartment -> apartment.getStreet().getName().equals("Test"));
        System.out.println("Apartments with name Alice: " + apartmentWithNameTest);

    }
}