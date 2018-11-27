package com.gdxtemplate.game;

public class CheckerPiecesSuperclass {
	
	private int radius = 24;
	private static int[][] a = new int[12][5];
	private static int[][] b = new int[12][5];
	private int x = 0;
	
	public void createArray() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				a[x][0] = 0;
				a[x][1] = x;
				if (i % 2 == 0) {
						a[x][2] = j*100;
				}
				else {
					a[x][2] = j*100 + 50;
				}
				a[x][3] = i*50;
				a[x][4] = 0;
				x++;
			}
			
		}
		x = 0;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				b[x][0] = 0;
				b[x][1] = x;
				if (i % 2 == 1) {
						b[x][2] = j*100;
				}
				else {
					b[x][2] = j*100 + 50;
				}
				b[x][3] = i*-50+ 350;
				b[x][4] = 0;
				x++;
			}
			
		}
		
}
	
	public int[][] ArrayA(){
		return a;
	}
	
	public int[][] ArrayB(){
		return b;
	}
	
	public int GetRadius() {
		return(radius);
	}
	public void ASetState(int i){ ///Allows for king state or deleting
		a[i][4] = 1;
	}
	public void BSetState(int i){ ///Allows for king state or deleting
		b[i][4] = 1;
	}
}
