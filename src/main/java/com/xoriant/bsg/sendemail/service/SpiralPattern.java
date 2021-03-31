package com.xoriant.bsg.sendemail.service;

public class SpiralPattern {

	public static void main(String[] args) {
		int m = 5;
		int[][] spiral = new int[m][m];
		int count = 1;
		int i = 0, j = 0;

		for(; i<1; i++){
			for(; j<=m-1; j++){
				spiral[i][j] = count++;
			}
		}
		j = j-1;
		for(; j>1; j--){
			for(; i<=m-1; i++){
				spiral[i][j] = count++;
			}
		}
		
		i = i-1;
		for(; i>1; i--){
			for(; j>=0; j--){
				spiral[i][j] = count++;
			}
		}
		j = j+1;
		for(; i<2; i++){
			for(; j<2; j++){
				spiral[i][j] = count++;
			}
		}
		
		for(int r=0; r<m; r++){
			for(int s=0; s<m; s++){
				System.out.print(spiral[r][s]+" ");
			}
			System.out.println();
		}
		

	}
	
	private void getSpiral(int m){
		int maxCount = m*m;
		int count = 1;
		int[][] spiral = new int[m][m];
		int i = 0, j = 0;
		do{
			for(; i<1; i++){
				for(; j<=m-1; j++){
					spiral[i][j] = count++;
				}
			}
			j = j-1;
			for(; j>1; j--){
				for(; i<=m-1; i++){
					spiral[i][j] = count++;
				}
			}
			i = i-1;
		}while(count<maxCount);
	}

}
