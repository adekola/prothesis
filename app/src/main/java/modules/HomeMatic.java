package modules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kola on 8/9/2016.
 */
public class HomeMatic implements ITechnologySupport{

    public HomeMatic() {
        init();
    }

    Map<String, String> commandsDict = new HashMap<String, String>();

    //sets up the commands
    void init(){
        commandsDict.put("define", "define %s CUL_HM");
        commandsDict.put("dimUp", "set %s up");
        commandsDict.put("dimDown", "set %s down");
        commandsDict.put("on", "set %s on");
        commandsDict.put("off", "set %s off");
        commandsDict.put("toggle", "set %s toggle");
    }

    public String ParseCommand(String deviceName, String commandKey ){
        String cmdTemplate = commandsDict.get(commandKey);
        return String.format(cmdTemplate, deviceName);
    }
}
