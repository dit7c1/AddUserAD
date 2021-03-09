package local.dit.model;

public class AdminDataAD {
    private String host;
    private String port;
    private String domain;
    private String adminLogin;
    private String adminPassword;

    public AdminDataAD(String host, String port, String domain, String adminLogin, String adminPassword) {
        this.host = host;
        this.port = port;
        this.domain = domain;
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDomain() {
        return domain;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
}