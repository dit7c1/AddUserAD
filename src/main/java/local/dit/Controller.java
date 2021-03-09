package local.dit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import local.dit.model.AdminDataAD;
import local.dit.model.SettingsDataAD;
import local.dit.model.UserData;
import local.dit.util.SaveFile;
import local.dit.util.forAdmin.ConnectAD;
import local.dit.util.forUser.CreateUser;
import local.dit.view.FillData;

import javax.naming.NamingException;

public class Controller {
    private UserData userData;

    @FXML
    private TextField hostID;
    @FXML
    private TextField portID;
    @FXML
    private TextField domainID;
    @FXML
    private TextField adminLoginID;
    @FXML
    private PasswordField adminPasswordID;

    // изменение статуса подключения
    @FXML
    private Label statusID;

    // ошибка - отсутствие фамилии
    @FXML
    private Label errorLastNameID;
    @FXML
    private Label errorFirstNameID;
    @FXML
    private Label errorPatronymicID;

    // поля для ручного заполнения
    @FXML
    private TextField lastNameFirstNamePatronymicID;
    @FXML
    private TextField userTelID;
    @FXML
    private TextField userPositionID;

    // поля для автоматического заполнения
    @FXML
    private TextField firstNamePatronymicID;
    @FXML
    private TextField lastNameID;
    @FXML
    private TextField displayNameID;
    @FXML
    private TextField userLoginID;
    @FXML
    private TextField userPasswordID;
    @FXML
    private TextField userEmailID;

    @FXML
    private Button buttonFillInID;
    @FXML
    private Button buttonCreateID;

    @FXML
    private ChoiceBox<String> userDomain;
    ObservableList<String> choiceDomain = FXCollections.observableArrayList("spirtnoy", "ltd");

    //
    public void initialize() {
        buttonFillInID.disableProperty().bind(lastNameFirstNamePatronymicID.textProperty().isEmpty());
        buttonCreateID.disableProperty().bind(firstNamePatronymicID.textProperty().isEmpty());

        userDomain.setValue("spirtnoy");
        userDomain.setItems(choiceDomain);
    }

    // проверка подключения к AD
    public void onClickButtonConnectAction() throws NamingException {
        // Model Admin data
        AdminDataAD administratorData = new AdminDataAD(hostID.getText(), portID.getText(), domainID.getText(),
                adminLoginID.getText(), adminPasswordID.getText());

        // Model connecting settings
        SettingsDataAD settingsConnection = new SettingsDataAD(administratorData);

        // меняем статус
        ConnectAD connectAD = new ConnectAD();
        connectAD.initConnect(settingsConnection, statusID);
    }

    // заполнить поля пользователя
    public void onClickButtonFillInAction() {
        String[] incomingUserData = lastNameFirstNamePatronymicID.getText().split("\\s+");
        // TODO сделать проверку, дабы избежать проблемы с отсутствием данных
        if (incomingUserData.length == 1) {
            errorLastNameID.setStyle("-fx-text-fill: green");
            errorFirstNameID.setStyle("-fx-text-fill: red");
            errorPatronymicID.setStyle("-fx-text-fill: red");
            errorPatronymicID.setText("Отчество - отсутствует");
        } else if (incomingUserData.length == 2) {
            errorLastNameID.setStyle("-fx-text-fill: green");
            errorFirstNameID.setStyle("-fx-text-fill: green");
            errorPatronymicID.setStyle("-fx-text-fill: red");
            errorPatronymicID.setText("Отчество - отсутствует");
        } else {
            errorLastNameID.setStyle("-fx-text-fill: green");
            errorFirstNameID.setStyle("-fx-text-fill: green");
            errorPatronymicID.setStyle("-fx-text-fill: green");
            errorPatronymicID.setText("Отчество");
            userData = new UserData(userDomain.getValue(), incomingUserData[0], incomingUserData[1], incomingUserData[2], userTelID.getText(), userPositionID.getText());
            FillData receivedData = new FillData();
            receivedData.fill(userData, firstNamePatronymicID, lastNameID, displayNameID, userLoginID, userPasswordID, userEmailID);
        }
    }

    // создать пользователя
    public void onClickButtonCreateAction() {
        CreateUser createUser = new CreateUser();
        createUser.addUser(userData);
    }

    public void onClickButtonSaveAction() {
        SaveFile saveFile = new SaveFile();
        saveFile.save(userData);
    }
}