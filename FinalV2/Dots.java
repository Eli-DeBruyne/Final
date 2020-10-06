import greenfoot.*;

public class Dots extends Actor{
    private int dotIndex;
  public Dots(){
  }
  public Dots(int x){
      this.dotIndex = x;
  }
  public void act() 
  {
      //generateDots();
      playGame();
      ((MyWorld)getWorld()).mouseClick();
  }
      public void hide(){
      for(Object obj : getWorld().getObjects(null)){
          ((Actor)obj).getImage().setTransparency(0);
      }
  }
  public void visable(){
      for(Object obj : getWorld().getObjects(null)){
          ((Actor)obj).getImage().setTransparency(255);
      }
  }
  public void playGame(){
    if(((MyWorld)getWorld()).getFinished()){
      visable();
      sleep();
      hide();
      ((MyWorld)getWorld()).change();
      sleep();
      visable();
      ((MyWorld)getWorld()).setFinished(false);
    }
  }
  public void sleep(){
    Greenfoot.delay(50);
  }
}