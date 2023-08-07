import greenfoot.*; // Importa las clases necesarias de Greenfoot

public class submarino extends Actor {
    public submarino() {
        GreenfootImage imagen = getImage();
        int nuevoAncho = imagen.getWidth() * 2;
        int nuevoAlto = imagen.getHeight() * 2;
        imagen.scale(60, 60);
        setImage(imagen); 
    }

    int contBasura = 0;
    int totalBasura = 10;

    public void act(){
        moverSubmarino();
        recogerBasura();
        detectarPez();
        verificarFelicitaciones();
    }

    private void moverSubmarino() {
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 1);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 1);
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 1, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 1, getY());
        }
    }

    private void recogerBasura() {
        Actor basura = getOneIntersectingObject(basura1.class);
        if (basura != null) {
            getWorld().removeObject(basura);
            contBasura++;
            actualizarEtiqueta();
        }
    }

    private void detectarPez() {
        Actor pez = getOneIntersectingObject(pez.class);
        if (pez != null) {
            getWorld().showText("Perdiste", 200, 100);
            perdiste();
        }
    }
    private void actualizarEtiqueta(){
        GreenfootImage texto = new GreenfootImage("Cantidad de basura recogida: " + contBasura, 30, Color.BLACK, null);
        getWorld().showText("", 100, 100);
        getWorld().showText("Cantidad de basura recogida " + contBasura, 200, 100);
    }
    private void perdiste() {
        Greenfoot.delay(100); // Agrega un pequeño retraso para que el jugador pueda leer el mensaje "Perdiste"
        Greenfoot.setWorld(new MyWorld()); // Reiniciar el juego creando un nuevo mundo
    }
    private void verificarFelicitaciones()
    {
        if (contBasura == totalBasura)
        {
            // Mostrar mensaje de felicitaciones
            getWorld().showText("¡Felicitaciones! Has recogido todas las latas.", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            perdiste();
        }
    }
}

