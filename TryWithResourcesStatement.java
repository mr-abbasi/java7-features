import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesStatement {
    public static void main(String[] args) throws Exception {
//        readFromBufferReaderBeforeJava7();
//        readFromBufferReaderAfterJava7();
        readFromCustomResource();
    }

    public static void readFromBufferReaderBeforeJava7() throws IOException {
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader("example.txt"));
            String lineTxt;
            while ((lineTxt = bufferedReader.readLine()) != null){
                System.out.println(lineTxt);
            }

        }
        finally {
           bufferedReader.close();
        }
    }

    public static void readFromBufferReaderAfterJava7() throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("example.txt"))) {
            String lineTxt;
            while ((lineTxt = bufferedReader.readLine()) != null){
                System.out.println(lineTxt);
            }
        }
    }

    public static void readFromCustomResource() throws Exception {
        try (CustomResource customResource = new CustomResource()){
            customResource.readFromResource();
        }
    }
}

class CustomResource implements AutoCloseable {
    public void readFromResource(){
        System.out.println("Reading data ...");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Custom Resource is closing");
    }
}
