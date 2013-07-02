package com.dre.brewery;

import java.util.Map;
import java.util.HashMap;

import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.configuration.ConfigurationSection;

import com.dre.brewery.Brew;

public class BPlayer {
	public static Map<String, BPlayer> players = new HashMap<String, BPlayer>();// Players name and BPlayer
	private static Map<Player, Integer> pTasks = new HashMap<Player, Integer>();// Player and count
	private static int taskId;
	public static int pukeItemId;

	private int quality = 0;// = quality of drunkeness * drunkeness
	private int drunkeness = 0;// = amount of drunkeness
	private boolean passedOut = false;// if kicked because of drunkeness
	private int offlineDrunk = 0;// drunkeness when gone offline
	private Vector push = new Vector(0, 0, 0);
	private int time = 20;

	public BPlayer() {
	}

	// reading from file
	public BPlayer(String name, int quality, int drunkeness, int offlineDrunk, Boolean passedOut) {
		this.quality = quality;
		this.drunkeness = drunkeness;
		this.offlineDrunk = offlineDrunk;
		this.passedOut = passedOut;
		players.put(name, this);
	}

	public static BPlayer get(String name) {
		if (!players.isEmpty()) {
			if (players.containsKey(name)) {
				return players.get(name);
			}
		}
		return null;
	}

	/*public String getPlayerName() {
		for (Map.Entry<String,BPlayer> entry : players.entrySet()) {
			if (entry.getValue() == this) {
				return entry.getKey();
			}
		}
		return null;
	}

	public Player getPlayer() {
		return org.bukkit.Bukkit.getPlayer(getPlayerName());
	}*/

	public static Player getPlayer(String name) {
		return org.bukkit.Bukkit.getPlayer(name);
	}

	// returns true if drinking was successful
	public static boolean drink(int uid, Player player) {
		Brew brew = Brew.get(uid);
		if (brew != null) {
			int brewAlc = brew.calcAlcohol();
			if (brewAlc == 0) {
				//no alcohol so we dont need to add a BPlayer
				addBrewEffects(brew, player);
				return true;
			}
			BPlayer bPlayer = get(player.getName());
			if (bPlayer == null) {
				bPlayer = new BPlayer();
				players.put(player.getName(), bPlayer);
			}
			bPlayer.drunkeness += brewAlc;
			bPlayer.quality += brew.getQuality() * brewAlc;

			if (bPlayer.drunkeness <= 100) {

				addBrewEffects(brew, player);
				if (brew.getQuality() < 5) {
					addQualityEffects(brew.getQuality(), brewAlc, player);
				}

			} else {
				if (P.p.getConfig().getBoolean("enableKickOnOverdrink", false)) {
					bPlayer.passOut(player);
				} else {
					bPlayer.quality = bPlayer.getQuality() * 100;
					bPlayer.drunkeness = 100;
					addPuke(player, 60 + (int) (Math.random() * 60));
					P.p.msg(player, "Du kannst nicht mehr trinken");
				}
			}
			P.p.msg(player, "Du bist nun " + bPlayer.drunkeness + "% betrunken, mit einer Qualität von " + bPlayer.getQuality());
			return true;
		}
		return false;
	}

	// push the player around if he moves
	public static void playerMove(PlayerMoveEvent event) {
		BPlayer bPlayer = get(event.getPlayer().getName());
		if (bPlayer != null) {
			bPlayer.move(event);
		}
	}

	// player is drunk
	public void move(PlayerMoveEvent event) {
		// has player more alc than 10
		if (drunkeness >= 10) {
			if (drunkeness <= 100) {
				if (time > 1) {
					time--;
				} else {
					// Is he moving
					if (event.getFrom().getX() != event.getTo().getX() || event.getFrom().getZ() != event.getTo().getZ()) {
						Player player = event.getPlayer();
						Entity entity = (Entity) player;
						// not in midair
						if (entity.isOnGround()) {
							time--;
							if (time == 0) {
								// push him only to the side? or any direction
								// like now
								push.setX(Math.random() - 0.5);
								push.setZ(Math.random() - 0.5);
								player.setVelocity(push);
							} else if (time < 0 && time > -10) {
								// push him some more in the same direction
								player.setVelocity(push);
							} else {
								// when more alc, push him more often
								time = (int) (Math.random() * (201.0 - (drunkeness * 2)));
							}
						}
					}
				}
			}
		}
	}

