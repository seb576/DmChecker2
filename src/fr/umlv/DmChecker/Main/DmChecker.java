package fr.umlv.DmChecker.Main;

import java.util.List;

import com.martiansoftware.jsap.JSAPException;

import fr.umlv.DmChecker.ObjetOptions.ObjetOptions;
import fr.umlv.DmChecker.Process.DmCheckerProcessObjectOptions;



//TODO : renommer en main
public class DmChecker {

	/*
	 * -1 -o youhou -O youpi F:\Drive\IG3\Java\JAVA_CONDITIONNELLE_PROJET\Ziptests\Exemples_Revuz\loginnam12.zip
	 *  -1 -E .odt -e ssier -o srcc -O yalah F:\Drive\IG3\Java\JAVA_CONDITIONNELLE_PROJET\Ziptests\hello.zip
	 *  -1 -o kjerhghr -O gkjhe C:\Users\seb\Documents\GitHub\DmChecker\mainrep\loginnam12.zip
	 */
	 /*  COMMENTAIRES SEB
	 *  C:\Users\seb\Documents\GitHub\DmChecker\mainrep\loginnam12.zip
	 *  
	 *  TEMPLATE :
	 *  -3 repertoiredetest [-d] repertoiredeprojets fichierderesultats
	 *  
	 *  PARAMETRES POSSIBLES :
	 *  -3 C:\Users\seb\Documents\GitHub\DmChecker\tests1 -d C:\Users\seb\Documents\GitHub\DmChecker\mainrep resultats.txt
	 *  -3 C:\Users\seb\Documents\GitHub\DmChecker\tests1 resultats.txt
	 */
	public static void main(String[] args) throws JSAPException {
		/*
		 * COMMENTAIRE SEB
		 * Doit-on renommer ArgumentParser ? Je le trouve assez parlant comme nom (sinon, tu peux le nommer JSAPParser)
		 */
		ArgumentParser parser = new ArgumentParser();
		List<ObjetOptions> objetOptions = parser.parse(args);
		// a changer
		/*
		 * COMMENTAIRES SEB :
		 * DmCheckerProcessObjectOptions1 devient DmCheckerProcess car c'est une interface donc tu t'en fous
		 * de ce qu'il y a derrière
		 * 
		 * new DmCheckerProcessObjectOptions1() devient DmCheckerProcessObjectOptions() auquel tu lui donne un objet
		 * de type abstrait ObjetOptions comme ca on s'en fous de savoir si c'est ObjetOptions1, 2, 3 ou 4.
		 * 
		 * Le paramètre donné au constructeur, on le fait descendre dans la méthode process
		 */
		/*
		 * Dernière mise à jour : le type est défini dans la liste des paramètres fournis
		 * donc plus besoin de devoir appeler une classe numérotée pour détecter de quelle option il s'agit.
		 */
		DmCheckerProcessObjectOptions processor = new DmCheckerProcessObjectOptions();
		processor.process(objetOptions.get(0));
	}

}
