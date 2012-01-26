package com.andersonhc.PlayerFreeze;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import com.andersonhc.PlayerFreeze.PlayerFreeze;

public class PlayerFreezeListener implements Listener {
	
	private final PlayerFreeze plugin;

	public PlayerFreezeListener(PlayerFreeze instance) {
		plugin = instance;
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (plugin.isListed(event.getPlayer().getName())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlockDamage(BlockDamageEvent event) {
		if (plugin.isListed(event.getPlayer().getName())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if (plugin.isListed(event.getPlayer().getName())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player frozen = event.getPlayer();
		if (plugin.isListed(frozen.getName())) {
			frozen.teleport(plugin.getLocation(frozen));
		} 
	}
	
	@EventHandler
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

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if (plugin.isListed(event.getPlayer())) {
			plugin.ReNotifyPlayer(event.getPlayer());
		}
	}

}
