package Patrol.utilities;

import java.util.Random;

public class GenerateRandomData {

	public static String getRandomName() {
		String[] indianNames = {
		        "Aarav", "Vivaan", "Aditya", "Sai", "Krishna",
		        "Anaya", "Isha", "Diya", "Meera", "Saanvi"     
		};
        Random random = new Random();
        int index = random.nextInt(indianNames.length);
        return indianNames[index];
    }	
	
}