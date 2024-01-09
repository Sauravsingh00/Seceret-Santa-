package com.testing.seceresantapage.learn.seceretsanta.candidate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Component
public class PlayerController {
	@Autowired
	private PlayerRepository db;
	
	
	@GetMapping("/player")
	public List<Player> allPlayers() {
		System.out.println("##################################Finding All players");
		return db.findAll();
		//return Arrays.asList(new Player(1, "Nitin", "8210444329","Chapra"));
				
	}
	@GetMapping("/player/{id}")
	public Player PlayerDetails(@PathVariable long id) {
		System.out.println("##################Player Details Requested ######$");
		Optional<Player> player = db.findById(id);
		return player.get();
	}
	@PostMapping("/player")
	public void addPlayer(@RequestBody Player player) {
		System.out.println("##############Player Added ##");
		db.save(player);
		
	}
	@PutMapping("/player/{id}")
	public void editPlayerDetails(@PathVariable long id,@RequestBody Player player) {
		System.out.println(" #######Player Detail Edited ");
		
		db.save(player);
	}
	@DeleteMapping("/player/{id}")
	public void DeletePlayer(@PathVariable long id) {
		System.out.println("#############Player Deleted ");
		db.deleteById(id);
	}
	
	@GetMapping("/player/ss")
	public HashMap<String, Player> SeceretSanta(){
		System.out.println("Seceret santa method invoked ..........");
		
		
		HashMap<String, Player> xyz= new HashMap<String, Player>();
		List<Player> abc= db.findAll();
		ArrayList<String> names= new ArrayList<String>();
		ArrayList<Long> ids = new ArrayList<Long>();
		
		for(Player x:abc) {
			names.add(x.getName());
			ids.add(x.getId());
		}
		
		int len = ids.size();
		int ss;
		//Collections.sort(names);
		//Collections.shuffle(ids);
		if(len%2==0) {
		ss=5%len;
		}
		else {
			ss=4%len;
		}
		for(String name:names) {
			xyz.put(name, PlayerDetails(ids.get(ss)));
			ss=(ss+1)%len;
			
		}
		
		
		return xyz;
	}
	
}
