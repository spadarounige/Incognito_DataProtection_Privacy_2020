package incognito;

public class Node {
	
	private int id;
	private int birthday;
	private int sex;
	private int zipcode;
	private int nazionalita;
	private int figli;
	private int statoCivile;
	private int titoloStudio;
	private int professione;
	private int stipendio;
	private int height;
	private boolean mark;
	private int isKAnonyminzated;

	public Node(int id, int birthday, int sex, int zipcode, int nazionalita, int figli, int statoCivile,
			int titoloStudio, int professione, int stipendio) {
		this.id = id;
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.figli = figli;
		this.statoCivile = statoCivile;
		this.titoloStudio = titoloStudio;
		this.professione = professione;
		this.stipendio = stipendio;
		this.height = birthday+sex+zipcode+nazionalita+titoloStudio+professione+stipendio+figli+statoCivile;
		this.mark = false;
		this.isKAnonyminzated = -1;
	}
	public Node(int id, int birthday, int sex, int zipcode, int nazionalita, int figli, int statoCivile,
			int titoloStudio, int professione) {
		this.id = id;
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.figli = figli;
		this.statoCivile = statoCivile;
		this.titoloStudio = titoloStudio;
		this.professione = professione;
		this.height = birthday+sex+zipcode+nazionalita+titoloStudio+professione+figli+statoCivile;
		this.mark = false;
		this.isKAnonyminzated = -1;
	}
	public Node(int id, int birthday, int sex, int zipcode, int nazionalita, int figli, int statoCivile,
			int titoloStudio) {
		this.id = id;
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.figli = figli;
		this.statoCivile = statoCivile;
		this.titoloStudio = titoloStudio;
		this.height = birthday+sex+zipcode+nazionalita+titoloStudio+figli+statoCivile;
		this.mark = false;
		this.isKAnonyminzated = -1;
	}
	public Node(int id, int birthday, int sex, int zipcode, int nazionalita, int figli, int statoCivile) {
		this.id = id;
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.figli = figli;
		this.statoCivile = statoCivile;
		this.height = birthday+sex+zipcode+nazionalita+figli+statoCivile;
		this.mark = false;
		this.isKAnonyminzated = -1;
	}
	public Node(int id, int birthday, int sex, int zipcode, int nazionalita, int figli) {
		this.id = id;
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.figli = figli;
		this.height = birthday+sex+zipcode+nazionalita+figli;
		this.mark = false;
		this.isKAnonyminzated = -1;
	}
	public Node(int id, int birthday, int sex, int zipcode, int nazionalita) {
		this.id = id;
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.nazionalita = nazionalita;
		this.height = birthday+sex+zipcode+nazionalita;
		this.mark = false;
		this.isKAnonyminzated = -1;
	}
	public Node(int id, int birthday, int sex, int zipcode) {
		this.id = id;
		this.birthday = birthday;
		this.sex = sex;
		this.zipcode = zipcode;
		this.height = birthday+sex+zipcode;
		this.mark = false;
		this.isKAnonyminzated = -1;
	}
	public Node(int id, int birthday, int sex) {
		this.id = id;
		this.birthday = birthday;
		this.sex = sex;
		this.height = birthday+sex;
		this.mark = false;
		this.isKAnonyminzated = -1;
	}
	public Node(int id, int birthday) {
		this.id = id;
		this.birthday = birthday;
		this.height = birthday;
		this.mark = false;
		this.isKAnonyminzated = -1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Node other = (Node) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}
	
	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getIsKAnonyminzated() {
		return isKAnonyminzated;
	}

	public void setIsKAnonyminzated(int isKAnonyminzated) {
		this.isKAnonyminzated = isKAnonyminzated;
	}

	public boolean isRoot() {
		boolean isRoot = false;
		if(this.height == 0)
			isRoot = true;
		return isRoot;
	}
	public void mark() {
		this.mark = true;
	}
	
	public int getHeight() {
		return this.height;
	}

