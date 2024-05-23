public class Nodo {
    private Producto dato;
    private Nodo izq;
    private Nodo der;
    
    public Nodo (Producto dato){
        this.dato= dato;
    }
    public Nodo (){    }
    public Nodo getIzq(){ return izq;  }
    public Nodo getDer(){ return der;  }
    public Producto getDato(){ return dato; }
    public void setDato(Producto dato){ this.dato= dato; }
    public void setIzq(Nodo nodo){ this.izq=nodo; }
    public void setDer(Nodo nodo){ this.der=nodo; }
}
