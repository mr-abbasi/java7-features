import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SuppressedException {

    private static final Logger log = Logger.getLogger("SuppressedException");

    public static void main(String[] args) {
        try (Door door = new Door()) {
            door.doSomeThing();
        } catch (Exception ex) {
            log.log(Level.SEVERE, ex.getMessage());
            Throwable[] exceptions = ex.getSuppressed();
            if (exceptions!= null &&  exceptions.length > 0) {
                for (Throwable throwable : exceptions) {
                    log.log(Level.SEVERE, throwable.getMessage());
                }
            }
        }
    }
}

class Door implements AutoCloseable {

    public void doSomeThing() throws IOException {
        throw new IOException("I/O Exception happened");
    }


    @Override
    public void close() throws Exception {
        throw new NullPointerException("Ohhhh!!! Null pointer happend!!!");
    }
}

