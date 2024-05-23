import java.util.Scanner;

public class ArbolBinario {
    Nodo raiz = new Nodo();

    public void setRaiz(Producto dato) {
        if (raiz.getDato() == null)
            raiz.setDato(dato);
        else
            System.out.println("Solo puede existir una raiz");
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public boolean validarRaiz() {
        if (raiz.getDato() != null)
            return true;
        return false;
    }

    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.getIzq());
            System.out.println("Codigo: " + raiz.getDato().getCodigo() + "   Nombre: " + raiz.getDato().getNombre()
                    + "   Precio: " + raiz.getDato().getPrecio() + "    Cantidad: " + raiz.getDato().getCantidad());
            inorden(raiz.getDer());
        }
    }

    public void visualizarRecorridos() {
        inorden(raiz);
    }

    public void insertarNodo(Nodo raiz, Producto nuevo) {
        if (validarRaiz()) {
            if (nuevo.getCodigo() < raiz.getDato().getCodigo()) {
                if (raiz.getIzq() == null) {
                    Nodo nodoNuevo = new Nodo(nuevo);
                    raiz.setIzq(nodoNuevo);
                } else
                    insertarNodo(raiz.getIzq(), nuevo);
            } else if (nuevo.getCodigo() > raiz.getDato().getCodigo())
                if (raiz.getDer() == null) {
                    Nodo nodoNuevo = new Nodo(nuevo);
                    raiz.setDer(nodoNuevo);
                } else
                    insertarNodo(raiz.getDer(), nuevo);
            else
                System.out.println("Ya existe ");
        } else {
            System.out.println("Agregar antes un producto primario");
        }
    }

    public void actualizarCantidad() {
        int codigoBuscar;
        int nuevaCantidad;
        Scanner entrada = new Scanner(System.in);
        Excepciones a = new Excepciones();
        inorden(raiz);
        System.out.println("Ingrese el codigo del producto al que le actualizará la cantidad:");
        codigoBuscar = a.validarDatoEntrada();
        Nodo nodo = buscarNodo(raiz, codigoBuscar);
        if (nodo != null) {
            do{
            System.out.println("Ingrese la nueva cantidad de existencia:");
            nuevaCantidad = a.validarDatoEntrada();
            }while(nuevaCantidad <=0 );
            nodo.getDato().setCantidad(nuevaCantidad);
            System.out.println("Cantidad actualizada.");
        } else {
            System.out.println("Producto no encontrado.");

        }
    }

    public Nodo buscarNodo(Nodo raiz, int codigoBuscar) {
        if (raiz == null) {
            return null;
        }
        if (raiz.getDato().getCodigo() == codigoBuscar) {
            return raiz;
        } else if (codigoBuscar < raiz.getDato().getCodigo()) {
            return buscarNodo(raiz.getIzq(), codigoBuscar);
        } else {
            return buscarNodo(raiz.getDer(), codigoBuscar);
        }
    }

    public int contarNodos(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + contarNodos(raiz.getIzq()) + contarNodos(raiz.getDer());
    }

    public void guardarDatos() {
        int numeroProductos = contarNodos(raiz);
        if (numeroProductos <= 5) {
            System.out.println("Debe haber más de 5 productos para guardar los datos.");
        } else {
            Archivo a = new Archivo();
            a.escribirInformacion();
        }

    }

    public String[][] guardarRegistros() {
        String[][] registros = new String[100][4];
        int[] index = { 0 };
        guardarRecursivo(raiz, registros, index);

        String[][] resultados = new String[index[0]][4];
        for (int i = 0; i < index[0]; i++) {
            resultados[i] = registros[i];
        }
        return resultados;
    }

    public void guardarRecursivo(Nodo nodo, String[][] registros, int[] index) {
        if (nodo != null) {
            guardarRecursivo(nodo.getIzq(), registros, index);
            if (nodo.getDato().getCantidad() > 4) {
                registros[index[0]][0] = String.valueOf(nodo.getDato().getCodigo());
                registros[index[0]][1] = nodo.getDato().getNombre();
                registros[index[0]][2] = String.valueOf(nodo.getDato().getCantidad());
                registros[index[0]][3] = String.valueOf(nodo.getDato().getPrecio());
                index[0]++;
            }
            guardarRecursivo(nodo.getDer(), registros, index);
        }
    }

}
