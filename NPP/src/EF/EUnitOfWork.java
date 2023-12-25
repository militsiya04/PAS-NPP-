package EF;

import Repositories.*;
import Repositories.Impl.*;
import UnitOfWork.IUnitOfWork;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class EUnitOfWork implements IUnitOfWork {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private ApartmentRepository apartmentRepository;
    private StreetRepository streetRepository;
    private BuildingRepository buildingRepository;
    private PlumbingRepository plumbingRepository;
    private FurnitureRepository furnitureRepository;

    public EUnitOfWork(String persistenceUnitName) {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IApartmentRepository getApartmentRepository() {
        if (apartmentRepository == null) {
            apartmentRepository = new ApartmentRepository(entityManager);
        }
        return apartmentRepository;
    }

    @Override
    public IStreetRepository getStreetRepository() {
        if (streetRepository == null) {
            streetRepository = new StreetRepository(entityManager);
        }
        return streetRepository;
    }

    @Override
    public IBuildingRepository getBuildingRepository() {
        if (buildingRepository == null) {
            buildingRepository = new BuildingRepository(entityManager);
        }
        return buildingRepository;
    }

    @Override
    public IPlumbingRepository getPlumbingRepository() {
        if (plumbingRepository == null) {
            plumbingRepository = new PlumbingRepository(entityManager);
        }
        return plumbingRepository;
    }

    @Override
    public IFurnitureRepository getFurnitureRepository() {
        if (furnitureRepository == null) {
            furnitureRepository = new FurnitureRepository(entityManager);
        }
        return furnitureRepository;
    }

    @Override
    public void save() {
        try {
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
