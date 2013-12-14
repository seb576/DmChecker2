package fr.umlv.DmChecker.ObjetOptions;

import fr.umlv.DmChecker.utils.FilesUtils;

/*
 * COMMENTAIRES SEB :
 * Exemples :
 * -3 repertoiredetest -d repertoiredeprojets fichierderesultats
 * -3 repertoiredetest fichierderesultats
 */

/*
Usage : DmChecker -3 repertoiredetest [-d] repertoiredeprojets fichierderesultats
DmChecker vas faire tourner les tests junit du repertoiredetest sur le projet repertoiredeprojets 
(avec l'option -d sur tout les sousrepertoire directs de repertoiredeprojets.
On suppose que l'on connaît la structure de source du projet a tester et que le répertoire de test 
est défini avec la même structure de paquetage.
Le résultat de l’exécution de DmChecker -3 est un fichier texte avec le format suivant :
<dmchecker><soft name="nomdurepertoire"><test name="nomcompletdutest" result=true|false >affichages du test si il y en a </test>…</soft>…</dmchecker>
voire le dossier reptest
TESTS :
Le répertoire de test contient des tests junit applicables sur le projet rendu.
On suppose que l'on a une structure de fichiers de la forme suivante :
mon_projet_a_moi/
src/paka1/paka2/toto.java
bin/(vide)
doc/des fichiers
 */
public class ObjetOptions3 extends ObjetOptions {
	private String repertoireDeTest;
	// champ optionnel accessible via l'option -d / --destination repertoireDeProjets
	private String repertoireDeProjets;
	private String fichierDeResultats;
	
	public ObjetOptions3() {
		super(OptionGenerale.OPT3);
	}
	
	public void processOption3(){
		//TODO SEB
		System.out.println("Je suis dans le process 3 de l'objet ObjetOptions3");
		System.out.println(this.getFichierDeResultats());
		System.out.println(this.getRepertoireDeProjets());
		System.out.println(this.getRepertoireDeTest());
		
		if(!FilesUtils.fileExist(getFichierDeResultats())){
			System.out.println("Le fichier 'resultats' n'existe pas !");
		}
		
		if(getRepertoireDeProjets() != null && !FilesUtils.fileExist(getRepertoireDeProjets())){
			System.out.println("Le répertoire de projet 'répertoireDeProjets' n'existe pas !");
		}
		
		if(!FilesUtils.fileExist(getRepertoireDeTest())){
			System.out.println("Le répertoire de test 'répertoireDeTest' n'existe pas !");
		}
	}

	public String getRepertoireDeTest() {
		return repertoireDeTest;
	}

	public void setRepertoireDeTest(String repertoireDeTest) {
		this.repertoireDeTest = repertoireDeTest;
	}

	public String getRepertoireDeProjets() {
		return repertoireDeProjets;
	}

	public void setRepertoireDeProjets(String repertoireDeProjets) {
		this.repertoireDeProjets = repertoireDeProjets;
	}

	public String getFichierDeResultats() {
		return fichierDeResultats;
	}

	public void setFichierDeResultats(String fichierDeResultats) {
		this.fichierDeResultats = fichierDeResultats;
	}

}
