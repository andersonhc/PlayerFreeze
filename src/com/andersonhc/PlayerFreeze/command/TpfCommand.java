package com.andersonhc.PlayerFreeze.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.andersonhc.PlayerFreeze.PlayerFreeze;
import com.andersonhc.PlayerFreeze.PlayerFreeze.PluginPermission;

public class TpfCommand implements CommandExecutor {
	private final PlayerFreeze plugin;

	//Constructor
	public TpfCommand (PlayerFreeze plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (args.length != 1) return false;
		
		Player player = null;
		if (sender instanceof Player) {
			player = (Player)sender;
		} else {
			sender.sendMessage(plugin.getString("GENERAL_NO_CONSOLE"));
		}
		
		if (!plugin.hasPermission(sender, PluginPermission.FREEZE)) {
			player.sendMessage(ChatColor.BLUE + plugin.getString("GENERAL_NO_PERMISSION"));
		}
		
		Player warned = plugin.findOnlinePlayer(args[0]);
		
		if (warned == null ) {
			player.sendMessage(ChatColor.BLUE + "Player " + ChatColor.AQUA + args[0] + ChatColor.BLUE + plugin.getString("GENERAL_INVALID_PLAYER"));
			return true;
		}
		
		if (plugin.isListed(warned)) {
			plugin.setLocation(warned.getName(), player.getLocation());
			warned.teleport(player.getLocation());
		} else {
			player.sendMessage(ChatColor.BLUE + "Player " + ChatColor.AQUA + args[0] + ChatColor.BLUE + plugin.getString("UNFREEZE_NOT_FROZEN"));
		}
		return true;

	}

}
