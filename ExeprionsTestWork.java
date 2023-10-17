/*Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, 
разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, 
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
пользователь должен увидеть стектрейс ошибки.
*/

package ExeptionsTestWork;

public class ExeprionsTestWork {
    public static void main(String[] args) {
        DataReader personData = new DataReader();

        DataParser parcedData = new DataParser();
        while (true) {
            try {
                parcedData.parceData(personData.getData());
                System.out.println("Ура, все ок пока что...\n Ваши данные:");
                System.out.printf("Фамилия: %s \n", parcedData.geLastName());
                System.out.printf("Имя: %s \n", parcedData.getFirstName());
                System.out.printf("Отчество: %s \n", parcedData.getPatronimic());
                System.out.printf("Дата рождения: %s \n", parcedData.getDateOfBirth());
                System.out.printf("Номер телефона: %s \n", parcedData.getPhoneNumber());
                System.out.printf("Пол: %s \n", parcedData.getGender());

                break;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("\nПопробуйте снова.");
            }

        }
        personData.closeDataReader();

        String path = String.format("ExeptionsTestWork/%s.txt", parcedData.getName().get(0));
        String dataToSave = String.format("<%s><%s><%s><%s><%d><%c>\n", parcedData.geLastName(),
                parcedData.getFirstName(), parcedData.getPatronimic(), parcedData.getDateOfBirth(),
                parcedData.getPhoneNumber(), parcedData.getGender());
        DataSaver.saveToFile(path, dataToSave);

    }

}
