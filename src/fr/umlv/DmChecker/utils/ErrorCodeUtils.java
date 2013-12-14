package fr.umlv.DmChecker.utils;

public class ErrorCodeUtils {
	
	/*
	 * COMMENTAIRE SEB :
	 * Pourquoi ne pas utiliser une HashMap avec en cl� chaque num�ro d'erreur sp�cifi�, et en valeur le message ?
	 * Ce serait plus simple que d'avoir � cr�er un int et un String par erreur.
	 * La lecture d'une erreur se ferait directement avec le num�ro de code d'erreur associ�.
	 */
	
	/* De 1 � 127 */
	public static final int ERROR_CODE_FILE_NO_EXIST = 1;
	public static final int ERROR_CODE_NOT_ZIP_FILE = 2;
	public static final int ERROR_CODE_EMPTY_ZIP = 3;
	public static final int ERROR_CODE_ONE_TOP_MULTIPLE_ENTRIES = 4;
	public static final int ERROR_CODE_ONE_TOP_SPECIFIED_NOT_FOUND = 5;
	public static final int ERROR_CODE_ENDSWITH = 6;
	public static final int ERROR_CODE_EXISTS = 7;
	public static final int ERROR_CODE_INTERDIT = 8;
	public static final int ERROR_CODE_BEGINSWITH = 9;
	
	public static final String ERROR_MESSAGE_FILE_NO_EXIST_FORMAT = "L'archive '%s' sp�cifi�e est inexistante";
	public static final String ERROR_MESSAGE_FILE_NOT_ZIP_FILE_FORMAT = "Le fichier '%s' sp�cifi� n'est une archive de type ZIP\nImpossible d'analyser votre rendu";
	public static final String ERROR_MESSAGE_EMPTY_ZIP_FORMAT = "L'archive '%s' est vide";
	public static final String ERROR_MESSAGE_ONE_TOP_MULTIPLE_ENTRIES_FORMAT = "Plusieurs fichiers de niveau one top dans l'archive '%s'";
	public static final String ERROR_MESSAGE_ONE_TOP_SPECIFIED_NOT_FOUND_FORMAT = "Il n'y a pas de oneTop de nom '%s'";
	// TODO : Il faudra bien faire gaffe � afficher tous les trucs invalides dans un seul %s
	public static final String ERROR_MESSAGE_ENDSWITH_FORMAT = "Pr�sence de fichiers interdits dont le nom se termine par '%s'";
	public static final String ERROR_MESSAGE_EXISTS_FORMAT = "Absence des fichiers ou r�pertoires '%s'";
	public static final String ERROR_MESSAGE_INTERDIT_FORMAT = "Pr�sence de fichiers ou r�pertoires interdits : '%s'";
	public static final String ERROR_MESSAGE_BEGINSWITH_FORMAT = "Pr�sence de fichiers ou r�pertoires interdits � cause du d�but du nom de fichier ou r�pertoire : '%s'";

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
