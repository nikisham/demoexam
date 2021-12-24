package ClientApp.util;

import javax.swing.*;
import java.awt.*;

public class BaseForm extends JFrame {
private JPanel CreateForm;
public static String APP_TITLE = "My App";
    public BaseForm(int width, int height){
    setTitle(APP_TITLE);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(800,600));
    setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-width/2,
            Toolkit.getDefaultToolkit().getScreenSize().height/2-height/2);
    setVisible(true);
    }
}

