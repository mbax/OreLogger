package com.kdude63.orelogger;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin implements Listener{
	
	FileConfiguration config;
	List<Integer> ores;
	
	
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		if (!new File(this.getDataFolder().getPath() + File.separatorChar + "config.yml").exists())
            saveDefaultConfig();
		config = getConfig();
		ores = config.getIntegerList("OresToCheck");
	}
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e){
		this.getLogger().info(e.getBlock().toString());
		if(ores.contains(e.getBlock())){
			
		}
	}
}