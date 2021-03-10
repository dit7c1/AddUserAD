package local.dit.util.forUser;

import local.dit.model.UserData;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveFile {

    public void save(UserData userData) {
        String date = new SimpleDateFormat("dd.MM.yyyy(HH.mm.ss)").format(new Date());
        try (FileWriter saveFile = new FileWriter(userData.getUserLogin() + "." + date + ".txt", false)) {
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
            saveFile.write(str.toString());
            //saveFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}