package fr.umlv.DmChecker.ObjetOptions;

/**
 * Classe commune entre les options -1 et -2
 * @author alexandre
 *
 */
public class ObjetOptionControleDeploiement extends ObjetOptions {
	
	

	private String[] oneTop;
	private String[] endsWiths;
	private String[] existent;
	private String[] interdits;
	private String[] beginWiths;
	private String[] forceOneTop;
	private String[] forceEndsWiths;
	private String[] forceExistent;
	private String[] forceInterdits;
	private String[] forceBeginWiths;

	protected ObjetOptionControleDeploiement(OptionGenerale opt) {
		super(opt);
	}
	
	
	public String[] getOneTop() {
		return oneTop;
	}

	public String[] getEndsWiths() {
		return endsWiths;
	}

	public String[] getExistent() {
		return existent;
	}

	public String[] getInterdits() {
		return interdits;
	}

	public String[] getBeginWiths() {
		return beginWiths;
	}

	public String[] getForceOneTop() {
		return forceOneTop;
	}

	public String[] getForceEndsWiths() {
		return forceEndsWiths;
	}

	public String[] getForceExistent() {
		return forceExistent;
	}

	public String[] getForceInterdits() {
		return forceInterdits;
	}

	public String[] getForceBeginWiths() {
		return forceBeginWiths;
	}

	public void setOneTop(String[] oneTop) {
		this.oneTop = oneTop;
	}

	public void setEndsWiths(String[] endsWiths) {
		this.endsWiths = endsWiths;
	}

	public void setExistent(String[] existent) {
		this.existent = existent;
	}

	public void setInterdits(String[] interdits) {
		this.interdits = interdits;
	}

	public void setBeginWiths(String[] beginWiths) {
		this.beginWiths = beginWiths;
	}

	public void setForceOneTop(String[] forceOneTop) {
		this.forceOneTop = forceOneTop;
	}

	public void setForceEndsWiths(String[] forceEndsWiths) {
		this.forceEndsWiths = forceEndsWiths;
	}

	public void setForceExistent(String[] forceExistent) {
		this.forceExistent = forceExistent;
	}

	public void setForceInterdits(String[] forceInterdits) {
		this.forceInterdits = forceInterdits;
	}

	public void setForceBeginWiths(String[] forceBeginWiths) {
		this.forceBeginWiths = forceBeginWiths;
	}



}
