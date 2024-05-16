# CPU-Scheduling-Simulator
implementation of  CPU Scheduling Simulator  java code
CPU Scheduling Simulator
This project implements a CPU scheduling simulator in Java. The simulator supports three different scheduling algorithms: Non-Preemptive Shortest Job First (SJF), Shortest Remaining Time First (SRTF), and Non-Preemptive Priority Scheduling.

Table of Contents
Getting Started
Usage
Classes and Methods
Scheduling Algorithms
Examples
License
Getting Started
Prerequisites
Java Development Kit (JDK) installed
A code editor or IDE (such as IntelliJ IDEA or Eclipse)
Usage
Run the main method in the CPU_Scheduling class.
Follow the prompts to enter the number of processes, context switching cost, and the details of each process.
Choose the scheduling algorithm:
Non-Preemptive Shortest Job First (SJF)
Shortest Remaining Time First (SRTF)
Non-Preemptive Priority Scheduling
Classes and Methods
process_info
This class contains information about the processes and methods to manipulate and access that information.

Attributes:
String processName
int arrivalTime
int burstTime
int startTime
int finishTime
int priorityLevel
int waitingTime
int turnaroundTime
int RemainingTime
double quantumTime
int AG_factor
int randomNum
double nonPreemptiveQuantum
Constructors:
process_info(String processName, int arrivalTime, int burstTime, int priorityLevel)
process_info(String processName, int arrivalTime, int burstTime)
process_info(String processName, int arrivalTime, int burstTime, int startTime, int finishTime, int waitingTime, int turnaroundTime)
process_info(String processName, int arrivalTime, int burstTime, int priorityLevel, double quantumTime)
Methods:
Getters and setters for all attributes.
toString(): Returns a string representation of the process.
CPU_Scheduling
The main class to execute the CPU scheduling simulator.

Methods:
main(String[] args): Entry point of the program. Handles user input and initiates the chosen scheduling algorithm.
NonPreemptiveSJF
Class to handle Non-Preemptive Shortest Job First (SJF) scheduling.

Methods:
Run_schedule(List<process_info> list, int contextSwitchingCost)
runNonPreemptiveSJF(List<process_info> processes, int contextSwitchingCost)
sortArrival(List<process_info> list)
sortBurst(List<process_info> list)
SRTF
Class to handle Shortest Remaining Time First (SRTF) scheduling.

Methods:
Run_schedule(List<process_info> list)
runSRTF(List<process_info> processes)
sortArrival(List<process_info> list)
sortRemainingTime(List<process_info> list)
NonPreemptivePriority
Class to handle Non-Preemptive Priority Scheduling.

Methods:
Run_schedule(List<process_info> list)
runPriorityScheduling(List<process_info> processes)
sortArrival(List<process_info> list)
sortPriority(List<process_info> list)
Scheduling Algorithms
Non-Preemptive Shortest Job First (SJF)
This algorithm selects the process with the shortest burst time to execute next. It is a non-preemptive algorithm, meaning once a process starts execution, it runs to completion.

Shortest Remaining Time First (SRTF)
This preemptive version of SJF always selects the process with the smallest remaining time to execute next. If a new process arrives with a shorter remaining time, the current process is preempted and moved back to the ready queue.

Non-Preemptive Priority Scheduling
This algorithm selects the process with the highest priority (lowest numerical value) to execute next. It is non-preemptive, so the selected process runs to completion before the next process is selected based on priority.

Examples
To run the simulator, execute the CPU_Scheduling class. Example prompts and user input sequence:

Enter number of processes: 3
Enter the context switching cost: 2
Choose Algorithm:
1- NonPreemptiveSJF.
2- SRTF.
3- Priority Scheduling.
For each process, enter:
ProcessName, ArrivalTime, BurstTime
For Priority Scheduling, also enter PriorityLevel
License
This project is licensed under the MIT License - see the LICENSE.md file for details.
