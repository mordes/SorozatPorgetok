package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Globals;
import com.mygdx.game.Menu.MenuScreen;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyLabel;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;

import jdk.nashorn.internal.objects.Global;

/**
 * Created by Kicsi on 2016. 10. 14..
 */

public class EndStage extends MyStage {

    public EndStage(Game game) {
        super(game);
    }
    public EndStage(Viewport viewport, Batch batch, Game game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
    }
    public EndStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    private MyLabel labelEnd;
    private TextButton bBack;

    @Override
    public boolean keyDown(int keyCode) {
        if (keyCode == Input.Keys.BACK)
        {
            Globals.musicchange = !Globals.musicchange;
            game.setScreen(new MenuScreen(game));
        }
        return false;
    }


    protected void init(){

        addActor(labelEnd = new MyLabel("Játék vége\nElért pontszámod: "+GameStage.getJatszottMenet()+"/"+GameStage.getJoValasz()));
        labelEnd.setWidth(100);
        labelEnd.setHeight(50);
        labelEnd.setY(MyScreen.WORLD_HEIGHT/2-labelEnd.getHeight()/2);
        labelEnd.setX(MyScreen.WORLD_WIDTH/2-labelEnd.getWidth()/2);

        MyButton.setSize((int)MyScreen.WORLD_WIDTH/2, (int)MyScreen.WORLD_HEIGHT/8);
        bBack = new MyButton("Vissza a menübe");
        bBack.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Globals.musicchange = true;
                GameStage.vissza();
                game.setScreen(new MenuScreen(game));
            }
        });
        bBack.setSize(MyScreen.WORLD_WIDTH/2+MyScreen.WORLD_WIDTH/4, MyScreen.WORLD_HEIGHT/8);
        bBack.setPosition(MyScreen.WORLD_WIDTH/8, MyScreen.WORLD_WIDTH/16);
        addActor(bBack);

    }


    @Override
    public void act() {
        super.act();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
