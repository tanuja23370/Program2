

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Person {
    private String name;
    private Date dob;

    public Person(String name, String dobStr) throws ParseException {
        this.name = name;
        this.dob = parseDate(dobStr);
    }

    private Date parseDate(String dobStr) throws ParseException {
        String[] formats = {"dd-MM-yyyy", "yyyy-MM-dd"};
        for (String format : formats) {
            try {
                return new SimpleDateFormat(format).parse(dobStr);
            } catch (ParseException ignored) {}
        }
        throw new ParseException("Invalid date format", 0);
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAge() {
        Calendar dobCalendar = Calendar.getInstance();
        dobCalendar.setTime(dob);

        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dobCalendar.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dobCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        try {
            Person p = new Person("Alice", "2000-05-10");
            p.displayName();
            p.displayAge();
        } catch (ParseException e) {
            System.out.println("Date parsing error: " + e.getMessage());
        }
    }
}
