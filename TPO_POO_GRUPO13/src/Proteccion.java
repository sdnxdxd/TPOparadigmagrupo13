public class Proteccion extends Herramienta{

    public Proteccion(String s, Tipo tipo, int x, int u) {
        super(tipo);
        this.atributo = x;
        this.Usos=u;
        this.nombre = s;
    }

    @Override
    public void IncrementarAtributos() {
        atributo = atributo+20;
    }

    public void DecrementarAtributos() {
        atributo = atributo-20;
    }
}
