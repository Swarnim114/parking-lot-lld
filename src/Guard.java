
public class Guard {
    private String name;
    private int age;

    public Guard(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Ticket generateTicket(EntryGate entryGate, Vehicle vehicle) {
        return entryGate.generateTicket(vehicle);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
