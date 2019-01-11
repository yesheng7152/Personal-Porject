package supProb3;
import java.util.Scanner; 
public class Simulation {
	Printer printer;
	Queue<PrintRequest> queueArray[];
	public Simulation (int numberQueues, double probability, 
			char option, int upgrade) {
		//initializing printer and queue array
		printer= new Printer();
		queueArray = new Queue [numberQueues];
		for (int i=0; i<numberQueues; i++) {
			queueArray[i]=new Queue <PrintRequest> (40);
		}
		//declaring values needed later in the program
		int tick=0;
		int time=1000;
		int waitTime=0;
		int maxWait=0;
		int totalWait=0;
		int pRCount=0;
		int dequeueCount=0;
		boolean allEmpty = true;
		int high;
		int lower=numberQueues-1;
		//when printer is accepting print request
		while (tick<time) {
			double randomN= Math.random();
			boolean create = (randomN<probability);
			if (option == 'A') {
				//create a new PrintRequest and put it in the queue
				if (create){
					PrintRequest pr=new PrintRequest(tick);
					queueArray[0].enqueue(pr);
				}
			}else if(option == 'B') {
				//find the location of the high priority queue and the one right after
				if (create) {
					high=0;
					while (high <numberQueues-1&& queueArray[high].isEmpty()==true) { 
						high++;
					}
					if (high!=numberQueues-1) {
						lower= high+1;
						while (lower <numberQueues-1 && queueArray[lower].isEmpty()==true) { 
							lower++;
						}
					}
					//upgrade the one in the lower queue to the higher one when needed
					if(dequeueCount==upgrade && !queueArray[lower].isEmpty()) {
						PrintRequest upgradePR= queueArray[lower].dequeue();
						queueArray[high].enqueue(upgradePR);
						dequeueCount=0;
					}
					//then enqueue the PrintRequest
					PrintRequest pr=new PrintRequest(tick);
					queueArray[(int)pr.numPages/10].enqueue(pr);
				}
			}else if (option == 'C') {
				//same as B with, expect the queue that the printRequest enqueued at is different
				if (create) {
					high=0;
					while (high <numberQueues-1&& queueArray[high].isEmpty()==true) { 
						high++;
					}
					if (high!=numberQueues-1) {
						lower= high+1;
						while (lower <numberQueues-1 && queueArray[lower].isEmpty()==true) { 
							lower++;
						}
					}
					if(dequeueCount==upgrade && !queueArray[lower].isEmpty()) {
						PrintRequest upgradePR= queueArray[lower].dequeue();
						queueArray[high].enqueue(upgradePR);
						dequeueCount=0;
					}
					PrintRequest pr=new PrintRequest(tick);
					queueArray[pr.numPages%10].enqueue(pr);
				}
			}
			
			//Process the printRequests in the queues
			//first find the location of the priority queue and the second priority queue
			high=0;
			while (high <numberQueues-1 && queueArray[high].isEmpty()==true) { 
				high++;
			}
			if (high!=numberQueues-1) {
				lower= high+1;
				while (lower <numberQueues-1 && queueArray[lower].isEmpty()==true) { 
					lower++;
				}
			}
			//if the printer is not busy and there are PrintRequest waiting to be processed
			//then process the PrintRequest
			if (printer.printerIdle() && high<numberQueues 
					&& !queueArray[high].isEmpty()) {
				PrintRequest nextPr = queueArray[high].dequeue();
				dequeueCount++;
				printer.printFile(nextPr);
				//we will count waitTime as the time between it's creation and the starting of it's processing
				waitTime= tick-nextPr.clock;
			}else {
				//if the PrintRequest is completed processed then we update the count, total wait, and max wait
				PrintRequest processed=printer.processForOneUnit();
				if (processed!=null&&processed.clock!=0) {
					pRCount ++;
					totalWait += waitTime;
					if (waitTime>maxWait) {
						maxWait=waitTime;
					}
				}
			}
			tick++;
		}
		//if there are still PrintRequests left in the queues after the time units ran out
		if (option == 'A') {
			//we keep processing the PrintRequest until all queues are empty
			while(!queueArray[0].isEmpty() || (!printer.printerIdle())) {
				tick++;
				if (printer.printerIdle()&& queueArray[0].isEmpty()==false) {
					PrintRequest nextPr = queueArray[0].dequeue();
					printer.printFile(nextPr);
					waitTime= tick-nextPr.clock;
				}else {
					PrintRequest processed=printer.processForOneUnit();
					if (processed == null) {
					}
					if (processed!=null&&processed.clock!=0) {
						pRCount ++;
						totalWait += waitTime;
						if (waitTime>maxWait) {
							maxWait=waitTime;
						}
					}
				}
			}
		}else{
			//we keep processing the PrintRequest until all queues are empty
			high=0;
			while (high <numberQueues-1 && queueArray[high].isEmpty()==true) { 
				high++;
			}
			if (high!=numberQueues-1) {
				lower= high+1;
				while (lower <numberQueues-1 && queueArray[lower].isEmpty()==true) { 
					lower++;
				}
			}
			while((!queueArray[lower].isEmpty())||(!queueArray[high].isEmpty())
					||!printer.printerIdle()) {
				if (high<numberQueues|| (printer.printerIdle())) {
					//time keep going
					tick ++;
					//upgrade a PrintRequest when necessary 
					if(dequeueCount==upgrade && !queueArray[lower].isEmpty()) {
						PrintRequest upgradePR= queueArray[lower].dequeue();
						queueArray[high].enqueue(upgradePR);
						dequeueCount=0;
					}
					//if the printer is empty it will take the next PR in the high priority queue
					if ((printer.printerIdle())&&(!queueArray[high].isEmpty())) {
						PrintRequest nextPr = queueArray[high].dequeue();
						dequeueCount++;
						printer.printFile(nextPr);
						waitTime= tick-nextPr.clock;
					}else {
						PrintRequest processed=printer.processForOneUnit();
						if (processed == null) {
						}
						if (processed!=null&&processed.clock!=0) {
							pRCount ++;
							totalWait += waitTime;
							if (waitTime>maxWait) {
								maxWait=waitTime;							
							}
						}
					}
				}
				//checking if there are any queues that are still not empty
				high=0;
				while (high <numberQueues-1 && queueArray[high].isEmpty()==true) { 
					high++;
				}
				if (high!=numberQueues-1) {
					lower= high+1;
					while (lower <numberQueues-1 && queueArray[lower].isEmpty()==true) { 
						lower++;
					}
				}

			}
		}
		//We print out the  information at the end when all PrintRequests are processed 
		System.out.println("the max wait time is " + maxWait);
		if (pRCount!=0){
			System.out.println("the average wait time is calucalated by the total amount of wait time (not including the first printRequest");
			System.out.println("since it's wait time is zero) divided by total PrintRequest without the first one, so the average time is: "
					+ totalWait/pRCount);
		}else if (pRCount+1==0){
			System.out.println("Not request was made");
		}else {
			System.out.println("Only one printRequest was made, so there were no waiting time or the wait time is 0");
		}
	}

	public static void main (String args[]) {
		//scanning variables from the terminal
		Scanner scan = new Scanner(System.in);
		//since for B pagenumber/10=<10
		System.out.println("Enter the number of queues need to be at least 11: ");
		int N= scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the probability in decimal (0-1): ");
		double Pro=scan.nextDouble();
		scan.nextLine();
		System.out.println("Enter either A, B, or C (must be capitalized): ");
		char O=scan.next().charAt(0);
		System.out.println("Enter the number of dequeue operations before promotion: ");
		int K=scan.nextInt();
		scan.nextLine();
		Simulation test1= new Simulation (N, Pro, O, K);
	}
}