import greenfoot.*;

public class pez extends Actor
{
    private int direccion = 1; // 1 para derecha, -1 para izquierda

    public void act()
    {
        mover();
    }

    private void mover()
    {
        int margen = 50; // Margen de distancia desde el borde
        int worldWidth = getWorld().getWidth();
        int x = getX();

        if (x <= margen || x >= worldWidth - margen) {
            cambiarDireccion();
        }

        move(1 * direccion);
    }

    private void cambiarDireccion()
    {
        direccion *= -1;
    }
}
