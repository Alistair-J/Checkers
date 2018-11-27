package com.gdxtemplate.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class RenderPieces {
	
	public void render(int x, int y, ShapeRenderer sr, CheckerPiecesSuperclass ChPiSu) {
		int[][]Team1 = ChPiSu.ArrayA();
		int[][]Team2 = ChPiSu.ArrayB();
		

		sr.begin(ShapeType.Filled);
		for(int i = 0; i < 12; i++) {
			sr.setColor(0/255f, 0/255f, 255/255f, 0f);
			if (Team1[i][4] != 2) { ///Checks if piece was taken
				sr.circle(Team1[i][2]+25, Team1[i][3]+25, ChPiSu.GetRadius());
			}
			if (Team1[i][4] == 1) {
				sr.setColor(1,1,1,1);
				sr.circle(Team1[i][2]+25, Team1[i][3]+25, ChPiSu.GetRadius()/2);
			}
		}
		for(int i = 0; i < 12; i++) {
			sr.setColor(255/255f, 0/255f, 255/255f, 0f);
			sr.circle(Team2[i][2]+25, Team2[i][3]+25, ChPiSu.GetRadius());
			if (Team2[i][4] == 1) {
				sr.setColor(1,1,1,1);
				sr.circle(Team2[i][2]+25, Team2[i][3]+25, ChPiSu.GetRadius()/2);
			}
		}
		sr.end();
	}

}
