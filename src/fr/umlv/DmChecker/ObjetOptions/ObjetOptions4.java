package fr.umlv.DmChecker.ObjetOptions;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.umlv.DmChecker.IHM.IHM;
import fr.umlv.DmChecker.utils.FilesUtils;
import fr.umlv.DmChecker.utils.StringUtils;

//DmChecker -4 nomexe repertoire fichierdedonnée fichierdecritères		
public class ObjetOptions4 extends ObjetOptions {
	private String nomExe;
	private String repertoire;
	private String fichierDeDonnees;
	private String fichierDeCriteres;

	public ObjetOptions4() {
		super(OptionGenerale.OPT4);
	}

	public void processOption4(){
		if(StringUtils.isEmptyOrNull(nomExe)){
			throw new IllegalArgumentException("Error : ObjetOptions4, nomExe is empty or null.");
		}
		if(StringUtils.isEmptyOrNull(repertoire)){
			throw new IllegalArgumentException("Error : ObjetOptions4, repertoire is empty or null.");
		}
		if(StringUtils.isEmptyOrNull(fichierDeDonnees)){
			throw new IllegalArgumentException("Error : ObjetOptions4, fichierDeDonnees is empty or null.");
		}
		if(StringUtils.isEmptyOrNull(fichierDeCriteres)){
			throw new IllegalArgumentException("Error : ObjetOptions4, fichierDeCriteres is empty or null.");
		}
		if(!FilesUtils.fileExist(repertoire)){
			throw new IllegalStateException("Error : ObjetOptions4, repertoire is not a file or directory.");
		}
		if(!FilesUtils.fileExist(fichierDeDonnees)){
			throw new IllegalStateException("Error : ObjetOptions4, fichierDeDonnees is not a file or directory.");
		}
		if(!FilesUtils.fileExist(fichierDeCriteres)){
			throw new IllegalStateException("Error : ObjetOptions4, fichierDeCriteres is not a file or directory.");
		}
		//TODO SEB
		// Lambda here ? Bonne façon de l'utiliser ?
		Runnable r = () -> {
			JFrame fenetre = new IHM(nomExe, repertoire, fichierDeDonnees, fichierDeCriteres);
				fenetre.setVisible(true);
			};
		SwingUtilities.invokeLater(r);
	}

	public String getNomExe() {
		return nomExe;
	}

	public void setNomExe(String nomExe) {
		this.nomExe = nomExe;
	}

	public String getRepertoire() {
		return repertoire;
	}

	public void setRepertoire(String repertoire) {
		this.repertoire = repertoire;
	}

	public String getFichierDeDonnees() {
		return fichierDeDonnees;
	}

	public void setFichierDeDonnees(String fichierDeDonnees) {
		this.fichierDeDonnees = fichierDeDonnees;
	}

	public String getFichierDeCriteres() {
		return fichierDeCriteres;
	}

	public void setFichierDeCriteres(String fichierDeCriteres) {
		this.fichierDeCriteres = fichierDeCriteres;
	}

}
