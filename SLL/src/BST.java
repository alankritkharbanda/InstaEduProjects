/**
 * This class acts as a node for the Binary Search Tree Algorithm 
 * @author
 *
 */
 class BSTnode <T extends Comparable <T> > {
	
	T data;
	BSTnode <T> left;
	BSTnode <T> right;
	int count;
	
	public BSTnode(T data){
		this.data = data;
		count=0;
	}
	public void incrementcount()
	{
		count++;
	}
	public int getcount()
	{
		return count;
		
	}
	
	public BSTnode (T data, BSTnode <T> left, BSTnode <T> right)
	{
		this.data = data;
		this.left = left;
		this.right = right;
	}
	//Below are the desired Getters and Setters
	
	//Method to set the left node
	public void setLeft(BSTnode <T> data)
	{
		left = data;
	}
	
	//Method to set the right node
	public void setRight( BSTnode <T> data)
	{
		right = data;
	}
	
	//Method to get the left node
	public BSTnode <T> getLeft()
	{
		return left;
	}
	//Method to get the right node
	public  BSTnode <T> getRight()
	{
		return right;
	}
	
	//Method to set data to node
	public void setData (T d)
	{
		data = d;
	}
	//Method to get data from the node
	public T getData()
	{
		return data;
	}
	
	
	public int compareTo(BSTnode<T> other) {
		return this.data.compareTo(other.data);
	}

}
public class BST <T extends Comparable <T>> {
	
	BSTnode <T> root;
	
	
	public BST (T value){
		root = new BSTnode<T>(value);
		
	}

	public void insert(T data)
	{
		root = insert(root, data);
	}
	
	//Method to insert an element into the Binary Search Tree
	private BSTnode<T> insert (BSTnode<T> array, T key)
	{
		if (array == null)
		{
			return new BSTnode<T>(key);
		}
		
		if (key.compareTo(array.data) == 0)
		{
			array.incrementcount();
			/*array.left=root.left;
			array.right=root.right;
			*/
			return array;
		}
		if (key.compareTo(array.data) < 0)
		{
			array.left = insert(array.left, key);
		}
		
		else
		{
			array.right = insert(array.right, key);
		}
		
		return array;
	}
	
	
	//Method to count number of nodes
	public int CountNodes()
	{
		return CountNodes(root);
	}
	
	
	//Method to count number of nodes
	private int CountNodes(BSTnode<T> r)
	{
		if(r == null)
		{
			return 0;
		}
		
		else
		{
			int l = 1;
			l += CountNodes(r.getLeft());
			l += CountNodes(r.getRight());
			return l;
		}
	}
	public int numnodescutoff(BSTnode<String> left,int t)
	{
		
		if(left==null)
		return 0;
		int x=0;
		if(left.getcount()>=t)
			x=1;
		return x+numnodescutoff(left.left, t)+numnodescutoff(left.right, t);
		
		
	}
	
	//Method to search for an element in the Binary Search Tree
	public boolean search (T key)
	{
		return search(root, key);
	}
	
	
	//Method for inorder traversal
	public void inorder()
	{
		inorder(root);
	}
	
	//Method for inorder traversal
	public void inorder(BSTnode<T> r)
	{
		if(r != null)
		{
			inorder(r.getLeft());
			System.out.println(r.getData() + " ");
			inorder(r.getRight());
		}
	}
	
	//Method for preorder traversal

	public void preorder()
	{
		preorder(root);
	}
	
	public void preorder(BSTnode<T> r)
	{
		if (r != null)
		{
			System.out.println(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		
		}
	}
	//method for post order traversal
	
	public void postorder()
	{
		postorder(root);
	}
 
	public void postorder(BSTnode<T> r)
	{
		if (r != null)
		{
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.println(r.getData() + " ");
		}
	}
	
	//Method to search for an element in the Binary Search Tree
	public boolean search(BSTnode<T> array, T key)
	{
		if (array == null)
		{
			return false;
		}
		
		else
		{
			if (key.compareTo(array.data) == 0)
			{
				return true;
			}
			else
			{
				if (key.compareTo(array.data) < 0)
				{
					return search(array.left, key);
				}
				else
				{
					return search(array.right, key);
				}
			}
		}
	}
	
	//Method to delete an element in the Binary Search Tree
	public void delete (T toDelete)
	{
		root = delete(root, toDelete);
	}
	
	
	private BSTnode<T> delete(BSTnode<T> array, T key)
	{
		if (array == null)
		{
		throw new RuntimeException("Sorry, but the element can not be deleted.");
		}
		else
		{
			if (key.compareTo(array.data) < 0)
			{
				array.left = delete(array.left, key);
			}
			else
			{
				if (key.compareTo(array.data) > 0)
				{
					array.right = delete (array.right, key);
				}
				else
				{
					//get data from the rightmost node in left subtree
					array.data = retrieveData(array.left);
					
					//delete the rightmost node in the left subtree
					array.left = delete(array.left, array.data);
				}
				
			}
		}
		return array;
	}
	
	
	private T retrieveData(BSTnode<T> array)

	{
		while(array.right != null){
			array = array.right;
		}
		
		return array.data;
	}

	
}
