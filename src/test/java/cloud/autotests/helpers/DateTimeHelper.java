package cloud.autotests.helpers;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTimeHelper {
    String[] months = {"января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября",
            "октября", "ноября", "декабря"};

    String[] daysOfWeek = {"суббота", "воскресенье", "понедельник", "вторник", "среда", "четверг", "пятница"};

    GregorianCalendar gcalendar = new GregorianCalendar();

    public String currentMonth = months[gcalendar.get(Calendar.MONTH)];
    public Integer currentDay = gcalendar.get(Calendar.DATE);
    public String currentDayOfWeek = daysOfWeek[gcalendar.get(Calendar.DAY_OF_WEEK)];
    public Integer currentHour = gcalendar.get(Calendar.HOUR);
    public Integer currentMinute = gcalendar.get(Calendar.MINUTE);
}
