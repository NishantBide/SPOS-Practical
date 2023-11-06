import java.util.*;
import java.io.*;
class prac6 {

    static void first_fit()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter no of block:");
        int n=input.nextInt();
        System.out.println("Enter no of process:");
        int s=input.nextInt();
        int[] block=new int[n];
        int[] process=new int[s];
        System.out.println("Enter values of block size:");
        for(int i=0;i<n;i++)
        {
            block[i]=input.nextInt();
        }
        System.out.println("Enter values of process:");
        for(int i=0;i<s;i++)
        {
            process[i]=input.nextInt();
        }
        
        for(int i=0;i<s;i++)
        {
            int flag=-1;
            for(int j=0;j<n;j++)
            {
                if(process[i]<=block[j])
                {
                    flag=j;
                    break;
                }
            }
            if(flag>-1)
            {
                System.out.println("Space found for "+process[i]);
                System.out.print("Before: ");
                for(int k=0;k<n;k++)
                {
                    System.out.print(block[k]+" ");
                }
                System.out.println();
                block[flag]-=process[i];
                System.out.print("After: ");
                for(int k=0;k<n;k++)
                {
                    System.out.print(block[k]+" ");
                }
                System.out.println();

            }

            else{
                System.out.println("Space is not availabe!!!");
            }
        }
    }
    static void nextFit()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter no of block:");
        int n=input.nextInt();
        System.out.println("Enter no of process:");
        int s=input.nextInt();
        int[] block=new int[n];
        int[] process=new int[s];
        System.out.println("Enter values of block size:");
        for(int i=0;i<n;i++)
        {
            block[i]=input.nextInt();
        }
        System.out.println("Enter values of process:");
        for(int i=0;i<s;i++)
        {
            process[i]=input.nextInt();
        }
        
        int ptr=0;
        int pev=0;
        
        for(int i=0;i<s;i++)
        {
            int flag=-1;
            int temp=0;
            for(int j=ptr;j<n;j++)
            {
                temp=j;
                if(process[i]<=block[j])
                {
                    flag=j;
                    ptr=j;
                    pev=ptr;
                    break;
                }
               
            }
            if(temp==n-1 && flag==-1)
            {
                for(int q=0;q<pev;q++)
                {
                    if(process[i]<=block[q])
                {
                    flag=q;
                    break;
                }
                }
            }
            if(flag>-1)
            {
                System.out.println("Space found for "+process[i]);
                System.out.print("Before: ");
                for(int k=0;k<n;k++)
                {
                    System.out.print(block[k]+" ");
                }
                System.out.println();
                block[flag]-=process[i];
                System.out.print("After: ");
                for(int k=0;k<n;k++)
                {
                    System.out.print(block[k]+" ");
                }
                System.out.println();

            }

            else{
                System.out.println("Space is not availabe!!!");
            }
        } 
    }

    static int close_v(int[] arr,int k)
    {
        int p=-1;
        int i=0;
       while(arr[i]<k)
       {
        p=i;
        i++;
       }
        return p;
    }
    static void bestFit()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter no of process:");
        int n=input.nextInt();
        int[] pro=new int[n];
        System.out.println("Enter no of block:");
        int s=input.nextInt();
        int[] block=new int[s];
        System.out.println("Enter values of process:");
        for(int i=0;i<n;i++)
        {
            pro[i]=input.nextInt();
        }
        System.out.println("Enter values of block size:");
        
        for(int i=0;i<s;i++)
        {
            block[i]=input.nextInt();
        }

        for(int i=0;i<n;i++) {
            for(int j=i;j<n-i;j++)
            {
                if(block[j]>block[j+1])
                {
                    int temp=block[j];
                    block[j]=block[j+1];
                    block[j+1]=temp;
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            int k=0;
            k=close_v(block, pro[i]);
            if(k<s)
            {
                System.out.println("Space found for "+pro[i]);
                System.out.println("Before ");
                for(int q=0;q<s;q++)
                    System.out.print(block[q]+" ");
                System.out.println();
                block[k+1]-=pro[i];
                System.out.println("After ");
                for(int q=0;q<s;q++)
                    System.out.print(block[q]+" ");
                System.out.println();
                
            }
            else
            {
                System.out.println("Space is not availabe for "+pro[i]);
            }

        }

    }

    static int max_v(int[] arr)
    {
        int pos=0;
        int max=arr[0];
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
    static void worstFit()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter no of process:");
        int n=input.nextInt();
        int[] pro=new int[n];
        System.out.println("Enter no of block:");
        int s=input.nextInt();
        int[] block=new int[s];
        System.out.println("Enter values of process:");
        for(int i=0;i<n;i++)
        {
            pro[i]=input.nextInt();
        }
        System.out.println("Enter values of block size:");
        
        for(int i=0;i<s;i++)
        {
            block[i]=input.nextInt();
        }

        for(int i=0;i<n;i++)
        {
            int test=max_v(block);
            if(block[test]>=pro[i])
            {
                System.out.println("Space found for "+pro[i]);
                System.out.println("Before ");
                for(int q=0;q<s;q++)
                    System.out.print(block[q]+" ");
                System.out.println();
                block[test]-=pro[i];
                System.out.println("After ");
                for(int q=0;q<s;q++)
                    System.out.print(block[q]+" ");
                System.out.println();
            }
            else
            {
                System.out.println("Space is not availabe for "+pro[i]);
            }
        }


    }
    public static void main(String[] arg)
    {
        //bestFit();
        worstFit();
    }
}
