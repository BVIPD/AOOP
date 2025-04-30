package module2;
import java.util.*;

public class Passenger implements Comparable<Passenger> {
    private String name;
    private int age;
    private boolean isVIP;

    public Passenger(String name, int age, boolean isVIP) {
        this.name = name;
        this.age = age;
        this.isVIP = isVIP;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isVIP() { return isVIP; }

    @Override
    public int compareTo(Passenger other) {
        if (this.isVIP && !other.isVIP) return -1;
        if (!this.isVIP && other.isVIP) return 1;
        if (this.age >= 60 && other.age < 60) return -1;
        if (this.age < 60 && other.age >= 60) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ", VIP: " + isVIP + ")";
    }
}
