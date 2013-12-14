package fr.umlv.DmChecker.Main;

import java.util.ArrayList;
import java.util.List;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.StringParser;
import com.martiansoftware.jsap.Switch;
import com.martiansoftware.jsap.UnflaggedOption;

import fr.umlv.DmChecker.ObjetOptions.ObjetOptions;
import fr.umlv.DmChecker.ObjetOptions.ObjetOptions1;
import fr.umlv.DmChecker.ObjetOptions.ObjetOptions2;
import fr.umlv.DmChecker.ObjetOptions.ObjetOptions3;
import fr.umlv.DmChecker.ObjetOptions.ObjetOptions4;

public class ArgumentParser {
	private static final String opt1String = "opt1";
	private static final String opt2String = "opt2";
	private static final String opt3String = "opt3";
	private static final String opt4String = "opt4";
	private static final String verboseString = "verbose";
	/*
	 * COMMENTAIRE SEB C'est quoi le commentaire ci-dessous ?
	 */
	// alt shift R + CTRL shif x
	private static final String DESTINATIONSTRING = "dest";
	private static final String oneTopString = "onetop";
	private static final String endsWithString = "endswith";
	private static final String existeString = "existe";
	private static final String interditString = "interdit";
	private static final String beginWithString = "startswith";
	private static final String forceEndsWithString = "forceendswith";
	private static final String forceOneTopString = "forceonetop";
	private static final String forceExisteString = "forceexiste";
	private static final String forceInterditString = "forceinterdit";
	private static final String forceBeginWithString = "forcestartswith";
	/*
	 * COMMENTAIRE SEB : Ca correspond à quoi cette variable ci-dessous ?
	 * Comment je fais pour récupérer les saisies de l'utilisateur par exemple
	 * le répertoire de destination ? Et dans quel ordre ?
	 */
	// faire attention
	private static final String resteLigneCommandeString = "resteLigneCommande";

	/*
	 * COMMENTAIRE SEB : vu que le constructeur ci-dessus est vide, on peut le
	 * dégager ou le mettre en private et appeler la méthode parse en static
	 * ci-dessous (changements à faire dans DmChecker aussi) Pourquoi cela ?
	 * Parce qu'il n'y a aucune instance d'objet propre à cette classe sur
	 * lequel travailler.
	 */
	public ArgumentParser() {
	}

