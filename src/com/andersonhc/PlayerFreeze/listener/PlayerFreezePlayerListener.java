package com.andersonhc.PlayerFreeze.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import com.andersonhc.PlayerFreeze.PlayerFreeze;

public class PlayerFreezePlayerListener extends PlayerListener {
	
	private final PlayerFreeze plugin;

	public PlayerFreezePlayerListener(PlayerFreeze instance) {
		plugin = instance;
	}

	public void onPlayerMove(PlayerMoveEvent event) {
		Player frozen = event.getPlayer();
		if (plugin.isListed(frozen.getName())) {
			frozen.teleport(plugin.getLocation(frozen));
		} 
	}
	
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		Player frozen = event.getPlayer();
		if (plugin.isListed(frozen.getName())) {
			if(event.getTo().equals(plugin.getLocation(frozen))) {
				return;
			} else {
				event.setCancelled(true);
			}
		} 
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (plugin.isListed(event.getPlayer())) {
			plugin.ReNotifyPlayer(event.getPlayer());
		}
	}

}