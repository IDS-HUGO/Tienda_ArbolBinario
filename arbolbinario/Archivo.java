import java.io.FileWriter;
import java.io.PrintWriter;
public class Archivo {
    private String[][] registros;
    public void escribirInformacion() {
        
        try (FileWriter fichero = new FileWriter("Productos.txt"); 
        PrintWriter pw = new PrintWriter(fichero))
        {
            for (String[] registro : this.registros) {
                pw.println("Código: " + registro[0]);
                pw.println("Nombre: " + registro[1]);
                pw.println("Cantidad en existencia: " + registro[2]);
                pw.println("Precio: " + registro[3]);
                pw.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 

    }

    public void setRegistros(String[][] registros) {
        this.registros = registros;
    }
    
}
