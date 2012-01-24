package com.andersonhc.PlayerFreeze.listener;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.andersonhc.PlayerFreeze.PlayerFreeze;

public class PlayerFreezeBlockListener extends BlockListener {
	
	private final PlayerFreeze plugin;

	public PlayerFreezeBlockListener(PlayerFreeze instance) {
		plugin = instance;
	}

	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		if (plugin.isListed(event.getPlayer().getName())) {
			event.setCancelled(true);
		}
	}

	@Override
	public void onBlockDamage(BlockDamageEvent event) {
		if (plugin.isListed(event.getPlayer().getName())) {
			event.setCancelled(true);
		}
	}

	@Override
	public void onBlockPlace(BlockPlaceEvent event) {
		if (plugin.isListed(event.getPlayer().getName())) {
			event.setCancelled(true);
		}
	}
}
