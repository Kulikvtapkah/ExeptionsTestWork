
package ExeptionsTestWork;

import java.util.LinkedList;

public class DataParser {
    protected LinkedList<String> name;
    protected String dateOfBirth;
    protected long phoneNumber;
    protected char gender;

    public DataParser() throws InvalidDataAmountExeption {
        this.name = new LinkedList<String>() ;
        this.dateOfBirth = "";
        this.gender = 'm';
        this.phoneNumber = 0;
    }

    public void parceData(LinkedList<String> rawData) {
        name = rawData;
        if (name.size() != 6) {
            throw new InvalidDataAmountExeption(name.size());
        }
        phoneNumber = Long.parseLong(specifyData("[0-9]+", "номер телефона"));
        dateOfBirth = specifyData("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).(\\d{4})", "дату рождения");
        gender = specifyData("(f|m)", "ваш пол").charAt(0);

    }

    private String specifyData(String dataPattern, String dataType) {
        String specificData = "";
        boolean dataFound = false;
        for (int i = name.size() - 1; i >= 0; i--) {
            if (name.get(i).matches(dataPattern)) {
                specificData = name.remove(i);
                dataFound = true;
                break;
            }
        }

        if (!dataFound)
            throw new DataNotFoundExeption(dataType);
        return specificData;
    }

    public LinkedList<String> getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public String getFirstName() {
        return name.get(1);
    }

    public String geLastName() {
        return name.get(0);
    }

    public String getPatronimic() {
        return name.get(2);
    }
}
