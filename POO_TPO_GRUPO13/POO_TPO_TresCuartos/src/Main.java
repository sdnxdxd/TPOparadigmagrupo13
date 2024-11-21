public class Main {
    public static void main(String[] args) {

        Tipo Fuego = new Tipo();
        Tipo Planta = new Tipo();
        Tipo Agua = new Tipo();

        Fuego.setContrario(Agua);
        Planta.setContrario(Fuego);
        Agua.setContrario(Planta);

        Personaje Heroe = new Personaje("Batman", 100,100,100,Fuego);

        Herramienta A1 = new Arma("Batarang de Hojas", Planta,-50,10);
        Herramienta A2 = new Arma("BatiManguera",Agua,-55,5);
        Herramienta P1 = new Proteccion("Batifuego" , Fuego,150,2);

        Heroe.obtieneObjeto(A1);
        Heroe.obtieneObjeto(P1);

        TorreDelPoder Gotham = new TorreDelPoder();
        Gotham.torreDelPoder(Heroe);

    }
}