package project;

import java.util.*;

public class Sort {
	private Eatery[] temp_list;															//��ȯ�� ���� �ӽ� ����Ʈ����.
	
	public Sort() {
	}
	
	public Eatery[] getbfsort(Eatery array[], Graph graph, int po) {					//�׷��� ���Ŀ� ���� �޼ҵ�
		
		Eatery[] temp_eat = new Eatery[array.length];
		temp_eat = array.clone();
		
		return graph.BFSort(temp_eat, po);
	}
	public Eatery[] getquicksort(Eatery array[] ) {										//�̸� ���Ŀ� ���� �޼ҵ�
		Eatery[] temp_eat = new Eatery[array.length];
		temp_eat = array.clone();
		
		quicksort(temp_eat, 0, temp_eat.length-1);
		return temp_eat;
	}
	
	public Eatery[] getmergesort(Eatery array[]) {										//���� ���Ŀ� ���� �޼ҵ�
		Eatery[] temp_eat = new Eatery[array.length];
		temp_eat = array.clone();
		
		mergesort(temp_eat, 0, temp_eat.length-1);
		return temp_eat;
	}
	//����Ʈ
	public void quicksort(Eatery array[], int left, int right) {
		int i,j;
		Eatery pivot,tmp;
		if(left<right) {
			i=left; j=right;
			pivot = array[(left+right)/2];
			do {
				while(array[i].getName().compareTo(pivot.getName()) < 0) i++;
				while(pivot.getName().compareTo(array[j].getName()) < 0 ) j--;
				if(i <= j) {
					tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
					i++;j--;
				}
			} while(i<=j);
			
			if (left < j) quicksort(array, left, j);
			if (i < right) quicksort(array, i, right);
		}
	}
	
	//����
	public void merge(Eatery array[], int low, int mid, int high) {
		Eatery[] temp = new Eatery[high+1];
		int h = low; int i = low; int j = mid+1;
		while(i<= mid && j <= high) {
			Double i_ = array[i].getRating();
			Double j_ = array[j].getRating();
			if(i_.compareTo(j_) <= 0) {
				temp[h] = array[i];
				i++;
			}
			else {
				temp[h] = array[j];
				j++;
			}
			h++;
		}
			
		if(mid < i) {
			for (int k = j; k<= high; k++) {
				temp[h] = array[k];
				h++;
			}
		}
		else {
			for (int k = i; k<= mid; k++) {
				temp[h] = array[k];
				h++;
			}
		}
		for(int k = low; k<=high; k++) {
			array[k] = temp[k];
		}
	}
	
	//������Ʈ
	public void mergesort(Eatery array[], int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			mergesort(array,low,mid);
			mergesort(array,mid+1,high);
			merge(array,low,mid,high);
		}
	}
	
	
}
