import java.util.ArrayList;
import java.util.Date;

// Enum para categorías de publicaciones
enum Categoria {
    LIBRO,
    REVISTA,
    PERIODICO
}

// Clase Persona
class Persona {
    protected String nombre;
    protected String direccion;
    protected String correo;
    protected String telefono;
    protected int edad;
    protected String genero;

    public Persona(String nombre, String direccion, String correo, String telefono, int edad, String genero) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
        this.genero = genero;
    }
}

// Clase Cuenta
class Cuenta {
    private String contraseña;
    private String correo;
    private int multaPendiente;

    public Cuenta(String contraseña, String correo) {
        this.contraseña = contraseña;
        this.correo = correo;
        this.multaPendiente = 0;
    }

    public void registrarMulta(int multa) {
        this.multaPendiente += multa;
        System.out.println("Multa registrada: $" + multa);
    }
}

// Clase Lector
class Lector extends Persona {
    private ArrayList<Publicacion> publicacionesPrestadas;

    public Lector(String nombre, String direccion, String correo, String telefono, int edad, String genero) {
        super(nombre, direccion, correo, telefono, edad, genero);
        this.publicacionesPrestadas = new ArrayList<>();
    }

    public void prestarPublicacion(Publicacion publicacion) {
        publicacionesPrestadas.add(publicacion);
        System.out.println("Publicación prestada: " + publicacion.titulo);
    }
}

// Clase Autor
class Autor extends Persona {
    private ArrayList<Publicacion> publicaciones;

    public Autor(String nombre, String direccion, String correo, String telefono, int edad, String genero) {
        super(nombre, direccion, correo, telefono, edad, genero);
        this.publicaciones = new ArrayList<>();
    }

    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
        System.out.println("Publicación agregada: " + publicacion.titulo);
    }
}

// Clase Publicacion
class Publicacion {
    protected String titulo;
    protected String editorial;
    protected Date fechaPublicacion;
    protected Categoria categoria;

    public Publicacion(String titulo, String editorial, Date fechaPublicacion, Categoria categoria) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.categoria = categoria;
    }
}

// Clase Biblioteca
class Biblioteca {
    private String nombre;
    private String direccion;
    private Persona encargado;

    public Biblioteca(String nombre, String direccion, Persona encargado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.encargado = encargado;
    }

    public void imprimirInformacion() {
        System.out.println("Nombre de la biblioteca: " + nombre);
        System.out.println("Dirección de la biblioteca: " + direccion);
        System.out.println("Información del Encargado:");
        System.out.println("Nombre: " + encargado.nombre);
        System.out.println("Correo: " + encargado.correo);
        System.out.println("Teléfono: " + encargado.telefono);
    }
}

// Clase Multa
class Multa {
    private Date fechaEmision;
    private double monto;
    private boolean estadoDePago;
    private Lector lector;

    public Multa(Date fechaEmision, double monto, Lector lector) {
        this.fechaEmision = fechaEmision;
        this.monto = monto;
        this.estadoDePago = false;
        this.lector = lector;
    }
}

// Clase Main
public class Main {
    public static void main(String[] args) {
        // Crear un autor
        Autor autor = new Autor("John Doe", "Calle Principal 123", "johndoe@example.com", "123456789", 40, "Masculino");

        // Crear una publicación
        Publicacion libro = new Publicacion("Mi Libro", "Editorial X", new Date(), Categoria.LIBRO);

        // Agregar publicación al autor
        autor.agregarPublicacion(libro);

        // Crear un lector
        Lector lector = new Lector("Alice", "Calle Secundaria 456", "alice@example.com", "987654321", 25, "Femenino");

        // Crear una cuenta para el lector
        Cuenta cuentaLector = new Cuenta("password123", "alice@example.com");

        // Asignar cuenta al lector

        // Prestar publicación al lector
        lector.prestarPublicacion(libro);

        // Registrar una multa al lector
        Multa multa = new Multa(new Date(), 20, lector);
        

        // Crear una biblioteca
        Persona encargado = new Persona("Pedro", "Avenida Central 789", "pedro@example.com", "987654321", 35, "Masculino");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal", "Avenida Central 789", encargado);

        // Imprimir información de la biblioteca
        biblioteca.imprimirInformacion();
    }
}
