package com.gdxtemplate.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Highlighting {
	private int mouseX,mouseY;
	private int x,y;
	
	public int GetX() {
		mouseX = Gdx.input.getX();
		x = (int)(mouseX / 50);
		x *= 50;
		return(x);
	}
	
	public int GetY() {
		mouseY = Gdx.input.getY();
		y = (int)(mouseY / 50);
		y *= -50;
		y += 350;
		return(y);
	}
	
	public void MovesA(ShapeRenderer sr, int state) {
		sr.begin(ShapeType.Filled);
		sr.setColor(0/255f, 153/255f, 51/255f, 0f);
		sr.rect(GetX() + 50, GetY() + 50, 50, 50);
		sr.rect(GetX() - 50, GetY() + 50, 50, 50);
		
		sr.setColor(0, 0, 0, 0);
		sr.circle(GetX() + 75, GetY() + 75, 24);
		sr.circle(GetX() - 25, GetY() + 75, 24);
		
		if (state == 1) {
			sr.circle(GetX() + 75, GetY() - 25, 24);
			sr.circle(GetX() - 25, GetY() - 25, 24);
			sr.setColor(0/255f, 153/255f, 51/255f, 0f);
			sr.rect(GetX() + 50, GetY() - 50, 50, 50);
			sr.rect(GetX() - 50, GetY() - 50, 50, 50);
		}
		
		sr.end();
	}
	public void MovesB(ShapeRenderer sr, int state) {
		sr.begin(ShapeType.Filled);
		sr.setColor(0/255f, 153/255f, 51/255f, 0f);
		sr.rect(GetX() - 50, GetY() - 50, 50, 50);
		sr.rect(GetX() + 50, GetY() - 50, 50, 50);
		
		sr.setColor(0, 0, 0, 0);
		sr.circle(GetX() - 25, GetY() - 25, 24);
		sr.circle(GetX() + 75, GetY() - 25, 24);
		
		if (state == 1) {
			sr.circle(GetX() + 75, GetY() + 25, 24);
			sr.circle(GetX() - 25, GetY() + 25, 24);
			sr.setColor(0/255f, 153/255f, 51/255f, 0f);
			sr.rect(GetX() + 50, GetY() + 50, 50, 50);
			sr.rect(GetX() - 50, GetY() + 50, 50, 50);
		}
		
		sr.end();
	}
	
	public void highlight(ShapeRenderer sr) {
		sr.begin(ShapeType.Filled);
		sr.setColor(0/255f, 153/255f, 51/255f, 0f);
		sr.rect(GetX(), GetY(), 50, 50);
		sr.end();
	}

}
