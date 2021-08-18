package com.BSTree;

public class Main {

    public static void main(String[] args) throws Exception {
        BST tree = new BST();
        tree.addVertex(50, "fifty");
        tree.addVertex(30, "thirty");
        tree.addVertex(20, "twenty");
        tree.addVertex(40, "forty");
        tree.addVertex(10, "ten");
        tree.addVertex(35, "t5");
        tree.addVertex(45, "f5");
        tree.addVertex(33, "t3");
        tree.addVertex(38, "t8");
        tree.addVertex(44, "f4");
        tree.addVertex(70, "seventy");
        tree.addVertex(90, "ninety");
        tree.addVertex(60, "sixty");


        tree.removeVertex(10);
        System.out.println(tree.findVertex(20));

    }
}

