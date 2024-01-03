public class CatchMultiExceptions {
    public static void main(String[] args) {
        try {
            rethrowException("First");
        } catch (FirstException | SecondException | ThirdException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void rethrowException(String s) throws FirstException, SecondException, ThirdException {
        if (s.equals("First")) {
            throw new FirstException("First Exception");
        } else if (s.equals("Second")) {
            throw new SecondException("Second Exception");
        } else {
            throw new ThirdException("Third Exception");
        }
    }
}

class FirstException extends Exception {
    public FirstException(String message) {
        super(message);
    }
}

class SecondException extends Exception {
    public SecondException(String message) {
        super(message);
    }
}

class ThirdException extends Exception {
    public ThirdException(String message) {
        super(message);
    }
}


