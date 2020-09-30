package by.HomeWork2_2;
import java.util.Calendar;
import java.util.Date;

public class MyExceptions extends RuntimeException {
    private String message;
    private Date date;

    MyExceptions(String message) {
        super(message);
        this.message = message;
        this.date = Calendar.getInstance().getTime();
    }

    @Override
    public String toString() {
        return this.date + " MyExceptions." + this.message;
    }
}

