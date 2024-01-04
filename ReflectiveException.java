import java.lang.reflect.InvocationTargetException;

public class ReflectiveException {
    public static void main(String[] args) {

    }

    public static void afterJava7() throws ReflectiveOperationException{
        Class.forName("RethrowsException.java").getMethod("beforeJava7").invoke(null, new Object[]{});
    }

    public static void beforeJava7() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Class.forName("RethrowsException.java").getMethod("beforeJava7").invoke(null, new Object[]{});
    }
}