	public void passOut(Player player) {
		player.kickPlayer("Du hast zu viel getrunken und bist in Ohnmacht gefallen!");
		offlineDrunk = drunkeness;
		passedOut = true;
	}

	// can the player login or is he too drunk
	public int canJoin() {
		if (drunkeness <= 30) {
			return 0;
		}
		if (P.p.getConfig().getBoolean("enableLoginDisallow", false) == false) {
			if (drunkeness <= 100) {
				return 0;
			} else {
				return 3;
			}
		}
		if (drunkeness <= 50) {
			if ((Math.random() > 0.3 && !passedOut) || Math.random() > 0.5) {
				return 0;
			} else {
				return 1;
			}
		}
		if (drunkeness <= 70) {
			if(!passedOut) {
				if (Math.random() > 0.5) {
					return 0;
				} else {
					return 1;
				}
			}
		}
		if (drunkeness <= 100) {
			if (!passedOut) {
				if (Math.random() > 0.8) {
					return 0;
				} else {
					return 2;
				}
			}
		}
		return 3;
	}

	// player joins
	public void join(final Player player) {
		if (offlineDrunk == 0) {
			return;
		}
		// delayed login event as the player is not fully accessible pre login
		P.p.getServer().getScheduler().runTaskLater(P.p, new Runnable() {
			public void run() {
				login(player);
			}
		}, 1L);
	}

	// he may be having a hangover
	public void login(final Player player) {
		if (drunkeness < 10) {
			if (offlineDrunk > 60) {
				if (P.p.getConfig().getBoolean("enableHome", false)) {
					goHome(player);
				}
			}
			hangoverEffects(player);
			// wird der spieler noch gebraucht?
			players.remove(player.getName());

		} else if (offlineDrunk - drunkeness >= 20) {
			// do some random teleport later
		}

		offlineDrunk = 0;
	}

	public void goHome(final Player player) {
		String homeType = P.p.getConfig().getString("homeType", null);
		if (homeType != null) {
			Location home = null;
			if (homeType.equalsIgnoreCase("bed")) {
				home = player.getBedSpawnLocation();
			} else if (homeType.equalsIgnoreCase("ManagerXL")) {
				if (com.dre.managerxl.MPlayer.get(player.getName()) != null) {
					home = com.dre.managerxl.MPlayer.get(player.getName()).getHome();
				}
			} else if (homeType.startsWith("cmd: ")) {
				player.performCommand(homeType.substring(5));
			} else if (homeType.startsWith("cmd:")) {
				player.performCommand(homeType.substring(4));
			} else {
				P.p.errorLog("Config.yml 'homeType: " + homeType + "' unknown!");
			}
			if (home != null) {
				player.teleport(home);
			}
		}
	}

	public void hangoverEffects(final Player player) {
		int duration = offlineDrunk * 50 * getHangoverQuality();
		int amplifier = getHangoverQuality() / 3;

		PotionEffectType.SLOW.createEffect(duration, amplifier).apply(player);
		PotionEffectType.HUNGER.createEffect(duration, amplifier).apply(player);
	}

	// Chance that players puke on big drunkeness
	// runs every 6 sec, average chance is 10%, so should puke about every 60 sec
	// good quality can decrease the chance by up to 10%
	public void drunkPuke(Player player) {
		if (drunkeness >= 80) {
			if (drunkeness >= 90) {
				if (Math.random() < 0.15 - (getQuality() / 100)) {
					addPuke(player, 20 + (int) (Math.random() * 40));
				}
			} else {
				if (Math.random() < 0.08 - (getQuality() / 100)) {
					addPuke(player, 10 + (int) (Math.random() * 30));
				}
			}
		}
	}

	// make a Player puke "count" items
	public static void addPuke(Player player, int count) {
		if (!P.p.getConfig().getBoolean("enablePuke", false)) {
			return;
		}

		if (pTasks.isEmpty()) {
			taskId = P.p.getServer().getScheduler().scheduleSyncRepeatingTask(P.p, new Runnable() {
				public void run() {
					pukeTask();
				}
			}, 1L, 1L);
		}
		pTasks.put(player, count);
	}

