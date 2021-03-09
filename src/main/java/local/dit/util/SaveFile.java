package local.dit.util;

import local.dit.model.UserData;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveFile {

    public void save(UserData userData) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        try (FileWriter writer = new FileWriter(userData.getUserLogin() + "." + date + ".txt", false)) {
            StringBuilder str = new StringBuilder();
            str.append("Сотрудник: \t");
            str.append(userData.getLastName());
            str.append(" ");
            str.append(userData.getFirstName());
            str.append(" ");
            str.append(userData.getPatronymic());
            str.append("\n");
            str.append("Логин: \t\t");
            str.append(userData.getUserLogin());
            str.append("\n");
            str.append("E-mail: \t");
            str.append(userData.getUserEmail());
            str.append("\n");
            str.append("Пароль: \t");
            str.append(userData.getUserPassword());
            writer.write(str.toString());
            //writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}