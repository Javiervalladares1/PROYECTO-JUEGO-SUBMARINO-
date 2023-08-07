import greenfoot.*;

public class MyWorld extends World
{
    private GreenfootSound musicaFondo;
    private boolean instruccionesMostradas = false;

    public MyWorld()
    {    
        super(800, 600, 1);
        prepare();
        prepararMusica();
    }

    private void prepare()
    {
        // Agrega el submarino al mundo
        submarino sub = new submarino();
        addObject(sub, 100, 100);

        // Agrega 10 objetos "basura" dispersos por el mapa
        int numeroBasuras = 10;
        for (int i = 0; i < numeroBasuras; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new basura1(), x, y);
        }

        // Agrega 8 objetos "pez" dispersos por el mapa
        int numeroPeces = 8;
        int distanciaMinima = 100;

        for (int i = 0; i < numeroPeces; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());

            if (distanciaMinimaEntrePezYBasura(x, y, distanciaMinima))
            {
                addObject(new pez(), x, y);
            }
            else
            {
                i--;
            }
        }

        // Agrega la etiqueta de contador al mundo
        CONTADOR etiquetaContador = new CONTADOR();
        addObject(etiquetaContador, 500, 50);
    }
    
    private void mostrarInstrucciones() {
        showText("¡Instrucciones del juego!", getWidth() / 2, 100);
        showText("Usa las flechas para mover el submarino.", getWidth() / 2, 200);
        showText("Recoge la basura para acumular puntos.", getWidth() / 2, 250);
        showText("Evita los peces.", getWidth() / 2, 300);
        showText("Presiona cualquier tecla para comenzar.", getWidth() / 2, 500);
    }

    private void eliminarInstrucciones() {
        showText("", getWidth() / 2, 100);
        showText("", getWidth() / 2, 200);
        showText("", getWidth() / 2, 250);
        showText("", getWidth() / 2, 300);
        showText("", getWidth() / 2, 500);
    }

    private void prepararMusica()
    {
        musicaFondo = new GreenfootSound("musica.mp3");
        musicaFondo.playLoop();
    }

    public void act()
    {
        if (!instruccionesMostradas) {
            mostrarInstrucciones();
            Greenfoot.delay(300); // Pausa durante 5 segundos (300 frames a 60 fps)
            eliminarInstrucciones();
            instruccionesMostradas = true;
        }
    }

    public void stopped()
    {
        musicaFondo.pause();
    }

    private boolean distanciaMinimaEntrePezYBasura(int x, int y, int distanciaMinima)
    {
        for (Object obj : getObjects(basura1.class))
        {
            Actor basura = (Actor) obj;
            int distanciaX = Math.abs(x - basura.getX());
            int distanciaY = Math.abs(y - basura.getY());
            int distanciaTotal = (int) Math.sqrt(distanciaX * distanciaX + distanciaY * distanciaY);

            if (distanciaTotal < distanciaMinima)
            {
                return false;
            }
        }

        return true;
    }
}
