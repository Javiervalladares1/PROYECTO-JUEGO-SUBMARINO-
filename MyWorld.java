import greenfoot.*;

public class MyWorld extends World
{
    private GreenfootSound musicaFondo;

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
        int numeroBasuras = 10; // Cantidad de objetos "basura" que deseas agregar
        for (int i = 0; i < numeroBasuras; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new basura1(), x, y);
        }

        // Agrega 5 objetos "pez" dispersos por el mapa
        int numeroPeces = 8; // Cantidad de objetos "pez" que deseas agregar
        int distanciaMinima = 100; // Distancia mínima entre los objetos "pez" y "basura"

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
                // Si la posición del objeto "pez" está demasiado cerca de los objetos "basura",
                // busca otra posición aleatoria.
                i--;
            }
        }

        // Agrega la etiqueta de contador al mundo
        CONTADOR etiquetaContador = new CONTADOR();
        addObject(etiquetaContador, 500, 50);
    }

    private boolean distanciaMinimaEntrePezYBasura(int x, int y, int distanciaMinima)
    {
        // Verifica la distancia entre el objeto "pez" y los objetos "basura" existentes
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

    private void prepararMusica()
    {
        // Crea una instancia de GreenfootSound y carga el archivo de música
        musicaFondo = new GreenfootSound("musica.mp3");

        // Reproduce la música en bucle (para que se repita)
        musicaFondo.playLoop();
    }

    public void stopped()
    {
        // Detiene la música cuando se detiene el mundo
        musicaFondo.pause();
    }
}

