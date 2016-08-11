package modules;

import android.util.Log;

/**
 * Created by kola on 6/11/2016.
 */
public class Mapper {

    static ITechnologySupport techSupportClass;
    //this method is able to accept an intended command for a given device and use to call the appropriate tech support class
    //
    public static boolean Do(String what, Dimmer targetDimmer){

        switch(targetDimmer.getTech()){
            case "FS20":
                techSupportClass = new FS20();
                break;
            case "HomeMatic":
                techSupportClass = new HomeMatic();
                break;
            case "EnOcean":
                techSupportClass = new EnOcean();
                break;
            default:
                break;
        }
        //check the tech of the device, then instantiate the appropriate technology class
        String cmdText  = techSupportClass.ParseCommand(targetDimmer.getDeviceName(), what);
        //for debug purposes only
        Log.d("DEFINE", cmdText);

        //now call the connector to execute the command
        return false;
    }
}
