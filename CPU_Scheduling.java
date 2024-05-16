import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

//class that have the info of the process
class process_info
{
    private String processName;
    private int arrivalTime;
    private int burstTime;
    private int startTime;
    private int finishTime;
    private int priorityLevel;
    private int waitingTime;
    private int turnaroundTime;
    private int RemainingTime;
    private double quantumTime;
    private int AG_factor;
    private int randomNum;
    private double nonPreemptiveQuantum;
    private process_info(String processName, int arrivalTime, int burstTime, int startTime, int finishTime, int priorityLevel, int waitingTime, int turnaroundTime,double quantumTime,int AG_factor) {
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.priorityLevel = priorityLevel;
        this.waitingTime = waitingTime;
        this.turnaroundTime = turnaroundTime;
        this.quantumTime = quantumTime;
        this.RemainingTime = burstTime;
        this.AG_factor = AG_factor;
        Random random = new Random();
        this.randomNum = random.nextInt(20);
        this.nonPreemptiveQuantum = Math.ceil(quantumTime*0.5);
    }

    //constructor 1 that takes process name , arrival time , burst time and priority level as parameters
    public process_info(String processName, int arrivalTime, int burstTime, int priorityLevel) {
        this(processName, arrivalTime, burstTime, 0, 0, priorityLevel, 0, 0,0,0);
    }

    //constructor 2 that takes process name , arrival time and burst time  as parameters
    public process_info(String processName, int arrivalTime, int burstTime) {
        this(processName, arrivalTime, burstTime, 0, 0, 0, 0, 0,0,0);
    }
    //constructor 3 that takes process name , arrival time , burst time ,start time , finish time , waiting time and turnaround time  as parameters
    public process_info(String processName, int arrivalTime, int burstTime, int startTime,int finishTime,int waitingTime,int turnaroundTime) {
        this(processName, arrivalTime, burstTime, startTime, finishTime, 0, waitingTime, turnaroundTime,0,0);
    }
    //constructor 4 that takes process name , arrival time , burst time , priority level and quantum time as parameters
    public process_info(String processName, int arrivalTime, int burstTime, int priorityLevel,double quantumTime) {
        this(processName, arrivalTime, burstTime, 0, 0, priorityLevel, 0, 0,quantumTime,0);
    }


    //getters and setters
    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public String getProcessName() {
        return this.processName;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getBurstTime() {
        return this.burstTime;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return this.priorityLevel;
    }

    public int getWaitingTime() {
        return this.waitingTime;
    }

    public int getTurnaroundTime() {
        return this.turnaroundTime;
    }

    public int getRemainingTime() {
        return RemainingTime;
    }

    public void setRemainingTime(int RemainingTime) {
        this.RemainingTime = RemainingTime;
    }

    public void setQuantumTime(double quantumTime) {
        this.quantumTime = quantumTime;
    }
    public void setAG_factor(int AG_factor) {
        this.AG_factor = AG_factor;
    }

    public double getQuantumTime() {
        return quantumTime;
    }
    public int getAG_factor() {
        return AG_factor;
    }

    public int getRandomNum() {
        return randomNum;
    }

    public void setnonPreemptiveQuantum(double nonPreemptiveQuantum) {
        this.nonPreemptiveQuantum = nonPreemptiveQuantum;
    }
    public double getnonPreemptiveQuantum() {
        return nonPreemptiveQuantum;
    }

    @Override
    public String toString() {
        return "\nprocess_info{" + "\n\tprocessName=" + processName
                + "\n\tarrivalTime=" + arrivalTime
                + "\n\tburstTime=" + burstTime
                + "\n\tstartTime=" + startTime
                + "\n\tfinishTime=" + finishTime
                + "\n\tpriorityLevel=" + priorityLevel
                + "\n\twaitingTime=" + waitingTime
                + "\n\tturnaroundTime=" + turnaroundTime
                + "\n}";
    }

}
class CPU_Scheduling {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        List<process_info> list = new ArrayList();

        int case_num;
        int n;
        int contextSwitchingCost;
        System.out.println("\nEnter number of processes : ");
        n = sc.nextInt();
        if (n == 0)
        {
            System.out.println("No process !");
            return;
        }

        System.out.println("enter the context switching cost: ");
        contextSwitchingCost=sc.nextInt();

