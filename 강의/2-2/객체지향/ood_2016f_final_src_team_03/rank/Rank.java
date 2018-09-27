package rank;

import java.io.*;

/** �г��Ӱ� ���� ����,����,���⸦ ���� Ŭ����
 *  @author �ϼ��� */
public class Rank {

	/** File_Ranksave(score).txt */
	static File fileS = new File("Ranksave(score).txt"); //���� ��������
	
	/** File_Ranksave(nick).txt  */
	static File fileN = new File("Ranksave(nick).txt"); // �г�����������

	/**
	 * ���Ͽ� ������ �г��Ӹ� ������������ �����Ͽ� �ְ� �����ϴ� �޼ҵ�
	 * @param score
	 * @param nickname
	 * input value
	 * */
	public static void Input(int score,String nickname){
		try {
			/* ���� ���� ���� */
			String fileOut = output(fileS);	
			BufferedWriter bW = new BufferedWriter(new FileWriter(fileS));				
			String str = Integer.toString(score);
			str = str + "A" + fileOut;			
			bW.write(str,0,str.length());
			bW.flush();		
			bW.close(); //���� �ݱ�

			DataInputStream dis = new DataInputStream(new FileInputStream(fileS));
			int count1 = 0;
			int count2 = 0;
			int Inputs;

			char[][] S = new char[6][4];
			for(int i=0;i<6;i++){
				for(int j=0;j<4;j++)
				{
					S[i][j]='!';
				}
			}

			while((Inputs = dis.read()) !=-1) {
				if( Inputs == 65 ){	
					count1++;
					count2 = 0;
					continue;
				}	
				if(count1==6) break;
				S[count1][count2] = (char) Inputs;
				count2++;	
			}   
			int Score[] = new int[7];

			for(int i=0;i<7;i++)
			{ Score[i]=0; }

			for(int i = 0 ; i < 6 ; i++){ //char �迭��  int�� �������·� ��ȯ 
				int sum = 0; int mul = 1;
				for(int j=3; j > -1 ; j--){	
					if(S[i][j]=='!') continue;
					for(int k = 0 ; k < 10 ; k++){
						if(S[i][j] == (char)(48+k))
							sum += k * mul;
					}mul = mul * 10;		
				}
				Score[i] = sum;
				sum = 0; 
			}

			/* �г��� ���� ����*/
			String fileOutn = output(fileN);	
			BufferedWriter buffWrite2 = new BufferedWriter(new FileWriter(fileN));				
			nickname = nickname + "/" + fileOutn;			
			buffWrite2.write(nickname,0,nickname.length());		
			buffWrite2.flush();		
			buffWrite2.close();

			String Nickname[] = new String[6];
			for(int i=0; i<6; i++){  Nickname[i]=""; }


			FileInputStream fis = new FileInputStream(fileN);
			InputStreamReader isr = new InputStreamReader(fis);
			int Inputn; int n = 0;
			while((Inputn = isr.read()) !=-1) {
				if( Inputn == 47 ){					
					n++;
					continue;
				}
				if(n==6)break;
				Nickname[n]+=(char)Inputn;
			}
			isr.close();

			int tscore = 0; 
			String tname = ""; // �̸��� ���� �Ͻ������ϱ����� ����
			for(int j=0 ;j < 7;j++){ // �迭  �������� ����
				for(int k = j+1 ; k < 7 ;k++){
					if(Score[j] < Score[k]){
						tscore = Score[j];
						tname =  Nickname[j];
						Score[j]  = Score[k];
						Nickname[j] =  Nickname[k];
						Score[k] = tscore;
						Nickname[k] = tname;				
					}
					else if(Score[j]==Score[k]);
				}
			}

			BufferedWriter ifbWs = new BufferedWriter(new FileWriter(fileS));
			BufferedWriter ifbWn = new BufferedWriter(new FileWriter(fileN));
			for(int i=0;i<5;i++){
				if(Score[i]==0) break;
				ifbWs.write(Integer.toString(Score[i]));
				ifbWs.write("A");
				ifbWs.flush();
				ifbWn.write( Nickname[i]);
				ifbWn.write("/");
				ifbWn.flush();
			}
			ifbWs.close();
			ifbWn.close();


			dis.close();
		} catch (IOException e) {
			System.out.println("Error Input -- " + e.toString());
		}
	}
	/** Returns void
	 * @return void
	 * */
	
	/**
	 * ������ ���� �г��Ӱ� ������ ���ڿ� �迭�� ��ȯ ���ִ� �޼ҵ�
	 * */
	public static String[] OpenFile() throws IOException{
		String NS[] = new String[6];
		try {	
			char[][] S = new char[6][4];

			DataInputStream dis = new DataInputStream(new FileInputStream(fileS));
			int count1 = 0;
			int count2 = 0;
			int Inputs;

			while((Inputs = dis.read()) !=-1) {
				if( Inputs == 65 ){	
					count1++;
					count2 = 0;
					continue;
				}	
				if(count1==6) break;
				S[count1][count2] = (char) Inputs;
				count2++;	
			}   
			dis.close();

			String Ss[]=new String[6];
			for(int i=0; i<6; i++){
				Ss[i]="";
				for(int j=0; j<4; j++)
					Ss[i]+=S[i][j];
			}

			String N[] = new String[6];
			for(int i=0; i<6; i++){ N[i]=""; }
			int n = 0;

			FileInputStream fis = new FileInputStream(fileN);
			InputStreamReader isr = new InputStreamReader(fis);
			int Inputn;
			while((Inputn = isr.read()) !=-1) {
				if( Inputn == 47 ){					
					n++;
					continue;
				}
				if(n==6)break;
				N[n]+=(char)Inputn;
			}
			isr.close();

			for(int i=0;i<6;i++)
				NS[i] = N[i] + "   " + Ss[i];

		} catch (FileNotFoundException e) {
			System.out.println("Error openfile -- " + e.toString());
		}
		return NS;
	}
	/** Returns String[](�г��� + ���� �迭)
	 * @return String[]
	 * */

	/** 
	 * ���Ͽ� �ִ� ���� �ҷ��� ��ȯ���ִ� �޼ҵ�
	 * @param file
	 * */
	static String output(File file) {	
		int b;			
		String fileContent = "";
		try	{					
			BufferedReader buffRead = new BufferedReader(new FileReader(file));			
			while ((b = buffRead.read()) != -1) {			
				fileContent += (char)b;			
			}
			buffRead.close();			
		}			
		catch (Exception e)	{		
			System.out.println(e);			
		}
		return fileContent;		
	}
	/** Returns String(���Ͽ� ������ִ� ���ڿ�)
	 * @return String
	 * */
}