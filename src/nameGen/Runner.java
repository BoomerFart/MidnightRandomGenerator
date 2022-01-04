package nameGen;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class Runner{
	public static void main(String[] args) {
		//variables
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		//fill this array with members from your alliance
		String[] members = {"Boomer","Iowned","KidClutch","Kacchan","Kashichi","CrowLeyZz","Milla","creati","Krau","Trafalgar Law","Merxzzz","Banagher","JmMacz","Kagami","Abama","Krawless","Kenpachira","Dremaker","Ayanokouji","JEduardo564","IsaccRecord","Isackhero","Miki","Argenfreak","khryzthyan","Boredom","Krolm","Zaraki","ZhadeWolf","VICKY02", "David","Float","jdow","kegclap","Maleaha","Mathz","Rolando","silverCloud","sirAnek","SMAAAASH","SonLucas","Uzui","Yoshyzin","Pacboy" };
		int memberCount = members.length;
		//update this array when new units are added. Last updated: WHM Bakugo
		CharacterUnit[] units = {new CharacterUnit("Aizawa","he"),new CharacterUnit("Ochaco","she"),new CharacterUnit("Kirishima","he"),new CharacterUnit("Kaminari","he"),new CharacterUnit("Deku","he"),new CharacterUnit("Ojiro","he"),new CharacterUnit("Endev","he"),new CharacterUnit("Tokoyami","he"),new CharacterUnit("Iida","he"),new CharacterUnit("Froppy","she"),new CharacterUnit("Mineta","he"),new CharacterUnit("All Might","he"),new CharacterUnit("Stain","he"),new CharacterUnit("Todoroki","he"),new CharacterUnit("Bakugo","he"),new CharacterUnit("Momo","she"),new CharacterUnit("Shigaraki","he"),new CharacterUnit("Hawks","he"),new CharacterUnit("Mina","she"),new CharacterUnit("Dabi","he"), new CharacterUnit("WHM Deku","he"),new CharacterUnit("WHM Todoroki", "he"),new CharacterUnit("WHM Bakugo","he")};
		//class 1-A units that are more easily available
		String[] warunits = {"Ochaco","Kirishima","Kaminari","Deku","Ojiro","Tokoyami","Iida","Froppy","Mineta","All Might","Todoroki","Bakugo","Momo","Mina"};
		int unitCount = units.length;
		int warUnitCount = warunits.length;
		//ArrayList<String> units = new ArrayList<String>(); //
		//int unitCount = units.size();
		//String change;
		//String name;
		char retry;
		//System.out.println(memberCount);
		do {
		System.out.println("Program use?\nValid answers member, unit, war");
		String resp = s.next();
		s.nextLine();
		resp = resp.toUpperCase();
		
		switch(resp) {
		case "MEMBER":
			/* create array with all the names of members then use random function to select a random name and print that name*/
						System.out.println(randSelectMemb(members, r, memberCount));
			break;
			
		case "UNIT":
			/*use units array and random function to select random unit*/
			System.out.println(randSelectUnit(units, r, unitCount).getName());
			break;
			
			
		case "WAR":
			warFunction(members, warunits, units, r, memberCount, warUnitCount, s);
			/* **name here** your name was picked today. Please ping me which unit you would like us to start the war tonight off with. If someone doesnt have the unit you choose, they can pick a unit from the back up units list. The unit you select does not have to be from that list, feel free to choose whoever you want.
			 * En Espanol: Su nombre era elegido, digame la personaje quein quiere empieza la guerra con por los otros. Si no tienen la personaje, pueden usar unas de los "Backup Units" de la lista. La personaje quein elegiria no necessitan ser en la lista.
			 * For those participating in war tonight, please have your first unit be **unit**, as chosen by **Name**. If he falls you're free to use whoever you may to avenge your loss. If you don't have **unit**, please use one of the other recommended "Backup Units" from the post above.
			 * No response from **name here** , so random number generator picked **unit**. For those participating in war tonight, please have your first unit be *unit**. If he falls you're free to use whoever you may to avenge your loss.If you don't have *unit**, please use one of the other recommended "Backup Units" from the post above.
			 */
			/*ArrayList<String> res1 = new ArrayList<String>();
			String chosen = randSelectMemb(members, r, memberCount);
			
			System.out.println(chosen);
			
			res1.add(warunits[r.nextInt(warUnitCount)]);
			res1.add(warunits[r.nextInt(warUnitCount)]);
			while(res1.get(0) == res1.get(1)) {
				res1.remove(1);
				res1.add(warunits[r.nextInt(warUnitCount)]);
			}
			res1.add(warunits[r.nextInt(warUnitCount)]);
			while(res1.get(2) == res1.get(1) || res1.get(2) == res1.get(0)) {
				res1.remove(2);
				res1.add(warunits[r.nextInt(warUnitCount)]);
			}
			res1.add(warunits[r.nextInt(warUnitCount)]);
			while(res1.get(3) == res1.get(2)|| res1.get(3) == res1.get(1) || res1.get(3) == res1.get(0)) {
				res1.remove(3);
				res1.add(warunits[r.nextInt(warUnitCount)]);
			}
			res1.add(warunits[r.nextInt(warUnitCount)]);
			while(res1.get(4) == res1.get(3) || res1.get(4) == res1.get(2)|| res1.get(4) == res1.get(1) || res1.get(4) == res1.get(0)) {
				res1.remove(4);
				res1.add(warunits[r.nextInt(warUnitCount)]);
			}
			System.out.println("Backup Units to choose:");
			System.out.println(res1);
			System.out.println("\n@"+chosen+" your name was picked today. Please ping me which unit you would like us to start the war tonight off with. If someone doesnt have the unit you choose, they can pick a unit from the back up units list. The unit you select does not have to be from that list, feel free to choose whoever you want.");
			System.out.println("\nUnit Chosen: ");
			String cUnit = s.next();
			System.out.println("\n@Midnight Hero For those participating in war tonight, please have your first unit be **"+cUnit+"**, as chosen by **"+chosen+"**. If he falls you're free to use whoever you may to avenge your loss. If you don't have **"+cUnit+"**, please use one of the other recommended \"Backup Units\" from the post above.\n\n\n\n\n");
			*/
			break;
		
		
	/*	case "ADD":
			s.nextLine();
			System.out.println("Add a unit or a member of the Alliance? Valid answers member, unit");
			change = s.next();
			change = change.toUpperCase();
			System.out.println(change);
			switch(change) {
			/*	
			case "MEMBER":
						s.nextLine();
						System.out.print("Input name(case sensitive): ");
						name = s.next();
						members.add(name);
						System.out.print(name);
						System.out.println(" added to members list.");
						break;
						/
			
			case "UNIT":
				s.nextLine();
				System.out.print("Input name: ");
				name = s.next();
				units.add(name);
				System.out.print("units list now: ");
				System.out.println(units);
				break;
			
			default:
				System.out.println("Invalid input, exiting.");
			}
		*/
		default: 
			System.out.println("Read the valid answers list next time dumbass!");
			break;
		}
		s.nextLine();
		System.out.println("Would you like to run again? Y/N");
		retry = s.next().charAt(0);
		retry = Character.toLowerCase(retry);
		}while(retry == 'y'); //do while loop to allow repeating
		
		s.close();
		System.out.println("Goodbye!");
		}

public static String randSelectMemb(String[] m, Random r, int memberCount) {
	return m[r.nextInt(memberCount)];
	
}

public static CharacterUnit randSelectUnit(CharacterUnit[] c, Random r, int unitCount) {
	return c[r.nextInt(unitCount)];
}

public static void warFunction(String[] m, String[] w, CharacterUnit[]c, Random r, int memberCount, int warUnitCount, Scanner s) {
	ArrayList<String> res1 = new ArrayList<String>();
	String chosen = randSelectMemb(m, r, memberCount);
	
	System.out.println(chosen);
	
	res1.add(w[r.nextInt(warUnitCount)]);
	res1.add(w[r.nextInt(warUnitCount)]);
	while(res1.get(0) == res1.get(1)) {
		res1.remove(1);
		res1.add(w[r.nextInt(warUnitCount)]);
	}
	res1.add(w[r.nextInt(warUnitCount)]);
	while(res1.get(2) == res1.get(1) || res1.get(2) == res1.get(0)) {
		res1.remove(2);
		res1.add(w[r.nextInt(warUnitCount)]);
	}
	res1.add(w[r.nextInt(warUnitCount)]);
	while(res1.get(3) == res1.get(2)|| res1.get(3) == res1.get(1) || res1.get(3) == res1.get(0)) {
		res1.remove(3);
		res1.add(w[r.nextInt(warUnitCount)]);
	}
	res1.add(w[r.nextInt(warUnitCount)]);
	while(res1.get(4) == res1.get(3) || res1.get(4) == res1.get(2)|| res1.get(4) == res1.get(1) || res1.get(4) == res1.get(0)) {
		res1.remove(4);
		res1.add(w[r.nextInt(warUnitCount)]);
	}
	System.out.println("Backup Units to choose:");
	System.out.println(res1);
	System.out.println("\n@"+chosen+" your name was picked today. Please ping me which unit you would like us to start the war tonight off with. If someone doesnt have the unit you choose, they can pick a unit from the back up units list. The unit you select does not have to be from that list, feel free to choose whoever you want.");
	System.out.println("\nUnit Chosen: ");
	String cString = s.nextLine();
	CharacterUnit cUnit = charNameValidation(cString, c, s);
	System.out.println("\n@Midnight Hero For those participating in war tonight, please have your first unit be **"+cUnit.getName()+"**, as chosen by **"+chosen+"**. If "+cUnit.getPronoun()+" falls you're free to use whoever you may to avenge your loss. If you don't have **"+cUnit.getName()+"**, please use one of the other recommended \"Backup Units\" from the post above.\n\n\n\n\n");
}

public static CharacterUnit charNameValidation(String n, CharacterUnit[] c, Scanner s) {
	CharacterUnit name = new CharacterUnit("","");
	String f;
	for(int i = 0; i < c.length; i++) {
		if(n.equals(c[i].getName())) {
			name = c[i];
			break;
		}
	}
	if(name.getName().equals("")) {
		System.out.print("Invalid Name. Valid names include:\n");
		for(int i = 0; i < c.length-1; i++) {
			System.out.print(c[i].getName()+", ");
		}
		System.out.println(c[c.length-1].getName()+"\nPlease input a valid name.");
		f = s.nextLine();
		System.out.println(f);
		name = charNameValidation(f, c, s);
	}
	return name;
}
}