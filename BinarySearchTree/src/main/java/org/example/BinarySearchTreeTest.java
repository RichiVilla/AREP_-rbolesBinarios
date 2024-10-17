package org.example;

import java.util.Comparator;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        // Crear un comparador para enteros
        Comparator<Integer> comparator = Integer::compareTo;
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(comparator);

        // 1. Insertar elementos
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        // 2. In-order Traversal (debería ser: 3, 5, 7, 10, 12, 15, 18)
        System.out.println("In-order traversal:");
        bst.inOrder();

        // 3. Pre-order Traversal (debería ser: 10, 5, 3, 7, 15, 12, 18)
        System.out.println("Pre-order traversal:");
        bst.preOrder();

        // 4. Post-order Traversal (debería ser: 3, 7, 5, 12, 18, 15, 10)
        System.out.println("Post-order traversal:");
        bst.postOrder();

        // 5. Buscar elementos
        System.out.println("Buscar 7: " + bst.search(7)); // true
        System.out.println("Buscar 20: " + bst.search(20)); // false

        // 6. Eliminar un nodo
        System.out.println("Eliminar 5:");
        bst.delete(5);
        System.out.println("In-order traversal después de eliminar 5:");
        bst.inOrder();

        // 7. Buscar el mínimo y el máximo
        System.out.println("Valor mínimo: " + bst.findMin()); // 3
        System.out.println("Valor máximo: " + bst.findMax()); // 18

        // 8. Altura del árbol
        System.out.println("Altura del árbol: " + bst.height()); // 3

        // 9. Balance del árbol
        System.out.println("Árbol balanceado: " + bst.balance()); // true o false dependiendo del estado del árbol

        // 10. Contar nodos
        System.out.println("Número de nodos: " + bst.countNodes()); // 6 (después de eliminar 5)

        // 11. Limpiar el árbol
        bst.clear();
        System.out.println("Número de nodos después de limpiar: " + bst.countNodes()); // 0

    }
}