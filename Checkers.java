package com.gdxtemplate.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class Checkers extends ApplicationAdapter {
	ShapeRenderer sr;
	CheckerPiecesSuperclass ChPiSu = new CheckerPiecesSuperclass();
	Highlighting HiLi = new Highlighting(); 
	Move Mo = new Move();
	private static int piece = 0;
	private int state = 0;
	private int gameEndA = 0;
	private int gameEndB = 0;
	
	@Override
	public void create () {
		sr = new ShapeRenderer();
		ChPiSu.createArray();
	}

	@Override
	public void render () {
		gameEndA = 0;
		gameEndB = 0;
		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		int[][] a = ChPiSu.ArrayA();
		int[][] b = ChPiSu.ArrayB();
		for(int i = 0; i < 12 ;i++) {
			if (a[i][4] != 3) {
				gameEndA = 1;
				
			}
		}
		for(int i = 0; i < 12 ;i++) {
			if (b[i][4] != 3) {
				gameEndB = 1;
			}
		}
		if(gameEndA == 0) {
			System.out.println("Player 2 wins");
		}
		if(gameEndB == 0) {
			System.out.println("Player  wins");
		}
		if (gameEndA != 0 || gameEndB != 0) {
			RenderCheckers Render = new RenderCheckers();
			RenderPieces RenderPieces = new RenderPieces(); 
			Render.render(sr);
			HiLi.highlight(sr);
			if (Mo.Turn() % 2 == 0) {
				for(int i = 0; i < 12; i++) {
					if (a[i][2] == HiLi.GetX() && a[i][3] == HiLi.GetY()) {
						piece = a[i][1];
						state = a[i][4];
					}
				}
					
			}
			if(Mo.Turn() % 2 == 1) {
				for(int i = 0; i < 12; i++) {
					if (b[i][2] == HiLi.GetX() && b[i][3] == HiLi.GetY()) {
						piece = b[i][1];
						state = b[i][4];
					}
				}
			}
			if (Mo.Turn() % 2 == 0) {
				HiLi.MovesA(sr, state);
				if (Gdx.input.isKeyJustPressed(Keys.Q)) {
					Mo.AMoveLeftForward(ChPiSu.ArrayA(),ChPiSu.ArrayB(), piece);
				}
				if(Gdx.input.isKeyJustPressed(Keys.E)) {
					Mo.AMoveRightForward(ChPiSu.ArrayA(),ChPiSu.ArrayB(), piece);
				}
				if (state == 1) {
					if(Gdx.input.isKeyJustPressed(Keys.Z)) {
						Mo.AMoveRightBackward(ChPiSu.ArrayA(),ChPiSu.ArrayB(), piece);
					}
					if(Gdx.input.isKeyJustPressed(Keys.C)) {
						Mo.AMoveLeftBackward(ChPiSu.ArrayA(),ChPiSu.ArrayB(), piece);
					}
				}
			}
			else {
				HiLi.MovesB(sr, state);
				if (Gdx.input.isKeyJustPressed(Keys.NUMPAD_1)) {
					Mo.BMoveLeftForward(ChPiSu.ArrayA(),ChPiSu.ArrayB(), piece);
				}
				if(Gdx.input.isKeyJustPressed(Keys.NUMPAD_3)) {
					Mo.BMoveRightForward(ChPiSu.ArrayA(),ChPiSu.ArrayB(), piece);
				}
				if (state == 1) {
					if(Gdx.input.isKeyJustPressed(Keys.NUMPAD_9)) {
						Mo.BMoveRightBackward(ChPiSu.ArrayA(),ChPiSu.ArrayB(), piece);
					}
					if(Gdx.input.isKeyJustPressed(Keys.NUMPAD_7)) {
						Mo.BMoveLeftBackward(ChPiSu.ArrayA(),ChPiSu.ArrayB(), piece);
					}
				}
			}
			
			RenderPieces.render(100, 100, sr, ChPiSu);
			}
	}
	
	
	@Override
	public void dispose () {
	}
	

}