package java_oracle;

import java_oracle_DAO.ColorDAO;
import java_oracle_DTO.ColorDTO;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Menu {

    ColorDAO colorDAO = new ColorDAO();
    ColorDTO colorDTO = new ColorDTO();
    ResourceBundle bundleDefault;

    Menu(){
        Locale.setDefault(new Locale("en", "US"));
        bundleDefault = ResourceBundle.getBundle("resources_" + Locale.getDefault());
        colorDAO.bundleDefault = ResourceBundle.getBundle("resources_" + Locale.getDefault());
    }

    public int displayMenu(int type) {
        Scanner input = new Scanner(System.in);
        int selection;

        switch (type) {
            case 1, 2 -> System.out.println(new String(bundleDefault.getString("printOptions")));
            case 3 -> System.out.println(new String(bundleDefault.getString("selectLang")));
        }
        selection = input.nextInt();
        return selection;
    }

    public void run() throws UnsupportedEncodingException {
        int langChoice;
        int userChoice;
        boolean isGo = true;

        while(true){
            langChoice = displayMenu(3);

            if (langChoice == 1) {
                break;
            } else if (langChoice == 2){
                Locale.setDefault(new Locale("ru", "RU"));
                bundleDefault = ResourceBundle.getBundle("resources_" + Locale.getDefault());
                colorDAO.bundleDefault = ResourceBundle.getBundle("resources_" + Locale.getDefault());
                break;
            } else if (langChoice == 3){
                isGo = false;
                break;
            } else {
                System.out.println(new String(bundleDefault.getString("tryAgain")));
            }
        }

        while (isGo){
            userChoice = displayMenu(langChoice);

            switch (userChoice) {
                case 1 -> m_addRow();
                case 2 -> m_updateRow();
                case 3 -> m_deleteRow();
                case 4 -> isGo = false;
                default -> System.out.println(new String(bundleDefault.getString("tryAgain")));
            }
        }
    }

    public void m_addRow(){
        colorDTO.setAll(enterValues());
        colorDAO.addRow(colorDTO);
    }

    public void m_updateRow(){
        colorDTO.setAll(enterValues());
        colorDAO.updateRow(colorDTO, enterID());
    }

    public void m_deleteRow(){
        colorDAO.deleteRow(enterID());
    }

    public ColorRGB enterValues(){
        Scanner input = new Scanner(System.in);
        int red, green, blue;
        String name;
        System.out.println(new String(bundleDefault.getString("enterRed")));
        red = input.nextInt();
        System.out.println(new String(bundleDefault.getString("enterGreen")));
        green = input.nextInt();
        System.out.println(new String(bundleDefault.getString("enterBlue")));
        blue = input.nextInt();
        System.out.println(new String(bundleDefault.getString("enterName")));
        name = input.next();

        return new ColorRGB(red, green, blue, name);
    }

    public int enterID(){
        Scanner input = new Scanner(System.in);
        int id;
        System.out.println(new String(bundleDefault.getString("enterID")));
        id = input.nextInt();
        return id;
    }
}
