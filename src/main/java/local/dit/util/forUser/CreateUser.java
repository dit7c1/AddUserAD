package local.dit.util.forUser;

import local.dit.model.UserData;
import local.dit.util.forAdmin.ConnectAD;

import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;

public class CreateUser {
    private String organisationUnitSpirtnoy = ",OU=moscow,OU=spirtnoy,DC=spirtnoy,DC=local";
    private String organisationUnitLTD = ",OU=Moscow_office,OU=main,DC=ltd,DC=local";

    public void addUser(UserData userData) {
        Attributes container = new BasicAttributes();

        Attribute objClasses = new BasicAttribute("objectClass");
        objClasses.add("top");
        objClasses.add("person");
        objClasses.add("organizationalPerson");
        objClasses.add("user");

        Attribute cn = new BasicAttribute("cn", userData.getDisplayName());
        Attribute givenName = new BasicAttribute("givenName", userData.getFirstName() + " " + userData.getPatronymic());
        Attribute sn = new BasicAttribute("sn", userData.getLastName());
        Attribute displayName = new BasicAttribute("displayName", userData.getDisplayName());
        Attribute principalName = new BasicAttribute("userPrincipalName", userData.getFirstNameLatin() + "." + userData.getLastNameLatin() + "@spirtnoy.com");
        Attribute sAMAccountName = new BasicAttribute("sAMAccountName", userData.getUserLogin());
        Attribute telephoneNumber = new BasicAttribute("telephoneNumber", userData.getUserTel());
        Attribute mail = new BasicAttribute("mail", userData.getUserEmail());
        Attribute title = new BasicAttribute("title", userData.getUserPosition());
        //Attribute uid = new BasicAttribute("uid", userData.getFirstNameLatin());

        container.put(objClasses);
        container.put(cn);
        container.put(givenName);
        container.put(sn);
        container.put(displayName);
        container.put(principalName);
        container.put(sAMAccountName);
        container.put(telephoneNumber);
        container.put(mail);
        container.put(title);
        //container.put(uid);

        if (userData.getUserDomain().equals("spirtnoy")) {
            try {
                ConnectAD.context.createSubcontext(getUserDN(userData.getDisplayName(), organisationUnitSpirtnoy), container);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (userData.getUserDomain().equals("ltd")) {
            try {
                ConnectAD.context.createSubcontext(getUserDN(userData.getDisplayName(), organisationUnitLTD), container);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static String getUserDN(String cnName, String ou) {
        return "CN=" + cnName + ou;
    }
}