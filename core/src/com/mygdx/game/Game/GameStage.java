package com.mygdx.game.Game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Assets;
import com.mygdx.game.Globals;
import com.mygdx.game.Menu.PlayStage;
import com.mygdx.game.MyLabel;
import com.mygdx.game.MyScreen;
import com.mygdx.game.MyStage;
import com.mygdx.game.MyTextField;
import com.mygdx.game.PopupOneSpriteStaticActor;
import com.mygdx.matek.SequenceOperator;

/**
 * Created by Kicsi on 2016. 10. 07..
 */

public class GameStage extends MyStage{

    public GameStage(Game game) {
        super(game);
    }
    public GameStage(Viewport viewport, Batch batch, Game game) { super(viewport, batch, game); }
    public GameStage(Viewport viewport, Game game) {
        super(viewport, game);
    }

    //Buttons buttons;
    public static MyTextField myTextArea2;
    public MyLabel stopper;
    public static MyTextField[] elements1_5 = new MyTextField[5];
    public static MyLabel[] myLabel = new MyLabel[5];
    public static SequenceOperator sc = new SequenceOperator();
    public static int db = 0, jatszottMenet = 0, joValasz=0;
    public boolean playing = true;

    private int ido = 60;

    protected void init() {
        Globals.musicchange = false;
        super.init();
        myLabel = new MyLabel[5];
        float leftMargin = 15;

        //6. elem
        addActor(myTextArea2 = new MyTextField("A billentyű eléréséhez kattints ide!"){
            @Override
            public void onSubmit() {
                if (
                (!getText().equals("\n") && !getText().equals("")) //üres String, enter vizsgálata
                && (getText().substring(getText().length() == 1 ? 0 : 1 //ha csak 1 hosszú, és az előjel vagy sem
                    ,getText().length()).matches("[0-9]+")) //számokból áll-e
                && ((getText().charAt(0) == '-' && getText().length()>1) || (getText().charAt(0)+"").matches("[0-9]+")) //előjel, ha van akkor követi-e érték
                )
                {
                    if (sc.getLineNumber(5) == Integer.parseInt(getText())) {
                        //System.out.println("Helyes megfejtés!");
                        addActor(new PopupOneSpriteStaticActor(Assets.assetManager.get(Assets.greenCheck))
                        {
                            @Override
                            protected void init() {
                                super.init();
                                setSize(MyScreen.WORLD_WIDTH, MyScreen.WORLD_HEIGHT);
                                joValasz++;
                                jatszottMenet++;
                                playing=false;
                                //Idozito.ido.stop();
                            }

                            @Override
                            public void act(float delta) {
                                super.act(delta);
                                if (elapsedTime>showTimer)
                                {
                                    xy();
                                }
                            }
                        });
                    }
                    else {
                        //System.out.println("Helytelen megfejtés!");
                        addActor(new PopupOneSpriteStaticActor(Assets.assetManager.get(Assets.redX))
                        {
                            @Override
                            protected void init() {
                                super.init();
                                setSize(MyScreen.WORLD_WIDTH, MyScreen.WORLD_HEIGHT);
                                //Idozito.ido.stop();
                                jatszottMenet++;
                                playing = false;
                                //System.out.println(getZIndex());
                            }

                            @Override
                            public void act(float delta) {
                                super.act(delta);
                                if (elapsedTime>showTimer)
                                {
                                    xy();
                                }
                            }
                        });
                        helyesValasz();
                    }
                }
                else {
                    myTextArea2.setText("Nem megfelelő tartalmat írtál be!");
                }
            }
        });
        /*
        for (Actor a : getActors()) {
            if (a instanceof PopupOneSpriteStaticActor)
            {
                getActors().removeValue(a,true);
            }
        }
               */
        myTextArea2.setWidth(MyScreen.WORLD_WIDTH-leftMargin*2);
        myTextArea2.setHeight(Globals.size);
        myTextArea2.setY(MyScreen.WORLD_HEIGHT/2 );
        myTextArea2.setX(leftMargin);
        myTextArea2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                try {
                    Integer.parseInt(myTextArea2.getText());
                }
                catch (Exception e)
                {
                    myTextArea2.setText("");
                }
/*                if (myTextArea2.getText().compareTo("Nem megfelelő tartalmat írtál be!") == 0  || myTextArea2.getText().compareTo("A billentyű eléréséhez kattints ide!")==0) {

                }*/
            }
        });


        //stopper
        stopper = new MyLabel("ASD");
        stopper.setWidth(100);
        stopper.setHeight(Globals.size);
        stopper.setPosition(getViewport().getWorldWidth()-stopper.getWidth()-10, getViewport().getWorldHeight()- stopper.getHeight()-10);
        addActor(stopper);


        float currentX = 0;
        float currentY = labelHeight();
        sc.newSequence(PlayStage.difficulty-1);

        /*for (int i = 0; i < 6; i++) {
            System.out.println(sc.getLineNumber(i));
        }*/

        for (int i = 0; i < myLabel.length; i++) {
            addActor(myLabel[i] = new MyLabel(sc.getLineNumber(i)+""));
            myLabel[i].setY(currentY);
            myLabel[i].setX(currentX);
            currentX += MyScreen.WORLD_WIDTH /5;
            myLabel[i].setWidth(MyScreen.WORLD_WIDTH /5);
            myLabel[i].setHeight(Globals.size);
        }


    }

    public void helyesValasz(){
        MyLabel l = new MyLabel("A helyes válasz: "+sc.getLineNumber(5));
        l.setPosition(MyScreen.WORLD_WIDTH/2 - l.getWidth()/2, MyScreen.WORLD_HEIGHT/2 - l.getHeight()/2);
        addActor(l);
        //l.setZIndex(200);
    }

    private float labelHeight(){
        float a;
        a = stopper.getY() - stopper.getHeight();
        a -= myTextArea2.getY();
        a = MyScreen.WORLD_HEIGHT - (a/2+Globals.size/2);
        return a;
    }



    @Override
    public void act(float delta) {
        super.act(delta);
        int time = ido - (int)elapsedTime;
        if(time <=10) stopper.setColor(1f,0f,0f, 1f);
        if (time < 0)
        {
            stopper.setText("0");
            if (playing) {
                jatszottMenet++;
                game.setScreen(new EndScreen(game));
            }
        }
        else
        {
            stopper.setText(time + "");
        }
    }

    void xy(){
        if(db!=9){
            game.setScreen(new GameScreen(game));
            db++;
        }else
            game.setScreen(new EndScreen(game));
    }

    public static int getJoValasz() {
        return joValasz;
    }

    public static int getJatszottMenet() {
        return jatszottMenet;
    }

    public static void vissza(){db = 0; jatszottMenet=0; joValasz=0;}

    @Override
    public void dispose() {super.dispose(); }

}
