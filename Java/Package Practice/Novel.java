package books;

interface Readable {
    void read();
}

public class Novel implements Readable {
    public void read() {
        System.out.println("Reading a Novel.");
    }
}


