package com.testing.seceresantapage.learn.seceretsanta.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class playerCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private PlayerRepository db;
	
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
			db.save(new Player(1, "Nitin", "8210444329","Chapra"));
			db.save(new Player(2, "Saurav", "8210444329","Chapra"));
			db.save(new Player(3, "Golu", "8210444329","Chapra"));
			
			
			
			
			

		
	}

}
