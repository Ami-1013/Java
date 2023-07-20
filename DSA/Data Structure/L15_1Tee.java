/*          Tree
- A tree is a non-linear data structure with hierarchical relationships between its element without having any cycle, it is
  basically reversed from a real life tree.

- Properties (From the tree diagram)
    1- Represent hierarchical data.
    2- Each node has two component: data and link to its sub category.
    3- Base category and sub category under it & We can as many sub category under a base category.

- Why tree?
    Because other linear data structure such as array, linked list, stack etc get their runtime increase as their size increases.
    As they are linear or 2-Directional they can't store data in a structure or hierarchical form.

    TREE ---
    1- Quicker and easier access to data.
    2- Store hierarchical data like folder structure, organization structure.
    3- There are many types of data structure which perform better in various case.
        ex - Binary search tree in sorted data, AVL, Red Black Tree, Tries.

- Tree Terminology

    1- Root: top node without parent.
    2- Edge: a link btw parent and child.
    3- Leaf: a node which does not have children.
    4- Sibling: children of same parent.
    5- Ancestor: parent, grandparent, great grandparent ... of a node.
    6- Depth of node: length of the path from root to node.
    7- Height of node: a length of the path from the node to its  deepest node.
    8- Depth of tree: depth of root node.
    9- Height of tree: height of root node.

-

*/ 

import java.util.ArrayList;

class TreeNode{
    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data){
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChildren(TreeNode node){
        this.children.add(node);
    }

    public String print(int level){
        String ret;
        ret = "  ".repeat(level) + data + "\n";
        for (TreeNode node: this.children){
            ret += node.print(level+1);
        }
        return ret;
    }

}


public class L15_1Tee {
    public static void main(String[] args) {
        
        TreeNode drinks = new TreeNode("drinks");
        TreeNode hot = new TreeNode("hot");
        TreeNode cold = new TreeNode("cold");
        TreeNode tea = new TreeNode("tea");
        TreeNode coffee = new TreeNode("coffee");
        TreeNode wine = new TreeNode("wine");
        TreeNode beer = new TreeNode("beer");


        drinks.addChildren(hot);
        drinks.addChildren(cold);

        hot.addChildren(tea);
        hot.addChildren(coffee);

        cold.addChildren(wine);
        cold.addChildren(beer);

        System.out.println(drinks.print(0));



    }
    
}
