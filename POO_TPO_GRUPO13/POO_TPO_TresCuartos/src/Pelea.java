import java.util.stream.Collectors;

public class Pelea implements Peleable{

    @Override
    public void pelea(Personaje p1, Personaje p2) {
        try {
            if (p1 == null || p2 == null) {
                throw new IllegalArgumentException("Falta uno o ambos personajes.");
            }

            System.out.println("-------------------- ¡Comienza la pelea entre " + p1.getNombre() + " y " + p2.getNombre() + "! --------------------");

            Print.printEstats(p1);
            Print.printEstats(p2);

            // Inicia la pelea solo si ambos personajes son válidos
            while (p1.getSalud() > 0 && p2.getSalud() > 0) {
                p1.usarObjeto(p2);

                if (p2.getSalud() > 0) {
                    p2.usarObjeto(p1);
                    Print.Imprimir(p1, p2);
                }
            }

            // Determina al ganador de la pelea
            if (p1.vive()) {
                System.out.println("¡¡El ganador de la pelea es " + p1.getNombre().toUpperCase() + "!!");
                if(p2.getHerramientas() != null && p2.getHerramienta() != null) {
                    p1.obtieneObjeto(p2.getHerramienta());
                    System.out.println(p1.getNombre().toUpperCase()
                            + " obtiene " + p2.getHerramienta().getNombre() + " de "
                            + p2.getNombre());
                }

            } else {
                System.out.println("¡¡El ganador de la pelea es " + p2.getNombre().toUpperCase()+ "!!");

            }
        }
        catch(IllegalArgumentException ex){
            // Captura el error si falta uno de los personajes
            System.out.println("Error: " + ex.getMessage());
        }
    }
}