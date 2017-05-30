package sg.edu.rp.c346.c302_p06exercise;

import java.io.Serializable;

/**
 * Created by 15017103 on 30/5/2017.
 */

public class Geo implements Serializable {
    private String lat;
    private String lng;

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
