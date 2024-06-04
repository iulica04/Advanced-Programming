package comp;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales //to display all available locales
{
    private ResourceBundle messages;

    public DisplayLocales(ResourceBundle messages) {
        this.messages = messages;
    }

    public void execute() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        System.out.println(messages.getString("locales"));
        for (Locale locale : availableLocales)
            System.out.println(locale.toString() + " " + locale.getDisplayName());
    }
}
