import java.util.*;

class Flight {
    int flightNumber;
    String origin, destination, time, airline;

    public Flight(int flightNumber, String origin, String destination, String time, String airline) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.time = time;
        this.airline = airline;
    }

    @Override
    public String toString() {
        return String.format("Vuelo %d | %s → %s | %s | %s", flightNumber, origin, destination, time, airline);
    }
}

class Node {
    Flight data;
    Node left, right;
    int height;

    Node(Flight data) {
        this.data = data;
        this.height = 1;
    }
}

class AVLTree {
    Node root;

    // Obtener altura del nodo
    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    // Obtener factor de balance
    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    // Rotación derecha
    Node rotateRight(Node y) {
        System.out.println("🔄 Rotación derecha en nodo " + y.data.flightNumber);
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Rotación izquierda
    Node rotateLeft(Node x) {
        System.out.println("🔄 Rotación izquierda en nodo " + x.data.flightNumber);
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insertar vuelo en el árbol AVL
    Node insert(Node node, Flight data) {
        if (node == null)
            return new Node(data);

        if (data.flightNumber < node.data.flightNumber)
            node.left = insert(node.left, data);
        else if (data.flightNumber > node.data.flightNumber)
            node.right = insert(node.right, data);
        else
            return node; // No duplicados

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Casos de rotación
        if (balance > 1 && data.flightNumber < node.left.data.flightNumber) {
            System.out.println("⚖ Desbalance tipo Izquierda-Izquierda");
            return rotateRight(node);
        }

        if (balance < -1 && data.flightNumber > node.right.data.flightNumber) {
            System.out.println("⚖ Desbalance tipo Derecha-Derecha");
            return rotateLeft(node);
        }

        if (balance > 1 && data.flightNumber > node.left.data.flightNumber) {
            System.out.println("⚖ Desbalance tipo Izquierda-Derecha");
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && data.flightNumber < node.right.data.flightNumber) {
            System.out.println("⚖ Desbalance tipo Derecha-Izquierda");
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    // Buscar por número de vuelo
    Flight search(Node node, int number) {
        if (node == null)
            return null;
        if (number == node.data.flightNumber)
            return node.data;
        return (number < node.data.flightNumber) ? search(node.left, number) : search(node.right, number);
    }

    // Buscar por destino
    void searchByDestination(Node node, String destination) {
        if (node != null) {
            searchByDestination(node.left, destination);
            if (node.data.destination.toLowerCase().contains(destination.toLowerCase()))
                System.out.println(node.data);
            searchByDestination(node.right, destination);
        }
    }

    // Recorridos
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }
}

public class SistemaVuelosAVL {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            AVLTree tree = new AVLTree();
            
            // Vuelos de ejemplo para probar balanceo
            Flight[] vuelosEjemplo = {
                new Flight(301, "Bogotá", "Medellín", "08:30", "Avianca"),
                new Flight(102, "Cali", "Barranquilla", "09:15", "LATAM"),
                new Flight(450, "Medellín", "Cartagena", "10:00", "Wingo"),
                new Flight(210, "Bucaramanga", "Bogotá", "11:45", "Viva Air"),
                new Flight(380, "Pereira", "Cali", "12:20", "Satena")
            };
            
            for (Flight f : vuelosEjemplo) {
                System.out.println("\n✈ Insertando " + f);
                tree.root = tree.insert(tree.root, f);
            }
            
            int option;
            do {
                System.out.println("\n===== SISTEMA DE VUELOS AVL =====");
                System.out.println("1. Registrar nuevo vuelo");
                System.out.println("2. Buscar vuelo por número");
                System.out.println("3. Buscar vuelo por destino");
                System.out.println("4. Mostrar recorrido INORDEN");
                System.out.println("5. Mostrar recorrido PREORDEN");
                System.out.println("6. Mostrar recorrido POSTORDEN");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                option = sc.nextInt();
                sc.nextLine();
                
                switch (option) {
                    case 1 -> {
                        System.out.print("Número de vuelo: ");
                        int num = sc.nextInt(); sc.nextLine();
                        System.out.print("Origen: ");
                        String orig = sc.nextLine();
                        System.out.print("Destino: ");
                        String dest = sc.nextLine();
                        System.out.print("Hora: ");
                        String time = sc.nextLine();
                        System.out.print("Aerolínea: ");
                        String air = sc.nextLine();
                        tree.root = tree.insert(tree.root, new Flight(num, orig, dest, time, air));
                    }
                    case 2 -> {
                        System.out.print("Ingrese número de vuelo: ");
                        int num = sc.nextInt();
                        Flight f = tree.search(tree.root, num);
                        System.out.println(f != null ? f : "Vuelo no encontrado.");
                    }
                    case 3 -> {
                        System.out.print("Ingrese destino: ");
                        String dest = sc.nextLine();
                        tree.searchByDestination(tree.root, dest);
                    }
                    case 4 -> tree.inOrder(tree.root);
                    case 5 -> tree.preOrder(tree.root);
                    case 6 -> tree.postOrder(tree.root);
                    case 0 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (option != 0);
        }
    }
}
