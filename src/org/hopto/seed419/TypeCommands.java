/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hopto.seed419;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author seed419
 */
public class TypeCommands extends JavaPlugin {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // If the command is equal to tc or typecommand
        if (label.equalsIgnoreCase("tc") || label.equalsIgnoreCase("typecommand")) {

            //Create a new StringBuilder object - This is in case the command has multiple arguments.
            //IE /use item 34 player
            //or something like that...
            StringBuilder sb = new StringBuilder();

            //Append all strings the player typed to one string using a for loop and a stringbuilder.
            for (String x : args) {
                sb.append(x);
            }

            //If the sender is a player, broadcast the message in this fashion..
            if (sender instanceof Player) {
                Player player = (Player) sender;
                getServer().broadcastMessage(ChatColor.YELLOW + "Command: " + ChatColor.WHITE + sb.toString());
                return true;

               //If the sender isn't a player, let's pretend to be the server!
            } else {
                getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[Server] " + sb.toString());
                return true;
            }
        }
        //If the command wasn't tc or typecommand - we don't care about it!
        return false;
    }
}
