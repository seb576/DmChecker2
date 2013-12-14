package fr.umlv.DmChecker.Process;

import fr.umlv.DmChecker.ObjetOptions.ObjetOptions;
import fr.umlv.DmChecker.ObjetOptions.ObjetOptions1;
import fr.umlv.DmChecker.ObjetOptions.ObjetOptions2;
import fr.umlv.DmChecker.ObjetOptions.ObjetOptions3;
import fr.umlv.DmChecker.ObjetOptions.ObjetOptions4;
import fr.umlv.DmChecker.ObjetOptions.ObjetOptionControleDeploiement;

public class DmCheckerProcessObjectOptions {
	/*
	 * COMMENTAIRE SEB : J'ai mis en commentaire car je ne veux que rediriger
	 * l'objetOption donn� vers la bonne classe ObjetOptionsX pour lui donner la
	 * responsabilit� de traiter son propre process
	 */
	// private final ObjetOptions objetOption;

	// TODO: faire en sorte d'allumer un booleen si on a une seule erreur avec
	// un 'force' pour � la fin ne pas accepter l'archive, ou l'accepter m�me si
	// y'a des erreurs avec des options non force
	// TODO : faire le exit qui prend en compte le boolean pr�c�dent

	/*
	 * COMMENTAIRE SEB :
	 * Il n'y a plus rien � mettre dedans
	 */
	public DmCheckerProcessObjectOptions() {
	}

	// TODO : g�rer le fait que si option non force, malgr� les erreurs le
	// fichier est accept�
	// TODO : g�rer le fait que si option force le fichier est pas accept�
	// TODO : faire attention au fait qu'il ne faut pas extraire une archive
	// pour rien (je pense au DmChecker -2. Il faudrait d'abord faire le -1 pour
	// chaque archive, et si accept�, d�zipper seulement ce qui est accept�, si
	// refus� ne rien d�zipper

	/*
	 * COMMENTAIRE SEB : Cette m�thode est une sorte de factory car selon le
	 * num�ro de l'option optionGenerale de l'objet objetOption je vais pouvoir
	 * rediriger vers le bon process.
	 */
	
	
	


	public void process(ObjetOptions objetOption) {
		switch (objetOption.getOptionGenerale()) {
		case OPT1:
			System.out.println("Option -1 choisie");
			((ObjetOptions1) objetOption).processOption1();
			break;
		case OPT2:
			System.out.println("Option -2 choisie");
			((ObjetOptions2) objetOption).processOption2();
			break;
		case OPT3:
			System.out.println("Option -3 choisie");
			((ObjetOptions3) objetOption).processOption3();
			break;
		case OPT4:
			System.out.println("Option -4 choisie");
			((ObjetOptions4) objetOption).processOption4();
			break;
		default:
			/*
			 * TODO SEB : C'est mal de mettre du texte ici, utiliser la classe
			 * d'erreur pour signaler celle-ci.
			 */
			throw new IllegalArgumentException(
					"Error : the given argument is not an instance of ObjectOptions.");
		}
	}

}
