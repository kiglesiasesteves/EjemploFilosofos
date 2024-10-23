import java.util.logging.Level;
import java.util.logging.Logger;

public class Mesa {
    private boolean[] tenedores;

    public Mesa(int numTenedores){
        this.tenedores = new boolean[numTenedores];
    }

    public int tenedorIzquierda(int i){
        return i;
    }

    public int tenedorDerecha(int i){
        if(i == 0){
            return this.tenedores.length - 1;
        }else{
            return i - 1;
        }
    }

    // Método sin sincronización, los filósofos compiten por los tenedores
    public void cogerTenedores(int comensal){

        // No se espera ni se coordina, cada filósofo intenta coger los tenedores
        //Eliminé la sincronización y el wait():
        // Ahora los filósofos intentan tomar los tenedores sin esperar a que estén disponibles.
        // Esto simula la falta de coordinación.
        if (tenedores[tenedorIzquierda(comensal)] || tenedores[tenedorDerecha(comensal)]) {
            System.out.println("Filósofo " + (comensal + 1) + " no pudo comer, esperando por tenedores.");
        }

        tenedores[tenedorIzquierda(comensal)] = true;
        tenedores[tenedorDerecha(comensal)] = true;
    }

    public void dejarTenedores(int comensal){
        tenedores[tenedorIzquierda(comensal)] = false;
        tenedores[tenedorDerecha(comensal)] = false;
    }

}