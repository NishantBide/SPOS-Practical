import java.io.*; 
import java.util.Scanner; 
class CPUScheduling { 
public static void main(String args[]) { 
Scanner s=new Scanner(System.in); 
char ans; 
do { 
System.out.println("\t ---- MENU ---- \n1. FCFS \n2. RoundRobin\n3. SJF\n"); 
System.out.print("Enter Your Choice : "); 
int choice = s.nextInt(); 
switch(choice) { 
case 1: 
FCFS(); 
break; 
case 2: 
RoundRobin(); 
break; 
case 3: 
SJF(); 
break; 
default: 
System.out.print("You have Entered wrong choice"); 
} 
System.out.print("Do you want to Continue?(Y/N) : "); 
ans = s.next().charAt(0); 
} while(ans=='Y'); 
} 
static void FCFS() { 
int i,no_p,burst_time[],TT[],WT[]; 
float avg_wait=0,avg_TT=0; 
burst_time=new int[50]; 
TT=new int[50]; 
WT=new int[50]; 
WT[0]=0;
Scanner s=new Scanner(System.in); 
System.out.print("Enter the number of process : "); 
no_p=s.nextInt(); 
System.out.print("\nEnter Burst Time for processes : "); 
for(i=0;i<no_p;i++) { 
System.out.print("\tP"+(i+1)+": "); 
burst_time[i]=s.nextInt(); 
} 
for(i=1;i<no_p;i++) { 
WT[i]=WT[i-1]+burst_time[i-1]; 
avg_wait+=WT[i]; 
} 
avg_wait/=no_p; 
for(i=0;i<no_p;i++) { 
TT[i]=WT[i]+burst_time[i]; 
avg_TT+=TT[i]; 
} 
avg_TT/=no_p; 
System.out.println("\n-----------------------------------------"); 
System.out.println("\tProcesses:"); 
System.out.println("-------------------------------------------"); 
System.out.println(" Process\tBurst Time\tWaiting Time\tTurn Around Time"); 
for(i=0;i<no_p;i++) { 
System.out.println("\tP"+(i+1)+"\t "+burst_time[i]+"\t\t"+WT[i]+"\t\t "+TT[i]); 
} 
System.out.println("\n----------------------------------------------"); 
System.out.println("\nAverage waiting time : "+avg_wait); 
System.out.println("\nAverage Turn Around time : "+avg_TT+"\n"); } 
static void RoundRobin() { 
int Process[]=new int[10]; 
int a[]=new int[10]; 
int Arrival_time[]=new int[10]; 
int Burst_time[]=new int[10]; 
int WT[]=new int[10]; 
int TAT[]=new int[10]; 
int Pno,sum=0;;
int TimeQuantum; 
System.out.print("\nEnter the no. of Process : "); 
Scanner sc=new Scanner(System.in); 
Pno=sc.nextInt(); 
System.out.print("\nEnter each process : "); 
for(int i=0;i<Pno;i++) { 
Process[i]=sc.nextInt(); 
} 
System.out.print("\nEnter the Burst Time of each process : "); for(int i=0;i<Pno;i++) { 
Burst_time[i]=sc.nextInt(); 
} 
System.out.print("\nEnter the Time Quantum : "); 
TimeQuantum=sc.nextInt(); 
do { 
for(int i=0;i<Pno;i++) { 
if(Burst_time[i]>TimeQuantum) { 
Burst_time[i]-=TimeQuantum; 
for(int j=0;j<Pno;j++) { 
if((j!=i)&&(Burst_time[j]!=0)) 
WT[j]+=TimeQuantum; 
} 
} 
else { 
for(int j=0;j<Pno;j++) { 
if((j!=i)&&(Burst_time[j]!=0)) 
WT[j]+=Burst_time[i]; 
} 
Burst_time[i]=0; 
} 
} 
sum=0; 
for(int k=0;k<Pno;k++) 
sum=sum+Burst_time[k]; 
} while(sum!=0); 
for(int i=0;i<Pno;i++) 
TAT[i]=WT[i]+a[i]; 
System.out.println("process\t\tBT\tWT\tTAT"); 
for(int i=0;i<Pno;i++) { 
System.out.println("process"+(i+1)+"\t"+a[i]+"\t"+WT[i]+"\t"+TAT[i]);
} 
float avg_wt=0; 
float avg_tat=0; 
for(int j=0;j<Pno;j++) { 
avg_wt+=WT[j]; 
} 
for(int j=0;j<Pno;j++) { 
avg_tat+=TAT[j]; 
} 
System.out.println("average waiting time "+(avg_wt/Pno)+"\nAverage turn around time"+(avg_tat/Pno)); 
} 
static void SJF() { 
int burst_time[];
int process[];
int waiting_time[];
int tat[];
int arr_time[],completion_time[];
int i,j,n,total=0,total_comp=0,pos, temp; 
float wait_avg,TAT_avg; 
Scanner s = new Scanner(System.in); 
System.out.print("Enter number of process : "); 
n = s.nextInt(); 
process = new int[n]; 
burst_time = new int[n]; 
waiting_time = new int[n]; 
arr_time=new int[n]; 
tat = new int[n]; 
completion_time=new int[n]; 
//burst time 
System.out.println("\nEnter Burst time:"); 
for(i=0;i<n;i++) { 
System.out.print("\nProcess["+(i+1)+"]: "); 
burst_time[i] = s.nextInt();; 
process[i]=i+1; //Process Number 
} 
//arrival time 
System.out.println("\nEnter arrival time:"); 
for(i=0;i<n;i++) { 
System.out.print("\nProcess["+(i+1)+"]: "); 
arr_time[i] = s.nextInt();; 
process[i]=i+1; //Process Number 
}
//Sorting 
for(i=0;i<n;i++) { 
pos=i; 
for(j=i+1;j<n;j++) { 
if(burst_time[j]<burst_time[pos]) pos=j; 
} 
temp=burst_time[i]; 
burst_time[i]=burst_time[pos]; burst_time[pos]=temp; 
temp=process[i]; 
process[i]=process[pos]; 
process[pos]=temp; 
System.out.printf("process",process[i]); 
} 
//completion time new 
for(i=1;i<n;i++) { 
completion_time[i]=0; 
for(j=0;j<i;j++) 
completion_time[i]+=burst_time[j]; 
total_comp+=completion_time[i]; 
} 
//First process has 0 waiting time 
waiting_time[0]=0; 
//calculate waiting time 
for(i=1;i<n;i++) { 
waiting_time[i]=0; 
for(j=0;j<i;j++) 
waiting_time[i]+=burst_time[j]; 
total+=waiting_time[i]; 
} 
//Calculating Average waiting time 
wait_avg=(float)total/n; 
total=0; 
System.out.println("\nPro_number\t Burst Time\tcompletion_time\tWaiting Time\tTurnaround Time"); 
for(i=0;i<n;i++) { 
tat[i]=burst_time[i]+waiting_time[i]; 
//Calculating Turnaround Time 
total+=tat[i];

System.out.println("\n"+process[i]+"\t\t"+burst_time[i]+"\t\t"+completion_time[i]+"\t\t"+waiting_time[i]+"\t\t "+tat[i]);
} 
//Calculation of Average Turnaround Time 
TAT_avg=(float)total/n; 
System.out.println("\n\nAWT : "+wait_avg); 
System.out.println("\nATAT : "+TAT_avg); 
} 
} 
