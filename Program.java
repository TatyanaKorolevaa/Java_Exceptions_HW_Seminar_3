import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Program {

    public static void main(String[] args) {

        System.out.println("Введите данные в формате: Фамилия Имя Отчество Дата_рождения(дд.мм.гггг) Номер_телефона Пол");
        String dataEntry = System.console().readLine();

        String[] data = dataEntry.split(" ");

        if (data.length != 6) {
            System.err.println("Введено недостаточно или слишком много данных.");
            return;
        }

        try {
            String surname = data[0];
            String name = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            PersonalData PersonalData = new PersonalData (surname, name, middleName, birthDate, phoneNumber, gender);

            
            String fileName = surname + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true); 

            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
            String formattedDate = dateFormat.format(PersonalData.getBirthDate());

            String fileData = String.format("<%s> <%s> <%s> <%s> <%d> <%c>%n",
            PersonalData.getSurname(), PersonalData.getName(), PersonalData.getMiddleName(), formattedDate, PersonalData.getPhoneNumber(), PersonalData.getGender());

            fileWriter.write(fileData);
            fileWriter.close();

            System.out.println("Создан файл: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неверный формат номера телефона.");
        } catch (ParseException e) {
            System.err.println("Ошибка: Неверный формат даты рождения.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл.");
        }
    }
}
