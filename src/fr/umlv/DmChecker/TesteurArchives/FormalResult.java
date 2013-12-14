package fr.umlv.DmChecker.TesteurArchives;

/*
 *  Cette classe repr�sente un fichier test� par une propri�t� formelle.
 *  Concr�tement, nous avons besoin d'un nom de fichier ou r�pertoire,
 *  de son statut de validation (true / false) et
 *  d'un message expliquant pourquoi il n'est pas valide si son statut est false
 */
public class FormalResult {
	private final String dirFileName;
	private final boolean status;
	private final String messageStatus;

	public FormalResult(String dirFileName, boolean status, String messageStatus){
		this.dirFileName = dirFileName;
		this.status = status;
		this.messageStatus = messageStatus;
	}

	public String getDirFileName() {
		return dirFileName;
	}

	public boolean isStatus() {
		return status;
	}

	public String getMessageStatus() {
		return messageStatus;
	}
}
