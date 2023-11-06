import java.util.*;
import java.io.*;
public class sposassi1{
	public static void main(String args[]){
	
		ic[] icarr = new ic[30];	
		int icIndex = 0;
		symtab[] symarr = new symtab[20];
		int symIndex = 0;
		mach_c[] marr=new mach_c[30];
		Scanner input = new Scanner(System.in);
		System.out.println("Reading the File : ");
		int line = 0;
		int lc = 0;
		String word = "", id = "", types, opop1, opop2;
		HashMap<String, String> optab = new HashMap<>();
		HashMap<String, String> type = new HashMap<>();
		//OPCODES
		optab.put("STOP", "00");
		optab.put("ADD", "01");
		optab.put("SUB", "02");
		optab.put("MULT", "03");
		optab.put("MOVER", "04");
		optab.put("MOVEM", "05");
		optab.put("COMP", "06");
		optab.put("BC", "07");
		optab.put("DIV", "08");
		optab.put("READ", "09");
		optab.put("BREG","02");
		optab.put("CREG","03");
		optab.put("PRINT", "10");
		optab.put("LE", "02");
		//TYPE
		type.put("STOP", "IS");
		type.put("ADD", "IS");
		type.put("SUB", "IS");
		type.put("MULT", "IS");
		type.put("MOVER", "IS");
		type.put("MOVEM", "IS");
		type.put("COMP", "IS");
		type.put("BC", "IS");
		type.put("DIV", "IS");
		type.put("READ", "IS");
		type.put("PRINT", "IS");
		type.put("DS", "DL");
		type.put("DC", "DL");
		type.put("START", "AD");
		type.put("END", "AD");
		try
		{
			
			File myFile = new File("text.txt");
			Scanner myReader = new Scanner(myFile);
			System.out.println("******************************Assembly Code******************************");
			while(myReader.hasNextLine()){
				String data = myReader.nextLine();
				String[] result = data.split(" ");
				for(int i = 0; i < result.length; i++){
					System.out.print(result[i]+" --- ");
				}
				line++;
				if(result.length == 2){
					opop1 = null;
					opop2 = result[1];
				}
				
				else if(result.length == 1){
					opop1 = null;
					opop2 = null;
				}
				else{
					opop1 = result[1];
					opop2 = result[2];
				}
				if(!result[0].equals("START") && line == 1)
					System.out.println("File should start with 'START'!");
				
				if(line == 1)
					lc = Integer.parseInt(opop2);
				if(line != 1){
					word = result[0];	
					id = optab.get(word);
					System.out.println(id);
				}//System.out.println(lc);
				//types = optab.get(word);
				
				int pos ;
				switch(result[0])
				{
					case "READ":
					pos = symtab.checkSymInSymtab(symarr, symIndex, opop2);
					if (pos == -1)	// symbol not found
					{  // add symbol in symtab
						symarr[symIndex] = new symtab(opop2,0);
						pos = symIndex;
						symIndex++;
					}
					icarr[icIndex] = new ic(Integer.toString(lc), type.get(result[0]),optab.get(result[0]), optab.get(opop1), "S", Integer.toString(pos));
					icIndex++;
					lc++;
					
					break;
					case "PRINT":
						pos = symtab.checkSymInSymtab(symarr, symIndex, opop2);
						if (pos == -1)	// symbol not found
						{  // add symbol in symtab
							symarr[symIndex] = new symtab(opop2,0);
							pos = symIndex;
							symIndex++;
						}
						icarr[icIndex] = new ic(Integer.toString(lc), type.get(result[0]),optab.get(result[0]), optab.get(opop1), "S", Integer.toString(pos));
						icIndex++;
						lc++;
						
						break;
						
					case "MOVER":
						pos = symtab.checkSymInSymtab(symarr, symIndex, opop2);
						if (pos == -1)	// symbol not found
						{  // add symbol in symtab
							symarr[symIndex] = new symtab(opop2,0);
							pos = symIndex;
							symIndex++;
						}
						icarr[icIndex] = new ic(Integer.toString(lc), type.get(result[0]),optab.get(result[0]), optab.get(opop1), "S", Integer.toString(pos));
						icIndex++;
						lc++;
						break;
					
					case "MOVEM":
						pos = symtab.checkSymInSymtab(symarr, symIndex, opop2);
						if (pos == -1)	// symbol not found
						{  // add symbol in symtab
							symarr[symIndex] = new symtab(opop2,0);
							pos = symIndex;
							symIndex++;
						}
						icarr[icIndex] = new ic(Integer.toString(lc), type.get(result[0]),optab.get(result[0]), optab.get(opop1), "S", Integer.toString(pos));
						icIndex++;
						lc++;
						
						break;
					
					case "MULT":
						pos = symtab.checkSymInSymtab(symarr, symIndex, opop2);
						if (pos == -1)	// symbol not found
						{  // add symbol in symtab
							symarr[symIndex] = new symtab(opop2,0);
							pos = symIndex;
							symIndex++;
						}
						icarr[icIndex] = new ic(Integer.toString(lc), type.get(result[0]),optab.get(result[0]), optab.get(opop1), "S", Integer.toString(pos));
						icIndex++;
						lc++;
						
						break;

					case "ADD":
						pos = symtab.checkSymInSymtab(symarr, symIndex, opop2);
						if (pos == -1)	// symbol not found
						{  // add symbol in symtab
							symarr[symIndex] = new symtab(opop2,0);
							pos = symIndex;
							symIndex++;
						}
						icarr[icIndex] = new ic(Integer.toString(lc), type.get(result[0]),optab.get(result[0]), optab.get(opop1), "S", Integer.toString(pos));
						icIndex++;
						lc++;
						
						break;

					case "COMP":
						pos = symtab.checkSymInSymtab(symarr, symIndex,opop2);
						if (pos == -1)	// symbol not found
						{  // add symbol in symtab
							symarr[symIndex] = new symtab(opop2,0);
							pos = symIndex;
							symIndex++;
						}
						icarr[icIndex] = new ic(Integer.toString(lc), type.get(result[0]),optab.get(result[0]), optab.get(opop1), "S", Integer.toString(pos));
						icIndex++;
						lc++;
						
						break;

					case "BC":
						pos = symtab.checkSymInSymtab(symarr, symIndex, opop2);
						if (pos == -1)	// symbol not found
						{  // add symbol in symtab
							symarr[symIndex] = new symtab(opop2,0);
							pos = symIndex;
							symIndex++;
						}
						icarr[icIndex] = new ic(Integer.toString(lc), type.get(result[0]),optab.get(result[0]), optab.get(opop1), "S", Integer.toString(pos));
						icIndex++;
						lc++;
						
						break;
					case "STOP":
						break;
					default:
						//System.out.println("Invalid instruction");
						
				}
			
				System.out.println();
			}
			int i=0;
			while(i<symarr.length)
			{
				if(symarr[i] != null && symarr[i].addre==0) {
					symarr[i].addre=lc;
					lc++;
				}
				i++;
			}
			System.out.println("###############################PASS ONE##################################");
			System.out.println("******************************Symbol Table******************************");
			symtab.printSymtab(symarr, symIndex);
			System.out.println("******************************Intermediate Code******************************");
			ic.printIC(icarr, icIndex);
			System.out.println("###############################PASS TWO##################################");
			System.out.println("******************************Machine Code******************************");
			for(int j=0;j<icIndex;j++)
			{
				int index=Integer.parseInt(icarr[j].op2);
				if(marr[j]==null)
				{
					marr[j]=new mach_c(icarr[j].add, icarr[j].opcode, icarr[j].op1,symarr[index].addre);
					//System.out.println(marr[j].lc1+"******************");
				}
					//System.out.println("Hello***************");
			}
			mach_c.printMach_c(marr, marr.length);
			myReader.close();
		}
		
		catch(FileNotFoundException e){
			System.out.println("An error occured with the file!");
			//e.printStackTrace();
		}
		input.close();
	}
}
class ic{
	String add, type, opcode, op1, op2type, op2;
	ic(String lc, String types, String id, String opop1, String opop2type, String opop2){
		add = lc;
		type = types;
		opcode = id;
		op1 = opop1;
		op2type = opop2type;
		op2 = opop2;
	}
	public static void printIC(ic[] icarr, int length)
	{
		System.out.println("address type  opcode  op1  op2type  op2");
		for (int i = 0 ; i < length ; i++)
			System.out.println(icarr[i].add + "\t" + icarr[i].type + "\t" + icarr[i].opcode + "\t" + icarr[i].op1 + "\t" + icarr[i].op2type + "\t" + icarr[i].op2);
	}
}

