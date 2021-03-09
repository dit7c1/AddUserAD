package local.dit.view;

import javafx.scene.control.TextField;
import local.dit.model.UserData;

public class FillData {

    public void fill(UserData userData, TextField firstNamePatronymic, TextField lastNameID, TextField displayNameID,
                     TextField userLoginID, TextField userPasswordID, TextField userEmailID) {
        firstNamePatronymic.setText(userData.getFirstNamePatronymic());
        lastNameID.setText(userData.getLastName());
        displayNameID.setText(userData.getDisplayName());
        userLoginID.setText(userData.getUserLogin());
        userPasswordID.setText(userData.getUserPassword());
        userEmailID.setText(userData.getUserEmail());
    }
}