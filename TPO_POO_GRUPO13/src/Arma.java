public class Arma extends Herramienta{
    public Arma( String s, Tipo tipo, int x, int u) {
        super(tipo);
        this.nombre = s;
        this.atributo = -x;
        this.Usos = u;
    }

    public int getDanio() {
        return atributo;
    }

    @Override
    public void IncrementarAtributos() {
        atributo = atributo-25;
    }

    @Override
    public void DecrementarAtributos() {
        atributo = atributo+25;
    }
}