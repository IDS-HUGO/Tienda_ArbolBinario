public class Producto {
    private int codigo;
    private String nombre;
    private float precio;
    private int cantidad;

    public Producto(String nombre, float precio, int codigo,int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }
    public Producto() {

    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
