package Entities;

import java.util.Objects;

public class Furniture {
    private int id;
    private String name;

    public Furniture(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Furniture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Furniture furniture = (Furniture) obj;
        return id == furniture.id &&
                Objects.equals(name, furniture.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
