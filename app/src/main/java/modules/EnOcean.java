package modules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kola on 8/9/2016.
 */
public class EnOcean implements ITechnologySupport{

    public EnOcean() {
        init();
    }

    Map<String, String> commandsDict = new HashMap<String, String>();

    //sets up the commands
    void init(){
        commandsDict.put("define", "define %s EnOcean");
        commandsDict.put("dimUp", "set %s dimup 10%%");
        commandsDict.put("dimDown", "set %s dimdown 10%%");
        commandsDict.put("on", "set %s on");
        commandsDict.put("off", "set %s off");
    }

    //we'll do without parameters to the actions for now
    public String ParseCommand(String deviceName, String commandKey ){
        String cmdTemplate = commandsDict.get(commandKey);
        return String.format(cmdTemplate, deviceName);
    }
}
