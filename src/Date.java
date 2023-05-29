public class Date {
    protected int day;
    protected int month;
    protected int year;

    public Date(int year, int month, int day) {
        if (year > 3999 || year <= -3999) {
            this.year = 0;
        } else {
            this.year = year;
        }
        if (month > 12 || month < 1) {
            this.month = 1;
        } else {
            this.month = month;
        }
        if (day > 31 || day < 1) {
            this.day = 1;
        } else {
            this.day = day;
        }
    }
    public int getDay() {return day;}
    public boolean setDay(int day) {
        this.day = day;
        if (day<1 || day>31) {
            this.day = 1;
        }
        return true;
    }
    public int getMonth() {return month;}
    public boolean setMonth(int month) {
        this.month = month;
        if (month<1 || month>12) {
            this.month = 1;
        }
        return true;
    }
    public int getYear() {return year;}
    public boolean setYear(int year) {
        this.year = year;
        if (year<-3999 || year>3999) {
            this.year = 0;
        }
        return true;
    }
    @Override
    public boolean equals(Object other){
        if (!(other instanceof Date)) {
            return false;
        }
        Date otherDate = (Date) other;
        int hashCodeOther = other.hashCode();
        int hashCode = this.hashCode();
        // int positiveYears = year+3999;
        //int hashCode = 12*31*positiveYears+31*month+day;
        boolean firstCheck = false;
        if(this.day==otherDate.day && this.month==otherDate.month && this.year==otherDate.year){
            firstCheck = true;
        }
        boolean secondCheck = false;
        if(hashCode == hashCodeOther){
            secondCheck = true;
        }
        return firstCheck && secondCheck;
    }
    @Override
    public int hashCode(){
        int positiveYears = year+3999;
        return 12*31*positiveYears+31*month+day;
    }
    @Override
    public String toString() {
        String dayString;
        String monthString;
        String yearString;

        if (day < 10) {
            dayString = "0" + day;
        } else {
            dayString = day+"";
        }

        if (month < 10) {
            monthString = "0" + month;
        } else {
            monthString = month+"";
        }

        if (-10 < year && year < 10) {
            yearString = "000" + year;
        } else if (-100 < year && year < 100) {
            yearString = "00" + year;
        } else if (-1000 < year && year < 1000) {
            yearString = "0" + year;
        } else {
            yearString = year+"";
        }

        return dayString + "/" + monthString + "/" + yearString;
    }

}