public class RethrowsException {
    public static void main(String[] args) throws Exception {
//        beforeJava7("FirstException");
        afterJava7("SecondException");
    }

    public static void beforeJava7(String exceptionName) throws Exception{
        try{
            if(exceptionName.equals("FirstException")){
                throw new TheFirstException();
            }
            else{
                throw new TheSecondException();
            }
        }
        catch (Exception ex){
            throw ex;
        }
    }

    public static void afterJava7(String exceptionName) throws TheFirstException,TheSecondException {
        try {
            if(exceptionName.equals("FirstException")){
                throw new TheFirstException();
            }
            else {
                throw new TheSecondException();
            }
        }
        catch (Exception ex){
            throw ex;
        }
    }

}

class TheFirstException extends Exception{

}

class TheSecondException extends Exception{

}
