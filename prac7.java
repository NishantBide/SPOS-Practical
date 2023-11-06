import java.io.*;
import java.util.*;
class prac7{

    static int min_v(int[] arr)
    {
        int min=arr[0];
        int pos=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]<min)
            {
                min=arr[i];
                pos=i;
            }
        }
        return pos;
    }

    static int pres(int[] arr,int k)
    {
        int p=-1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==k)
            {  p=i;
                break;
            } 

        }
        return p;
    }

    static int check(int[] arr,int k,int pos)
    {
        int p=-1;
        for(int i=pos+1;i<arr.length;i++)
        {
            if(arr[i]==k)
            {  p=i;
                break;
            } 

        }
        return p;
    }

    static void display(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

    

    static void LRU()
    {
        
        System.out.println("Enter no of processes:");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] pro=new int[n];
        System.out.println("Enter value of processes:");
        for(int i=0;i<n;i++)
        {
            pro[i]=input.nextInt();
        }
        System.out.println("Enter size of frame:");
        int s=input.nextInt();
        int[] frame=new int[s];
        int[] least=new int[s];
        for(int i=0;i<s;i++)
        {
            frame[i]=-1;
            least[i]=-1;
        }
        int l=-1;
        int temp=-1;
        for(int i=0;i<n;i++)
        {
            temp=pres(frame, pro[i]);
            if(temp>=0)
            {
                System.out.println("page hit");
                display(frame);
                System.out.println();
            }

            else{
                System.out.println("page fault");
                l=min_v(least);
                frame[l]=pro[i];
                least[l]=i;
                display(frame);
                System.out.println();
                
            }
        }

    }

    static int max_v(int[] arr)
    {
        int max=arr[0];
        int pos=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
                pos=i;
            }
        }
        return pos;
    }

    static void optimal()
    {
        System.out.println("Enter no of processes:");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] pro=new int[n];
        System.out.println("Enter value of processes:");
        for(int i=0;i<n;i++)
        {
            pro[i]=input.nextInt();
        }
        System.out.println("Enter size of frame:");
        int s=input.nextInt();
        int[] frame=new int[s];
        int[] most=new int[s];
        for(int i=0;i<s;i++)
        {
            frame[i]=-1;
            most[i]=-1;
        }
        int temp=-1;
        int t=-1;
        for(int i=0;i<n;i++)
        {
            temp=pres(frame, pro[i]);
            if(temp>=0)
            {
                System.out.println("Page hit");
                display(frame);
                System.out.println();
            }
            else{
                int q=min_v(frame);
                if(frame[q]==-1)
                {
                    System.out.println("Page fault");
                    frame[q]=pro[i];
                    display(frame);
                    System.out.println();
                }
                else
                {
                    for(int l=0;l<s;l++)
                    {
                        most[l]=check(pro, frame[l], i);
                    }
                    int f=min_v(most);
                    if(most[f]==-1)
                    {
                        System.out.println("Page fault");
                        frame[f]=pro[i];
                        display(frame);
                        System.out.println();
                    }
                    else
                    {
                        int z=max_v(most);
                        System.out.println("Page fault");
                        frame[z]=pro[i];
                        display(frame);
                        System.out.println();
                    }
                    
                }
            }
        }
    }

    public static void main(String[] arg)
    {
        LRU();
        optimal();
    }
}