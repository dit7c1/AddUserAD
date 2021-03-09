package local.dit.util.forAdmin;

import javafx.application.Platform;
import javafx.scene.control.Label;
import local.dit.model.SettingsDataAD;
import java.util.Hashtable;
import java.util.TimerTask;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.naming.Context;

public class ConnectAD {
    public static LdapContext context;

    // проверка подключения
    public void initConnect(SettingsDataAD settingsDataAD, Label statusID) throws NamingException {
        Hashtable<String, String> env = new Hashtable<String, String>();

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        if (settingsDataAD.getDomain().equals("spirtnoy")) {
            env.put(Context.SECURITY_PRINCIPAL, settingsDataAD.getDistinguishedNameSpirtnoy());
        } else if (settingsDataAD.getDomain().equals("ltd")) {
            env.put(Context.SECURITY_PRINCIPAL, settingsDataAD.getDistinguishedNameLtd());
        }
        env.put(Context.SECURITY_CREDENTIALS, settingsDataAD.getAdminPassword());
        env.put(Context.PROVIDER_URL, settingsDataAD.getDomainURL());

        try {
            context = new InitialLdapContext(env, null);
            statusID.setText("Success");
            statusID.setStyle("-fx-text-fill: green");
            // возвращаем дефолтный цвет и статус через 7 сек
            new java.util.Timer().schedule(
                    new TimerTask() {
                        public void run() {
                            Platform.runLater(() -> {
                                statusID.setText("Status");
                                statusID.setStyle("-fx-text-fill: black");
                            });
                        }
                    }, 7000);

        } catch (NamingException e) {
            statusID.setText("Error");
            statusID.setStyle("-fx-text-fill: red");
            // возвращаем дефолтный цвет и статус через 7 сек
            new java.util.Timer().schedule(
                    new TimerTask() {
                        public void run() {
                            Platform.runLater(() -> {
                                statusID.setText("Status");
                                statusID.setStyle("-fx-text-fill: black");
                            });
                        }
                    }, 7000);

            System.err.println("Problem creating object: ");
            e.printStackTrace();
        }
    }
}