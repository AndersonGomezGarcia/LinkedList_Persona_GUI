class Persona {
    private String nombre;
    private String apellidos;
    private String cedula;

    public Persona(String nombre, String apellidos, String cedula) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public  String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
