package local.dit.model;

import local.dit.util.forUser.ConvertToLatinText;
import local.dit.util.forUser.LoginGenerator;
import local.dit.util.forUser.PasswordGenerator;

public class UserData {
    private String userDomain;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String firstNamePatronymic;
    private String displayName;
    private String lastNameLatin;
    private String firstNameLatin;
    private String userLogin;
    private String userPassword;
    private String userEmail;
    private String userTel;
    private String userPosition;

    public UserData(String userDomain, String lastName, String firstName, String patronymic, String userTel, String userPosition) {
        this.userDomain = userDomain;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.firstNamePatronymic = firstName + " " + patronymic;
        this.displayName = lastName + " " + firstName + " " + patronymic;
        this.lastNameLatin = ConvertToLatinText.convert(lastName);
        this.firstNameLatin = ConvertToLatinText.convert(firstName);
        this.userLogin = LoginGenerator.generateLogin(firstNameLatin, lastNameLatin);
        this.userPassword = PasswordGenerator.generatePassword(firstNameLatin, lastNameLatin);
        this.userEmail = firstNameLatin + "." + lastNameLatin + "@stellargroup.ru";
        this.userTel = userTel;
        this.userPosition = userPosition;
    }

    public String getUserDomain() {
        return userDomain;
    }

    public String getFirstNamePatronymic() {
        return firstNamePatronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLastNameLatin() {
        return lastNameLatin;
    }

    public String getFirstNameLatin() {
        return firstNameLatin;
    }

    public String getUserTel() {
        return userTel;
    }

    public String getUserPosition() {
        return userPosition;
    }
}