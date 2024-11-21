public abstract class Herramienta {
    protected String nombre;
    private Tipo tipo;
    private Personaje dueno;
    protected int atributo;
    protected int Usos;

    public Herramienta(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setDueno(Personaje dueno) {
        this.dueno = dueno;
    }

    public Personaje getDueno() {
        return this.dueno;
    }

    public int getUsos() {
        return Usos;
    }

    public void setUsos(int usos) {
        Usos = usos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAtributo() {
        return atributo;
    }

    public void mismoTipo(){
        if(this.tipo.equals(dueno.getTipo()))
            IncrementarAtributos();
        if(this.tipo.getContrario().equals(dueno.getTipo()))
            DecrementarAtributos();
    }

    public void IncrementarAtributos(){

    }

    public void DecrementarAtributos(){

    }
}
