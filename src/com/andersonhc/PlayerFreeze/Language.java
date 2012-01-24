package com.andersonhc.PlayerFreeze;

import java.util.HashMap;
import java.util.Map;

public class Language {

	private final PlayerFreeze plugin;
	private Map<String, String> lang = new HashMap<String, String>();
	
	Language (PlayerFreeze instance) {
		this.plugin = instance;
	}
	
	public void loadLanguage() {
		String language = "english";
		language = plugin.getConfig().getString("PlayerFreeze.options.language", "english");
		
		addString("FREEZE_WARNED_PLAYER", " was warned and is now frozen.", language);
		addString("FREEZE_ALREADY_FROZEN", " is already frozen.", language);
		addString("FREEZE_SUCCESS", " is now frozen.", language);
		addString("FREEZE_NOTIFY_NOMESSAGE", "You are now frozen.", language);
		addString("FREEZE_NOTIFY_MESSAGE", "You are now frozen for ", language);
		addString("FREEZE_STATUS", " is frozen.", language);
		addString("WARN_ALREADY_FROZEN", " is frozen.", language);
		addString("WARN_ALREADY_WARNED", " is already warned.", language);
		addString("WARN_SUCCESS", " is now warned.", language);
		addString("WARN_NOTIFY_NOMESSAGE", "You have been warned.", language);
		addString("WARN_NOTIFY_MESSAGE", "You have been warned for ", language);
		addString("WARN_ACKNOWLEDGE_PLAYER", "You have acknowledged your warning.", language);
		addString("WARN_ACKNOWLEDGE_ADMIN", " has acknowledged his warning.", language);
		addString("WARN_STATUS", " is warned.", language);
		addString("UNWARN_SUCCESS_PLAYER", "You have been unwarned.", language);
		addString("UNWARN_SUCCESS_ADMIN", " has been freed.", language);
		addString("UNWARN_NO_PERMISSION", "You don t have permission to unwarn this player.", language);
		addString("UNFREEZE_SUCCESS_PLAYER", "You have been unfrozen.", language);
		addString("UNFREEZE_SUCCESS_ADMIN", " has been freed.", language);
		addString("UNFREEZE_NO_PERMISSION", "You don t have permission to unfreeze this player.", language);
		addString("UNFREEZE_NOT_FROZEN", " is not frozen.", language);
		addString("GENERAL_NO_PERMISSION", "Permission denied.", language);
		addString("GENERAL_NO_CONSOLE", "This command cannot be issued by console.", language);
		addString("GENERAL_INVALID_PLAYER", " not found.", language);
		addString("LIST_AMOUNT_FROZEN", " players frozen.", language);
		addString("LIST_NO_FROZEN", "No frozen players at this moment.", language);
		addString("LIST_AMOUNT_WARNED", " players warned.", language);
		addString("LIST_NO_WARNED", "No warned players at this moment.", language);
		addString("FREEZEALL_NOTIFY_PLAYERS", "All players have been frozen.", language);
		addString("FREEZEALL_NOTIFY_ADMINS", "All players have been frozen by ", language);
		addString("WARNALL_NOTIFY_PLAYERS", "All players have been warned.", language);
		addString("WARNALL_NOTIFY_ADMINS", "All players have been warned by ", language);
		plugin.saveConfig();
	}
	

	private void addString(String key, String def, String language) {
		setString(key, plugin.getConfig().getString("PlayerFreeze.Strings." + language + "." + key, def));
		plugin.getConfig().set("PlayerFreeze.Strings." + language + "." + key, def);
	}

	public String getString(String key) {
		return lang.get(key);
	}

	public void setString(String key, String value) {
		lang.put(key, value);
	}
}
