package Entities;

public class Apartment {
    int id;
    int number;
    Furniture[] furniture;
    Plumbing[] plumbing;
    Street street;
    Building building;
    public Apartment(int id,int number, Street street,Building building){
        this.id = id;
        this.number = number;
        this.street = street;
        this.building = building;
    }
}
