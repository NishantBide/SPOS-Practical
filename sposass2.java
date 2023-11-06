import java.util.*;
import java.io.*;
//import java.io.FileWriter;
//import java.io.IOException;

public class sposass2 {
	public static void main(String arg[]) {
		String[] MDT = new String[40];
		int MDT_index = 0;
		MNT[] mnt_table= new MNT[20];
		int mnt_index=0;
		try {
			File myFile = new File("Input.txt");
			Scanner myReader = new Scanner(myFile);
			FileWriter ir = new FileWriter("Intermediate.txt");
			String str = "";

			int flag = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				// String[] result = data.split(" ");

				if (data.equals("MACRO")) {
					data = myReader.nextLine();
					while (!data.equals("MEND")) {

						MDT[MDT_index] = data;
						System.out.println(MDT_index+" "+MDT[MDT_index]);

						MDT_index++;
						data = myReader.nextLine();
					}
					MDT[MDT_index] = data;
					System.out.println(MDT_index+" "+MDT[MDT_index]);

					MDT_index++;
					flag = 1;
				}

				if (flag == 0)
					ir.write(data + "\n");

				if (data.equals("MEND"))
					flag = 0;

			}
			//int MDT_l= MDT.length;
			//System.out.println(MDT_index);
			for(int i=0;i<MDT_index;i++)
			{
				
				if(mnt_index==0)
				{
				String[] temp=MDT[0].split(" ");
				mnt_table[0]= new MNT(temp[0],0);
				mnt_index++;
				}
				
				else if(MDT[i].equals("MEND") && i<MDT_index-1)
				{
					String[] temp=MDT[i+1].split(" ");
					mnt_table[mnt_index]= new MNT(temp[0],i+1);
					mnt_index++;
					
				}
				
			}
			ir.close();
			System.out.println("MNT Table");
			MNT.display(mnt_table,mnt_index);
			File myFile2 = new File("Intermediate.txt");
			Scanner myReader2 = new Scanner(myFile2);
			FileWriter ot = new FileWriter("Output.txt");
			int val=-1;
			while (myReader2.hasNextLine())
			{
				String data2 = myReader2.nextLine();
				String[] result=data2.split(" ");
				for(int i=0;i<mnt_index;i++)
				{
					if(result[0].equals(mnt_table[i].macro_n))
					{
						val=i;
						break;
					}
					else
						val=-1;
					
				}
				if(val==-1)
					ot.write(data2+"\n");
				else
				{
						int temp=mnt_table[val].m_index;
						temp+=1;
						while(!MDT[temp].equals("MEND"))
						{
							
							ot.write(MDT[temp]+"\n");
							temp+=1;
						}
				}
			}

			
			ot.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured with the file!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occured with the file!");
			e.printStackTrace();
		}
		
	}
}

class MNT 
{
	String macro_n;
	int m_index;
	MNT(String m_n, int m_i)
	{
		macro_n=m_n;
		m_index=m_i;
	}
    public static void display(MNT[] arr, int length)
	{
		for(int i=0;i<length;i++)
		{
			System.out.println(arr[i].macro_n+" "+arr[i].m_index);
		}
	}
}
