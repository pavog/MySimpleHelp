package me.paulvogel.mysimplehelp;

import me.paulvogel.mysimplehelp.pages.PageHandler;
import me.paulvogel.mysimplehelp.utils.CommandUtils;
import me.paulvogel.mysimplehelp.utils.FileUtils;
import org.bukkit.plugin.java.JavaPlugin;

public class MySimpleHelp extends JavaPlugin {

    private static MySimpleHelp instance;

    public static MySimpleHelp getInstance() {
        return MySimpleHelp.instance;
    }

    public void onEnable() {
        instance = this;

        FileUtils.init();
        PageHandler.init();

        try {
            CommandUtils.registerFakeCommand(new HelpCommandExecutor(), this);
        } catch (ReflectiveOperationException e) {
            this.getLogger().severe("Could not register custom command!");
            e.printStackTrace();
        }
    }


}
