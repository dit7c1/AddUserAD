package local.dit.util.forAdmin;

import local.dit.model.UserData;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class AllUsersAD {

    //todo убрать личные данные
    public boolean searchUsers(UserData userLogin) throws NamingException {
        boolean result = true;
        String searchFilter = "(objectClass=organizationalPerson)";
        String[] requiredAttributes = {"cn", "sAMAccountName"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(requiredAttributes);
        //todo продумать момент с путями для разных доменов
        NamingEnumeration users = ConnectAD.context.search("OU=Moscow_office,OU=main,DC=ltd,DC=local", searchFilter, controls);
        SearchResult searchResult = null;
        String commonName = null;
        String sAMAccountName = null;

        while (users.hasMore()) {
            searchResult = (SearchResult) users.next();
            Attributes attr = searchResult.getAttributes();

            commonName = attr.get("cn").get(0).toString();
            sAMAccountName = attr.get("sAMAccountName").get(0).toString();

            result = sAMAccountName.equals(userLogin.getUserLogin());
        }

        return result;
    }
}