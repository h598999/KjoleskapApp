package HjelpeKlasser;

public class displayNameTranslation {

	private String de;
	private String fr;
	private String it;
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getFr() {
		return fr;
	}
	public void setFr(String fr) {
		this.fr = fr;
	}
	public String getIt() {
		return it;
	}
	public void setIt(String it) {
		this.it = it;
	}
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	private String en;
	
	public String toString() {
		String str = "de: " + de + "," + "\n" + "fr: "+ fr + "," + "\n" + "it: "  + it;
		return str;
	}
	
}