	public static void pukeTask() {
		for (Player player : pTasks.keySet()) {
			puke(player);
			int newCount = pTasks.get(player) - 1;
			if (newCount == 0) {
				pTasks.remove(player);
			} else {
				pTasks.put(player, newCount);
			}
		}
		if (pTasks.isEmpty()) {
			P.p.getServer().getScheduler().cancelTask(taskId);
		}
	}

	public static void puke(Player player) {
		Location loc = player.getLocation();
		Vector direction = loc.getDirection();
		direction.multiply(0.5);
		loc.setY(loc.getY() + 1.5);
		loc.setPitch(loc.getPitch() + 10);
		loc.add(direction);
		Item item = player.getWorld().dropItem(loc, new ItemStack(pukeItemId));
		item.setVelocity(direction);
		item.setPickupDelay(Integer.MAX_VALUE);
	}

	public void drunkEffects(Player player) {
		int duration = 10 - getQuality();
		duration += drunkeness / 2;
		duration *= 20;
		if (duration > 960) {
			duration *= 5;
		} else if (duration < 460) {
			duration = 460;
		}
		PotionEffectType.CONFUSION.createEffect(duration, 0).apply(player);
	}

	public static void addQualityEffects(int quality, int brewAlc, Player player) {
		int duration = 7 - quality;
		duration *= 250;
		PotionEffectType.BLINDNESS.createEffect(duration, 0).apply(player);

		if (brewAlc > 15) {
			duration = 10 - quality;
			duration += brewAlc;
			duration *= 40;
		} else {
			duration = 200;
		}
		PotionEffectType.POISON.createEffect(duration, 0).apply(player);
	}

	public static void addBrewEffects(Brew brew, Player player) {
		if (brew.getEffect() != null) {
			int duration = (brew.getEffectDur() / 8) * brew.getQuality() * 20;
			int amplifier = brew.getQuality() / 3;

			PotionEffectType type = PotionEffectType.getByName(brew.getEffect());
			type.createEffect(duration, amplifier).apply(player);
		}
	}

	public static void drunkeness() {
		for (String name : players.keySet()) {
			BPlayer bplayer = players.get(name);

			if (bplayer.drunkeness > 30) {
				if (bplayer.offlineDrunk == 0) {
					Player player = getPlayer(name);
					if (player != null) {

						bplayer.drunkEffects(player);

						if (P.p.getConfig().getBoolean("enablePuke", false)) {
							bplayer.drunkPuke(player);
						}

					}
				}
			}
		}
	}

	// decreasing drunkeness over time
	public static void onUpdate() {
		if (!players.isEmpty()) {
			int soberPerMin = 2;
			for (String name : players.keySet()) {
				BPlayer bplayer = players.get(name);
				if (bplayer.drunkeness == soberPerMin) {
					// Prevent 0 drunkeness
					soberPerMin++;
				}
				bplayer.quality -= bplayer.getQuality() * soberPerMin;
				bplayer.drunkeness -= soberPerMin;
				if (bplayer.drunkeness > 0) {
					if (bplayer.offlineDrunk == 0) {
						if (getPlayer(name) == null) {
							bplayer.offlineDrunk = bplayer.drunkeness;
						}
					}
				} else if (bplayer.drunkeness <= (-1) * bplayer.offlineDrunk) {
					players.remove(name);
				}
			}
		}
	}

	// save all data
	public static void save(ConfigurationSection config) {
		for (String name : players.keySet()) {
			ConfigurationSection section = config.createSection(name);
			section.set("quality", players.get(name).quality);
			section.set("drunk", players.get(name).drunkeness);
			if (players.get(name).offlineDrunk != 0) {
				section.set("offDrunk", players.get(name).offlineDrunk);
			}
			if (players.get(name).passedOut) {
				section.set("passedOut", true);
			}
		}
	}

	// getter
	public int getDrunkeness() {
		return drunkeness;
	}

	public int getQuality() {
		if (drunkeness == 0) {
			P.p.errorLog("drunkeness should not be 0!");
			return quality;
		}
		return Math.round(quality / drunkeness);
	}

	// opposite of quality
	public int getHangoverQuality() {
		return -getQuality() + 10;
	}

	public int getHangoverProgress() {
		return offlineDrunk + drunkeness;
	}

}