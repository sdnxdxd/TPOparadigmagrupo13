public interface Peleable  {


    void pelea(Personaje p1, Personaje p2);

    Personaje determinarGanador(Personaje p1, Personaje p2);

    void aplicarEfectosPrePelea(Personaje p1, Personaje p2);

    void imprimirEstadoActual(Personaje p1, Personaje p2);

    void finalizarPelea(Personaje ganador, Personaje perdedor);

}