        System.out.println("Choose Algorithm: ");
        System.out.println("1- NonPreemptiveSJF.");
        System.out.println("2- SRTF.");
        System.out.println("3- Priority Scheduling.");

        case_num = sc.nextInt();
        switch (case_num) {
            case 1:
                for (int i = 1; i <= n; i++) {
                    System.out.println("( " + i + " )  Enter ProcessName, ArrvialTime and BurstTime: ");
                    list.add(new process_info(sc.next(), sc.nextInt(), sc.nextInt()));
                }
                NonPreemptiveSJF.Run_schedule(list,contextSwitchingCost);
                break;
            case 2:
                for (int i = 1; i <= n; i++) {
                    System.out.println("( " + i + " )  Enter ProcessName, ArrvialTime and BurstTime: ");
                    list.add(new process_info(sc.next(), sc.nextInt(), sc.nextInt()));
                }
                SRTF.Run_schedule(list);
                break;
            case 3:
                for (int i = 1; i <= n; i++) {
                    System.out.println("( " + i + " )  Enter ProcessName, ArrvialTime and BurstTime and priorityLevel: ");
                    list.add(new process_info(sc.next(), sc.nextInt(), sc.nextInt(),sc.nextInt()));
                }
                NonPreemptivePriority.Run_schedule(list);
                break;
            default:
                System.out.println("ERROR !");

        }
    }
}


