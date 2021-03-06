package com.mygdx.game.Game;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyButton;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.MyScreen;

/**
 * Created by Kicsi on 2016. 10. 07..
 */

public class Buttons extends Group {

    private float h = (MyScreen.WORLD_WIDTH)/8f;

    private TextButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bEnter, bTorol , bMinus;
    private boolean minus = false;

    private TextField textField = null;

    public void setTarget(TextField textField)
    {
        this.textField = textField;
    }

    public void onEnterPressed()
    {

    }

    private boolean appendText(String s)
    {
        if (textField == null) return false;
            int cp = textField.getCursorPosition();
                if (s.equals("negativ")) {
                    textField.setText("-" + textField.getText().substring(0, cp) + textField.getText().substring(cp, textField.getText().length()));
                } else if (s.equals("pozitiv")) {
                    textField.setText(textField.getText().substring(1, cp) + textField.getText().substring(cp, textField.getText().length()));
                } else if (s.equals("torol")) {
                    textField.setText(textField.getText().substring(0, cp - 1) + textField.getText().substring(cp, textField.getText().length()));
                } else {
                    textField.setText(textField.getText().substring(0, cp) + s + textField.getText().substring(cp, textField.getText().length()));
                }
                textField.setCursorPosition(cp + 1);
                return true;
    }

    boolean jo(){
        boolean b = false;
        try{
            if (textField.getText().length()>=6)
            {
                throw new Exception();
            }
            int i = Integer.parseInt(textField.getText());
            if(i<Integer.MAX_VALUE && i>Integer.MIN_VALUE) b = true;
        }catch(Exception e){}
        if(textField.getText().equals("")) b = true;
        else if(textField.getText().charAt(0) == '-') b = true;
        return b;
    }

    public Buttons() {
        MyButton.setSize((int)h,(int)h);
        b0 = new MyButton("0");
        b0.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(!(textField.getText().equals("")) && jo()){
                    if(textField.getText().charAt(0) != '-'){
                        appendText("0");
                    }else{
                        if(textField.getText().length()>1){
                            appendText("0");
                        }
                    }
                }
            }
        });
        b0.setSize(h,h);
        b0.setPosition(0f, b0.getHeight());

        b1 = new MyButton("1");
        b1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(jo())appendText("1");
            }
        });
        b1.setSize(h,h);
        b1.setPosition(b0.getWidth(), b1.getHeight());

        b2 = new MyButton("2");
        b2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(jo())appendText("2");
            }
        });
        b2.setSize(h,h);
        b2.setPosition(2*(b1.getWidth() ), b2.getHeight());

        b3 = new MyButton("3");
        b3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(jo())appendText("3");
            }
        });
        b3.setSize(h,h);
        b3.setPosition(3*(b2.getWidth() ), b3.getHeight());

        b4 = new MyButton("4");
        b4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(jo())appendText("4");
            }
        });
        b4.setSize(h,h);
        b4.setPosition(4*(b3.getWidth() ), b4.getHeight());

        b5 = new MyButton("5");
        b5.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(jo())appendText("5");
            }
        });
        b5.setSize(h,h);
        b5.setPosition(5*(b4.getWidth() ), b5.getHeight());

        b6 = new MyButton("6");
        b6.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(jo())appendText("6");
            }
        });
        b6.setSize(h,h);
        b6.setPosition(6*(b5.getWidth() ), b6.getHeight());

        b7 = new MyButton("7");
        b7.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(jo())appendText("7");
            }
        });
        b7.setSize(h,h);
        b7.setPosition(7*(b6.getWidth()), b7.getHeight());

        b8 = new MyButton("8");
        b8.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(jo())appendText("8");
            }
        });
        b8.setSize(h,h);
        b8.setPosition(0f, 0f);

        b9 = new MyButton("9");
        b9.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(jo())appendText("9");
            }
        });
        b9.setSize(h,h);
        b9.setPosition(b8.getWidth(), 0f);


        bMinus = new MyButton("-/+");
        bMinus.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(!minus) {
                    minus = true;
                    appendText("negativ");
                }
                else{
                    minus = false;
                    if((GameStage.myTextArea2.getText()).length() > 0) {
                        appendText("pozitiv");
                    }
                }
            }
        });
        bMinus.setSize(h,h);
        bMinus.setPosition(2*b9.getWidth(), 0f);

        MyButton.setSize((int)h*2,(int)h);
        bTorol = new MyButton("Törlés");
        bTorol.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if ((GameStage.myTextArea2.getText()).length() == 1) {
                    appendText("torol");
                    minus = false;
                }
                else if ((GameStage.myTextArea2.getText()).length() > 0) {
                    appendText("torol");
                }

            }
        });
        bTorol.setSize(2*h,h);
        bTorol.setPosition(3*b9.getWidth(), 0f);

        MyButton.setSize((int)h*3,(int)h);
        bEnter = new MyButton("Enter");
        bEnter.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                onEnterPressed();
            }
        });
        bEnter.setSize(3*h,h);
        bEnter.setPosition(3*b9.getWidth()+bTorol.getWidth(), 0f);

        addActor(b0);
        addActor(b1);
        addActor(b2);
        addActor(b3);
        addActor(b4);
        addActor(b5);
        addActor(b6);
        addActor(b7);
        addActor(b8);
        addActor(b9);
        addActor(bMinus);
        addActor(bTorol);
        addActor(bEnter);

    }

}
