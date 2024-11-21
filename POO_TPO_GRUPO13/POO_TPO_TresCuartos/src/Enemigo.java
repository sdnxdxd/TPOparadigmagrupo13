import java.util.ArrayList;

public class Enemigo {

    public ArrayList<Personaje> ListaEnemigo(){

        ArrayList<Personaje> enemigos = new ArrayList<>();
        Tipo Fuego = new Tipo();
        Tipo Planta = new Tipo();
        Tipo Agua = new Tipo();

        Fuego.setContrario(Agua);
        Planta.setContrario(Fuego);
        Agua.setContrario(Planta);



        // Primera Ronda
        Personaje R1 = new Personaje("Pinguino", 200, 30, 120, Agua);
        Herramienta espadaDeMadera = new Arma("Espada de Fuego", Fuego ,-10,4);
        R1.obtieneObjeto(espadaDeMadera);
        enemigos.add(R1);

        // Segunda Ronda
        Personaje R2 = new Personaje("Hiedra" , 130 , 200, 150, Planta);
        Herramienta bate = new Arma("Rama",Planta,-10,5);
        Herramienta prote = new Proteccion("Corteza",Planta,100,1);
        R2.obtieneObjeto(bate);
        R2.obtieneObjeto(prote);
        enemigos.add(R2);


        // Tercera Ronda
        Personaje R3 = new Personaje("Bane" , 300 , 50, 200, Fuego);
        Herramienta garras = new Arma("Punios de Agua",Agua, -40, 8);
        Herramienta Veneno = new Arma("Venom", Fuego, -40,2);
        R3.obtieneObjeto(garras);
        R3.obtieneObjeto(Veneno);
        enemigos.add(R3);

        // Final boss
        Personaje jefeFinal = new Personaje("Guason" , 500 ,500 , 100, Fuego);
        Herramienta ochurus = new Arma("Ochurus",Planta,-35,2);
        Herramienta pistola = new Arma("Pistola de juguete",Fuego,-90,3);
        Herramienta curita = new Proteccion("Armadura de Agua", Agua,250,1);
        jefeFinal.obtieneObjeto(ochurus);
        jefeFinal.obtieneObjeto(curita);
        jefeFinal.obtieneObjeto(pistola);
        enemigos.add(jefeFinal);


        return enemigos;

    }
}