//non_preemptive scheduling
class NonPreemptiveSJF
{
    //takes a list of process_info objects representing the processes to be scheduled
    //takes an integer representing the context switching cost.
    public static void Run_schedule(List<process_info> list, int contextSwitchingCost)
    {
        // Create a copy of the list to avoid modifying the original list
        List<process_info> processes = new ArrayList<>(list);

        // Sort the list based on arrival time initially
        sortArrival(processes);

        // calls the method to run the Non-Preemptive SJF
        runNonPreemptiveSJF(processes,contextSwitchingCost);
    }
    // method implements the Non-Preemptive SJF scheduling
    // takes a list of processes and the context switching cost as parameters.
    public static void runNonPreemptiveSJF(List<process_info> processes, int contextSwitchingCost) {
        int currentTime = 0; //variable to hold the current time
        int order=0; //variable to hold order of execution
        int total_WaitingTime = 0; //total waiting time of processes
        int total_TurnaroundTime = 0; //total turnaround time of processes
        int n= processes.size();//number of processes

        //creating a ready queue to hold the processes
        List<process_info> readyQueue = new ArrayList<>();
        //loop that continues until both the list of processes and the ready queue are empty
        while (!processes.isEmpty() || !readyQueue.isEmpty())
        {
            // Move processes from the list to the ready queue whose arrival time has come
            while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= currentTime)
            {
                readyQueue.add(processes.remove(0));
            }

            // Sort the ready queue based on burst time
            sortBurst(readyQueue);

            // start executing the process with the shortest burst time from the ready queue
            if (!readyQueue.isEmpty()) {
                // Execute the process with the shortest burst time
                process_info currentProcess = readyQueue.remove(0);

                // applying the context switching cost
                if (currentTime > 0)
                {
                    currentTime += contextSwitchingCost;
                }

                currentProcess.setStartTime(currentTime);// adjusting start time of the process
                currentProcess.setFinishTime(currentTime + currentProcess.getBurstTime());// adjusting finish time of the process
                currentProcess.setTurnaroundTime(currentProcess.getFinishTime() + contextSwitchingCost - currentProcess.getArrivalTime());// calculating the turnaround time of the process
                currentProcess.setWaitingTime(currentProcess.getTurnaroundTime() - currentProcess.getBurstTime());// calculating the waiting time of the process

                currentTime = currentProcess.getFinishTime();// updating the current time

                total_WaitingTime+=currentProcess.getWaitingTime();// calculating the total waiting time
                total_TurnaroundTime+=currentProcess.getTurnaroundTime();// calculating the total turnaround time


                order++;// incrementing order

                //displaying the process info
                System.out.println("Process "+order+ " executed: " + currentProcess.getProcessName());
                System.out.println(currentProcess);
            }
            else
            {
                // No processes are ready, move time forward
                currentTime++;
            }
        }
        double avgWaitingTime = (double) total_WaitingTime / n; //calculating the average waiting time
        double avgTurnaroundTime = (double) total_TurnaroundTime / n; //calculating the average turnaround time
        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }


    // method used to sort processes based on arrival time
    public static void sortArrival(List<process_info> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getArrivalTime() > list.get(j + 1).getArrivalTime()) {
                    // swapping
                    process_info temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
    // method used to sort processes based on burst time
    public static void sortBurst(List<process_info> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getBurstTime() > list.get(j + 1).getBurstTime()) {
                    //swapping
                    process_info temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
// shortest remaining time first scheduling
class SRTF
{
    //takes a list of process_info objects representing the processes to be scheduled
    public static void Run_schedule(List<process_info> list)
    {
        // Create a copy of the list to avoid modifying the original list
        List<process_info> processes = new ArrayList<>(list);

        // Sort the list based on arrival time initially
        sortArrival(processes);

        // calls the method to run the Preemptive SJF
        runSRTF(processes);
    }

    // method implements the Preemptive SJF scheduling
    // takes a list of processes
    public static void runSRTF(List<process_info> processes)
    {
        int currentTime = 0; //variable to hold the current time
        int order=0; //variable to hold order of execution
        int total_WaitingTime = 0; //total waiting time of processes
        int total_TurnaroundTime = 0; //total turnaround time of processes
        int n= processes.size();//number of processes


        List<process_info> readyQueue = new ArrayList<>();// creating a ready queue to hold the processes
        List<process_info> executionOrder = new ArrayList<>();// creating a execution order to hold the processes in order

        while (!processes.isEmpty() || !readyQueue.isEmpty())
        {
            // Move processes from the list to the ready queue whose arrival time has come
            while (!processes.isEmpty() && processes.get(0).getArrivalTime() <= currentTime)
            {
                readyQueue.add(processes.remove(0));
            }

            // Sort the ready queue based on remaining time
            sortRemainingTime(readyQueue);

            // Execute the process with the shortest remaining time
            // The process details are updated
            // if the process still has remaining time, it is moved back to the ready queue.
            if (!readyQueue.isEmpty())
            {

                process_info currentProcess = readyQueue.remove(0);
                int executionTime = 1; // Default execution time is 1 unit

                //handling the aging by putting the process in front in the ready queue if it's waiting time is more than 10
                if (currentProcess.getWaitingTime() > 30)
                {
                    // Move the process to the front of the ready queue
                    readyQueue.add(0, currentProcess);
                }

                if (currentProcess.getRemainingTime() == 1)
                {
                    executionTime = 1;
                }

                else if (!processes.isEmpty() && processes.get(0).getArrivalTime() <= currentTime + 1)
                {
                    // Check if a new process with smaller remaining time arrives
                    int nextArrivalTime = processes.get(0).getArrivalTime();
                    int remainingTimeAfterOneUnit = currentProcess.getRemainingTime() - 1;

                    if (remainingTimeAfterOneUnit > 0 && remainingTimeAfterOneUnit < (nextArrivalTime - currentTime - 1))
                    {
                        executionTime = remainingTimeAfterOneUnit;
                    }
                }
                currentProcess.setStartTime(currentTime);// adjusting start time of the process
                currentProcess.setFinishTime(currentTime + executionTime);// adjusting finish time of the process
                currentProcess.setTurnaroundTime(currentProcess.getFinishTime() - currentProcess.getArrivalTime());// calculating the turnaround time of the process
                currentProcess.setWaitingTime(currentProcess.getTurnaroundTime() - currentProcess.getBurstTime());// calculating the waiting time of the process
                currentProcess.setRemainingTime(currentProcess.getRemainingTime() - executionTime);//updating the remaining time of the process

                currentTime = currentProcess.getFinishTime();//updating the current time

                order++;// incrementing order

                //displaying the process info

                System.out.println("Process " + order + " executed: " + currentProcess.getProcessName());
                executionOrder.add(new process_info(currentProcess.getProcessName(), currentProcess.getArrivalTime(),currentProcess.getBurstTime(),currentProcess.getStartTime(), currentProcess.getFinishTime(), currentProcess.getWaitingTime(),currentProcess.getTurnaroundTime()));


                // Move the process back to the list if it has remaining time
                if (currentProcess.getRemainingTime() > 0)
                {
                    readyQueue.add(currentProcess);
                }

                //taking the last waiting and turnaround times and updating the total waiting and turnaround
                if(currentProcess.getRemainingTime()==0)
                {
                    total_TurnaroundTime+=currentProcess.getTurnaroundTime();
                    total_WaitingTime+=currentProcess.getWaitingTime();
                }
            }
            else
            {
                // No processes are ready, move time forward
                currentTime++;
            }
        }
        System.out.println("every process excuted for 1 second at a time");
        System.out.println(executionOrder);
        double avgWaitingTime = (double) total_WaitingTime / n; //calculating the average waiting time
        double avgTurnaroundTime = (double) total_TurnaroundTime / n; //calculating the average turnaround time

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    public static void sortArrival(List<process_info> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getArrivalTime() > list.get(j + 1).getArrivalTime()) {
                    // Swapping
                    process_info temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }


    public static void sortRemainingTime(List<process_info> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getRemainingTime() > list.get(j + 1).getRemainingTime()) {
                    // Swapping
                    process_info temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}

// non-preemptive priority scheduling
class NonPreemptivePriority
{
    //takes a list of process_info objects representing the processes to be scheduled
    public static void Run_schedule(List<process_info> list)
    {
        // Create a copy of the list to avoid modifying the original list
        List<process_info> processes = new ArrayList<>(list);

        // Sort the list based on arrival time initially
        sortArrival(processes);

        // calls the method to run the Non-preemptive priority
        runPriorityScheduling(processes);
    }

    public static void runPriorityScheduling(List<process_info> processes)
    {
        int priority = 1;// priority level
        int currentTime = 0; // variable to hold the current time
        int order=0; // variable to hold order of execution
        int total_WaitingTime = 0; // total waiting time of processes
        int total_TurnaroundTime = 0; // total turnaround time of processes
        int n= processes.size();// number of processes


        List<process_info> readyQueue = new ArrayList<>();

        while (!processes.isEmpty() || !readyQueue.isEmpty())
        {
            //sorting the processes array based on the priority level
            sortPriority(processes);

            // Aging: Increase priority of waiting processes
            // if they have been waiting for more than 30 units of time
            for (process_info process : processes)
            {
                if (currentTime - process.getArrivalTime() >= 30)
                {
                    process.setPriorityLevel(process.getPriorityLevel() - 1);
                }
            }

            //The list is sorted again based on the updated priority levels.
            sortPriority(processes);

            // loop moves processes from the list to the ready queue whose priority level is less than or equal to the current priority.
            while (!processes.isEmpty() && processes.get(0).getPriorityLevel() <= priority)
            {
                readyQueue.add(processes.remove(0));
            }

            //block executes the process with the highest priority from the ready queue
            //if no processes are ready, the priority level is increased.
            if (!readyQueue.isEmpty())
            {
                process_info currentProcess = readyQueue.remove(0);

                currentProcess.setStartTime(currentTime); // adjusting start time of the process
                currentProcess.setFinishTime(currentTime + currentProcess.getBurstTime());// adjusting finish time of the process
                currentProcess.setTurnaroundTime(currentProcess.getFinishTime() - currentProcess.getArrivalTime());// calculating the turnaround time of the process
                currentProcess.setWaitingTime(currentProcess.getTurnaroundTime() - currentProcess.getBurstTime());// calculating the waiting time of the process

                currentTime = currentProcess.getFinishTime();//updating the current time

                total_WaitingTime += currentProcess.getWaitingTime();
                total_TurnaroundTime += currentProcess.getTurnaroundTime();


                order++;// incrementing order

                //displaying the process info
                System.out.println("Process " + order + " executed: " + currentProcess.getProcessName());
                System.out.println(currentProcess);

            }
            else
            {
                // No processes are ready, move time forward
                priority++;
            }
        }


        double avgWaitingTime = (double) total_WaitingTime / n; //calculating the average waiting time
        double avgTurnaroundTime = (double) total_TurnaroundTime / n; //calculating the average turnaround time

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
    public static void sortArrival(List<process_info> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getArrivalTime() > list.get(j + 1).getArrivalTime()) {
                    // Swap elements
                    process_info temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
    public static void sortPriority(List<process_info> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getPriorityLevel() > list.get(j + 1).getPriorityLevel()) {
                    // Swap elements
                    process_info temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
