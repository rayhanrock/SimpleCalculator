package CalculatorFinal;

import java.time.LocalDateTime;

public class AgeCalculation {

    String calculate(int udate, int umonth, int uyear) {
        LocalDateTime object = LocalDateTime.now();

        int date = object.getDayOfMonth();
        int month = object.getMonthValue();
        int year = object.getYear();

        int adate, amonth, ayear, i, day = 0;

        switch (umonth) {
            case 3:
            case 1:

            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                if (uyear % 4 == 0) {
                    day = 29;
                } else {
                    day = 28;
                }
        }
        if (udate > day || umonth > 12 || udate == 0 || umonth ==0 || uyear==0) {
            return "0";
        }

        ayear = year - uyear - 1;
        amonth = 12 - (umonth - month) - 1;
        adate = day - udate + date;
        if (adate >= day) {
            adate = adate - day;
            amonth = amonth + 1;
        }
        if (amonth >= 12) {
            amonth = amonth - 12;
            ayear = ayear + 1;
        }

        return adate + "," + amonth + "," + ayear;
    }

}
