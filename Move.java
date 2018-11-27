package com.gdxtemplate.game;

public class Move {

	private static int turn = 0;
	private int TakenPiece = 0;
	private int Tile1, Tile2;
	
	CheckerPiecesSuperclass ChPiSu = new CheckerPiecesSuperclass();
	
	public void ATakePieces(int[][] b, int i) {
		b[i][2] = 600;
		b[i][3] = 600;
		b[i][4] = 2;
	}
	
	public void BTakePieces(int[][] a, int i) {
		a[i][2] = 600;
		a[i][3] = 600;
		a[i][4] = 2;
	}
	
	public void AMoveLeftForward(int[][] a, int[][] b, int i) {
		Tile1 = 0;
		Tile2 = 0;
		if(a[i][2] != 0 && a[i][3] != 350) {
			for (int j = 0; j < 12; j++) {
				if(a[i][2] - 50 == b[j][2] && a[i][3] + 50 == b[j][3]) {
					Tile1 = 1;
				}
				if(a[i][2] - 50 == a[j][2] && a[i][3] + 50 == a[j][3]) {
					Tile1 = 1;
					Tile2 = 1;
				}
				if (a[i][2] - 100 == b[j][2] && a[i][3] + 100 == b[j][3]) {
					Tile2 = 1;
				}
				if (a[i][2] - 100 == a[j][2] && a[i][3] + 100 == a[j][3]) {
					Tile2 = 1;
				}
			}
			if (a[i][2] >= 100 && a[i][3] <= 250) {
				if (Tile1 == 1 && Tile2 == 0) {
					for (int j = 0; j < 12; j++) {
						if (a[i][2] - 50 == b[j][2] && a[i][3] + 50 == b[j][3]) {
							TakenPiece = j;
						}
					}
					a[i][2] -=100;
					a[i][3] += 100;
					ATakePieces(b, TakenPiece);
					turn++;
				}
			}
			if(Tile1 == 0) {
				a[i][2] -= 50;
				a[i][3] += 50;
				turn++;
			}
		}
		if (a[i][3] == 350) {
			ChPiSu.ASetState(i);
		}
	}
	public void AMoveRightForward(int[][] a, int[][] b, int i) {
		Tile1 = 0;
		Tile2 = 0;
		if(a[i][2] != 350 && a[i][3] != 350) {
			for (int j = 0; j < 12; j++) {
				if(a[i][2] + 50 == b[j][2] && a[i][3] + 50 == b[j][3]) {
					Tile1 = 1;
				}
				if(a[i][2] + 50 == a[j][2] && a[i][3] + 50 == a[j][3]) {
					Tile1 = 1;
					Tile2 = 1;
				}
				if ((a[i][2] + 100 == b[j][2] && a[i][3] + 100 == b[j][3])) {
					Tile2 = 1;
				}
				if (a[i][2] + 100 == a[j][2] && a[i][3] + 100 == a[j][3]) {
					Tile2 = 1;
				}
			}
			if (a[i][2] <= 250 && a[i][3] <= 250) {
				if (Tile1 == 1 && Tile2 == 0) {
					for (int j = 0; j < 12; j++) {
						if (a[i][2] + 50 == b[j][2] && a[i][3] + 50 == b[j][3]) {
							TakenPiece = j;
						}
					}
					a[i][2] +=100;
					a[i][3] += 100;
					ATakePieces(b, TakenPiece);
					turn++;
				}
			}
			if(Tile1 == 0) {
				a[i][2] += 50;
				a[i][3] += 50;
				turn++;
			}
		}
		if (a[i][3] == 350) {
			ChPiSu.ASetState(i);
		}
	}
	
	
	public void BMoveLeftForward(int[][] a, int[][] b, int i) {
	Tile1 = 0;
	Tile2 = 0;
	if(b[i][2] != 0 && b[i][3] != 0) {
		for (int j = 0; j < 12; j++) {
			if(b[i][2] - 50 == a[j][2] && b[i][3] - 50 == a[j][3]) {
				Tile1 = 1;
			}
			if(b[i][2] - 50 == b[j][2] && b[i][3] - 50 == b[j][3]) {
				Tile1 = 1;
				Tile2 = 1;
			}
			if ((b[i][2] - 100 == a[j][2] && b[i][3] - 100 == a[j][3])) {
				Tile2 = 1;
			}
			if (b[i][2] - 100 == b[j][2] && b[i][3] - 100 == b[j][3]) {
				Tile2 = 1;
			}
		}
		if (b[i][2] >= 100 && b[i][3] >= 100) {
			if (Tile1 == 1 && Tile2 == 0) {
				for (int j = 0; j < 12; j++) {
					if (b[i][2] - 50 == a[j][2] && b[i][3] - 50 == a[j][3]) {
						TakenPiece = j;
					}
				}
				b[i][2] -=100;
				b[i][3] -= 100;
				BTakePieces(a, TakenPiece);
				turn++;
			}
		}
		if(Tile1 == 0) {
			b[i][2] -= 50;
			b[i][3] -= 50;
			turn++;
		}
	}
	if (b[i][3] == 0) {
		ChPiSu.BSetState(i);
	}
}
	
