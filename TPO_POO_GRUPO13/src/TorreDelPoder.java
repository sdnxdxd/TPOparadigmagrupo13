import java.util.ArrayList;
import java.util.List;

public class TorreDelPoder {
    //Lista de enemigos
    Enemigo listaE = new Enemigo();

    public void torreDelPoder(Personaje personaje) {
        ArrayList<Personaje> enemigos = listaE.ListaEnemigo();
        try {
            // Verificar que el personaje no sea nulo
            if (personaje == null) {
                throw new IllegalArgumentException("El personaje no puede ser nulo");
            }

            Peleable pelea = new Pelea();

            // Verificar que haya enemigos disponibles
            if (enemigos == null || enemigos.isEmpty()) {
                throw new IllegalStateException("No hay enemigos disponibles para pelear.");
            }

            for (Personaje enemigo : enemigos) {
                // Verificar que el enemigo no sea nulo
                if (enemigo == null) {
                    throw new IllegalArgumentException("Uno de los enemigos es nulo");
                }

                pelea.pelea(personaje, enemigo);
                Print.printRondas(personaje);


                // Si el personaje muere, termina la torre
                if (!(personaje.vive())) break;
            }

            // Imprimir todas las rondas completadas
            Print.completaTodasLasRondas(personaje, enemigos.size());

        } catch (IllegalArgumentException | IllegalStateException ex) {
            // Captura de excepciones y muestra un mensaje de error
            System.out.println("Error: " + ex.getMessage() + " para la torre del poder.");
        }
    }

}
