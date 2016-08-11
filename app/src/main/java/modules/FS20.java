package modules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kola on 8/9/2016.
 */

//intended to capture the specifics of interacting with FS20 devices
public class FS20 implements ITechnologySupport {

    public FS20() {
        init();
    }

    Map<String, String> commandsDict = new HashMap<String, String>();

    //sets up the commands
    void init(){
        commandsDict.put("define", "define %s FS20");
        commandsDict.put("dimUp", "set %s dimup");
        commandsDict.put("dimDown", "set %s dimdown");
        commandsDict.put("on", "set %s on");
        commandsDict.put("off", "set %s off");
        commandsDict.put("toggle", "set %s toggle");
    }

    public String ParseCommand(String deviceName, String commandKey ){
        String cmdTemplate = commandsDict.get(commandKey);
        return String.format(cmdTemplate, deviceName);
    }
}
