package supProb3;

public class PrintRequest {
	protected int numPages;
	protected int clock;
	
	public PrintRequest (int time) {
		numPages = (int)(Math.random() * 100 + 1);
		clock = time;
	}

	/**
	 * @return the numPages
	 */
	public int getNumPages() {
		return numPages;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PrintRequest [numPages=" + numPages + ", clock=" + clock + "]";
	}

	/**
	 * @param numPages the numPages to set
	 */
	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	/**
	 * @return the clock
	 */
	public int getClock() {
		return clock;
	}

	/**
	 * @param clock the clock to set
	 */
	public void setClock(int clock) {
		this.clock = clock;
	}
	
	
}

