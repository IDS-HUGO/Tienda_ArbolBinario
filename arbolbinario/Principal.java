import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner entrada = new Scanner(System.in);

        Excepciones a = new Excepciones();
        int codigo, cantidad;
        float precio;
        int nuevocodigo, nuevoCantidad;
        float nuevoPrecio;
        int opc;
        do {
            System.out.println("----------------------------------------------------------------------------");
            System.out.println(
                    "1. Agregar producto primario\n2. Agregar mas productos\n3. Imprimir Productos\n4.Actualizar Cantidad de existencia\n5.Guardar\n6.Salir");
            System.out
                    .println("---------------------------------------------------------------------------------------");
            opc = a.validarDatoEntrada();
            switch (opc) {
                case 1:
                    do {
                        System.out.print("Ingresa el codigo del producto:\n");
                        codigo = a.validarDatoEntrada();
                    } while (codigo < 0 || codigo > 999);
                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = entrada.nextLine();
                    do {
                        System.out.println("Ingresa el precio del producto:");
                        precio = a.validarDatoEntrada();
                    } while (precio <= 0);
                    do {
                        System.out.println("Ingresa la cantidad del producto:");
                        cantidad = a.validarDatoEntrada();
                    } while (cantidad <= 0);
                    Producto producto = new Producto(nombre, precio, codigo, cantidad);
                    arbol.setRaiz(producto);
                    break;
                case 2:
                    do {
                        System.out.print("Ingresa el codigo del producto:\n");
                        nuevocodigo = a.validarDatoEntrada();
                    } while (nuevocodigo < 0 || nuevocodigo > 999);
                    System.out.println("Ingrese el nombre del producto: ");
                    String nuevoNombre = entrada.nextLine();
                    do {
                        System.out.println("Ingresa el precio del producto:");
                        nuevoPrecio = a.validarDatoEntrada();
                    } while (nuevoPrecio <= 0);
                    do {
                        System.out.println("Ingresa la cantidad del producto:");
                        nuevoCantidad = a.validarDatoEntrada();
                    } while (nuevoCantidad <= 0);
                    Producto nvProducto = new Producto(nuevoNombre, nuevoPrecio, nuevocodigo, nuevoCantidad);
                    arbol.insertarNodo(arbol.getRaiz(), nvProducto);
                    break;
                case 3:
                if (arbol.validarRaiz()) {
                    arbol.visualizarRecorridos();
                }else{
                    System.out.println("No hay");
                }
                    break;
                case 4:
                if (arbol.validarRaiz()) {
                    arbol.actualizarCantidad();
                }else{
                    System.out.println("No hay productos para actualizar. Agregue un producto");
                }
                    break;
                case 5:
                    if (arbol.validarRaiz()) {
                        Archivo archivo = new Archivo();
                        String[][] productos = arbol.guardarRegistros();
                        archivo.setRegistros(productos);
                        archivo.escribirInformacion();
                        System.out.println("Información guardada y saliendo...");
                    } else {
                        System.out.println("No hay productos para guardar. Agregue al menos un producto.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opc != 6);
    }

}
