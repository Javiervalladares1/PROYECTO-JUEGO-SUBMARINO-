import greenfoot.*;

public class basura1 extends Actor
{
    private int direccionY = 1; // 1 para abajo, -1 para arriba

    public basura1()
    {
        GreenfootImage imagen1 = getImage();
        int nuevoAncho = imagen1.getWidth() * 2;
        int nuevoAlto = imagen1.getHeight() * 2;
        imagen1.scale(60, 60);
        setImage(imagen1);
    }

    public void act()
    {
        mover();
    }

    private void mover()
    {
        int margen = 50; // Margen de distancia desde el borde
        int worldHeight = getWorld().getHeight();
        int y = getY();

        if (y <= margen || y >= worldHeight - margen) {
            cambiarDireccionY();
        }

        setLocation(getX(), y + (4 * direccionY));
    }

    private void cambiarDireccionY()
    {
        direccionY *= -1;
    }
}




