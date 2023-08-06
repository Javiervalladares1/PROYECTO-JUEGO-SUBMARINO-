import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class basura1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class basura1 extends Actor
{
    /**
     * Act - do whatever the basura1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public basura1()
    {
        GreenfootImage imagen1 = getImage();
        int nuevoAncho = imagen1.getWidth()*2;
        int nuevoAlto = imagen1.getHeight()*2;
        imagen1.scale(60, 60);
        setImage(imagen1);
    }
    public void act()
    {
        // Add your action code here.
    }
}
