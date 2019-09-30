package com.ohdgh.db;

public class DatabaseCredentials {
    static String hostName = "onlinehelpdesk.database.windows.net"; // update me
    static String dbName = "Development"; // update me
    static String user = "ohdgh"; // update me
    static String password = "Welcome@123"; // update me
    static String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
        + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
}
