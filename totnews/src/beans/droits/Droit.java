package beans.droits;

public enum Droit {
	ADMNINISTRATEUR,
	MODERATEUR,
	CORRECTEUR,
	UTILISATEUR;
	
	public String toString() {
		String s = null;
		if (this==Droit.ADMNINISTRATEUR) {
			s = "Administrateur";
		} else if (this==Droit.CORRECTEUR) {
			s = "Correcteur";
		} else if (this==Droit.MODERATEUR) {
			s = "Moderateur";
		} else if (this==Droit.UTILISATEUR) {
			s = "Utilisateur";
		}
		return s;
	}
}
