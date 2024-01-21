package org.example;

import java.io.*;

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
    private final PrintWriter writer;

    public MyIOResource(String fileName) throws IOException {
        this.writer = new PrintWriter(new FileWriter(fileName));
        System.out.println("Resource opened: " + fileName);
    }
    @Override
    public void close() throws IOException {
        writer.close();
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
