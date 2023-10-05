class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   */
	   public void preOrderTraversal(Node root){
		   
		   //base case
		   if(root == null)
			   return;
		   
		   //print the current node value
		   System.out.print(root.value + ", ");
		   
		   //go left recursively
		   preOrderTraversal(root.left);
		   
		   //go right recursively
		   preOrderTraversal(root.right);
	   }

	   
	   
	   /*
	   in-order traversal
	   */
	   public void inOrderTraversal(Node root){
		   
		   //base case
		   if(root == null)
			   return;
		   
		   //go left recursively
		   preOrderTraversal(root.left);
		   
		   //print the current node value
		   System.out.print(root.value + ", ");
		   
		   //go right recursively
		   preOrderTraversal(root.right);
	   }
	   
	   
	   
	   /*
	   post-order traversal
	   */
	  
	   public void postOrderTraversal(Node root){
		   
		   //base case
		   if(root == null)
			   return;
		   
		   //go left recursively
		   preOrderTraversal(root.left);
		   
		   //go right recursively
		   preOrderTraversal(root.right);
		   
		   //print the current node value
		   System.out.print(root.value + ", ");
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a specific value
	   */
	   public boolean find(Node root, int key) {
		   
		   //get root
		   Node current = root
				   
	       //while key has not been found, traverse through BST
		   while (current != null) {
			   if (current.value == key)
				   return true;
			   else if (key > current.value)
				   current = current.right;
			   else if (key < current.value)
				   current = current.left;		   
		   }
		   
		   //if key has not been found, return false
		   return false;
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
	   public int getMin(Node root){
		   
		   //get root
		   Node current = root;
		   
		   //if current node has a child to the left, move to that node
		   while(current.left != null) {
			   current = current.left;
		   }
	      
		   //return the value of the smallest node
		   return current.value;
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root){
		   
		   //get root
		   Node current = root;
		   
		   //if current node has a child to the right, move to that node
		   while(current.right != null) {
			   current = current.right;
		   }
	      
		   //return the value of the greatest node
		   return current.value;
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
