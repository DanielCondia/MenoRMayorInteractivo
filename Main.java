import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //Creamos array a para ordenar
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> arrayOrdenado = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner dc = new Scanner(System.in);
        boolean controladorDecision = true;
        do {
            System.out.println("Ingrese el número a ordenar");
            array.add(sc.nextInt());
            boolean controlador = true;
            while(controlador){
                System.out.println("Desea ingresar otro número?");
                System.out.println("Si(y), No(n)");
                String decision = dc.nextLine();
                if(Objects.equals(decision, "y")){
                    controlador = true;
                    break;
                }
                else if(Objects.equals(decision, "n")){
                    controladorDecision = false;
                    controlador = true;
                    break;
                }
                else{
                    System.out.println("Incorrecto, elija la opción correcta");
                }
            }
        }while(controladorDecision);
        //Creamos boolean control para que me controle el ciclo do while
        boolean control = true;
        do {
            //Creamos int contador para recorrer a
            int contador = 1;
            for (int i = 0; i < array.size(); i++) {
                //Si el número anterior es menor que el que le sigue
                if(array.get(i) < array.get(contador)){
                    //Agregamos a array ordenado el número que esta en posición de i
                    arrayOrdenado.add(array.get(i));
                }
                else{
                    //De lo contrario agregamos a array ordenado en posición de i el número que esta en posición de contador
                    arrayOrdenado.add(array.get(contador));
                    //Luego pasamos a array ordenado en posición de contador, lo que esta en a en posición de i
                    arrayOrdenado.add(array.get(i));
                    //Creamos la variable de control para el while, que es igual a lo que esta en contador + 1.
                    int controlWhile = ++contador;
                    while (controlWhile < array.size()){
                        //Posicionamos el resto de números de a, en array ordenado
                        arrayOrdenado.add(array.get(contador++));
                        controlWhile++;
                    }
                    //Nos salimos del ciclo for
                    break;
                }
                contador++;
            }
            //Variable que me permite controlar el bucle
            int segundoContador = 1;
            //Variable que me permite controlar la verificación del bucle
            boolean verificadorBooleano = true;
            for (int j = 0; j < arrayOrdenado.size(); j++) {
                if(segundoContador == arrayOrdenado.size()){
                    segundoContador = arrayOrdenado.size();
                    --segundoContador;
                }
                if(arrayOrdenado.get(j) <= arrayOrdenado.get(segundoContador)){
                    //El verificador booleano sigue en true
                    verificadorBooleano = true;
                }
                else{
                    //Borramos el contenido de arrays
                    array.clear();
                    array = new ArrayList<>(arrayOrdenado);
                    arrayOrdenado.clear();
                    verificadorBooleano = false;
                    break;
                }
                segundoContador++;
            }
            if(verificadorBooleano){
                control = false;
            }

        }while(control);

        System.out.println("Números ordenados" + arrayOrdenado);
        imprimirArreglo(arrayOrdenado);
    }
    public static void imprimirArreglo(ArrayList<Integer> arrayOrdenado){
        for (int i = 0; i < arrayOrdenado.size(); i++) {
            System.out.println(arrayOrdenado.get(i));
        }
    }
}