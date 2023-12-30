package Entities;

import java.util.Arrays;
import java.util.Objects;

public class Apartment {
    private int id;
    private int number;
    private Furniture[] furniture;
    private Plumbing[] plumbing;
    private Street street;
    private Building building;

    public Apartment(int id, int number, Street street, Building building) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.building = building;
    }

    public Apartment() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Furniture[] getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture[] furniture) {
        this.furniture = furniture;
    }

    public Plumbing[] getPlumbing() {
        return plumbing;
    }

    public void setPlumbing(Plumbing[] plumbing) {
        this.plumbing = plumbing;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }


    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", number=" + number +
                ", furniture=" + Arrays.toString(furniture) +
                ", plumbing=" + Arrays.toString(plumbing) +
                ", street=" + street +
                ", building=" + building +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Apartment apartment = (Apartment) obj;
        return id == apartment.id &&
                number == apartment.number &&
                Arrays.equals(furniture, apartment.furniture) &&
                Arrays.equals(plumbing, apartment.plumbing) &&
                Objects.equals(street, apartment.street) &&
                Objects.equals(building, apartment.building);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, number, street, building);
        result = 31 * result + Arrays.hashCode(furniture);
        result = 31 * result + Arrays.hashCode(plumbing);
        return result;
    }
}