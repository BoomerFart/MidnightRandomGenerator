package nameGen;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;
//import java.io.FileReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
//import java.io.BufferedReader;


public class Runner{
	/*TODO:
	 * Look into making Members and Units accept files so they're easier to keep track of
	 */
	public static void main(String[] args)throws IOException {
		//variables
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		File mem = new File("members.csv");
		File un = new File("units.csv");
		
		//Import members.csv
		Scanner fileMem = new Scanner(mem);
		ArrayList<String> members = new ArrayList<String>();
		
		while(fileMem.hasNextLine()) {
			members.add(fileMem.nextLine());
		}
		fileMem.close();
		//String[] membersArray = {"Boomer","Iowned","KidClutch","Kacchan","Kashichi","CrowLeyZz","Milla","creati","Krau","Trafalgar Law","Merxzzz","Banagher","JmMacz","Kagami","Abama","Krawless","Kenpachira","Dremaker","Ayanokouji","JEduardo564","IsaccRecord","Isackhero","Miki","Argenfreak","khryzthyan","Boredom","Krolm","Zaraki","ZhadeWolf","VICKY02", "David","Float","jdow","kegclap","Maleaha","Mathz","Rolando","silverCloud","sirAnek","SMAAAASH","SonLucas","Uzui","Yoshyzin","Pacboy" };
		//members = new ArrayList<String>(Arrays.asList(membersArray));
		
		
		//Import units.csv
		Scanner fileUn = new Scanner(un);
		fileUn.useDelimiter(",");
		//System.out.println("fileUn.hasNextLine: "+ fileUn.hasNextLine());
		ArrayList<CharacterUnit> unitList = new ArrayList<CharacterUnit>();
		while(fileUn.hasNextLine()) {
			String line = fileUn.nextLine();
			String[] delim = line.split("\\,");
			String n = delim[0];
			String p = delim[1];
			CharacterUnit newChar = new CharacterUnit(n,p);
			unitList.add(newChar);
			
			
}
		fileUn.close();
		/*for(int i = 0;i<unitList.size();i++){
		System.out.println("Unit list:\n"+unitList.get(i).getWritable());
		}
		*/

		
		//class 1-A units that are more easily available
		String[] warunits = {"Ochaco","Kirishima","Kaminari","Deku","Ojiro","Tokoyami","Iida","Froppy","Mineta","All Might","Todoroki","Bakugo","Momo","Mina"};
		int warUnitCount = warunits.length;
		char retry;
		//System.out.println(memberCount);
		
		//Main Code
		do {
		System.out.println("Program use?\nValid answers member - selects a random alliance member\nunit - selects random unit from units list\nwar - selects a Random alliance member and outputs list of backup units.\nadd - add a new member or unit to existing list\nremove - remove member or unit from existing list");
		String resp = s.nextLine();
		resp = resp.toUpperCase();
		
		switch(resp) {
		case "MEMBER":
			/* create array with all the names of members then use random function to select a random name and print that name*/
						System.out.println(randSelectMemb(members, r, members.size()));
			break;
			
		case "UNIT":
			/*use units array and random function to select random unit*/
			System.out.println(randSelectUnit(unitList, r, unitList.size()).getName());
			break;
			
			
		case "WAR":
			warFunction(members, warunits, unitList, r, members.size(), warUnitCount, s);
			break;
		
		
		case "ADD":
			
			String change;
			String name;
			char repeat = 'y';
			
			System.out.println("Add a unit or a member of the Alliance? Valid answers member, unit");
			change = s.nextLine();
			change = change.toUpperCase();
			System.out.println(change);
			switch(change) {
				
			case "MEMBER":
				FileWriter wr = new FileWriter(mem);
				BufferedWriter bw = new BufferedWriter(wr);
				do {
					
						System.out.print("Input name(case sensitive): ");
						name = s.nextLine();
						members.add(name);
						System.out.print(name);
						System.out.println(" added to members list. Add another member? y/n");
						repeat = s.nextLine().charAt(0);	
				}while(repeat == 'y');
				for(int i = 0;i<members.size(); i++) {
					bw.write(members.get(i));
					bw.newLine();
				}
				bw.close();
				wr.close();
						break;
		
						
			
			case "UNIT":
				FileWriter wrUnit = new FileWriter(un);
				BufferedWriter bwUnit = new BufferedWriter(wrUnit);
				do {
					System.out.print("Input name(case sensitive): ");
					name = s.nextLine();
					System.out.print("Input Pronoun: ");
					String pronoun = s.nextLine().toLowerCase();
					CharacterUnit addChar = new CharacterUnit(name,pronoun);
					unitList.add(addChar);
					System.out.print(name);
					System.out.println(" added to units list. Add another unit? y/n");
					repeat = s.nextLine().charAt(0);
			}while(repeat == 'y');
			//export file
			for(int i = 0;i<unitList.size()-1; i++) {
				bwUnit.write(unitList.get(i).getWritable());
				bwUnit.newLine();
			}
			bwUnit.write(unitList.get(unitList.size()-1).getWritable());
			bwUnit.close();
			wrUnit.close();
			break;
			
			default:
				System.out.println("Invalid input, exiting.");
			}
			break;
			
		case "REMOVE":
			FileWriter fw = new FileWriter(mem);
			BufferedWriter bwr = new BufferedWriter(fw);
			char repea = 'y';
			System.out.println("Remove a unit or a member of the Alliance? Valid answers member, unit");
			change = s.next();
			change = change.toUpperCase();
			System.out.println(change);
			switch(change) {
				
			case "MEMBER":
				do {
						System.out.println("Current Members List:");
						for(int i = 0; i<members.size()-1; i++) {
							System.out.println(members.get(i));
						}
						System.out.println(members.get(members.size()-1));
						System.out.print("Input name(case sensitive): ");
						name = memNameValidation(s,members);
						members.remove(name); // remove
						System.out.print(name);
						System.out.println(" removed from members list.");
						System.out.println("Remove another member? y/n");
						repea = s.nextLine().charAt(0);
						
			}while(repea == 'y');
			
			for(int i = 0;i<members.size()-1; i++) {
				bwr.write(members.get(i));
				bwr.newLine();
			}
			bwr.write(members.get(members.size()-1));
			bwr.close();
			fw.close();
			break;

			
						
			
			case "UNIT":
				FileWriter wrUnit = new FileWriter(un);
				BufferedWriter bwUnit = new BufferedWriter(wrUnit);
				do {
				System.out.print("Input name: ");
				String n = s.nextLine();
				CharacterUnit removeUnit = charNameValidation(n, unitList, s);
				unitList.remove(removeUnit);  // remove
				System.out.println(removeUnit.getName()+" removed. Remove another unit? y/n");
				repea = s.nextLine().charAt(0);
				}while(repea == 'y');
				for(int i = 0;i<unitList.size()-1; i++) {
					bwUnit.write(unitList.get(i).getWritable());
					bwUnit.newLine();
				}
				bwUnit.write(unitList.get(unitList.size()-1).getWritable());
				bwUnit.close();
				wrUnit.close();
				break;
			
			default:
				System.out.println("Invalid input, exiting.");
		}
			break;
				
	/*	case "VIEW":
		s.nextLine();
			System.out.println("View list for units or a members of the Alliance? Valid answers member, unit");
			change = s.next();
			change = change.toUpperCase();
			System.out.println(change);
			switch(change) {
			case "MEMBER":
				System.out.println(member)
				break;
			
			case "UNIT":
				for(int i = 0; i < units.length-1; i++){
				System.out.print(units[i].getName()+", ");
				}
				System.out.println(units[units.length-1].getName()]
				break;
				
				default:
				System.out.println("Invalid input, exiting.");
			
			*/
			
		default: 
			System.out.println("Read the valid answers list next time dumbass!");
			break;
		}
		System.out.println("Would you like to run again? Y/N");
		retry = s.next().charAt(0);
		retry = Character.toLowerCase(retry);
		s.nextLine();
		}while(retry == 'y'); //do while loop to allow repeating
		
		s.close();
		System.out.println("Goodbye!");
		}

public static String randSelectMemb(ArrayList<String> m, Random r, int memberCount) {
	return m.get(r.nextInt(memberCount));
	
}

public static CharacterUnit randSelectUnit(ArrayList<CharacterUnit> c, Random r, int unitCount) {
	return c.get(r.nextInt(unitCount));
}

public static void warFunction(ArrayList<String> m, String[] w, ArrayList<CharacterUnit> c, Random r, int memberCount, int warUnitCount, Scanner s) {
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

public static CharacterUnit charNameValidation(String n, ArrayList<CharacterUnit> c, Scanner s) {
	CharacterUnit name = new CharacterUnit("","");
	String f;
	for(int i = 0; i < c.size(); i++) {
		if(n.equals(c.get(i).getName())) {
			name = c.get(i);
			break;
		}
	}
	if(name.getName().equals("")) {
		System.out.print("Invalid Name. Valid names include:\n");
		for(int i = 0; i < c.size()-1; i++) {
			System.out.print(c.get(i).getName()+", ");
		}
		System.out.println(c.get(c.size()-1).getName()+"\nPlease input a valid name.");
		f = s.nextLine();
		name = charNameValidation(f, c, s);
	}
	return name;
}

public static String memNameValidation(Scanner s, ArrayList<String> m) {
	String name = s.nextLine();
	boolean match = false;
	do {
		for(int i = 0; i<m.size(); i++) {
			if(name.equals(m.get(i))) {
				match = true;
				
				break;
		}
		}
			if(match == false) {
				System.out.println("Name " + name + " was not found. Please input a name from the list.(This is case sensitive):");	
				name= s.nextLine();
			}
		
	}while(match == false);
	return name;

}

}



