import java.io.*;
import java.util.Arrays; 
import java.util.Scanner; 

class Scheduling { 
    public static void main(String args[]) { 
        Scanner s=new Scanner(System.in); 
        char ans; 
        do { 
            System.out.println("\t ---- MENU ---- \n1. RoundRobin \n2.Priority(Non-preemptive)\n"); 
            System.out.print("Enter Your Choice : "); 
            int choice = s.nextInt(); 
            switch(choice) { 
            case 1: 
                RoundRobin(); 
                break; 
            case 2: 
                P_N_P();
                break; 
            default: 
                System.out.print("You have Entered wrong choice"); 
            } 
            System.out.print("Do you want to Continue?(Y/N) : "); 
            ans = s.next().charAt(0); 
        } while(ans=='Y'); 
    }
static void RoundRobin() { 
	int n,i,qt,count=0,temp,sq=0,bt[],wt[],tat[],rem_bt[];  
		float awt=0,atat=0;  
		bt = new int[10];  
		wt = new int[10];  
		tat = new int[10];  
		rem_bt = new int[10];  
		Scanner s=new Scanner(System.in);  
		System.out.print("Enter the number of process (maximum 10) = ");  
		n = s.nextInt();  
		System.out.print("Enter the burst time of the process\n");  
		for (i=0;i<n;i++)  
		{  
			System.out.print("P"+i+" = ");   
			bt[i] = s.nextInt();  
			rem_bt[i] = bt[i];  
		}  
		System.out.print("Enter the quantum time: ");  
		qt = s.nextInt();  
		while(true)  
		{  
		for (i=0,count=0;i<n;i++)  
		{  
			temp = qt;  
			if(rem_bt[i] == 0)  
			{  
				count++;  
				continue;  
			}  
			if(rem_bt[i]>qt)  
				rem_bt[i]= rem_bt[i] - qt;  
			else  
				if(rem_bt[i]>=0)  
				{  
					temp = rem_bt[i];  
					rem_bt[i] = 0;  
				}  
			 System.out.println(" P"+i);
			sq = sq + temp;  
			tat[i] = sq;  
		}  
		if(n == count)  
			break;  
		}  
		System.out.print("--------------------------------------------------------------------------------");  
		System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");  
		System.out.print("--------------------------------------------------------------------------------");  
		for(i=0;i<n;i++)  
		{  
			wt[i]=tat[i]-bt[i];  
			awt=awt+wt[i];  
			atat=atat+tat[i];  
			System.out.print("\n "+(i+1)+"\t "+bt[i]+"\t\t "+tat[i]+"\t\t "+wt[i]+"\n");  
		}  
		awt=awt/n;  
		atat=atat/n;  
		System.out.println("\nAverage waiting Time = "+awt+"\n");  
		System.out.println("Average turnaround time = "+atat);  
		} 

static void P_N_P(){
System.out.println("*** Priority Scheduling ***");

        System.out.print("Enter Number of Process: ");
        Scanner sc = new Scanner(System.in);
        int numberOfProcess = sc.nextInt();
        String process[] = new String[numberOfProcess];

        int p = 1;
        for (int i = 0; i < numberOfProcess; i++) {
            process[i] = "P" + p;
            p++;
        }

        System.out.println(Arrays.toString(process));

        System.out.print("Enter Burst Time for " + numberOfProcess + " process: ");

        int burstTime[] = new int[numberOfProcess];
        for (int i = 0; i < numberOfProcess; i++) {
            burstTime[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(burstTime));

        System.out.print("Enter Priority for " + numberOfProcess + " process: ");

        int priority[] = new int[numberOfProcess];
        for (int i = 0; i < numberOfProcess; i++) {
            priority[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(priority));

int temp;
String temp2;
for (int i = 0; i < numberOfProcess - 1; i++) {
      for (int j = 0; j < numberOfProcess - 1; j++) {
            if (priority[j] > priority[j + 1]) {
                   temp = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = temp;

                    temp = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = temp;

                    temp2 = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = temp2;

                }
            }
        }

        int TAT[] = new int[numberOfProcess ];
        int waitingTime[] = new int[numberOfProcess ];

        for (int i = 0; i < numberOfProcess; i++) {
            TAT[i] = burstTime[i] + waitingTime[i];
            waitingTime[i + 1] = TAT[i];
        }

        int totalWT = 0;
        int totalTAT = 0;
        double avgWT;
        double avgTAT;

        System.out.println("Process     BT      WT        TAT");
        for (int i = 0; i < numberOfProcess; i++) {

            System.out.println(process[i] + "          " + burstTime[i] + "       " + waitingTime[i] + "         " + (TAT[i]));
            totalTAT += (waitingTime[i] + burstTime[i]);
            totalWT += waitingTime[i];

        }

        avgWT = totalWT / (double) numberOfProcess;
        avgTAT = totalTAT / (double) numberOfProcess;

        System.out.println("\n Average Wating Time: " + avgWT);
        System.out.println(" Average Turn Around Time: " + avgTAT);
}

}

