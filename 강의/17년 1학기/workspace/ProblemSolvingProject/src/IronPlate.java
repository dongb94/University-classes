import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

class Point{
	int x=0, y=0;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class IronPlate {
	static int[][] arr2;
	static Preview p;

	/**
	 * data의 이차원 원소를 l부터 r까지 내림차순 퀵정렬을 한다.
	 * @param data
	 * @param l
	 * @param r
	 */
	public static void quickSort_array(int[][] data, int l, int r) {
		// 가로 길이로 정렬하려면 주석친 부분 배열 인덱스를 0으로 바꾸면 됨, 세로는 1
		// 오름차순으로 정렬하려면 두 개의 while문의 부호를 바꾸면 됨
		int left = l;
		int right = r;
		int pivot = data[(l + r) / 2][0]; // 이 부분

		do {
			while (data[left][0] > pivot) // 이 부분
				left++;
			while (data[right][0] < pivot) // 이 부분
				right--;
			if (left <= right) {
				int temp0 = data[left][0];
				int temp1 = data[left][1];
				data[left][0] = data[right][0];
				data[left][1] = data[right][1];
				data[right][0] = temp0;
				data[right][1] = temp1;
				left++;
				right--;
			}
		} while (left <= right);

		if (l < right)
			quickSort_array(data, l, right);
		if (r > left)
			quickSort_array(data, left, r);
	}
	
	/**
	 * vector의 원소를 l부터 r까지 내림차순 퀵정렬을 한다.
	 * @param data
	 * @param l
	 * @param r
	 */
	public static void quickSort_vector(Vector<Point> v, int l, int r) {
		// 가로 길이로 정렬하려면 주석친 부분을 x로 바꾸면 됨, 세로는 y
		// 오름차순으로 정렬하려면 두 개의 while문의 부호를 바꾸면 됨
		int left = l;
		int right = r;
		int pivot = v.get((l + r) / 2).y; // 이 부분

		do {
			while (v.get(left).y < pivot) // 이 부분
				left++;
			while (v.get(right).y > pivot) // 이 부분
				right--;
			if (left <= right) {
				int temp0 = v.get(left).x;
				int temp1 = v.get(left).y;
				v.get(left).x = v.get(right).x;
				v.get(left).y = v.get(right).y;
				v.get(right).x = temp0;
				v.get(right).y = temp1;
				left++;
				right--;
			}
		} while (left <= right);

		if (l < right)
			quickSort_vector(v, l, right);
		if (r > left)
			quickSort_vector(v, left, r);
	}

	/**
	 * arr[i][0]과 arr[i][1]의 값을 서로 바꿈
	 * @param arr int형 2차원 배열
	 * @param i 바꿀 인덱스
	 */
	static void rotate(int[][] arr, int i){
		int temp = arr[i][0];
		arr[i][0] = arr[i][1];
		arr[i][1] = temp;
	}


	static int solveIronPlate(int[][] arr, int L) {
		// 데이터 정렬
		for(int i = 0; i < arr.length; i++){
			if(arr[i][0] < arr[i][1])
				rotate(arr, i);
		}
		quickSort_array(arr, 0, arr.length - 1);
		for(int i = 0; i < arr.length-1; i++){
			if(arr[i][0] ==  arr[i+1][0] && arr[i][1] < arr[i+1][1]){
				int temp = arr[i][1];
				arr[i][1] = arr[i+1][1];
				arr[i+1][1] = temp;
			}
		}

		// 필요한 변수 선언
		int M=-1;

		Vector<Point> v = new Vector<Point>();
		v.add(new Point(0, 0));

		int[][] using = new int[L][1000]; // 철판에서 사용되고 있는 부분을 저장하는 배열, 0이면 사용x, 1이면 사용 중
		arr2 = new int[arr.length][4]; // 자른 철판들의 위치를 저장하는 배열

		// 배열 초기화
		for(int i=0; i<arr2.length; i++){
			for(int j=0; j<arr2[i].length; j++){
				arr2[i][j] = 0;
			}
		}

		// 철판 자르기
		int i, j, k, l, m=0, x=0, y=0, index=-1;
		for(i = 0; i < arr.length; i++){
			if(arr[i][0] > L) // 철판 한 쪽이 L보다 길어서 세로로 쌓아야 하는 경우
				rotate(arr, i);

			if(arr[i][2] == 0){ // i번째 원소를 아직 사용하지 않은 경우
				boolean enoughSpace = true;

				for(k=0; k<v.size(); k++){
					enoughSpace = true;
					x = v.get(k).x;
					y = v.get(k).y;
					
					for(l = 0; l < arr[i][0]; l++){
						for(m = 0; m < arr[i][1]; m++){
							try{
								if(using[x+l][y+m] == 1)
									enoughSpace = false;
							} catch(ArrayIndexOutOfBoundsException e){
								enoughSpace = false;
							}
						}
					}
					
					if(!enoughSpace){
						enoughSpace = true;
						rotate(arr, i);
						
						for(l = 0; l < arr[i][0]; l++){
							for(m = 0; m < arr[i][1]; m++){
								try{
									if(using[x+l][y+m] == 1)
										enoughSpace = false;
								} catch(ArrayIndexOutOfBoundsException e){
									enoughSpace = false;
								}
							}
						}
					}
					
					if(enoughSpace)
						break;
					else
						rotate(arr, i);
				}

				if(enoughSpace){
					index = k;
					if(arr2[i][2] == 0 && arr2[i][3] == 0){
						arr2[i][0] = x;
						arr2[i][1] = y;
						arr2[i][2] = x+arr[i][0];
						arr2[i][3] = y+arr[i][1];
					}
					for(j = 0; j < arr[i][1]; j++){
						for(k = 0; k < arr[i][0]; k++){
							using[x+k][y+j] = 1;
						}
					}
					arr[i][2] = 1;
					v.remove(index);
					v.add(new Point(x + arr[i][0], y));
					v.add(new Point(x, y + (arr[i][1])));
					quickSort_vector(v, 0, v.size() - 1);
				}
			}
		}

		for(i=0; i<arr2.length; i++){
			for(j=0; j<arr2[i].length; j++){
				M = M > arr2[i][3] ? M : arr2[i][3];
			}
		}


		// 출력
		for(i = 0; i < arr2.length; i++){
			//System.out.print(arr2[i][0] + " " + arr2[i][1] + " " + arr2[i][2] + " " + arr2[i][3] + "\n");
		}

		if(p == null)
			p = new Preview(arr.length);
		p.make(arr2, L, M);
		return M;
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("packing_input.txt"));
			int T = sc.nextInt();    // 테스트 케이스의 수
			for (int t  = 0; t < T; t++) {
				long start = System.currentTimeMillis();
				int N = sc.nextInt();    // 철판의 수
				int L = sc.nextInt();    // 후판의 한 쪽 변의 길이

				int arr[][] = new int[N][3];
				for(int i = 0; i < N; i++){ // 철판의 양 변 길이
					arr[i][0] = sc.nextInt(); // 가로
					arr[i][1] = sc.nextInt(); // 세로
					arr[i][2] = 0; // 아직 사용 안했다는 것을 표시
				}
				long end = System.currentTimeMillis();
				System.out.println("경과 시간 : " + ((float)(end-start))/1000.0 + "초, M = " + solveIronPlate(arr, L));
			}
			p.index = 0;
			p.setVisible(true);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}        
	}
}