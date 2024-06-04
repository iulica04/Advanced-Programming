package comp;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Date;

public class Info //to display informations about the current or a specific locale
{
    private ResourceBundle messages;

    public Info(ResourceBundle messages) {
        this.messages = messages;
    }

    public void execute(Locale locale) {
        if (locale == null)
            locale = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle("res.Messages", locale);
        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        Currency currency = Currency.getInstance(locale);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        DateFormat dfEn = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);

        //getting country and language names
        String country = locale.getDisplayCountry(Locale.ENGLISH);
        String countryNative = locale.getDisplayCountry(locale);
        String language = locale.getDisplayLanguage(Locale.ENGLISH);
        String languageNative = locale.getDisplayLanguage(locale);

        //getting currency information
        String currencyCode = currency.getCurrencyCode();
        String currencyName = currency.getDisplayName(Locale.ENGLISH);
        String currencyNative = currency.getDisplayName(locale);

        //getting week days and months
        String[] weekdays = dfs.getWeekdays();
        String[] months = dfs.getMonths();

        //formatting the current date
        String today = df.format(new Date());
        String todayEn = dfEn.format(new Date());

        //creating the output for weekdays and months
        StringBuilder weekdaysString = new StringBuilder();
        for (int i = 2; i < weekdays.length; i++) {
            weekdaysString.append(weekdays[i]);
            if (i < weekdays.length - 1)
                weekdaysString.append(", ");
        }
        StringBuilder monthsString = new StringBuilder();
        for (int i = 0; i < months.length - 1; i++) {
            monthsString.append(months[i]);
            if (i < months.length - 2)
                monthsString.append(", ");
        }
        System.out.println(messages.getString("info").replace("{0}", locale.toString()));
        System.out.println("Country: " + country + " (" + countryNative + ")");
        System.out.println("Language: " + language + " (" + languageNative + ")");
        System.out.println("Currency: " + currencyCode + " (" + currencyName + ")");
        System.out.println("Week Days: " + weekdaysString.toString());
        System.out.println("Months: " + monthsString.toString());
        System.out.println("Today: " + todayEn + " (" + today + ")");
    }
}