	public void BMoveRightForward(int[][] a, int[][] b, int i) {
		Tile1 = 0;
		Tile2 = 0;
		if(b[i][2] != 350 && b[i][3] != 0) {
			for (int j = 0; j < 12; j++) {
				if(b[i][2] + 50 == a[j][2] && b[i][3] - 50 == a[j][3]) {
					Tile1 = 1;
				}
				if(b[i][2] + 50 == b[j][2] && b[i][3] - 50 == b[j][3]) {
					Tile1 = 1;
					Tile2 = 1;
				}
				if ((b[i][2] + 100 == a[j][2] && b[i][3] - 100 == a[j][3])) {
					Tile2 = 1;
				}
				if (b[i][2] + 100 == b[j][2] && b[i][3] - 100 == b[j][3]) {
					Tile2 = 1;
				}
			}
			if (b[i][2] >= 100 && b[i][3] >= 100) {
				if (Tile1 == 1 && Tile2 == 0) {
					for (int j = 0; j < 12; j++) {
						if (b[i][2] + 50 == a[j][2] && b[i][3] - 50 == a[j][3]) {
							TakenPiece = j;
						}
					}
					b[i][2] +=100;
					b[i][3] -= 100;
					BTakePieces(a, TakenPiece); 
					turn++;
				}
			}
			if(Tile1 == 0) {
				b[i][2] += 50;
				b[i][3] -= 50;
				turn++;
			}
		}
		if (b[i][3] == 0) {
			ChPiSu.BSetState(i);
		}
	}
	
