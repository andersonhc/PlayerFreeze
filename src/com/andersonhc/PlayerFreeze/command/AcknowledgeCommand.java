package com.andersonhc.PlayerFreeze.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.andersonhc.PlayerFreeze.PlayerFreeze;

public class AcknowledgeCommand implements CommandExecutor {

	private final PlayerFreeze plugin;

	//Constructor
	public AcknowledgeCommand (PlayerFreeze plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		Player player = null;
		if (sender instanceof Player) {
			player = (Player)sender;
		} else {
			sender.sendMessage(plugin.getString("GENERAL_NO_CONSOLE"));
			return true;
		}
		
		if (plugin.isWarned(player)) {
			plugin.unWarn(null, player.getName());
			for (int i = 0; i < plugin.getServer().getOnlinePlayers().length; i++) {
				Player warned = plugin.getServer().getOnlinePlayers()[i];
				if (plugin.isAdmin(warned)) {
					warned.sendMessage(ChatColor.AQUA + player.getDisplayName() + ChatColor.BLUE + plugin.getString("WARN_ACKNOWLEDGE_ADMIN"));
				}
			}
		}
		return true;

	}

}
