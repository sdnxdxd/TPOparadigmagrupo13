import java.util.List;
import java.util.stream.Collectors;

public class Print   {

    public static void Imprimir(Personaje p1, Personaje p2){

        System.out.println("--------------------------------------------------------");
        System.out.println("Peleador 1: " + p1.getNombre().toUpperCase() + "    salud: (" + p1.getSalud() + "/" + p1.getSaludTotal() + ")");
        System.out.println("Peleador 2: " + p2.getNombre().toUpperCase() + "    salud: (" + p2.getSalud() + "/" + p2.getSaludTotal() + ")");
        System.out.println("--------------------------------------------------------");
    }

    public static void printEstats(Personaje pj){
        System.out.println("Las estadisticas de: " + pj.getNombre());
        System.out.println("Salud: " + pj.getSalud());
        System.out.println("Defensa: " + pj.getDefensa());
        System.out.println("Ataque: " + pj.getAtaque());
        System.out.println("Inventario: " +
        pj.getHerramientas().stream().map(herramienta -> herramienta.getNombre()).collect(Collectors.joining(", ")));
        System.out.println("--------------------------------------------------------");
    }


    public static void printRondas(Personaje pj){

        if(!pj.vive()) {
            System.out.println("--------------------------------------------------------");
            System.out.println("El personaje " + pj.getNombre() + " ha caido en la ronda: " + pj.getRonda());
            System.out.println("FIN DEL JUEGO");
            System.out.println("--------------------------------------------------------");
        }else{
            System.out.println("El personaje " + pj.getNombre() +  " ha superado la ronda: " + pj.getRonda());
            System.out.println("El personaje " + pj.getNombre() +  " ha subido de nivel!");
            System.out.println();
            pj.setSalud(pj.getSaludTotal() + 50);
            pj.setSaludTotal(pj.getSalud());
            pj.setAtaque(pj.getAtaque()+25);
            pj.setDefensa(pj.getDefensa()+25);
            pj.setRonda(pj.getRonda() + 1);
        }

    }

    public static void completaTodasLasRondas(Personaje personaje, int size){

        if(personaje.getRonda()-1 == size) {
            System.out.println("El personaje " + personaje.getNombre() + " supero todas las rondas de la torre");
            System.out.println("--------------------------------------------------------");
        }

    }


}
