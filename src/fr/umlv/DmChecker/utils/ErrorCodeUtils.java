package fr.umlv.DmChecker.utils;

public class ErrorCodeUtils {
	
	/*
	 * COMMENTAIRE SEB :
	 * Pourquoi ne pas utiliser une HashMap avec en clé chaque numéro d'erreur spécifié, et en valeur le message ?
	 * Ce serait plus simple que d'avoir à créer un int et un String par erreur.
	 * La lecture d'une erreur se ferait directement avec le numéro de code d'erreur associé.
	 */
	
	/* De 1 à 127 */
	public static final int ERROR_CODE_FILE_NO_EXIST = 1;
	public static final int ERROR_CODE_NOT_ZIP_FILE = 2;
	public static final int ERROR_CODE_EMPTY_ZIP = 3;
	public static final int ERROR_CODE_ONE_TOP_MULTIPLE_ENTRIES = 4;
	public static final int ERROR_CODE_ONE_TOP_SPECIFIED_NOT_FOUND = 5;
	public static final int ERROR_CODE_ENDSWITH = 6;
	public static final int ERROR_CODE_EXISTS = 7;
	public static final int ERROR_CODE_INTERDIT = 8;
	public static final int ERROR_CODE_BEGINSWITH = 9;
	
	public static final String ERROR_MESSAGE_FILE_NO_EXIST_FORMAT = "L'archive '%s' spécifiée est inexistante";
	public static final String ERROR_MESSAGE_FILE_NOT_ZIP_FILE_FORMAT = "Le fichier '%s' spécifié n'est une archive de type ZIP\nImpossible d'analyser votre rendu";
	public static final String ERROR_MESSAGE_EMPTY_ZIP_FORMAT = "L'archive '%s' est vide";
	public static final String ERROR_MESSAGE_ONE_TOP_MULTIPLE_ENTRIES_FORMAT = "Plusieurs fichiers de niveau one top dans l'archive '%s'";
	public static final String ERROR_MESSAGE_ONE_TOP_SPECIFIED_NOT_FOUND_FORMAT = "Il n'y a pas de oneTop de nom '%s'";
	// TODO : Il faudra bien faire gaffe à afficher tous les trucs invalides dans un seul %s
	public static final String ERROR_MESSAGE_ENDSWITH_FORMAT = "Présence de fichiers interdits dont le nom se termine par '%s'";
	public static final String ERROR_MESSAGE_EXISTS_FORMAT = "Absence des fichiers ou répertoires '%s'";
	public static final String ERROR_MESSAGE_INTERDIT_FORMAT = "Présence de fichiers ou répertoires interdits : '%s'";
	public static final String ERROR_MESSAGE_BEGINSWITH_FORMAT = "Présence de fichiers ou répertoires interdits à cause du début du nom de fichier ou répertoire : '%s'";

	public static String getErrorMessageForCode(int code) {
		switch (code) {
		case ERROR_CODE_FILE_NO_EXIST:
			return ERROR_MESSAGE_FILE_NO_EXIST_FORMAT;
		case ERROR_CODE_NOT_ZIP_FILE:
			return ERROR_MESSAGE_FILE_NOT_ZIP_FILE_FORMAT;
		case ERROR_CODE_EMPTY_ZIP:
			return ERROR_MESSAGE_EMPTY_ZIP_FORMAT;
		case ERROR_CODE_ONE_TOP_MULTIPLE_ENTRIES:
			return ERROR_MESSAGE_ONE_TOP_MULTIPLE_ENTRIES_FORMAT;
		case ERROR_CODE_ONE_TOP_SPECIFIED_NOT_FOUND:
			return ERROR_MESSAGE_ONE_TOP_SPECIFIED_NOT_FOUND_FORMAT;
		case ERROR_CODE_ENDSWITH:
			return ERROR_MESSAGE_ENDSWITH_FORMAT;
		case ERROR_CODE_EXISTS:
			return ERROR_MESSAGE_EXISTS_FORMAT;
		case ERROR_CODE_INTERDIT:
			return ERROR_MESSAGE_INTERDIT_FORMAT;
		case ERROR_CODE_BEGINSWITH:
			return ERROR_MESSAGE_BEGINSWITH_FORMAT;
		default:
			return null;
		}
	}
}
