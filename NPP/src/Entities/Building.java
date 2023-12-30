package Entities;

import java.util.Objects;

public class Building {
    private int id;
    private int number;

    public Building(int id, int number) {
        this.id = id;
        this.number = number;
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


    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Building building = (Building) obj;
        return id == building.id &&
                number == building.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }
}
