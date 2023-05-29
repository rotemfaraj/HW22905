public class DateTime extends Date{
    private int hour;
    private int minute;
    public DateTime(int year, int month, int day, int hour, int minute) {
        super(year, month, day);
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
    }
    public int getHour() {
        return hour;
    }

    public boolean setHour(int hour) {
        this.hour = hour;
        if (hour < 0 || 23<hour) {
            this.hour = 0;
        }
        return true;
    }
    public int getMinute() {
        return minute;
    }

    public boolean setMinute(int minute) {
        this.minute = minute;
        if (minute<0 || minute>59) {
            this.minute = 0;
        }
        return true;
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DateTime)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        DateTime otherDateTime = (DateTime) other;
        return super.equals(otherDateTime) && this.hour == otherDateTime.hour && this.minute == otherDateTime.minute;
    }

    @Override
    public int hashCode() {
        int positiveYears = year + 3999;
        return 12 * 31 * 60 * 24 * positiveYears + 31 * 60 * 24 * month + 24 * 60 * day + 60 * hour + minute;
    }
    @Override
    public String toString(){
        String hourString;
        String minuteString;

        if (hour < 10) {
            hourString = "0" + hour;
        } else {
            hourString = hour+"";
        }

        if (minute < 10) {
            minuteString = "0" + minute;
        } else {
            minuteString = minute+"";
        }
        return super.toString() + " " + hourString + ":" + minuteString;
    }
}
