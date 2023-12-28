package Entities;

import java.util.Objects;

public class Street {
    private int id;
    private String name;

    public Street(int id, String name) {
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
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Street street = (Street) obj;
        return id == street.id &&
                Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
