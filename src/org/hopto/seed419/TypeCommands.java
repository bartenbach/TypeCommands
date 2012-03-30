package org.hopto.seed419;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

// For our main class in a craftbukkit plugin, we want to extend JavaPlugin.
public class TypeCommands extends JavaPlugin {


    // We'll override the 'onCommand' method from craftbukkit because we want to take action when a command has
    // been typed.
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        // If the command is equal to tc or typecommand
        if (label.equalsIgnoreCase("tc") || label.equalsIgnoreCase("typecommand")) {


            /* Create a new StringBuilder object - This is in case the command has multiple arguments.
               IE  /use item 34 player  or something like that...   */
            StringBuilder sb = new StringBuilder();


            /* Append all strings the player typed to one string using a for loop and a stringbuilder.
               We append a space after each argument so it comes out as expected.   */
            for (String x : args) {
                sb.append(x);
                sb.append(" ");
            }


            //If the sender is a player, broadcast the message in this fashion..
            if (sender instanceof Player) {
                getServer().broadcastMessage(ChatColor.YELLOW + "Command: " + ChatColor.WHITE + sb.toString());
                return true;
                //We return true at this point because we're done doing what we need to do.

            //If the sender isn't a player, let's pretend to be the server!
            } else {
                getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[Server] " + sb.toString());
                return true;
                //If this happens, we still return true because we successfully did what we wanted to do.
            }
        }
        //If the command wasn't tc or typecommand - we don't care about it!
        return false;
    }
}
