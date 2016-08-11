package modules;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import javax.xml.datatype.Duration;

/**
 * Created by kola on 6/11/2016.
 */
public class Dimmer implements Parcelable {


    public String _deviceName;
    public String _deviceManufacturer;
    public String _tech;


    protected Dimmer(Parcel in) {
        _deviceName = in.readString();
        _deviceManufacturer = in.readString();
        _tech = in.readString();
    }

    public static final Creator<Dimmer> CREATOR = new Creator<Dimmer>() {
        @Override
        public Dimmer createFromParcel(Parcel in) {
            return new Dimmer(in);
        }

        @Override
        public Dimmer[] newArray(int size) {
            return new Dimmer[size];
        }
    };


    //doubles as the unique device ID
    public String getDeviceName() {
        return _deviceName;
    }

    public void setTech(String _tech) {
        this._tech = _tech;
    }

    public String getTech() {
        return _tech;
    }

    public Dimmer(String _deviceName, String _deviceManufacturer, String _tech) {
        this._deviceName = _deviceName;
        this._deviceManufacturer = _deviceManufacturer;
        this._tech = _tech;
    }

    @Override
    public String toString() {
        return getDeviceName();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(_deviceName);
            parcel.writeString(_deviceManufacturer);
            parcel.writeString(_tech);
    }


    public boolean dimUp(){
        return Mapper.Do("dimUp", this);
    }

    public boolean dimDown(){
        return Mapper.Do("dimDown", this);
    }

    public boolean toggle(){
        return false;
    }

    public boolean on(){
        return Mapper.Do("on", this);
    }

    public boolean off(){
        return Mapper.Do("off", this);
    }

    public boolean onFor(Duration duration){
        return false;
    }

    public boolean ofFor(Duration duration){
        return false;
    }

    public boolean offTill(Date targetDate){
        return false;
    }

    public boolean onTill(Date targetDate){
        return false;
    }

    public boolean dimDownBy(double amount){
        return false;
    }

    public boolean dimUpBy(double amount){
        return false;
    }
}