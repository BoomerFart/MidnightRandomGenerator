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
		System.out.println("\n\n"); //spacing to make look prettier :)
		
		while(fileMem.hasNextLine()) {
			members.add(fileMem.nextLine());
		}
		fileMem.close();
		//in case need to reload or some reason
		//String[] membersArray = {"Boomer","Iowned","KidClutch","Kacchan","Kashichi","CrowLeyZz","Milla","creati","Krau","Trafalgar Law","Merxzzz","Banagher","JmMacz","Kagami","Abama","Krawless","Kenpachira","Dremaker","Ayanokouji","JEduardo564","IsaccRecord","Isackhero","Miki","Argenfreak","khryzthyan","Boredom","Krolm","Zaraki","ZhadeWolf","VICKY02", "David","Float","jdow","kegclap","Maleaha","Mathz","Rolando","silverCloud","sirAnek","SMAAAASH","SonLucas","Uzui","Yoshyzin","Pacboy" };
		//members = new ArrayList<String>(Arrays.asList(membersArray));
		
		
		//Import units.csv
		Scanner fileUn = new Scanner(un);
		fileUn.useDelimiter(",");
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
		
		/*for(int i = 0;i<unitList.size();i++){ //DEBUG
		System.out.println("Unit list:\n"+unitList.get(i).getWritable());
		}
		*/

		
		//class 1-A units that are more easily available
		String[] warunits = {"Ochaco","Kirishima","Kaminari","Deku","Ojiro","Tokoyami","Iida","Froppy","Mineta","All Might","Todoroki","Bakugo","Momo","Mina"};
		int warUnitCount = warunits.length;
		char retry;
		
		
		//Main Code
		do {
		System.out.println("\nProgram use?\nValid answers member - selects a random alliance member\nunit - selects random unit from units list\nwar - selects a Random alliance member and outputs list of backup units.\nadd - add a new member or unit to existing list\nremove - remove member or unit from existing list");
		String resp = s.nextLine();
		resp = resp.toUpperCase();
		
		switch(resp) {
		case "MEMBER":
			//create array with all the names of members then use random function to select a random name and print that name
						System.out.println(randSelectMemb(members, r, members.size()));
			break;
			
		case "UNIT":
			//use units array and random function to select random unit
			System.out.println(randSelectUnit(unitList, r, unitList.size()).getName());
			break;
			
			
		case "WAR":
			//use war function to do stuffs
			warFunction(members, warunits, unitList, r, members.size(), warUnitCount, s);
			break;
		
		
		case "ADD":
			//Variables
			String change;
			String name;
			char repeat = 'y';
			
			//Determine if adding to Member or Unit ArrayList
			System.out.println("Add a unit or a member of the Alliance? Valid answers member, unit");
			change = s.nextLine();
			change = change.toUpperCase();
			System.out.println(change);
			switch(change) {
				
			case "MEMBER":
				//File output variables
				FileWriter wr = new FileWriter(mem);
				BufferedWriter bw = new BufferedWriter(wr);
				
				//do while to allow for adding multiple members
				do {
					
						System.out.print("Input name(case sensitive): ");
						name = s.nextLine();
						members.add(name);
						System.out.print(name);
						System.out.println(" added to members list. Add another member? y/n");
						repeat = s.nextLine().charAt(0);	
				}while(repeat == 'y');
				
				//output entire arraylist to file
				for(int i = 0;i<members.size(); i++) {
					bw.write(members.get(i));
					bw.newLine();
				}
				//close scanners for file
				bw.close();
				wr.close();
						break;//End Add:Member
		
						
			
			case "UNIT":
				//File output variables
				FileWriter wrUnit = new FileWriter(un);
				BufferedWriter bwUnit = new BufferedWriter(wrUnit);
				
				//do while to allow for adding multiple units
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
			
			//close scanners for file
			bwUnit.close();
			wrUnit.close();
			break;//End Add:Unit
			
			default:
				System.out.println("Invalid input, exiting.");
			}
			break;//End ADD case
			
		case "REMOVE":
			//Variables
			char repea = 'y';
			
			//Determine if removing from Member or Unit ArrayList
			System.out.println("Remove a unit or a member of the Alliance? Valid answers member, unit");
			change = s.next();
			change = change.toUpperCase();
			System.out.println(change);
			switch(change) {
				
			case "MEMBER":
				//File output variables
				FileWriter fw = new FileWriter(mem);
				BufferedWriter bwr = new BufferedWriter(fw);
				
				//do while to allow for removing multiple members
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
			
			//close scanners for file
			bwr.close();
			fw.close();
			break;//End Remove:Member

			
						
			
			case "UNIT":
				//File output variables
				FileWriter wrUnit = new FileWriter(un);
				BufferedWriter bwUnit = new BufferedWriter(wrUnit);
				
				//do while to allow for removing multiple units
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
				
				//close scanners for file
				bwUnit.close();
				wrUnit.close();
				break;//End Remove:Unit
			
			default:
				System.out.println("Invalid input, exiting.");
		}
			break;//End REMOVE case
				
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
		}//End switch statement
		
		//See if need to run program again
		System.out.println("Would you like to run again? Y/N");
		retry = s.next().charAt(0);
		retry = Character.toLowerCase(retry);
		s.nextLine();
		}while(retry == 'y'); //do while loop to allow repeating
		
		s.close(); // close main scanner
		System.out.println("Goodbye!");
		}
	

	
	
