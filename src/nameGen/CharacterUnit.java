package nameGen;

public class CharacterUnit {
	private String name;
	private String pronoun;
	
	CharacterUnit(String n, String p){
		name = n;
		pronoun = p;
	}
	
	public String getName() {
		return name;
	}
	public String getPronoun() {
		return pronoun;
	}
	
	public String getWritable() {
		String r = name + "," + pronoun;
		return r;
	}

}
