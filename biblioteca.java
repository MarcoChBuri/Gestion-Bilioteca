import java.util.*;

public class Biblioteca {
    private String direccion;
    private String nombre;
    private List<Cuenta> cuentaList;

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentaList = new ArrayList<>();
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
    }
}

class Cuenta {
    private Biblioteca biblioteca;
    private List<Persona> personaList;
    private String contrasena;
    private String correo;
    private int multasPendientes;

    public Cuenta(Biblioteca biblioteca, String contrasena, String correo) {
        this.biblioteca = biblioteca;
        this.contrasena = contrasena;
        this.correo = correo;
        this.multasPendientes = 0;
        this.personaList = new ArrayList<>();
    }

    public void registrar(Persona persona) {
        personaList.add(persona);
        System.out.println("Registro exitoso!");
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public int getMultasPendientes() {
        return multasPendientes;
    }
}

abstract class Persona {
    private String nombre;
    private String correo;
    private String telefono;
    private int edad;
    private String genero;

    public Persona(String nombre, String correo, String telefono, int edad, String genero) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }
}

class Autor extends Persona {
    private String obras;
    private String estiloLiterario;
    private String bibliografia;

    public Autor(String nombre, String correo, String telefono, int edad, String genero, String obras, String estiloLiterario, String bibliografia) {
        super(nombre, correo, telefono, edad, genero);
        this.obras = obras;
        this.estiloLiterario = estiloLiterario;
        this.bibliografia = bibliografia;
    }

    public void buscar() {
        System.out.println("Buscando autor...");
    }

    public void agregar() {
        System.out.println("Agregando autor...");
    }

    public void eliminar() {
        System.out.println("Eliminando autor...");
    }
}

class Lector extends Persona {
    private List<Accion> accion;
    private String librosFavoritos;

    public Lector(String nombre, String correo, String telefono, int edad, String genero, String librosFavoritos) {
        super(nombre, correo, telefono, edad, genero);
        this.librosFavoritos = librosFavoritos;
        this.accion = new ArrayList<>();
    }

    public void buscarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro que desea buscar:");
        String titulo = scanner.nextLine();

        // Aquí iría la lógica para buscar el libro en la biblioteca

        System.out.println("Libro encontrado: " + titulo);
    }

    public void pedir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro que desea pedir:");
        String titulo = scanner.nextLine();

        // Aquí iría la lógica para pedir el libro a la biblioteca

        System.out.println("Libro pedido: " + titulo);
    }

    public void reservar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro que desea reservar:");
        String titulo = scanner.nextLine();

        // Aquí iría la lógica para reservar el libro en la biblioteca

        System.out.println("Libro reservado: " + titulo);
    }

    public void verificarMultas() {
        // Aquí iría la lógica para verificar si el lector tiene multas pendientes

        System.out.println("No se encontraron multas pendientes.");
    }
}

class Accion {
    private Lector lector;
    private CopiaPublicacion copiaPublicacion;

    public void notificar() {
        System.out.println("Notifying user...");
        // Add your notification logic here
    }

    public void cancelar() {
        System.out.println("Canceling action...");
        // Add your cancellation logic here
    }

    public void verificar() {
        System.out.println("Verifying action...");
        // Add your verification logic here
    }

    public void registrar() {
        System.out.println("Registering action...");
        // Add your registration logic here
    }
}

class Reserva extends Accion {
    private Date fechaReserva;
    private Date fechaRetiro;
    private Date fechaDevolucion;

    public Reserva(Date fechaReserva, Date fechaRetiro, Date fechaDevolucion) {
        this.fechaReserva = fechaReserva;
        this.fechaRetiro = fechaRetiro;
        this.fechaDevolucion = fechaDevolucion;
    }
}

abstract class Publicacion {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Publicacion(String titulo, String autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }
}

class Libro extends Publicacion {
    private Categoria categoria;
    private String edicion;
    private String volumen;

    public Libro(String titulo, String autor, int anioPublicacion, Categoria categoria, String edicion, String volumen
    ) {
        super(titulo, autor, anioPublicacion);
        this.categoria = categoria;
        this.edicion = edicion;
        this.volumen = volumen;
    }
}

class Periodico extends Publicacion {
    private String articulos;
    private String titulares;

    public Periodico(String titulo, String autor, int anioPublicacion, String articulos, String titulares) {
        super(titulo, autor, anioPublicacion);
        this.articulos = articulos;
        this.titulares = titulares;
    }
}

class Revista extends Publicacion {
    private Categoria categoria;
    private String edicion;

    public Revista(String titulo, String autor, int anioPublicacion, Categoria categoria, String edicion) {
        super(titulo, autor, anioPublicacion);
        this.categoria = categoria;
        this.edicion = edicion;
    }
}

enum Categoria {
    NOVELA,
    CIENTIFICO,
    MISTERIO,
    ROMANCE
}

class CopiaPublicacion {
    private List<Accion> accion;
    private Publicacion publicacion;
    private String numCopia;

    public CopiaPublicacion(Publicacion publicacion, String numCopia) {
        this.publicacion = publicacion;
        this.numCopia = numCopia;
        this.accion = new ArrayList<>();
    }

    public void prestar() {
        if (accion.isEmpty()) {
            accion.add(Accion.Prestado);
            System.out.println("La copia de la publicación ha sido prestada.");
        } else {
            System.out.println("La copia de la publicación ya está prestada.");
        }
    }

    public void devolver() {
        if (accion.contains(Accion.Prestado)) {
            accion.remove(Accion.Prestado);
            System.out.println("La copia de la publicación ha sido devuelta.");
        } else {
            System.out.println("La copia de la publicación no está prestada.");
        }
    }

    public void consultarEstado() {
        if (accion.contains(Accion.Prestado)) {
            System.out.println("La copia de la publicación está prestada.");
        } else {
            System.out.println("La copia de la publicación no está prestada.");
        }
    }
}