//Use Rand to get a random integer and select member from ArrayList at that location
public static String randSelectMemb(ArrayList<String> m, Random r, int memberCount) {
	return m.get(r.nextInt(memberCount));
	
}

//Use Rand to get a random integer and select unit from ArrayList at that location
public static CharacterUnit randSelectUnit(ArrayList<CharacterUnit> c, Random r, int unitCount) {
	return c.get(r.nextInt(unitCount));
}

//Select random Member(use function from before), select 4/5 random units from the easier/more likely to have list.
public static void warFunction(ArrayList<String> m, String[] w, ArrayList<CharacterUnit> c, Random r, int memberCount, int warUnitCount, Scanner s) {
	ArrayList<String> res1 = new ArrayList<String>();
	String chosen = randSelectMemb(m, r, memberCount);
	System.out.println(chosen);
	
	//while loops making and validating the backup units array.
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
	
	//Display backup units array
	System.out.println("Backup Units to choose:");
	System.out.println(res1);
	
	//Make discord message informing person who was picked they were picked.
	System.out.println("\n@"+chosen+" your name was picked today. Please ping me which unit you would like us to start the war tonight off with. If someone doesnt have the unit you choose, they can pick a unit from the back up units list. The unit you select does not have to be from that list, feel free to choose whoever you want.");
	
	//Get unit chosen(manual entry cuz fuck you that's why). send to unit name validation.
	System.out.println("\nUnit Chosen: ");
	String cString = s.nextLine();
	CharacterUnit cUnit = charNameValidation(cString, c, s);
	
	//Make discord message for group(change the "@Midnight Hero" to whatever tag
	System.out.println("\n@Midnight Hero For those participating in war tonight, please have your first unit be **"+cUnit.getName()+"**, as chosen by **"+chosen+"**. If "+cUnit.getPronoun()+" falls you're free to use whoever you may to avenge your loss. If you don't have **"+cUnit.getName()+"**, please use one of the other recommended \"Backup Units\" from the post above.\n\n\n\n\n");
}

//take input string compare with the CharacterUnit ArrayList's Name values.
public static CharacterUnit charNameValidation(String n, ArrayList<CharacterUnit> c, Scanner s) {
	//Variables
	CharacterUnit name = new CharacterUnit("",""); //set base value for later if loop calling invalid.
	String f;
	
	//goes through array looking for if the name is there.
	for(int i = 0; i < c.size(); i++) {
		if(n.equals(c.get(i).getName())) {
			name = c.get(i);
			break; //if name is there, set the return value and break out of FOR loop because you don't need to keep checking.
		}
	}//end FOR loop searching list
	
	//if name isn't found show the names available.
	if(name.getName().equals("")) {
		System.out.print("Invalid Name. Valid names include:\n");
		for(int i = 0; i < c.size()-1; i++) {
			System.out.print(c.get(i).getName()+", ");
		}
		
		//have name be reinput and recursive call function.
		System.out.println(c.get(c.size()-1).getName()+"\nPlease input a valid name.");
		f = s.nextLine();
		name = charNameValidation(f, c, s); //set return value to be result of this recursive call since it'll have to return a valid value eventually
	}
	return name;
}

//Validate a member's name manually entered is part of array.
public static String memNameValidation(Scanner s, ArrayList<String> m) {
	//Variables
	String name = s.nextLine();
	boolean match = false;
	
	//do-while loop getting match
	do {
		//search array for name to be a match
		for(int i = 0; i<m.size(); i++) {
			if(name.equals(m.get(i))) {
				match = true;
				
				break;
		}//end if loop checking values
		}//end for loop iterating array
		
			if(match == false) {
				System.out.println("Name " + name + " was not found. Please input a name from the list.(This is case sensitive):");	
				name= s.nextLine();
			}
		
	}while(match == false);
	return name;

}

}



