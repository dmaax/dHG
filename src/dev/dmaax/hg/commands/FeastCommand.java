package dev.dmaax.hg.commands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeastCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("feast")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("§cComando somente para jogadores.");
				return true;
			}
			Player player = (Player) sender;
			if(!player.hasPermission("dhg.comandos.feast")) {
				player.sendMessage("§cSem permissão.");
				return true;
			}
			
			if(args.length != 0) {
				player.sendMessage("Uso correto: /feast");
				return true;
			}
			
			Location playerLoc = player.getLocation();
			World world = playerLoc.getWorld();
			Block block = world.getBlockAt(playerLoc);
			block.setType(Material.WOOD);
			
		}
		return false;
	}

}
