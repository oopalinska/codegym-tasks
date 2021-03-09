package task2408_local_classes;

import java.text.SimpleDateFormat;

public abstract class SuperDog {
    protected String getSuperQuotes() {
        // Add some logic here
        return " *** ";
    }

    protected SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd-MMM-yyyy");
}
