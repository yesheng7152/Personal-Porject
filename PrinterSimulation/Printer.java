package supProb3;

public class Printer {
	int counter;
	PrintRequest processing;

	public Printer () {
		counter=0;
		processing=null;
	}

	/**
	 * return the status of printer
	 * @return		true if printer is not busy
	 * 				false if the printer is busy
	 */
	public boolean printerIdle() {
		if (processing==null)
			return true;
		else {
			return false;
		}
	}

	/**
	 * takes a PrintRequest
	 * @param pr		PrintRequest
	 * @return			if the printer is idle, the printer will start processing the given
	 * 						 print request, and the method returns true
	 * 					if the printer is not idle, the new Print Request pr is ignored, 
	 * 						and the method returns false
	 */
	public boolean printFile (PrintRequest pr) {
		if (this.printerIdle()) {
			counter=pr.numPages;
			processing=pr;
			return true;
		}else {
			return false;
		}
	}

	/**
	 * prints one page of the current print request
	 * @return			if the printer is idle, or if the current Print Request 
	 * 						is NOT completed within 1 unit of time, then processForOneUnit 
	 * 						returns null.
	 * 					if the current Print Request is completed in the current time unit, 
	 * 						the method returns the current PrintRequest object that just 
	 * 						finishes printing.
	 */
	public PrintRequest processForOneUnit() {
		if (counter>1||this.printerIdle()) {
			counter--;
			return null;
		}
		else {
			PrintRequest processed=processing;
			processing= null;
			return processed;
		}
	}
}
