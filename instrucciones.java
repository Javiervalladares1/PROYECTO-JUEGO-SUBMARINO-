import greenfoot.*;
/**
 * Write a description of class instrucciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class instrucciones extends Actor
{
    public instrucciones(String texto) {
        GreenfootImage imageTexto = new GreenfootImage(texto, 30, Color.BLACK, null);
        setImage(imageTexto);
}
}
