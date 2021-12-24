package ClientApp.entity;

import lombok.Data;

import java.util.Date;


@Data
public class ClientEntity {
    private int ID;
    private String FirstName;
    private String LastName;
    private String Patronymic;
    private Date Birthday;
    private Date RegDate;
    private String Email;
    private String Phone;
    private char Gender;

    public ClientEntity(int ID, String firstName, String lastName, String patronymic, Date birthday, Date regDate, String email,String phone, char gender) {
        this.ID = ID;
        FirstName = firstName;
        LastName = lastName;
        Patronymic = patronymic;
        Birthday = birthday;
        RegDate = regDate;
        Email = email;
        Phone = phone;
        Gender = gender;
    }

    public ClientEntity(String firstName, String lastName, String patronymic, Date birthday, Date regDate, String email, String phone, char gender) {
        this(-1,firstName,lastName,patronymic,birthday,regDate,email,phone,gender);
    }


}