	public List<ObjetOptions> parse(String[] args) throws JSAPException {
		JSAP jsap = new JSAP();
		List<ObjetOptions> listObjetsOptions = new ArrayList<>();
		ObjetOptions objetOption = null;
		/* Création des objets des paramètres de la ligne de commande */
		Switch opt1 = createSwitch(opt1String, '1', JSAP.NO_LONGFLAG);
		Switch opt2 = createSwitch(opt2String, '2', JSAP.NO_LONGFLAG);
		Switch opt3 = createSwitch(opt3String, '3', JSAP.NO_LONGFLAG);
		Switch opt4 = createSwitch(opt4String, '4', JSAP.NO_LONGFLAG);
		Switch verbose = createSwitch(verboseString, 'v', "verbose");
		FlaggedOption destinationFlaggedOption = createFlaggedOption(
				DESTINATIONSTRING, false, JSAP.STRING_PARSER, 'd',
				"destination", true);
		FlaggedOption oneTopFlaggedOption = createFlaggedOption(oneTopString,
				false, JSAP.STRING_PARSER, 'o', "onetop", true);
		FlaggedOption endsWithFlaggedOption = createFlaggedOption(
				endsWithString, false, JSAP.STRING_PARSER, 'e', "endsWith",
				true);
		FlaggedOption existeFlaggedOption = createFlaggedOption(existeString,
				false, JSAP.STRING_PARSER, 'x', "existe", true);
		FlaggedOption interditFlaggedOption = createFlaggedOption(
				interditString, false, JSAP.STRING_PARSER, 'i', "interdit",
				true);
		FlaggedOption beginWithFlaggedOption = createFlaggedOption(
				beginWithString, false, JSAP.STRING_PARSER, 'b', "beginsWith",
				true);
		FlaggedOption forceEndsWithFlaggedOption = createFlaggedOption(
				forceEndsWithString, false, JSAP.STRING_PARSER, 'E',
				"forceendsWith", true);
		FlaggedOption forceOneTopFlaggedOption = createFlaggedOption(
				forceOneTopString, false, JSAP.STRING_PARSER, 'O',
				"forceonetop", true);
		FlaggedOption forceExisteFlaggedOption = createFlaggedOption(
				forceExisteString, false, JSAP.STRING_PARSER, 'X',
				"forceexiste", true);
		FlaggedOption forceInterditFlaggedOption = createFlaggedOption(
				forceInterditString, false, JSAP.STRING_PARSER, 'I',
				"forceinterdit", true);
		FlaggedOption forceBeginWithFlaggedOption = createFlaggedOption(
				forceBeginWithString, false, JSAP.STRING_PARSER, 'B',
				"forcebeginsWith", true);
		// faire attention
		UnflaggedOption resteLigneCommandeUnflaggedOption = new UnflaggedOption(
				resteLigneCommandeString).setRequired(true)
				.setStringParser(JSAP.STRING_PARSER).setGreedy(true);
		/* Enregistrement des objets auprès de JSAP */
		jsap.registerParameter(opt1);
		jsap.registerParameter(opt2);
		jsap.registerParameter(opt3);
		jsap.registerParameter(opt4);
		jsap.registerParameter(verbose);
		jsap.registerParameter(destinationFlaggedOption);
		jsap.registerParameter(oneTopFlaggedOption);
		jsap.registerParameter(endsWithFlaggedOption);
		jsap.registerParameter(existeFlaggedOption);
		jsap.registerParameter(interditFlaggedOption);
		jsap.registerParameter(beginWithFlaggedOption);
		jsap.registerParameter(forceEndsWithFlaggedOption);
		jsap.registerParameter(forceOneTopFlaggedOption);
		jsap.registerParameter(forceExisteFlaggedOption);
		jsap.registerParameter(forceInterditFlaggedOption);
		jsap.registerParameter(forceBeginWithFlaggedOption);
		jsap.registerParameter(resteLigneCommandeUnflaggedOption);
		/* Aide pour chacun des objets */
		// TODO: aides non faites
		opt1.setHelp("");
		opt2.setHelp("");
		opt3.setHelp("");
		opt4.setHelp("");
		verbose.setHelp("Affichages supplémentaires sur la sortie standard d'erreur System.err");
		resteLigneCommandeUnflaggedOption.setHelp("");
		destinationFlaggedOption
				.setHelp("Répertoire dans lequel les archives sont décompressées s'il n'est pas donné en deuxième paramètre");
		oneTopFlaggedOption
				.setHelp("Un seul sous-répertoire de nom <onetop> dans le répertoire racine de l'archive sans compter les répertoires et fichiers ignorés comme : './ ' ");
		endsWithFlaggedOption
				.setHelp("Les fichiers dont le nom se termine par la <endswith> sont interdits par exemple: -e ~ pour les noms de fichiers terminant par ~ ou -e __MACOSX ces fichiers/répertoires seront ignorés à la décompression");
		existeFlaggedOption.setHelp("");
		interditFlaggedOption.setHelp("");
		beginWithFlaggedOption.setHelp("");
		forceEndsWithFlaggedOption.setHelp("");
		forceOneTopFlaggedOption.setHelp("");
		forceExisteFlaggedOption.setHelp("");
		forceInterditFlaggedOption.setHelp("");
		forceBeginWithFlaggedOption.setHelp("");
		JSAPResult config = jsap.parse(args);
		if (!config.success() || !atLeastOneDmCheckerOption(config)) {
			exitWithUsage(jsap);
		}
		// option -1 : vérification d'intégrité de l'archive
		if (config.getBoolean(opt1String)) {
			ObjetOptions1 objetOption1 = new ObjetOptions1();
			String nomFichierArchive = config
					.getString(resteLigneCommandeString);
			objetOption1.setFichierArchive(nomFichierArchive);
			objetOption1.setVerbose(config.getBoolean(verboseString));
			objetOption1.setOneTop(config.getStringArray(oneTopString));
			objetOption1.setEndsWiths(config.getStringArray(endsWithString));
			objetOption1.setExistent(config.getStringArray(existeString));
			objetOption1.setInterdits(config.getStringArray(interditString));
			objetOption1.setBeginWiths(config.getStringArray(beginWithString));
			objetOption1.setForceEndsWiths(config
					.getStringArray(forceEndsWithString));
			objetOption1.setForceOneTop(config
					.getStringArray(forceOneTopString));
			objetOption1.setForceExistent(config
					.getStringArray(forceExisteString));
			objetOption1.setForceInterdits(config
					.getStringArray(forceInterditString));
			objetOption1.setForceBeginWiths(config
					.getStringArray(forceBeginWithString));
			listObjetsOptions.add(objetOption1);
		}
		// option -2 : vérification de l'intégrité de l'archive, extraction et
		// tests
		if (config.getBoolean(opt2String)) {
			ObjetOptions2 objetOption2 = new ObjetOptions2();
	
			String[] resteLigneCommande  = config.getStringArray(resteLigneCommandeString);
			
			// TODO: vérifier que c'est obligé qu'il y ait 2 arguments
			if(resteLigneCommande.length == 0 || resteLigneCommande.length > 2) {
				//TODO: jsap usage and exit
				System.exit(1);
			}
			
			
			String archiveDarchive = resteLigneCommande[0];
			if(resteLigneCommande.length == 2) {
				String repertoireCible = resteLigneCommande[1];
				objetOption2.setRepertoireCible(repertoireCible);
			}
			else if(resteLigneCommande.length == 1 && config.getString(DESTINATIONSTRING) != null) {
				objetOption2.setRepertoireCible(config.getString(DESTINATIONSTRING));
			}
			else {// TODO: tester pas de 2eme param et pas de -d
				//TODO: JSAP usage et exit
				System.exit(1);
			}
			
			
			
			
			objetOption2.setArchiveDarchives(archiveDarchive);
			
			objetOption2.setVerbose(config.getBoolean(verboseString));
			objetOption2.setOneTop(config.getStringArray(oneTopString));
			objetOption2.setEndsWiths(config.getStringArray(endsWithString));
			objetOption2.setExistent(config.getStringArray(existeString));
			objetOption2.setInterdits(config.getStringArray(interditString));
			objetOption2.setBeginWiths(config.getStringArray(beginWithString));
			objetOption2.setForceEndsWiths(config
					.getStringArray(forceEndsWithString));
			objetOption2.setForceOneTop(config
					.getStringArray(forceOneTopString));
			objetOption2.setForceExistent(config
					.getStringArray(forceExisteString));
			objetOption2.setForceInterdits(config
					.getStringArray(forceInterditString));
			objetOption2.setForceBeginWiths(config
					.getStringArray(forceBeginWithString));
			listObjetsOptions.add(objetOption2);
		}
		// option -3 : tests JUnit
		if (config.getBoolean(opt3String)) {
			ObjetOptions3 objetOption3 = new ObjetOptions3();
			objetOption3.setRepertoireDeTest(config
					.getStringArray(resteLigneCommandeString)[0]);
			objetOption3.setRepertoireDeProjets(config
					.getString(DESTINATIONSTRING));
			objetOption3.setFichierDeResultats(config
					.getStringArray(resteLigneCommandeString)[1]);
			objetOption3.setVerbose(config.getBoolean(verboseString));
			listObjetsOptions.add(objetOption3);
		}
		// option -4 : IHM
		if (config.getBoolean(opt4String)) {
			ObjetOptions4 objetOption4 = new ObjetOptions4();
			objetOption4.setNomExe(config
					.getStringArray(resteLigneCommandeString)[0]);
			objetOption4.setRepertoire(config
					.getStringArray(resteLigneCommandeString)[1]);
			objetOption4.setFichierDeDonnees(config
					.getStringArray(resteLigneCommandeString)[2]);
			objetOption4.setFichierDeCriteres(config
					.getStringArray(resteLigneCommandeString)[3]);
			objetOption4.setVerbose(config.getBoolean(verboseString));
			listObjetsOptions.add(objetOption4);
		}
		/*
		 * switch(optionGenerale){ case "1": ObjetOptions1 objetOption1 = new
		 * ObjetOptions1(); String nomFichierArchive =
		 * config.getString(resteLigneCommandeString);
		 * objetOption1.setFichierArchive(nomFichierArchive);
		 */

		/*
		 * String nomFichierArchive =
		 * config.getString(resteLigneCommandeString); String optionBeginWith=
		 * config.getString(beginWithString);
		 * System.out.println(nomFichierArchive);
		 * System.out.println(optionBeginWith); System.out.println(); String[]
		 * testLineCommande = config.getStringArray(resteLigneCommandeString);
		 * for(String s : testLineCommande) { System.out.println(s); }
		 */
		return listObjetsOptions;
	}

