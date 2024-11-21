public class Main {
    public static void main(String[] args) {

        Tipo Fuego = new Tipo();
        Tipo Planta = new Tipo();
        Tipo Agua = new Tipo();

        Fuego.setContrario(Agua);
        Planta.setContrario(Fuego);
        Agua.setContrario(Planta);

        Personaje Heroe = new Personaje("Sanchez", 300,100,100,Fuego);

        //Personaje Malo = new Personaje("Mansete777_kick",130,100,10,TipoTipos.AGUA);

        Arma Esp = new Arma("Espada de Hoja", Agua,10,10);
        //Herramienta Cuchillo = new Arma(Planta,10,3);
        Herramienta Escudo = new Proteccion("Escudo de llamas" , Fuego,30,1);
        Herramienta Escudo2 = new Proteccion("nemiEscudoPersonal",Fuego,120,1);

        Heroe.obtieneObjeto(Esp);
        Heroe.obtieneObjeto(Escudo);
        Heroe.obtieneObjeto(Escudo2);

        //Malo.obtieneObjeto(Esp);
        //Malo.obtieneObjeto(Escudo1);

//        IPelea Pelea = new Pelea();
//        Pelea.pelea(Heroe,Malo);

        TorreDelPoder Gotham = new TorreDelPoder();
        Gotham.torreDelPoder(Heroe);

    }
}