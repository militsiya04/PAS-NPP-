package test;
import Entities.Admin;
import Entities.Worker;
import Repositories.Interfaceses.Manager;
public class Main {
    public static void main(String[] args) {
        Manager.createTable();

        Admin admin = new Admin(1, "adminUser", "adminPassword");

        Worker worker = admin.createWorker(1, "John", "Doe", "workerPassword");
    }
}
