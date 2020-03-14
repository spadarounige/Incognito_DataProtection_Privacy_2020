package incognito;

public class Table {

	private String birthday;
	private String sex;
	private String zipcode;
	private String nazionalita;
	private String statoCivile;
	private String titoloStudio;
	private String professione;
	private String figli;
	private String stipendio;
	
		
	
	public Table(String birthday, String sex, String zipcode, String nazionalita,String figli, String statoCivile,
			String titoloStudio, String professione, String stipendio) {
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.statoCivile = statoCivile;
		this.titoloStudio = titoloStudio;
		this.professione = professione;
		this.figli = figli;
		this.stipendio = stipendio;
	}
	
	public Table(String birthday, String sex, String zipcode, String nazionalita,String figli, String statoCivile,
			String titoloStudio, String professione) {
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.statoCivile = statoCivile;
		this.titoloStudio = titoloStudio;
		this.professione = professione;
		this.figli = figli;
		this.stipendio = null;
	}
	public Table(String birthday, String sex, String zipcode, String nazionalita,String figli, String statoCivile,
			String titoloStudio) {
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.statoCivile = statoCivile;
		this.titoloStudio = titoloStudio;
		this.professione = null;
		this.figli = figli;
		this.stipendio = null;
	}
	public Table(String birthday, String sex, String zipcode, String nazionalita,String figli, String statoCivile) {
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.statoCivile = statoCivile;
		this.titoloStudio = null;
		this.professione = null;
		this.figli = figli;
		this.stipendio = null;
	}
	public Table(String birthday, String sex, String zipcode, String nazionalita,String figli) {
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.statoCivile = null;
		this.titoloStudio = null;
		this.professione = null;
		this.figli = figli;
		this.stipendio = null;
	}
	public Table(String birthday, String sex, String zipcode, String nazionalita) {
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.statoCivile = null;
		this.titoloStudio = null;
		this.professione = null;
		this.figli = null;
		this.stipendio = null;
	}
	public Table(String birthday, String sex, String zipcode) {
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = null;
		this.statoCivile = null;
		this.titoloStudio = null;
		this.professione = null;
		this.figli = null;
		this.stipendio = null;
	}
	public Table(String birthday, String sex) {
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = null;
		this.nazionalita = null;
		this.statoCivile = null;
		this.titoloStudio = null;
		this.professione = null;
		this.figli = null;
		this.stipendio = null;
	}
	public Table(String birthday) {
		this.birthday = birthday;
		this.sex = null;
		this.zipcode = null;
		this.nazionalita = null;
		this.statoCivile = null;
		this.titoloStudio = null;
		this.professione = null;
		this.figli = null;
		this.stipendio = null;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public String getNazionalita() {
		return nazionalita;
	}



	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}



	public String getStatoCivile() {
		return statoCivile;
	}



	public void setStatoCivile(String statoCivile) {
		this.statoCivile = statoCivile;
	}



	public String getTitoloStudio() {
		return titoloStudio;
	}



	public void setTitoloStudio(String titoloStudio) {
		this.titoloStudio = titoloStudio;
	}



	public String getProfessione() {
		return professione;
	}



	public void setProfessione(String professione) {
		this.professione = professione;
	}



	public String getFigli() {
		return figli;
	}



	public void setFigli(String figli) {
		this.figli = figli;
	}



	public String getStipendio() {
		return stipendio;
	}



	public void setStipendio(String stipendio) {
		this.stipendio = stipendio;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((figli == null) ? 0 : figli.hashCode());
		result = prime * result + ((nazionalita == null) ? 0 : nazionalita.hashCode());
		result = prime * result + ((professione == null) ? 0 : professione.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((statoCivile == null) ? 0 : statoCivile.hashCode());
		result = prime * result + ((stipendio == null) ? 0 : stipendio.hashCode());
		result = prime * result + ((titoloStudio == null) ? 0 : titoloStudio.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (figli == null) {
			if (other.figli != null)
				return false;
		} else if (!figli.equals(other.figli))
			return false;
		if (nazionalita == null) {
			if (other.nazionalita != null)
				return false;
		} else if (!nazionalita.equals(other.nazionalita))
			return false;
		if (professione == null) {
			if (other.professione != null)
				return false;
		} else if (!professione.equals(other.professione))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (statoCivile == null) {
			if (other.statoCivile != null)
				return false;
		} else if (!statoCivile.equals(other.statoCivile))
			return false;
		if (stipendio == null) {
			if (other.stipendio != null)
				return false;
		} else if (!stipendio.equals(other.stipendio))
			return false;
		if (titoloStudio == null) {
			if (other.titoloStudio != null)
				return false;
		} else if (!titoloStudio.equals(other.titoloStudio))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Table [birthday=" + birthday + ", sex=" + sex + ", zipcode=" + zipcode + ", nazionalita=" + nazionalita
				+ ", statoCivile=" + statoCivile + ", titoloStudio=" + titoloStudio + ", professione=" + professione
				+ ", figli=" + figli + ", stipendio=" + stipendio + "]\n";
	}

	public String toFileRecord() {
		return birthday + "," + sex + "," + zipcode + "," + nazionalita + "," + figli + "," + statoCivile + "," + titoloStudio
				+ "," + professione + "," + stipendio+"\n";
	}
	
}