	public int getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(int nazionalita) {
		this.nazionalita = nazionalita;
	}

	public int getFigli() {
		return figli;
	}

	public void setFigli(int figli) {
		this.figli = figli;
	}

	public int getStatoCivile() {
		return statoCivile;
	}

	public void setStatoCivile(int statoCivile) {
		this.statoCivile = statoCivile;
	}

	public int getTitoloStudio() {
		return titoloStudio;
	}

	public void setTitoloStudio(int titoloStudio) {
		this.titoloStudio = titoloStudio;
	}

	public int getProfessione() {
		return professione;
	}

	public void setProfessione(int professione) {
		this.professione = professione;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isDirectGeneralization(Node node, int Qi){
		boolean isDirectGeneralization = false;
		if(Qi == 9)
			if(		   (this.birthday		>=	node.getBirthday()		&&
						this.sex			==	node.getSex()			&&
						this.zipcode		==	node.getZipcode()		&&
						this.nazionalita	==	node.getNazionalita()	&&
						this.figli 			==	node.getFigli()			&&
						this.statoCivile	== 	node.getStatoCivile()	&&
						this.stipendio		== 	node.getStipendio()		&&
						this.professione	== 	node.getProfessione()	&&
						this.titoloStudio	==	node.getTitoloStudio())	||
					
						(this.birthday		==	node.getBirthday()		&&
						this.sex			>=	node.getSex()			&&
						this.zipcode		==	node.getZipcode()		&&
						this.nazionalita	==	node.getNazionalita()	&&
						this.figli 			==	node.getFigli()			&&
						this.statoCivile	== 	node.getStatoCivile()	&&
						this.stipendio		== 	node.getStipendio()		&&
						this.professione	== 	node.getProfessione()	&&
						this.titoloStudio	==	node.getTitoloStudio())	||
						
						(this.birthday		==	node.getBirthday()		&&
						this.sex			==	node.getSex()			&&
						this.zipcode		>=	node.getZipcode()		&&
						this.nazionalita	==	node.getNazionalita()	&&
						this.figli 			==	node.getFigli()			&&
						this.statoCivile	== 	node.getStatoCivile()	&&
						this.stipendio		== 	node.getStipendio()		&&
						this.professione	== 	node.getProfessione()	&&
						this.titoloStudio	==	node.getTitoloStudio())	||
						
						(this.birthday		==	node.getBirthday()		&&
						this.sex			==	node.getSex()			&&
						this.zipcode		==	node.getZipcode()		&&
						this.nazionalita	>=	node.getNazionalita()	&&
						this.figli 			==	node.getFigli()			&&
						this.statoCivile	== 	node.getStatoCivile()	&&
						this.stipendio		== 	node.getStipendio()		&&
						this.professione	== 	node.getProfessione()	&&
						this.titoloStudio	==	node.getTitoloStudio())	||
						
						(this.birthday		==	node.getBirthday()		&&
						this.sex			==	node.getSex()			&&
						this.zipcode		==	node.getZipcode()		&&
						this.nazionalita	==	node.getNazionalita()	&&
						this.figli 			>=	node.getFigli()			&&
						this.statoCivile	== 	node.getStatoCivile()	&&
						this.stipendio		== 	node.getStipendio()		&&
						this.professione	== 	node.getProfessione()	&&
						this.titoloStudio	==	node.getTitoloStudio())	||
						
						(this.birthday		==	node.getBirthday()		&&
						this.sex			==	node.getSex()			&&
						this.zipcode		==	node.getZipcode()		&&
						this.nazionalita	==	node.getNazionalita()	&&
						this.figli 			==	node.getFigli()			&&
						this.statoCivile	>= 	node.getStatoCivile()	&&
						this.stipendio		== 	node.getStipendio()		&&
						this.professione	== 	node.getProfessione()	&&
						this.titoloStudio	==	node.getTitoloStudio())	||
						
						(this.birthday		==	node.getBirthday()		&&
						this.sex			==	node.getSex()			&&
						this.zipcode		==	node.getZipcode()		&&
						this.nazionalita	==	node.getNazionalita()	&&
						this.figli 			==	node.getFigli()			&&
						this.statoCivile	== 	node.getStatoCivile()	&&
						this.stipendio		>= 	node.getStipendio()		&&
						this.professione	== 	node.getProfessione()	&&
						this.titoloStudio	==	node.getTitoloStudio())	||
						
						(this.birthday		==	node.getBirthday()		&&
						this.sex			==	node.getSex()			&&
						this.zipcode		==	node.getZipcode()		&&
						this.nazionalita	==	node.getNazionalita()	&&
						this.figli 			==	node.getFigli()			&&
						this.statoCivile	== 	node.getStatoCivile()	&&
						this.stipendio		== 	node.getStipendio()		&&
						this.professione	>= 	node.getProfessione()	&&
						this.titoloStudio	==	node.getTitoloStudio())	||
						
						(this.birthday		==	node.getBirthday()		&&
						this.sex			==	node.getSex()			&&
						this.zipcode		==	node.getZipcode()		&&
						this.nazionalita	==	node.getNazionalita()	&&
						this.figli 			==	node.getFigli()			&&
						this.statoCivile	== 	node.getStatoCivile()	&&
						this.stipendio		== 	node.getStipendio()		&&
						this.professione	== 	node.getProfessione()	&&
						this.titoloStudio	>=	node.getTitoloStudio())
				)
				isDirectGeneralization = true;
		if(Qi == 8)
			if((this.birthday		>=	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.professione	== 	node.getProfessione()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
			
				(this.birthday		==	node.getBirthday()		&&
				this.sex			>=	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.professione	== 	node.getProfessione()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		>=	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.professione	== 	node.getProfessione()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	>=	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.professione	== 	node.getProfessione()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			>=	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.professione	== 	node.getProfessione()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	>= 	node.getStatoCivile()	&&
				this.professione	== 	node.getProfessione()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.professione	>= 	node.getProfessione()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.professione	== 	node.getProfessione()	&&
				this.titoloStudio	>=	node.getTitoloStudio())
				)
				isDirectGeneralization = true;
		if(Qi == 7)
			if((this.birthday		>=	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
			
				(this.birthday		==	node.getBirthday()		&&
				this.sex			>=	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		>=	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	>=	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			>=	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	>= 	node.getStatoCivile()	&&
				this.titoloStudio	==	node.getTitoloStudio())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile()	&&
				this.titoloStudio	>=	node.getTitoloStudio())
				)
				isDirectGeneralization = true;	
		if(Qi == 6)
			if((this.birthday		>=	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile())	||
			
				(this.birthday		==	node.getBirthday()		&&
				this.sex			>=	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		>=	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	>=	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			>=	node.getFigli()			&&
				this.statoCivile	== 	node.getStatoCivile())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli()			&&
				this.statoCivile	>= 	node.getStatoCivile())	
				)
				isDirectGeneralization = true;
		if(Qi == 5)
			if((this.birthday		>=	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli())		||
			
				(this.birthday		==	node.getBirthday()		&&
				this.sex			>=	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli())		||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		>=	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			==	node.getFigli())		||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	>=	node.getNazionalita()	&&
				this.figli 			==	node.getFigli())		||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita()	&&
				this.figli 			>=	node.getFigli())	
				)
				isDirectGeneralization = true;
		if(Qi == 4)
			if((this.birthday		>=	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita())	||
			
				(this.birthday		==	node.getBirthday()		&&
				this.sex			>=	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		>=	node.getZipcode()		&&
				this.nazionalita	==	node.getNazionalita())	||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode()		&&
				this.nazionalita	>=	node.getNazionalita())
				)
				isDirectGeneralization = true;
		if(Qi == 3)
			if((this.birthday		>=	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		==	node.getZipcode())		||
			
				(this.birthday		==	node.getBirthday()		&&
				this.sex			>=	node.getSex()			&&
				this.zipcode		==	node.getZipcode())		||
				
				(this.birthday		==	node.getBirthday()		&&
				this.sex			==	node.getSex()			&&
				this.zipcode		>=	node.getZipcode())
				)
				isDirectGeneralization = true;
		if(Qi == 2)
			if((this.birthday		>=	node.getBirthday()		&&
				this.sex			==	node.getSex())		||
			
				(this.birthday		==	node.getBirthday()		&&
				this.sex			>=	node.getSex())
				)
				isDirectGeneralization = true;
		if(Qi == 1)
			if(this.birthday		>=	node.getBirthday())
				isDirectGeneralization = true;

		return isDirectGeneralization;
	}
	
	@Override
	public String toString() {
		return "Node [id=" + id + ", birthday=" + birthday + ", sex=" + sex + ", zipcode=" + zipcode + ", nazionalita="
				+ nazionalita + ", figli=" + figli + ", statoCivile=" + statoCivile + ", titoloStudio=" + titoloStudio
				+ ", professione=" + professione + ", stipendio=" + stipendio + ", height=" + height + ", mark=" + mark
				+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
	}
	
	
	
	public String toString(int Qi) {
		switch(Qi) {
			case 9:
				return "Node [id=" + id + ", birthday=" + birthday + ", sex=" + sex + ", zipcode=" + zipcode + ", nazionalita="
				+ nazionalita + ", figli=" + figli + ", statoCivile=" + statoCivile + ", titoloStudio=" + titoloStudio
				+ ", professione=" + professione + ", stipendio=" + stipendio + ", height=" + height + ", mark=" + mark
				+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
			case 8:
				return "Node [id=" + id + ", birthday=" + birthday + ", sex=" + sex + ", zipcode=" + zipcode + ", nazionalita="
				+ nazionalita + ", figli=" + figli + ", statoCivile=" + statoCivile + ", titoloStudio=" + titoloStudio
				+ ", professione=" + professione + ", height=" + height + ", mark=" + mark
				+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
			case 7:
				return "Node [id=" + id + ", birthday=" + birthday + ", sex=" + sex + ", zipcode=" + zipcode + ", nazionalita="
				+ nazionalita + ", figli=" + figli + ", statoCivile=" + statoCivile + ", titoloStudio=" + titoloStudio
				+ ", height=" + height + ", mark=" + mark
				+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
			case 6:
				return "Node [id=" + id + ", birthday=" + birthday + ", sex=" + sex + ", zipcode=" + zipcode + ", nazionalita="
				+ nazionalita + ", figli=" + figli + ", statoCivile=" + statoCivile	+ ", height=" + height + ", mark=" + mark
				+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
			case 5:
				return "Node [id=" + id + ", birthday=" + birthday + ", sex=" + sex + ", zipcode=" + zipcode + ", nazionalita="
				+ nazionalita + ", figli=" + figli + ", height=" + height + ", mark=" + mark
				+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
			case 4:
				return "Node [id=" + id + ", birthday=" + birthday + ", sex=" + sex + ", zipcode=" + zipcode + ", nazionalita="
				+ nazionalita + ", height=" + height + ", mark=" + mark	+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
			case 3:
				return "Node [id=" + id + ", birthday=" + birthday + ", sex=" + sex + ", zipcode=" + zipcode + ", height="
				+ height + ", mark=" + mark	+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
			case 2:
				return "Node [id=" + id + ", birthday=" + birthday + ", sex=" + sex + ", height="
				+ height + ", mark=" + mark	+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
			case 1:
				return "Node [id=" + id + ", birthday=" + birthday + ", height=" + height + ", mark=" + mark
				+ ", isKAnonyminzated=" + isKAnonyminzated + "]\n";
			default:
				return "error";
		}
		
	}

	
}
