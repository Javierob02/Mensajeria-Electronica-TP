package com.company;

public class SMSTools {
    private static int id = 0;

    public static int getUniqueId() {
        return id++;
    }

    public static void sendMessage(String telefono, String mensaje) {
        return;
    }
}
