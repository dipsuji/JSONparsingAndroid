package learn4ever.json.parsing;

public class JsonResponseData {

   /* { JSON data
        "time": "02:24:35 PM",
            "milliseconds_since_epoch": 1538058275670,
            "date": "09-27-2018"
    }*/

    private String time;

    private String milliseconds_since_epoch;

    private String date;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMilliseconds_since_epoch() {
        return milliseconds_since_epoch;
    }

    public void setMilliseconds_since_epoch(String milliseconds_since_epoch) {
        this.milliseconds_since_epoch = milliseconds_since_epoch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "jsonResponseData [time = " + time + ", milliseconds_since_epoch = " + milliseconds_since_epoch + ", date = " + date + "]";
    }
}