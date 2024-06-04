package app;

import comp.DisplayLocales;
import comp.Info;
import comp.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.MissingResourceException;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages", Locale.getDefault());
        while (true) {
            System.out.print(messages.getString("prompt"));
            String command = scanner.nextLine();
            if (command.equals("displayLocales"))
                new DisplayLocales(messages).execute();
            else if (command.startsWith("setLocale")) {
                String[] parts = command.split(" ");
                if (parts.length > 1) {
                    new SetLocale(messages).execute(parts[1]);
                    try {
                        messages = ResourceBundle.getBundle("res.Messages", Locale.forLanguageTag(parts[1]));
                    } catch (MissingResourceException e) {
                        System.err.println("Resource bundle not found: " + e.getMessage());
                    }
                } else
                    System.out.println(messages.getString("invalid"));
            } else if (command.startsWith("info")) {
                String[] parts = command.split(" ");
                if (parts.length > 1)
                    new Info(messages).execute(Locale.forLanguageTag(parts[1]));
                else
                    new Info(messages).execute(null);
            } else
                System.out.println(messages.getString("invalid"));
        }
    }
}
