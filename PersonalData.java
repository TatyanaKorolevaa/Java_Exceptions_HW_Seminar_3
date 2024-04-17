
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PersonalData {


    private String surname;
    private String name;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;


    public PersonalData (String surname, String name, String middleName, String birthDate, long phoneNumber, char gender) throws ParseException {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        this.birthDate = dateFormat.parse(birthDate);
    }


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }
}
