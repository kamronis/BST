package com.BSTree;

public class BST {
    class Vertex
    {
        int key;
        String value;
        Vertex left, right;

        public Vertex(int key, String value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    Vertex root;

    public BST() {
        root = null;
    }

    public void addVertex(int key, String value) {
        root = recursiveInsert(root, key, value);
    }

    private Vertex recursiveInsert(Vertex root, int key, String value){
        if (root == null) {
            root = new Vertex(key, value);
            return root;
        }
        if (key < root.key) {
            root.left = recursiveInsert(root.left, key, value);
        }
        else {
            if (key > root.key) {
                root.right = recursiveInsert(root.right, key, value);
            }
        }

        return root;
    }

    public String findVertex(int key) throws Exception {
        return recursiveFind(root, key, false).value;
    }

    private Vertex recursiveFind(Vertex root, int key, boolean findParent) throws Exception {
        if (root == null) {
            throw new Exception("No vertex with key "+key);
        }
        if (((root.left != null && root.left.key == key) || (root.right != null && root.right.key == key)) && findParent) {
            return root;
        }
        if (key == root.key) {
            return root;
        }
        if (key < root.key) {
            return recursiveFind(root.left, key, findParent);
        }
        else {
            return recursiveFind(root.right, key, findParent);
        }
    }

    private Vertex getLeftest(Vertex vertex) {
        if (vertex.left != null) {
            if (vertex.left.left == null) {
                return vertex.left;
            } else {
                return getLeftest(vertex.left);
            }
        }
        return null;
    }

    public void removeVertex(int key) throws Exception {
        Vertex toRemove = recursiveFind(root, key, false);
        Vertex parent = recursiveFind(root, key, true);
        if (toRemove.right == null && toRemove.left == null) {
            if (parent.left != null && parent.left.key == toRemove.key) {
                parent.left = null;
            }
            if (parent.right != null && parent.right.key == toRemove.key) {
                parent.right = null;
            }
            if (parent.key == toRemove.key) {
                root = null;
            }


        } else {
            if (toRemove.right == null) {
                toRemove.right = toRemove.left.left;
                toRemove.key = toRemove.left.key;
                toRemove.value = toRemove.left.value;
                toRemove.left = toRemove.left.right;
                return;
            }
            if (toRemove.left == null || toRemove.right.left == null) {
                toRemove.left = toRemove.right.left;
                toRemove.key = toRemove.right.key;
                toRemove.value = toRemove.right.value;
                toRemove.right = toRemove.right.right;
                return;
            }
            Vertex leftest = getLeftest(toRemove.right);
            int keyBuffer = leftest.key;
            String valueBuffer = leftest.value;
            removeVertex(leftest.key);
            toRemove.key = keyBuffer;
            toRemove.value = valueBuffer;



        }

    }

}
