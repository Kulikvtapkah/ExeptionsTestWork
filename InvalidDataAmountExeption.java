package ExeptionsTestWork;

public class InvalidDataAmountExeption extends RuntimeException {
    String message;

    public InvalidDataAmountExeption(int dataAmount) {
        this.message = "слишком много";
        if (dataAmount < 6)
            this.message = "недостаточно";

    }

    @Override
    public String toString() {
        return String.format("\nОшибка 418: вы ввели %s данных:(", message);
    }
    
}
