import greenfoot.*;

public class MyWorld extends World{
    int color;
    private int preDeterminedDot = 1;
    private int startAmount = 2;
    Dots[] dot = new Dots[99];
    GreenfootSound backgroundMusic = new GreenfootSound("music.mp3");
    GreenfootSound click = new GreenfootSound("click.mp3");
    private int answer;
    private boolean clicked = false;
    private boolean finished = true;

  public MyWorld(){
    super(1280, 720, 1); 
    GreenfootImage background = getBackground();
    background.setColor(Color.BLACK);
    background.fill();  
    backgroundMusic.play();
    backgroundMusic.setVolume(35);
    System.out.printf("gen world%n");
    addDots(startAmount);
  }

  public void addDots(int count){
    for(int i = 0; i < count; i++){
      int x = Greenfoot.getRandomNumber(getWidth());
      int y = Greenfoot.getRandomNumber(getHeight());
      addObject(dot[i] = new Dots(i), x, y);
    }
    for(int i = 0; i < count; i++){
      decideColorOfDot(i);
    }
  }
  public void decideColorOfDot(int index){
    int random = Greenfoot.getRandomNumber(3);
    if(random == 0){
      dot[index].setImage("red.png");
      if(preDeterminedDot == index){
        color = random;
      }
    }
    if(random == 1){
      dot[index].setImage("green.png");
      if(preDeterminedDot == index){
        color = random;
      }
    }
    if(random == 2){
      dot[index].setImage("blue.png");
      if(preDeterminedDot == index){
          color = random;
      }
    }
    if(index == startAmount){
        finished = true;
    }
  }
  public void change(){
      int random;
    while(true){
      random = Greenfoot.getRandomNumber(3);
      if(random != color)
        break;
    }
    if(random == 0){
      dot[1].setImage("red.png");
    }
    if(random == 1){
      dot[1].setImage("green.png");
    }
    if(random == 2){
      dot[1].setImage("blue.png");
    }
  }
  public void mouseClick(){
    for(int i = 0; i < startAmount; i++){
      if(Greenfoot.mouseClicked(dot[i])){
        click.play();
        answer = i;
        checkAnswer();
        clicked = true;
        startAmount++;
        removeObjects(getObjects(Dots.class));
        addDots(startAmount);
        finished = true;
        break;
      }
    }
  }
  public void checkAnswer(){
        if(clicked){
            if(preDeterminedDot != answer){
                showText("wrong answer", 400, 400);
                clicked = false;
            }
            else{
                showText("right answer", 400, 400);
                clicked = false;
            }
        }
    }
    public boolean getFinished(){
        return this.finished;
    }
    public void setFinished(boolean finished){
        this.finished = finished;
    }
}