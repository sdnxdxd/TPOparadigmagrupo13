import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Personaje {
    private String Nombre;
    private int ronda = 1;
    private int salud;
    private int defensa;
    private int ataque;
    private Tipo tipo;
    private HashSet<Herramienta> Herramientas = new HashSet<>();
    private boolean usado = true;
    private int saludTotal;


    public int getSaludTotal() {
        return saludTotal;
    }

    public int getRonda() {
        return ronda;
    }

    public Personaje(String Name, int salud, int defensa, int ataque, Tipo tipo) {
        try {
            // Verificar si el nombre es nulo
            if (Name == null) {
                throw new IllegalArgumentException("El nombre no puede ser nulo.");
            }

            this.Nombre = Name;
            this.saludTotal = salud;
            this.salud = salud;
            this.defensa = defensa;
            this.ataque = ataque;
            this.tipo = tipo;

        } catch (IllegalArgumentException ex) {
            // Capturar la excepción si el nombre es nulo
            System.out.println("Error: " + ex.getMessage());
        }
    }


    public Tipo getTipo() {
        return tipo;
    }

    public boolean vive() {
        return salud > 0;
    }

    public void obtieneObjeto(Herramienta x) {
        try {
            if (x == null) {
                throw new IllegalArgumentException("La herramienta no puede ser nula.");
            }
            Herramientas.add(x);
            x.setDueno(this);
        } catch (Exception e) {
            System.err.println("Error al obtener el objeto: " + e.getMessage());
        }
    }


    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getSalud() {
        return salud;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setSaludTotal(int saludTotal) {
        this.saludTotal = saludTotal;
    }

    public HashSet<Herramienta> getHerramientas() {
        return Herramientas;
    }

    public Herramienta getHerramienta() {
        for (Herramienta herramienta : Herramientas)
            return herramienta;
        return null;
    }

    public void usarObjeto(Personaje victima) {
        int ataquetotald = this.getAtaque();
        int defensatotald = this.getDefensa();
        int defensatotal = victima.getDefensa();


        if (this.Herramientas != null) {
            List<Herramienta> herramientasRotas = new ArrayList<>();
            for (Herramienta HerramientaUsada : this.getHerramientas()) {
                if (usado == true) {
                    HerramientaUsada.mismoTipo();
                    usado = false;
                }
                if (HerramientaUsada.getUsos() > 0) {

                    if (HerramientaUsada.getAtributo() < 0) {
                        ataquetotald = HerramientaUsada.getAtributo() - this.getAtaque();
                        HerramientaUsada.setUsos(HerramientaUsada.getUsos() - 1);
                    }
                   else {
                       if (this.getSalud() < (this.getSaludTotal() / 2)) {
                           defensatotald = HerramientaUsada.getAtributo();
                           this.setSalud(this.getSalud() + defensatotald);
                           HerramientaUsada.setUsos(HerramientaUsada.getUsos() - 1);
                           System.out.println(this.getNombre() + " se ha protegido y su salud ahora es de: " + this.getSalud());
                        }
                    }
                }
                if (HerramientaUsada.getUsos() == 0) {
                    System.out.println("El objeto " + HerramientaUsada.getNombre() + " de " + this.getNombre() + " se rompió");
                    herramientasRotas.add(HerramientaUsada);

                }

            }
            this.Herramientas.removeAll(herramientasRotas);


            defensatotal = victima.getDefensa();
            int daniofinal = ataquetotald + defensatotal;

            //DANIO QUE SALE POR PANTALLA=
            //Ataquebase del personaje - Defensa de la victima + Danio del arma +/- ventaja tipo


            if (daniofinal < 0) {
                victima.setSalud(victima.getSalud() + daniofinal);
                System.out.println("--> " + this.getNombre() + " inflije " + -daniofinal + " de danio a " + victima.getNombre());

            } else { //si estan mano a mano van a usar su ataque base
                victima.setSalud(victima.getSalud() - (this.getAtaque() - 25));
                System.out.println("--> " + this.getNombre() + " le ha infligido " + (this.getAtaque() - 25) + " de danio con los punios sobre " + victima.getNombre());
            }

            if (victima.getSalud() <= 0)
                victima.setSalud(0);

        }
    }

        public void setRonda ( int ronda){
            this.ronda = ronda;
        }


    }

