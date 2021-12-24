package ClientApp.ui;

import ClientApp.entity.ClientEntity;
import ClientApp.manager.ClientEntityManager;
import ClientApp.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class SellectAll extends BaseForm {
    private JPanel panel1;
    private JTextArea textArea;
    private JButton BackButton;
    public SellectAll()
    {
        super(1000,800);
        setContentPane(panel1);
        initText();
        initButtons();
        setVisible(true);

    }
    private void initButtons() {BackButton.addActionListener(e -> {dispose();new CreateForm();});}
    private void initText() {
        try {
            List<ClientEntity> list = ClientEntityManager.selectAll();
            String s = "";
            for (ClientEntity m:list){
                s+=m;
                s+="\n";
            }
            textArea.setText(s);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
