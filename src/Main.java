import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Definir la matriz de ventas (5 filas x 12 columnas)
        int[][] ventas = new int[5][12];

        // Generar valores aleatorios para las ventas
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                ventas[i][j] = random.nextInt(10000) + 1; // Ventas entre 1 y 10000
            }
        }

        // Imprimir la matriz de ventas por filas usando forEach
        System.out.println("Matriz de ventas:");
        Arrays.stream(ventas)
                .forEach(row -> {
                    Arrays.stream(row)
                            .forEach(value -> System.out.printf("%8d  ", value));
                    System.out.println();
                });

        // Ordenar los elementos de una matriz por columna
        System.out.println("\nMatriz de ventas ordenada por columna:");
        for (int j = 0; j < ventas[0].length; j++) {
            final int column = j;
            Arrays.stream(ventas)
                    .mapToInt(row -> row[column])
                    .sorted()
                    .forEach(value -> System.out.printf("%8d  ", value));
            System.out.println();
        }

        // Filtrar elementos de una matriz por un criterio (por ejemplo, mayores que 5000)
        System.out.println("\nElementos de la matriz de ventas mayores que 5000:");
        Arrays.stream(ventas)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value > 5000)
                .forEach(value -> System.out.printf("%8d  ", value));
    }
}
