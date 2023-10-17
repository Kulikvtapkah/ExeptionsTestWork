package ExeptionsTestWork;

public class DataNotFoundExeption extends RuntimeException {
    String message;

    public DataNotFoundExeption(String message) {
        this.message = message;


    }

    @Override
    public String toString() {
        return String.format("\nОшибка: забыли ввести %s :(", message);
    }
    
}
