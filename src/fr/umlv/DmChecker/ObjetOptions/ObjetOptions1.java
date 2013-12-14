package fr.umlv.DmChecker.ObjetOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;

import fr.umlv.DmChecker.utils.ErrorCodeUtils;
import fr.umlv.DmChecker.utils.FilesUtils;
import fr.umlv.DmChecker.utils.ZipUtils;

public class ObjetOptions1 extends ObjetOptionControleDeploiement {

	private String fichierArchive;
	
	public ObjetOptions1() {
		super(OptionGenerale.OPT1);
	}
	
	public String getFichierArchive() {
		return fichierArchive;
	}

	public void setFichierArchive(String fichierArchive) {
		this.fichierArchive = fichierArchive;
	}

	public boolean processOption1() {
		
		super.accepted = true;
		
		/* v�rif du fichier (existence et zip) */
		if (!FilesUtils.fileExist(this.getFichierArchive())) {
			String message = String.format(
					ErrorCodeUtils.ERROR_MESSAGE_FILE_NO_EXIST_FORMAT,
					this.getFichierArchive());
			System.err.println(message);
			System.exit(ErrorCodeUtils.ERROR_CODE_FILE_NO_EXIST);
		}
		if (!ZipUtils.isZip(this.getFichierArchive())) {
			String message = String.format(
					ErrorCodeUtils.ERROR_MESSAGE_FILE_NOT_ZIP_FILE_FORMAT,
					this.getFichierArchive());
			System.err.println(message);
			System.exit(ErrorCodeUtils.ERROR_CODE_NOT_ZIP_FILE);
		}
		/* One Top et Force One top */
		if (this.getForceOneTop().length > 0) {
			testOneTop(true);
		}
		if (this.getOneTop().length > 0) {
			testOneTop(false);
		}
		/* EndsWith et Force Ends with */
		if (this.getForceEndsWiths().length > 0) {
			testEndsWith(true);
		}
		if (this.getEndsWiths().length > 0) {
			testEndsWith(false);
		}
		
		return super.accepted;	
	}

	/*A L'AIR OK*/
	public void testOneTop(boolean isForced) {
		String filename = this.getFichierArchive();
		List<ZipEntry> topLevelEntries = ZipUtils.topLevelEntries(filename);
		// if zip is empty
		if (topLevelEntries.size() == 0) {
			displayError(ErrorCodeUtils.ERROR_CODE_EMPTY_ZIP, filename,
					isForced);
		}
		// if more than one top level folder
		if (topLevelEntries.size() > 1) {
			displayError(ErrorCodeUtils.ERROR_CODE_ONE_TOP_MULTIPLE_ENTRIES,
					filename, isForced);
		}
		// get the top level folder of the archive
		ZipEntry oneTop = topLevelEntries.get(0);
		// TODO : tester si le zipEntry oneTop est bien un r�pertoire
		String[] oneTopList = (isForced) ? this.getForceOneTop()
				: this.getOneTop();
		String nameOneTop = oneTop.getName();
		// enlever le '/'
		// TODO : eventuellement trouver solution plus propre
		nameOneTop = nameOneTop.substring(0, nameOneTop.length() - 1);
		for (String oneTopElement : oneTopList) {
			if (!nameOneTop.equals(oneTopElement)) {
				displayError(
						ErrorCodeUtils.ERROR_CODE_ONE_TOP_SPECIFIED_NOT_FOUND,
						oneTopElement, isForced);
			}
		}
	}

	/**
	 * 
	 * @param isForced
	 */
	
	/*A L'AIR OK*/
	// TODO: tester si �a marche et int�grer dans le process() les fichiers dont
	// le nom se termine par la <endswith> sont interdits par exemple: -e ~ pour
	// les noms de fichiers terminant par ~ ou -e __MACOSX ces
	// fichiers/r�pertoires seront ignor�s � la d�compression
	public void testEndsWith(boolean isForced) {
		// System.out.println("On ex�cute testEndsWith avec "+isForced);
		List<String> contenuArchive = ZipUtils.getArchiveEntries(this
				.getFichierArchive());
	
		String[] endsWithOptions = (isForced) ? this
				.getForceEndsWiths() : this.getEndsWiths();
		for (String fileName : contenuArchive) {
			for (int i = 0; i < endsWithOptions.length; i++) {
				if (fileName.endsWith(endsWithOptions[i])) {
					// TODO : verbose
					displayError(ErrorCodeUtils.ERROR_CODE_ENDSWITH,
							endsWithOptions[i], isForced);
				}
			}
		}
	}

	/**
	 * 
	 * @param isForced
	 */
	// V�rifie la pr�sence du fichier ou r�pertoire (regex). Le r�pertoire top
	// level est ignor� dans la comparaison par exemple:-x index.html
	public void testExists(boolean isForced) {
		// get the regex which have to match to the filenames in the project
		String[] existsOptions = this.getExistent();
		List<Pattern> patternList = FilesUtils.createRegexPatterns(existsOptions);
		// m�thode dans fileutils pour r�cup�rer une liste de patterns
		// TODO : r�cup�rer la liste des fichiers / dossiers du projet en
		// excluant le one top level
		// TODO : cr�er une m�thode dans FileUtils qui permet de comparer une
		// liste de pattern a un nom de fichier ou dossier, en gros qui teste si
		// le nom de ce fichier ou dossier matche avec un des patterns de la
		// liste
		// TODO: ex�cuter cette m�thode pour chaque �l�ment de la liste de
		// fichiers ( et eventuellement cr�er une liste avec les regex qui
		// existent pas dans le projet, pour afficher les erreurs)
		// TODO : faire des regex pour tester
	}

	/**
	 * 
	 * @param isForced
	 */
	// V�rifie l'absence du fichier ou r�pertoire de regex <interdit> le
	// repertoire top level est ignor� dans la comparaison
	public void testInterdit(boolean isForced) {
		// TODO : � peu pr�s le m�me fonctionnement que testExists, donc d'abord
		// tester �a
	}

	// les fichiers/r�pertoires commen�ant par <startswith> sont interdits par
	// exemples f_ pour les noms de fichiers commen�ant par f_
	public void testBeginsWith(boolean isForced) {
		// TODO : r�cup�rer liste des noms des fichiers/r�pertoires (top level
		// inclut cette fois ci)
		List<String> listFiles = new ArrayList<String>();
		// on cr�e une liste en attendant
		String[] beginsWithOptions = this.getBeginWiths();
		for (int i = 0; i < beginsWithOptions.length; i++) {
			String beginOption = beginsWithOptions[i];
			for (String filename : listFiles) {
				if (filename.startsWith(beginOption)) {
					// Alors on a une erreur puisque le fichier est interdit
				}
			}
		}
	}

	

}
