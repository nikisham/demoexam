package ClientApp.ui;

import ClientApp.App;
import ClientApp.entity.ClientEntity;
import ClientApp.manager.ClientEntityManager;
import ClientApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class CreateForm extends BaseForm {
    private JPanel CreatePanel;
    private JTextField FirstNameField;
    private JTextField LastNameField;
    private JTextField PatronymicField;
    private JTextField EmailField;
    private JTextField PhoneField;
    private JTextField BirthdayField;
    private JComboBox GanderBox;
    private JButton AddButton;

public CreateForm(){super(800,600);setContentPane(CreatePanel);initBoxes();initButton();setVisible(true);}
public void initBoxes(){GanderBox.addItem("Женский");GanderBox.addItem("Мужской");}
public void initButton(){AddButton.addActionListener(e -> {
    String firstname = FirstNameField.getText();
if(firstname.isEmpty() || firstname.length()>50){
    JOptionPane.showMessageDialog(this,"Имя введено не правильно или слишком длинное","заг", JOptionPane.ERROR_MESSAGE);
    return;
}

    String lastname = LastNameField.getText();
        if(lastname.isEmpty() || lastname.length()>50){
            JOptionPane.showMessageDialog(this,"Фамилия введено не правильно или слишком длинное","заг", JOptionPane.ERROR_MESSAGE);
            return;
        }
    String patronymic = PatronymicField.getText();
        if(patronymic.isEmpty() || patronymic.length()>50){
            JOptionPane.showMessageDialog(this,"Отчество введено не правильно или слишком длинное","заг", JOptionPane.ERROR_MESSAGE);
            return;
        }
    String email = EmailField.getText();
        if(email.isEmpty() || email.length()>50){
            JOptionPane.showMessageDialog(this,"e-mail введено не правильно или слишком длинное","заг", JOptionPane.ERROR_MESSAGE);
            return;
        }
    String phone = PhoneField.getText();
        if(phone.isEmpty() || phone.length()>20){
            JOptionPane.showMessageDialog(this,"Телефон введено не правильно или слишком длинное","заг", JOptionPane.ERROR_MESSAGE);
            return;
        }
    Date birthday = null;
        try {
            birthday = App.DATE_FORMAT.parse(BirthdayField.getText());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        char gender =   GanderBox.getSelectedIndex()== 0? 'ж':'м'  ;

        ClientEntity clientEntity = new ClientEntity(
               firstname,
                lastname,
                patronymic,
                birthday,
                new Date(),
                email,
                phone,
                gender
        );

        try {
            ClientEntityManager.insert(clientEntity);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }

    });

}
}