class symtab{
	String symbs;
	int addre;
	symtab(String symbols,int addr)
	{
		symbs=symbols;
		addre=addr;
	}

	public static int checkSymInSymtab(symtab[] symarr, int length, String symb)
	{
		int pos = -1;
			for (int i = 0 ; i < length ; i++)
			{
				if (symarr[i].symbs.equals(symb))  // symbol found
				{
					pos = i;
					break;
				}	
			}
		return pos;
	}
	
	public static void printSymtab(symtab[] symarr, int length)
	{
		System.out.println("Index Symbol	Address ");
		for (int i = 0 ; i < length ; i++)
			System.out.println(i+"\t"+symarr[i].symbs + "\t" + symarr[i].addre);

	}

}

class mach_c
{
	String lc1,opc1,opc2;
	int opc3;
	mach_c() 
	{
		lc1="0";
		opc1="0";
		opc2="0";
		opc3=0;
	}
	mach_c(String lcc,String opc1c,String opc2c,int opc3c) 
	{
		lc1=lcc;
		opc1=opc1c;
		opc2=opc2c;
		opc3=opc3c;
	}

	public static void printMach_c(mach_c[] marr, int length)
	{
		System.out.println("address  opc1  opc2  opc3");
		for (int i = 0 ; i < length ; i++)
		{
		if(marr[i]!=null)
			System.out.println(marr[i].lc1 + "\t" + marr[i].opc1 + "\t" + marr[i].opc2 + "\t" + marr[i].opc3 );
		}
	}
}

