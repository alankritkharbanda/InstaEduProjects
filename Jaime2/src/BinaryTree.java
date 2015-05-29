import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
   This program demonstrates construction 
   and traversal of binary trees.
*/

public class BinaryTree
{
    private class Node
    {
        char value;          // Value stored in node
        Node left, right;    // Left and right child
        
        /**
           Constructor for leaf nodes.
           @param val The value to initialize the node.
        */
        
        Node(char val)
        {
            value = val;
            left = null;
            right = null;
        }
        
        /** 
           Constructor for non-leaf nodes.
           @param val The value to initialize the node.
           @param leftChild The link to the left child.
           @param rightChild The link to the right child.
        */
        
        Node(char val, Node leftChild, Node rightChild)
        {
            value = val;
            left = leftChild;
            right = rightChild;
        }
    }
   
    private Node root;        // Root of binary tree
    
    /**
       Constructor.
    */
 
    public BinaryTree()
    {
        Node aNode = new Node('A');  
        aNode.left = new Node('B');
        Node dNode = new Node('D');
        Node cNode = new Node('C', dNode, null);
        aNode.right = cNode;
        cNode.right=new Node('E');
        root = aNode;       
    }
    public Node insert(Node n,char ch)
    {
    	if(ch<n.value)
    	{
    		if(n.left==null)
    			n.left= new Node(ch,null,null);
    		else
    			n=insert(n.left,ch);
    		
    	}
    	else
    	{
    		if(n.left==null)
    			n.right= new Node(ch,null,null);
    		else
    			n=insert(n.right,ch);
    		
    		
    	}
    	
    	return n;
    }
    /**
       This private inorder method recursively 
       traverses a binary tree in inorder.
       @param btree The root of the tree to traverse.
    */
    
    private static void inorder(Node btree)
    {     
       if (btree != null)
       {
         inorder(btree.left);
         System.out.print(btree.value + " ");
         inorder(btree.right);
       }
    } 
    
    /**
       This inorder method is the public interface to
       the private inorder method. It calls the private 
       inorder method and passes it the root of the tree.
     * @return 
    */
    
    private Node getroot()
    {return root;}
    public void inorder()
    {
        inorder(root);
    }
    private static void preorder(Node btree)
    {     
       if (btree != null)
       {
    	   System.out.print(btree.value + " ");
    	   preorder(btree.left);
         
         preorder(btree.right);
       }
    } 
    private static void  postorder(Node btree)
    {     
       if (btree != null)
       {
    	  
    	   postorder(btree.left);
         
         postorder(btree.right);
         System.out.print(btree.value + " ");
       }
    } 
    /**
       The main method creates a binary tree
       and traverses it in inorder.
     * @throws IOException 
    */

    public static void main(String [ ] args) throws IOException
    {
       BinaryTree binTree = new BinaryTree();
      
       String str;
       //System.out.println("Enter")
       
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       int x=1;
       while(x!=5)
       {
    	   System.out.println("Enter choice : \n1. Inorder Traversal \n2.Postorder Traversal \n3.Preorder Traversal\n4.Number of Nodes \n5.Exit ");
    	   str=br.readLine();
       x=Integer.parseInt(str);
       switch(x)
       {
       case 1: inorder(binTree.getroot());
       break;
       case 2: postorder(binTree.getroot());
       break;
       case 3: preorder(binTree.getroot());
       break;
       case 4: System.out.println("Number of Nodes: "+numnodes(binTree.getroot()));
       break;
       case 5: 
       break;
       
       }
       
       
       }
       
       
       System.out.print("Inorder traversal is : " );
       binTree.inorder();        
    }
	public static int numnodes(Node getroot) {
		// TODO Auto-generated method stub
		if(getroot==null)
			return 0;
		return 1+numnodes(getroot.left)+numnodes(getroot.right);
	}    
}