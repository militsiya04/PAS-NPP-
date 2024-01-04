package tests.repositories;
import org.junit.Test;
import static org.junit.Assert.*;
import Entities.Apartment;
import Entities.Building;
import Entities.Street;
import Repositories.IRepository;
import Repositories.Impl.BaseRepository;

import java.util.List;

public class ApartmentRepositoryTest {
    @Test
    public void testCreate() {
        IRepository<Apartment> apartmentRepository = new BaseRepository<Apartment>() {
            @Override
            protected int getItemId(Apartment item) {
                return item.getId();
            }
        };

        Street street = new Street(12, "Test");
        Building building = new Building(13, 2);

        // Create
        apartmentRepository.create(new Apartment(1, 23, street, building));
        apartmentRepository.create(new Apartment(2, 24, street, building));

        List<Apartment> allApartments = apartmentRepository.getAll();
        System.out.println("All Apartments after create: " + allApartments);

        assertEquals(2, allApartments.size());
    }

    @Test
    public void testGetAll() {
        IRepository<Apartment> apartmentRepository = new BaseRepository<Apartment>() {
            @Override
            protected int getItemId(Apartment item) {
                return item.getId();
            }
        };

        Street street = new Street(12, "Test");
        Building building = new Building(13, 2);

        apartmentRepository.create(new Apartment(1, 23, street, building));
        apartmentRepository.create(new Apartment(2, 24, street, building));

        // GetAll
        List<Apartment> allApartments = apartmentRepository.getAll();
        System.out.println("All Apartments: " + allApartments);

        assertEquals(2, allApartments.size());
    }

    @Test
    public void testGetById() {
        IRepository<Apartment> apartmentRepository = new BaseRepository<Apartment>() {
            @Override
            protected int getItemId(Apartment item) {
                return item.getId();
            }
        };

        Street street = new Street(12, "Test");
        Building building = new Building(13, 2);

        apartmentRepository.create(new Apartment(1, 23, street, building));
        apartmentRepository.create(new Apartment(2, 24, street, building));

        // GetById
        Apartment apartmentById = apartmentRepository.get(1);
        System.out.println("Apartment by ID: " + apartmentById);

        assertNotNull(apartmentById);
    }

    @Test
    public void testFind() {
        IRepository<Apartment> apartmentRepository = new BaseRepository<Apartment>() {
            @Override
            protected int getItemId(Apartment item) {
                return item.getId();
            }
        };

        Street street = new Street(12, "Test");
        Building building = new Building(13, 2);

        apartmentRepository.create(new Apartment(1, 23, street, building));
        apartmentRepository.create(new Apartment(2, 24, street, building));

        // Find
        List<Apartment> apartmentWithNameTest = apartmentRepository.find(apartment -> apartment.getStreet().getName().equals("Test"));
        System.out.println("Apartments with name Test: " + apartmentWithNameTest);

        assertEquals(2, apartmentWithNameTest.size());
    }

    @Test
    public void testUpdate() {
        IRepository<Apartment> apartmentRepository = new BaseRepository<Apartment>() {
            @Override
            protected int getItemId(Apartment item) {
                return item.getId();
            }
        };

        Street street = new Street(12, "Test");
        Building building = new Building(13, 2);

        apartmentRepository.create(new Apartment(1, 23, street, building));

        // Update
        Apartment updatedApartment = new Apartment(1, 25, street, building);
        apartmentRepository.update(updatedApartment);
        List<Apartment> allApartmentsAfterUpdate = apartmentRepository.getAll();
        System.out.println("All Apartments after update: " + allApartmentsAfterUpdate);

        assertEquals(1, allApartmentsAfterUpdate.size());
        assertEquals(25, allApartmentsAfterUpdate.get(0).getNumber());
    }

    @Test
    public void testDelete() {
        IRepository<Apartment> apartmentRepository = new BaseRepository<Apartment>() {
            @Override
            protected int getItemId(Apartment item) {
                return item.getId();
            }
        };

        Street street = new Street(12, "Test");
        Building building = new Building(13, 2);

        apartmentRepository.create(new Apartment(1, 23, street, building));

        // Delete
        apartmentRepository.delete(1);
        Apartment apartmentById = apartmentRepository.get(1);
        System.out.println("Apartment by ID after delete: " + apartmentById);

        assertNull(apartmentById);
    }
}