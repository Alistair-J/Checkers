package com.gdxtemplate.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class RenderCheckers { ///Renders Grid
	
	private int gridX = 8;
	private int gridY = 8;
	private int x,y;
	private int a = 1;
	
	public void render(ShapeRenderer sr) {
		for (int i = 0; i < gridX; i++) {
			x = 0;
			for (int j = 0; j < gridY; j++) {
				sr.begin(ShapeType.Filled);
				sr.setColor((a%2),(a%2),(a%2),(a%2));
				sr.rect(x,y,50,50);
				sr.end();
				
				x += 50;
				a += 1;
				}
			y += 50;
			a += 1;
		}
	}

}
