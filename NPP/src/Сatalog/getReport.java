package Сatalog;

import EF.EFUnitOfWork;
import Entities.*;
import Identities.Admin;
import Identities.User;
import Identities.Worker;
import Repositories.IRepository;
import Repositories.Impl.BaseRepository;
import org.junit.Test;

public class getReport {
    public static String getReport(IRepository<Apartment> apartmentRepository, int id, User user) {
        if(user.getUserType() == "Admin") {
            Apartment apartment = new EFUnitOfWork().getApartment(apartmentRepository, id);
            StringBuilder result = new StringBuilder();

            Furniture[] furnitureArray = apartment.getFurniture();
            Plumbing[] plumbingArray = apartment.getPlumbing();

            result.append("FurnitureID\tFurnitureName\tPlumbingID\tPlumbingName\n");

            for (int i = 0; i < Math.max(furnitureArray.length, plumbingArray.length); i++) {
                if (i < furnitureArray.length) {
                    Furniture furniture = furnitureArray[i];
                    result.append(furniture.getId()).append("\t").append(furniture.getName()).append("\t");
                } else {
                    result.append("\t\t");
                }

                if (i < plumbingArray.length) {
                    Plumbing plumbing = plumbingArray[i];
                    result.append(plumbing.getId()).append("\t").append(plumbing.getName());
                }

                result.append("\n");
            }

            return result.toString();
        }else{
            return null;
        }
    }

    @Test
    public void testGetReport() {
        IRepository<Apartment> apartmentRepository = new BaseRepository<Apartment>() {
            @Override
            protected int getItemId(Apartment item) {
                return item.getId();
            }
        };

        Street street = new Street(12, "Test");
        Building building = new Building(13, 2);

        Furniture[] furnitureArray = {
                new Furniture(1, "Table"),
                new Furniture(2, "Chair"),
                new Furniture(3, "Sofa"),
                new Furniture(4, "Bed"),
                new Furniture(5, "Bookshelf")
        };

        Plumbing[] plumbingArray = {
                new Plumbing(1, "Sink"),
                new Plumbing(2, "Toilet"),
                new Plumbing(3, "Bathtub"),
                new Plumbing(4, "Shower"),
                new Plumbing(5, "Faucet")
        };

        Apartment testApartment = new Apartment(1, 12, street, building);
        testApartment.setFurniture(furnitureArray);
        testApartment.setPlumbing(plumbingArray);

        apartmentRepository.create(testApartment);

        User user = new Admin(2, "Admin");
        User user2 = new Worker(3, "Worker");

        String reportForUser = getReport(apartmentRepository, 1, user);
        String reportForUser2 = getReport(apartmentRepository, 1, user2);

        System.out.println("Report for User:\n" + reportForUser);
        System.out.println("Report for User2:\n" + reportForUser2);
    }
}