	public void BMoveRightBackward(int[][] a, int[][] b, int i) {
		Tile1 = 0;
		Tile2 = 0;
		if(b[i][2] != 350 && b[i][3] != 350) {
			for (int j = 0; j < 12; j++) {
				if(b[i][2] + 50 == a[j][2] && b[i][3] + 50 == a[j][3]) {
					Tile1 = 1;
				}
				if(b[i][2] + 50 == b[j][2] && b[i][3] + 50 == b[j][3]) {
					Tile1 = 1;
					Tile2 = 1;
				}
				if ((b[i][2] + 100 == a[j][2] && b[i][3] + 100 == a[j][3])) {
					Tile2 = 1;
				}
				if (b[i][2] + 100 == b[j][2] && b[i][3] + 100 == b[j][3]) {
					Tile2 = 1;
				}
			}
			if (b[i][2] <= 250 && b[i][3] <= 250) {
				if (Tile1 == 1 && Tile2 == 0) {
					for (int j = 0; j < 12; j++) {
						if (b[i][2] + 50 == a[j][2] && b[i][3] + 50 == a[j][3]) {
							TakenPiece = j;
						}
					}
					b[i][2] +=100;
					b[i][3] += 100;
					BTakePieces(a, TakenPiece);
					turn++;
				}
			}
			if(Tile1 == 0) {
				b[i][2] += 50;
				b[i][3] += 50;
				turn++;
			}
		}
		if (b[i][3] == 350) {
			ChPiSu.BSetState(i);
		}
	}
	public void BMoveLeftBackward(int[][] a, int[][] b, int i) {
		Tile1 = 0;
		Tile2 = 0;
		if(b[i][2] != 0 && b[i][3] != 350) {
			for (int j = 0; j < 12; j++) {
				if(b[i][2] - 50 == a[j][2] && b[i][3] + 50 == a[j][3]) {
					Tile1 = 1;
				}
				if(b[i][2] - 50 == b[j][2] && b[i][3] + 50 == b[j][3]) {
					Tile1 = 1;
					Tile2 = 1;
				}
				if (b[i][2] - 100 == a[j][2] && b[i][3] + 100 == a[j][3]) {
					Tile2 = 1;
				}
				if (b[i][2] - 100 == b[j][2] && b[i][3] + 100 == b[j][3]) {
					Tile2 = 1;
				}
			}
			
			if (b[i][2] >= 100 && b[i][3] <= 250) {
				if (Tile1 == 1 && Tile2 == 0) {
					for (int j = 0; j < 12; j++) {
						if (b[i][2] - 50 == a[j][2] && b[i][3] + 50 == a[j][3]) {
							TakenPiece = j;
						}
					}
					b[i][2] -=100;
					b[i][3] += 100;
					BTakePieces(a, TakenPiece);
					turn++;
				}
			}
			if(Tile1 == 0) {
				b[i][2] -= 50;
				b[i][3] += 50;
				turn++;
			}
		}
		if (b[i][3] == 350) {
			ChPiSu.BSetState(i);
		}
	}
	public void AMoveRightBackward(int[][] a, int[][] b, int i) {
		Tile1 = 0;
		Tile2 = 0;
		if(a[i][2] != 350 && a[i][3] != 0) {
			for (int j = 0; j < 12; j++) {
				if(a[i][2] + 50 == b[j][2] && a[i][3] - 50 == b[j][3]) {
					Tile1 = 1;
				}
				if(a[i][2] + 50 == a[j][2] && a[i][3] - 50 == a[j][3]) {
					Tile1 = 1;
					Tile2 = 1;
				}
				if ((a[i][2] + 100 == b[j][2] && a[i][3] - 100 == b[j][3])) {
					Tile2 = 1;
				}
				if (a[i][2] + 100 == a[j][2] && a[i][3] - 100 == a[j][3]) {
					Tile2 = 1;
				}
			}
			if (a[i][2] >= 100 && a[i][3] >= 100) {
				if (Tile1 == 1 && Tile2 == 0) {
					for (int j = 0; j < 12; j++) {
						if (a[i][2] + 50 == b[j][2] && a[i][3] - 50 == b[j][3]) {
							TakenPiece = j;
						}
					}
					a[i][2] +=100;
					a[i][3] -= 100;
					ATakePieces(b, TakenPiece); 
					turn++;
				}
			}
			if(Tile1 == 0) {
				a[i][2] += 50;
				a[i][3] -= 50;
				turn++;
			}
		}
		if (a[i][3] == 0) {
			ChPiSu.ASetState(i);
		}
	}
	public void AMoveLeftBackward(int[][] a, int[][] b, int i) {
		Tile1 = 0;
		Tile2 = 0;
		if(a[i][2] != 0 && a[i][3] != 0) {
			for (int j = 0; j < 12; j++) {
				if(a[i][2] - 50 == b[j][2] && a[i][3] - 50 == b[j][3]) {
					Tile1 = 1;
				}
				if(a[i][2] - 50 == a[j][2] && a[i][3] - 50 == a[j][3]) {
					Tile1 = 1;
					Tile2 = 1;
				}
				if ((a[i][2] - 100 == b[j][2] && a[i][3] - 100 == b[j][3])) {
					Tile2 = 1;
				}
				if (a[i][2] - 100 == a[j][2] && a[i][3] - 100 == a[j][3]) {
					Tile2 = 1;
				}
			}
			if (a[i][2] >= 100 && a[i][3] >= 100) {
				if (Tile1 == 1 && Tile2 == 0) {
					for (int j = 0; j < 12; j++) {
						if (a[i][2] - 50 == b[j][2] && a[i][3] - 50 == b[j][3]) {
							TakenPiece = j;
						}
					}
					a[i][2] -=100;
					b[i][3] -= 100;
					ATakePieces(b, TakenPiece);
					turn++;
				}
			}
			if(Tile1 == 0) {
				a[i][2] -= 50;
				a[i][3] -= 50;
				turn++;
			}
		}
		if (a[i][3] == 0) {
			ChPiSu.ASetState(i);
		}
	}
	
	public int Turn() {
		return (turn);
	}
	public void SetTurn(int a) {
		turn += a;
	}

}
