package comp;

import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale //to set the application current locale
{
    private ResourceBundle messages;

    public SetLocale(ResourceBundle messages) {
        this.messages = messages;
    }

    public void execute(String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);
        Locale.setDefault(locale);
        System.out.println(messages.getString("locale.set").replace("{0}", locale.toString()));
    }
}
