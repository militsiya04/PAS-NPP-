package Entities;

import java.util.Objects;

public class Plumbing {
    private int id;
    private String name;

    public Plumbing(int id, String name) {
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
        return "Plumbing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Plumbing plumbing = (Plumbing) obj;
        return id == plumbing.id &&
                Objects.equals(name, plumbing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
