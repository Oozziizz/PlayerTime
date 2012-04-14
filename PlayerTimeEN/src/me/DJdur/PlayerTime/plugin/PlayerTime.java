package me.DJdur.PlayerTime.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerTime extends JavaPlugin {
  public ChatColor g = ChatColor.GOLD;
  public ChatColor r = ChatColor.RED;
  public ChatColor b = ChatColor.BLUE;

  public void onDisable()
  {
    System.out.println("[PlayerTime] Disabled!");
  }

  public void onEnable()
  {
    System.out.println("[PlayerTime] Enabled!");
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    Player p = (Player) sender;
    
    if (cmd.getName().equalsIgnoreCase("time")) {
      if (args.length == 0) {
    	  if(p.hasPermission("playertime.time")) {
    	        p.sendMessage(b + "}---- PlayerTime help ----{");
    	        p.sendMessage(g + "/time day" + b + " - Sets your time to day.");
    	        p.sendMessage(g + "/time night" + b + " - Sets your time to night.");
    	        p.sendMessage(g + "/tid morning" + b + " - Sets your time to morning.");
    	        p.sendMessage(g + "/time reset" + b + " - Sets your time to the normal server-time.");
    	        p.sendMessage(g + "/time info" + b + " - Shows you information about the time.");
    	        return true;  
    	  }
      }if (args.length == 1) {
        if (args[0].equalsIgnoreCase("day")) {
        	if(p.hasPermission("playertime.day")) {
                p.setPlayerTime(6000L, false);
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to day.");
                return true;	
        	}
        }if (args[0].equalsIgnoreCase("night")) {
        	if(p.hasPermission("playertime.night")) {
                p.setPlayerTime(18000L, false);
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to night.");
                return true;
        	}
        }if (args[0].equalsIgnoreCase("morning")) {
        	if(p.hasPermission("playertime.morning")) {
                p.setPlayerTime(0L, false);
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to morning.");
                return true;
        	}
        }if (args[0].equalsIgnoreCase("dawn")) {
        	if(p.hasPermission("playertime.dawn")) {
                p.setPlayerTime(12000L, false);
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to dawn.");
                return true;
        	}
        }if (args[0].equalsIgnoreCase("reset")) {
        	if(p.hasPermission("playertime.reset")) {
                p.resetPlayerTime();
                p.sendMessage(g + "[PlayerTime] " + r + "You set your time to the normal server-time.");
                return true;
        	}
        }if (args[0].equalsIgnoreCase("info")) {
        	if(p.hasPermission("playertime.info")) {
        		p.sendMessage(r + "Your time is set on " + g + p.getPlayerTime() + r + ". The difference between the servertime and playertime is " + this.g + p.getPlayerTimeOffset() + this.r + ".");
                return true;
        	}
        }
      }
    }
    return true;
  }
}