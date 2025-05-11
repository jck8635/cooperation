package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileIO {
	
	public FileIO() {
	}
	
	//음식점 정보 불러오기
	public void getFile(ArrayList<Eatery> eat, ReservedEatery re,Graph gr) {
		File storelist = new File("c:/Users/USER/git/project-master/project-master/test(write).txt");
		try {
			FileReader fr = new FileReader(storelist);
			BufferedReader reader = new BufferedReader(fr);
			
			int i = 0;
			
			String size = reader.readLine();
			
			while(i < Integer.parseInt(size)) {				//1. 정해진 음식점 개수만큼만 반복
				Eatery tempEat = new Eatery();				//2. 음식점 0번째부터 정보 넣기
				eat.add(tempEat);
				String temp = reader.readLine();			//3. 음식점 이름 넣기
				eat.get(i).setName(temp);
				
				temp = reader.readLine();					//4. 음식점 평점 넣기
				double temp2 = Double.parseDouble(temp);
				eat.get(i).setRating(temp2);
			
				temp = reader.readLine();					//5. 음식점 위치 넣기
				eat.get(i).setLocation(temp);
				
				temp = reader.readLine();					//6. 음식점 소개 넣기
				eat.get(i).setIntroduction(temp);
				
				temp = reader.readLine();					//++ 음식점 전화번호 넣기
				eat.get(i).setPhonenumber(temp);
				
				temp = reader.readLine();					//7. 평가내용, 각 평점 넣기 (평가가 없을 경우 if문으로 들어가지 않음)
				
				String temp3 = null;						//if문에 쓸 변수	
				
				
				if(temp != null && !temp.equals("#")){		//8. 메모장에서 읽을 데이터가 있어야하고, #이 아니면 if문으로 들어감
					
					temp3 = reader.readLine();				//9. 7에서 temp로 데이터 하나를 읽어왔기 때문에 반복문 이전 temp3에 데이터 저장
					temp2 = Double.parseDouble(temp3);
					eat.get(i).evaluate(temp2, temp);		//10. 평가내용, 평점 넣기
					
					while(true) {
						temp = reader.readLine();			//11. 평가내용, 평점을 다 넣을 때까지 반복(#이 나오기 전까지)
						if(!temp.equals("#")) {
							temp3 = reader.readLine();
							temp2 = Double.parseDouble(temp3);
							eat.get(i).evaluate(temp2, temp);
							
						} else {
							break;
						}
					}
				}
				
				temp = reader.readLine();					//12. 메뉴판 넣기 (평가가 없을 경우 if문으로 들어가지 않음)
				
				int temp_int;
				
				if(temp != null && !temp.equals("*")){		//13. 메모장에서 읽을 데이터가 있어야하고, *이 아니면 if문으로 들어감
					
					temp3 = reader.readLine();				//14. 12에서 temp로 데이터 하나를 읽어왔기 때문에 반복문 이전 temp3에 데이터 저장
					temp_int = Integer.parseInt(temp3);
					eat.get(i).addMenu(new Food(temp_int, temp));			//15. 가격, 이름을 가진 음식 객체를 넣기.
					
					while(true) {
						temp = reader.readLine();			//16. 음식을 다 넣을 때까지 반복(*이 나오기 전까지)
						if(!temp.equals("*")) {
							temp3 = reader.readLine();
							temp_int = Integer.parseInt(temp3);
							eat.get(i).addMenu(new Food(temp_int, temp));
							
						} else {
							break;
						}
					}
				}
				
				i++;										//17. i번째 음식점 정보를 다 넣었으니 다음 음식점 정보를 넣음
				
			}
			reader.close();
			
		}
		
		catch (IOException e){
			e.printStackTrace();
		}

		//예약 정보 불러오기
		Path text2 = Paths.get("c:/Users/USER/git/project-master/project-master/test(write).txt");	
		
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
		
		//지도 불러오기
		Path text3 = Paths.get("c:/Users/USER/git/project-master/project-master/test(write).txt");
		
		try {
			BufferedReader reader = Files.newBufferedReader(text3, Charset.forName("euc-kr"));
			String temp;
			int size = Integer.parseInt(reader.readLine());
			gr.setNodeSize(size);
			for (int i = 0; i<size; i++) {
				temp = reader.readLine();
				gr.setHash(temp, i);
			}
			temp = reader.readLine();					//그래프 연결하기
			
			String temp2 = null;	//if문에 쓸 변수	
			
			
			if(temp != null && !temp.equals("#")){		//메모장에서 읽을 데이터가 있어야하고, #이 아니면 if문으로 들어감
				
				temp2 = reader.readLine();				//temp로 데이터 하나를 읽어왔기 때문에 반복문 이전 temp2에 데이터 저장
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
		File file = new File("c:/Users/USER/git/project-master/project-master/test(write).txt");
		String temp = null;
		
		try {
			FileWriter filewriter = new FileWriter(file);
			int i = 0;

			if(file.isFile() && file.canWrite()) {
				filewriter.append(eat.size() + "\n");
				while(i < eat.size()) {													//1. 정해진 음식점 개수만큼 반복
					filewriter.append(eat.get(i).getName() + "\n");					//2. i번째 음식점 이름 저장
					filewriter.append(eat.get(i).getRating() + "\n");				//3. 음식점 평점 저장
					filewriter.append(eat.get(i).getLocation() + "\n");				//4. 음식점 위치 저장
					filewriter.append(eat.get(i).getIntroduction() + "\n");			//5. 음식점 소개 저장
					filewriter.append(eat.get(i).getPhonenumber() + "\n");			//++. 음식점 전화번호 저장
					int j = 0;
					while(j < eat.get(i).getEval_size()) {
						filewriter.append(eat.get(i).getEvaluate_string(j) + "\n");	//6. 음식점 평가 내용, 평점 저장
						temp = String.valueOf(eat.get(i).getEvaluate_rate(j));
						filewriter.append(temp + "\n");
						j++;
					}
					filewriter.append("#\n");		//7. 평점 정보를 다 넣었다면 #을 넣고 다음 메뉴 정보 저장
					j = 0;
					while(j < eat.get(i).getMenu_size()) {
						filewriter.append(eat.get(i).getMenu(j).getName() + "\n");	//8. 메뉴판 음식 저장
						temp = String.valueOf(eat.get(i).getMenu(j).getPrice());
						filewriter.append(temp + "\n");
						j++;
					}
					filewriter.append("*\n");		//9. 메뉴 정보를 다 넣었다면 *을 넣고 다음 메뉴 정보 저장
					i++;
				}
			}
			filewriter.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		File file2 = new File("c:/Users/USER/git/project-master/project-master/test(write).txt");	//예약 정보 저장
		
		try {
			FileWriter filewriter = new FileWriter(file2);
			int i = 0;
			if(file2.isFile() && file2.canWrite()) {
				while(i < re.getReservedContent_size()) {
					filewriter.append(re.getReservedContent(i) + "\n");
					i++;
				}
			}			filewriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}


		
		