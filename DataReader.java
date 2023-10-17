package ExeptionsTestWork;

import java.util.Arrays;
import java.util.LinkedList;

import java.util.Scanner;

public class DataReader {
    private Scanner sc;

    public DataReader() {
        this.sc = new Scanner(System.in);
    }

    public LinkedList<String> getData() {
        System.out.println("Введите данные (ФИО, дата рождения, номер телефона, пол).\n!!! Не забудьте пробелы;)");
        String rawData = sc.nextLine();
        LinkedList<String> rawDataList = new LinkedList<String>(Arrays.asList(rawData.split(" ")));

        rawDataList.removeIf(n -> n.equals(""));
        return rawDataList;
    }

    public void closeDataReader() {
        sc.close();
    }

}
