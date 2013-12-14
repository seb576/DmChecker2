package fr.umlv.DmChecker.ObjetOptions;

import fr.umlv.DmChecker.utils.ErrorCodeUtils;

/**
 * Description de la classe
 * 
 * @author alexandre
 * 
 */
public abstract class ObjetOptions {
	private final OptionGenerale optionGenerale;
	private boolean verbose;
	
	
	protected boolean accepted;
	

	public enum OptionGenerale {
		OPT1, OPT2, OPT3, OPT4
	}

	protected ObjetOptions(OptionGenerale opt) {
		this.optionGenerale = opt;
		this.verbose = false;
	}

	public OptionGenerale getOptionGenerale() {
		return optionGenerale;
	}

	public void displayError(int errorCode, String filemane, boolean isForced) {
		// System.out.println(isForced?"FORCED":"NONFORCED");
		String message = String.format(
				ErrorCodeUtils.getErrorMessageForCode(errorCode), filemane);
		if (isForced) {
			System.err.println(message);
			accepted = false;
		} else {
			System.out.println(message);
		}
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

}
