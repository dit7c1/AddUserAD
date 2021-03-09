package local.dit.util;

import local.dit.model.UserData;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveFile {

    //todo сделать формирование строки через .append
    public void save(UserData userData) {
        String date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        try (FileWriter writer = new FileWriter(userData.getUserLogin() + "." + date + ".txt", false)) {
            writer.write(userData.getLastName() + " ");
            writer.write(userData.getFirstNamePatronymic() + " ");
            writer.write(userData.getPatronymic());
            writer.write("\n");
            writer.write(userData.getUserEmail());
            writer.write("\n");
            writer.write(userData.getUserPassword());
            writer.write("\n");
            writer.flush();
            System.out.println("success save");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
