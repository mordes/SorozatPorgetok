package com.mygdx.game.Game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyScreen;

/**
 * Created by Kicsi on 2016. 10. 07..
 */

public class Buttons {

    private float h = (MyScreen.WORLD_WIDTH)/8f;

    private TextButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bTorol, bEnter, bHelp;


    public Buttons() {
        b0 = new MyButton("0");
        b0.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b0.setSize(h,h);
        b0.setPosition(0f, b0.getHeight());

        b1 = new MyButton("1");
        b1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b1.setSize(h,h);
        b1.setPosition(b0.getWidth(), b1.getHeight());

        b2 = new MyButton("2");
        b2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b2.setSize(h,h);
        b2.setPosition(2*(b1.getWidth() ), b2.getHeight());

        b3 = new MyButton("3");
        b3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b3.setSize(h,h);
        b3.setPosition(3*(b2.getWidth() ), b3.getHeight());

        b4 = new MyButton("4");
        b4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b4.setSize(h,h);
        b4.setPosition(4*(b3.getWidth() ), b4.getHeight());

        b5 = new MyButton("5");
        b5.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b5.setSize(h,h);
        b5.setPosition(5*(b4.getWidth() ), b5.getHeight());

        b6 = new MyButton("6");
        b6.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b6.setSize(h,h);
        b6.setPosition(6*(b5.getWidth() ), b6.getHeight());

        b7 = new MyButton("7");
        b7.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b7.setSize(h,h);
        b7.setPosition(7*(b6.getWidth()), b7.getHeight());

        b8 = new MyButton("8");
        b8.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b8.setSize(h,h);
        b8.setPosition(0f, 0f);

        b9 = new MyButton("9");
        b9.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        b9.setSize(h,h);
        b9.setPosition(b8.getWidth(), 0f);

        bEnter = new MyButton("Enter");
        bEnter.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        bEnter.setSize(3*h,h);
        bEnter.setPosition(2*b9.getWidth(), 0f);

        bTorol = new MyButton("Törlés");
        bTorol.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        bTorol.setSize(3*h,h);
        bTorol.setPosition(2*b8.getWidth()+bEnter.getWidth(), 0f);

        bHelp = new MyButton("Help");
        bHelp.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

            }
        });
        bHelp.setSize(2*h,h);
        bHelp.setPosition(0f, MyScreen.WORLD_HEIGHT-bHelp.getHeight());
    }

    public TextButton getB0() {
        return b0;
    }

    public TextButton getB1() {
        return b1;
    }

    public TextButton getB2() {
        return b2;
    }

    public TextButton getB3() {
        return b3;
    }

    public TextButton getB4() {
        return b4;
    }

    public TextButton getB5() {
        return b5;
    }

    public TextButton getB6() {
        return b6;
    }

    public TextButton getB7() {
        return b7;
    }

    public TextButton getB8() {
        return b8;
    }

    public TextButton getB9() {
        return b9;
    }

    public TextButton getbTorol() {
        return bTorol;
    }

    public TextButton getbEnter() {
        return bEnter;
    }

    public TextButton getbHelp() {
        return bHelp;
    }
}