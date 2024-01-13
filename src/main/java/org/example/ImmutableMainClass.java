package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
final class Immutable {
    private final int rollNumber;
    private final String name;
    private final List<String> address;

    Immutable(int rollNumber, String name, List<String> addressList) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.address = new ArrayList<>(addressList);
    }
    public  final int getRollNumber() {
        return rollNumber;
    }
    public final String getName() {
        return name;
    }
    public final List<String> getAddress() {
        return Collections.unmodifiableList(address);
    }
}
public class ImmutableMainClass {
    public static void main(String[] args) {
        Immutable immutable = new Immutable(123, "bhar32", Arrays.asList("Purnia", "Bangalore"));
    }
}
