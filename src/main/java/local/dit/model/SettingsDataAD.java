package local.dit.model;

public class SettingsDataAD {
    private String domainURL;
    private String domain;
    private String domainRoot;
    private String distinguishedNameSpirtnoy;
    private String distinguishedNameLtd;
    private String adminPassword;

    public SettingsDataAD(AdminDataAD adminDataAD) {
        this.domainURL = "ldap://" + adminDataAD.getHost() + ":" + adminDataAD.getPort();
        this.domain = adminDataAD.getDomain();
        this.domainRoot = "DC=" + domain + ",DC=local";
        this.distinguishedNameSpirtnoy = "CN=" + adminDataAD.getAdminLogin() + ",OU=moscow,OU=spirtnoy," + domainRoot;
        this.distinguishedNameLtd = "CN=" + adminDataAD.getAdminLogin() + ",OU=Moscow_office,OU=main," + domainRoot;
        this.adminPassword = adminDataAD.getAdminPassword();
    }

    public String getDomainURL() {
        return domainURL;
    }

    public String getDomain() {
        return domain;
    }

    public String getDomainRoot() {
        return domainRoot;
    }

    public String getDistinguishedNameSpirtnoy() {
        return distinguishedNameSpirtnoy;
    }

    public String getDistinguishedNameLtd() {
        return distinguishedNameLtd;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}