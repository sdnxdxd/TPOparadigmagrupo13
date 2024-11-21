public class Pelea implements Peleable  {

    @Override
    public void pelea(Personaje p1, Personaje p2) {
        aplicarEfectosPrePelea(p1, p2);

        System.out.println("-------------------- ¡Comienza la pelea! --------------------");
        while (p1.vive() && p2.vive()) {
            p1.usarObjeto(p2);

            if (p2.vive()) {
                p2.usarObjeto(p1);
            }

            imprimirEstadoActual(p1, p2);
        }

        Personaje ganador = determinarGanador(p1, p2);
        Personaje perdedor = (ganador == p1) ? p2 : p1;

        finalizarPelea(ganador, perdedor);
    }

    @Override
    public Personaje determinarGanador(Personaje p1, Personaje p2) {
        if (p1.vive()) {
            return p1;
        } else if (p2.vive()) {
            return p2;
        } else {
            return null; // Empate
        }
    }

    @Override
    public void aplicarEfectosPrePelea(Personaje p1, Personaje p2) {
        System.out.println(p1.getNombre() + " y " + p2.getNombre() + " se preparan para la batalla.");
        // Aquí podrías aplicar buffs, efectos de inicio, etc.
    }

    @Override
    public void imprimirEstadoActual(Personaje p1, Personaje p2) {
        System.out.println("Estado actual de la pelea:");
        System.out.println(p1.getNombre() + " - Salud: " + p1.getSalud());
        System.out.println(p2.getNombre() + " - Salud: " + p2.getSalud());
        System.out.println("------------------------------------------------------------");
    }

    @Override
    public void finalizarPelea(Personaje ganador, Personaje perdedor) {
        if (ganador != null) {
            System.out.println("¡El ganador es " + ganador.getNombre() + "!");
            System.out.println(perdedor.getNombre() + " ha sido derrotado.");
        } else {
            System.out.println("¡La pelea terminó en empate!");
        }
    }

}



