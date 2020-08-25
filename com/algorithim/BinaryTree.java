package algorithim;

import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {
        Node rootNode = buildRootNode();
        inOrder(rootNode);
        preOrder(rootNode);
        postOrder(rootNode);
    }

    private static void postOrder(Node rootNode){
        System.out.println("......  Post Order ........");
        Stack<Node> preOrderStackOne = new Stack<>();
        Stack<Node> preOrderStackTwo = new Stack<>();
        preOrderStackOne.push(rootNode);
        while (!preOrderStackOne.isEmpty()){
            Node currentNode = preOrderStackOne.pop();
            preOrderStackTwo.push(currentNode);
           if(currentNode.getLeft()!=null){
               preOrderStackOne.push(currentNode.getLeft());
           }
           if(currentNode.getRight()!=null){
               preOrderStackOne.push(currentNode.getRight());
           }
        }
        while(!preOrderStackTwo.isEmpty()){
            System.out.println(preOrderStackTwo.pop().getData());
        }
    }
    private static void preOrder(Node rootNode){
        System.out.println("......  Pre Order ........");
        Stack<Node> preOrderStack = new Stack<>();
        preOrderStack.push(rootNode);
        while(!preOrderStack.isEmpty()){
            Node currentNode = preOrderStack.pop();
            System.out.println(currentNode.getData());
            if(currentNode.getRight()!=null){
                preOrderStack.push(currentNode.getRight());
            }
            if(currentNode.getLeft()!=null){
                preOrderStack.push(currentNode.getLeft());
            }
        }
    }

    private static void inOrder(Node rootNode){
        System.out.println("......  In Order ........");
        Stack<Node> inOrderStack = new Stack<>();
        Node currentNode = rootNode;
        currentNode = traverseLeft(inOrderStack, currentNode);
        while(currentNode==null && !inOrderStack.isEmpty()) {
            currentNode = inOrderStack.pop();
            System.out.println(currentNode.getData());
            currentNode = traverseLeft(inOrderStack, currentNode.getRight());
        }

    }

    private static Node traverseLeft(Stack<Node> inOrderStack, Node currentNode) {
        while (currentNode !=null){
            inOrderStack.add(currentNode);
            currentNode = currentNode.getLeft();
        }
        return currentNode;
    }

    private static Node buildNode(int data, Node leftChild, Node rightChild){
        Node node = new Node();
        node.setData(data);
        node.setLeft(leftChild);
        node.setRight(rightChild);
        return node;
    }

    /*
             1
           /   \
          2     3
         / \   / \
        4   5 6   7
       / \
      8   9
     */
    private static Node buildRootNode(){
        Node nodeEight = buildNode(8,null,null );
        Node nodeNine = buildNode(9, null, null);
        Node nodeFour = buildNode(4, nodeEight, nodeNine);
        Node nodeFive = buildNode(5, null, null);
        Node nodeTwo = buildNode(2, nodeFour, nodeFive);
        Node nodeSix = buildNode(6,null,null );
        Node nodeSeven = buildNode(7, null, null);
        Node nodeThree = buildNode(3, nodeSix, nodeSeven);
        Node rootNode = buildNode(1, nodeTwo, nodeThree);
        return rootNode;
    }
}
