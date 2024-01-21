package org.example;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

/*
 * Set references to objects to null when they are no longer needed.
 * For objects that implement AutoCloseable or Closeable, use try-with-resources to ensure proper resource cleanup.
 * Avoid using the finalize() method, as it's considered deprecated and may lead to resource leaks.
 * manually invoking garbage collection (System.gc()) is generally not recommended
 */
class MyNormalResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("MyResource is closed");
        // Other cleanup code

    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize method called");
        // Other cleanup code
        super.finalize();
    }
}

class MyIOResource extends IOException implements Closeable {

    @Override
    public void close() throws IOException {
        System.out.println("MyResource is closed");
        // Other cleanup code
    }
}
public class HandleMemoryLeakage {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle IOException, if necessary
            e.printStackTrace();
        }
    }
}
