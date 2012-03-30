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


        // If the command is equal to tc or typecommand - we want to know about it and take action!
        if (label.equalsIgnoreCase("tc") || label.equalsIgnoreCase("typecommand")) {


            /* We create a new StringBuilder object called sb - This is in case the command has multiple arguments.
               IE  "/sethome dog 22"  or something like that.                                          */
            StringBuilder sb = new StringBuilder();


            /* All the seperate arguments a player types after a command like "/sethome dog 22" are separated into an
             * array of strings called args (which is passed then to our onCommand method above).  We want to add
             * everything the player entered in that command to one string using a for loop and a stringbuilder.  We
             * append a space after each argument so it comes out as "/sethome dog 22", and not "/sethomedog22"   */
            for (String x : args) {
                sb.append(x);
                sb.append(" ");
            }


            /* Now we broadcast our message!  We use sb.toString() to turn the Strings our StringBuilder added for us
             * Into a String object!  I Messed with the ChatColors a bit to make it look official.
             */
            getServer().broadcastMessage(ChatColor.YELLOW + "Command: " + ChatColor.WHITE + sb.toString());
            return true;
            //We return true at this point because we've done what we needed to do successfully!

        }
        //If the command wasn't tc or typecommand - we don't care about it!  We return false and nothing happens!
        return false;
    }
}
