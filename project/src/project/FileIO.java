package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIO {
	
	public FileIO() {}
	
	public void getFile(ArrayList<Eatery> eat, ReservedEatery re, Graph gr) {
		Path text = Paths.get("C:\\Users\\USER\\git\\project\\project\\test(read).txt");
		try {
			BufferedReader reader = Files.newBufferedReader(text, Charset.forName("euc-kr"));
			int i = 0;
			
			String size = reader.readLine();
			
			while(i < Integer.parseInt(size)) {							//1. ������ ������ ������ŭ�� �ݺ�
				Eatery tempEat = new Eatery();				//2. ������ 0��°���� ���� �ֱ�
				eat.add(tempEat);
				String temp = reader.readLine();			//3. ������ �̸� �ֱ�
				eat.get(i).setName(temp);
				
				temp = reader.readLine();					//4. ������ ���� �ֱ�
				double temp2 = Double.parseDouble(temp);
				eat.get(i).setRating(temp2);
			
				temp = reader.readLine();					//5. ������ ��ġ �ֱ�
				eat.get(i).setLocation(temp);
				
				temp = reader.readLine();					//6. ������ �Ұ� �ֱ�
				eat.get(i).setIntroduction(temp);
				
				temp = reader.readLine();					//++ ������ ��ȭ��ȣ �ֱ�
				eat.get(i).setPhonenumber(temp);
				
				temp = reader.readLine();					//7. �򰡳���, �� ���� �ֱ� (�򰡰� ���� ��� if������ ���� ����)
				
				String temp3 = null;	//if���� �� ����	
				
				
				if(temp != null && !temp.equals("#")){		//8. �޸��忡�� ���� �����Ͱ� �־���ϰ�, #�� �ƴϸ� if������ ��
					
					temp3 = reader.readLine();				//9. 7���� temp�� ������ �ϳ��� �о�Ա� ������ �ݺ��� ���� temp3�� ������ ����
					temp2 = Double.parseDouble(temp3);
					eat.get(i).evaluate(temp2, temp);			//10. �򰡳���, ���� �ֱ�
					
					while(true) {
						temp = reader.readLine();			//11. �򰡳���, ������ �� ���� ������ �ݺ�(#�� ������ ������)
						if(!temp.equals("#")) {
							temp3 = reader.readLine();
							temp2 = Double.parseDouble(temp3);
							eat.get(i).evaluate(temp2, temp);
							
						} else {
							break;
						}
					}
				}
				
				temp = reader.readLine();					//12. �޴��� �ֱ� (�򰡰� ���� ��� if������ ���� ����)
				
				int temp_int;
				
				if(temp != null && !temp.equals("*")){		//13. �޸��忡�� ���� �����Ͱ� �־���ϰ�, *�� �ƴϸ� if������ ��
					
					temp3 = reader.readLine();				//14. 12���� temp�� ������ �ϳ��� �о�Ա� ������ �ݺ��� ���� temp3�� ������ ����
					temp_int = Integer.parseInt(temp3);
					eat.get(i).addMenu(new Food(temp_int, temp));			//15. ����, �̸��� ���� ���� ��ü�� �ֱ�.
					
					while(true) {
						temp = reader.readLine();			//16. ������ �� ���� ������ �ݺ�(*�� ������ ������)
						if(!temp.equals("*")) {
							temp3 = reader.readLine();
							temp_int = Integer.parseInt(temp3);
							eat.get(i).addMenu(new Food(temp_int, temp));
							
						} else {
							break;
						}
					}
				}
				
				i++;										//17. i��° ������ ������ �� �־����� ���� ������ ������ ����
				
			}
			reader.close();
			
		}
		
		catch (IOException e){
			e.printStackTrace();
		}
			
		Path text2 = Paths.get("C:\\Users\\USER\\git\\project\\project\\reservate_test(read).txt");	//���� ���� �ҷ�����
		
		try {
			BufferedReader reader = Files.newBufferedReader(text2, Charset.forName("euc-kr"));
			String temp;
			int zz = 0;
			while((temp = reader.readLine()) != null) {
				re.setReservedContent(temp);
				zz++;
			}
			reader.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
		Path text3 = Paths.get("C:\\Users\\USER\\git\\project\\project\\map(read).txt");	//���� �ҷ�����.
		
		try {
			BufferedReader reader = Files.newBufferedReader(text3, Charset.forName("euc-kr"));
			String temp;
			int size = Integer.parseInt(reader.readLine());
			gr.setNodeSize(size);
			for (int i = 0; i<size; i++) {
				temp = reader.readLine();
				gr.setHash(temp, i);
			}
			temp = reader.readLine();					//�׷��� �����ϱ�
			
			String temp2 = null;	//if���� �� ����	
			
			
			if(temp != null && !temp.equals("#")){		//�޸��忡�� ���� �����Ͱ� �־���ϰ�, #�� �ƴϸ� if������ ��
				
				temp2 = reader.readLine();				//temp�� ������ �ϳ��� �о�Ա� ������ �ݺ��� ���� temp2�� ������ ����
				gr.addEdge(temp, temp2);
				
				while(true) {
					temp = reader.readLine();
					if(!temp.equals("#")) {
						temp2 = reader.readLine();
						gr.addEdge(temp, temp2);
					} else {
						break;
					}
				}
			}
			
			reader.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void setFile(ArrayList<Eatery> eat, ReservedEatery re) {
		File file = new File("C:\\Users\\USER\\git\\project\\project\\test(write).txt");
		String temp = null;
		
		try {
			FileWriter filewriter = new FileWriter(file);
			int i = 0;

			if(file.isFile() && file.canWrite()) {
				filewriter.append(eat.size() + "\n");
				while(i < eat.size()) {													//1. ������ ������ ������ŭ �ݺ�
					filewriter.append(eat.get(i).getName() + "\n");					//2. i��° ������ �̸� ����
					filewriter.append(eat.get(i).getRating() + "\n");				//3. ������ ���� ����
					filewriter.append(eat.get(i).getLocation() + "\n");				//4. ������ ��ġ ����
					filewriter.append(eat.get(i).getIntroduction() + "\n");			//5. ������ �Ұ� ����
					filewriter.append(eat.get(i).getPhonenumber() + "\n");			//++. ������ ��ȭ��ȣ ����
					int j = 0;
					while(j < eat.get(i).getEval_size()) {
						filewriter.append(eat.get(i).getEvaluate_string(j) + "\n");	//6. ������ �� ����, ���� ����
						temp = String.valueOf(eat.get(i).getEvaluate_rate(j));
						filewriter.append(temp + "\n");
						j++;
					}
					filewriter.append("#\n");		//7. ���� ������ �� �־��ٸ� #�� �ְ� ���� �޴� ���� ����
					j = 0;
					while(j < eat.get(i).getMenu_size()) {
						filewriter.append(eat.get(i).getMenu(j).getName() + "\n");	//8. �޴��� ���� ����
						temp = String.valueOf(eat.get(i).getMenu(j).getPrice());
						filewriter.append(temp + "\n");
						j++;
					}
					filewriter.append("*\n");		//9. �޴� ������ �� �־��ٸ� *�� �ְ� ���� �޴� ���� ����
					i++;
				}
			}
			filewriter.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		File file2 = new File("C:\\Users\\USER\\git\\project\\project\\reservate_test(write).txt");	//���� ���� ����
		
		try {
			FileWriter filewriter = new FileWriter(file2);
			int i = 0;
			if(file2.isFile() && file2.canWrite()) {
				while(i < re.getReservedContent_size()) {
					filewriter.append(re.getReservedContent(i) + "\n");
					i++;
				}
			}
			filewriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}