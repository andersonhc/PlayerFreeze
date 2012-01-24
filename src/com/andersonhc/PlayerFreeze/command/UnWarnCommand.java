package com.andersonhc.PlayerFreeze.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.andersonhc.PlayerFreeze.PlayerFreeze;

public class UnWarnCommand implements CommandExecutor {

	private final PlayerFreeze plugin;

	//Constructor
	public UnWarnCommand (PlayerFreeze plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (args.length == 0) return false;
		if (args.length > 1) return false;
		
		//unwarn all or unfreeze all
		if (args[0].equalsIgnoreCase("all")) {
			if (commandLabel.equalsIgnoreCase("unfreeze")) {
				plugin.unFreezeAll(sender);
			} else {
				plugin.unWarnAll(sender);
			}
			return true;
		}

		//unwarn player or unfreeze player
		String warnedUser = plugin.findWarnedPlayer(args[0]);
		
		if (warnedUser == null) {
			sender.sendMessage(ChatColor.BLUE + "Player " + ChatColor.AQUA + args[0] + ChatColor.BLUE + plugin.getString("GENERAL_INVALID_PLAYER"));
		} else {
			plugin.unWarn(sender, warnedUser);
		}
		return true;
	}

}