	/* Exit and print DmChecker usage, and full help */
	private static void exitWithUsage(JSAP jsap) {
		System.err.println();
		System.err.println("Usage: java DmChecker " + jsap.getUsage());
		System.err.println();
		System.err.println(jsap.getHelp());
		System.exit(1);
	}

	/**
	 * Return a new FlaggedOption with the specified parameters
	 * 
	 * @param description
	 * @param setRequired
	 * @param parser
	 * @param shortFlag
	 * @param longFlag
	 * @return
	 */
	private static FlaggedOption createFlaggedOption(String description,
			Boolean setRequired, StringParser parser, char shortFlag,
			String longFlag, boolean multipleDeclaration) {
		return new FlaggedOption(description).setRequired(setRequired)
				.setStringParser(parser).setShortFlag(shortFlag)
				.setLongFlag(longFlag)
				.setAllowMultipleDeclarations(multipleDeclaration);
	}

	/* Return a new Switch with the specified parameters */
	private static Switch createSwitch(String description, char shortFlag,
			String longFlag) {
		return new Switch(description).setShortFlag(shortFlag).setLongFlag(
				longFlag);
	}

	/*
	 * Return true if at least one DmChecker main options is written by the user
	 * on the command line Otherwise return false
	 */
	private static boolean atLeastOneDmCheckerOption(JSAPResult config) {
		return (config.getBoolean(opt1String) || config.getBoolean(opt2String)
				|| config.getBoolean(opt3String) || config
					.getBoolean(opt4String));
	}
	
	
}
