package au.edu.jcu.cp3406.medreminder;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

import androidx.annotation.NonNull;

public class Medicine {
    private String name, type, time;
    private int qty;
    private Date date;
    private SimpleDateFormat dateFormat;

    Medicine() {
    }

    Medicine(String name, int qty, String type, String time) {
        this.name = name;
        this.qty = qty;
        this.type = type;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public int getQty() {
        return qty;
    }

    // get current date
    @SuppressLint("SimpleDateFormat")
    public String getDateToday() {
        date = Calendar.getInstance().getTime();
        dateFormat = new SimpleDateFormat("EEEE, d MMMMM yyyy");
        return dateFormat.format(date);
    }

    // return formatted list item in list view
    public String getString(@NonNull String type) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());

        if (type.equals("tablets")) {
            if (qty == 1) {
                type = "tablet";
                // e.g. 1 diabetes tablet
                formatter.format("1 " + "%s" + " " + "%s", name, type);
            } else {
                // e.g. 2 hypertension tablets
                formatter.format("%d" + " " + "%s" + " " + "%s", qty, name, type);
            }
        } else if (type.equals("liquid")) {
            // e.g. TCM 30ml
            formatter = formatter.format("%s" + " " + "%d" + "ml", name, qty);
        }
        return formatter.toString();
    }
}