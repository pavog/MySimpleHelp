package me.paulvogel.mysimplehelp;

import org.bukkit.plugin.java.JavaPlugin;

public class MySimpleHelp extends JavaPlugin {

  public void onEnable() {
    System.out.println("Enabled MySimpleHelp");
  }

  @Override
  public void onDisable() {
    System.out.println("Disabled MySimpleHelp");
  }

}
