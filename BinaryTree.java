public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // This ends default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // This ends constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // This ends constructor

   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
                               (BinaryTree<T>)rightTree);
   } // This ends setTree

   public void setRootData(T rootData)
   {
      root.setData(rootData);
   } // This ends setRootData
   
   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   } // This ends getRootData
   
   public boolean isEmpty()
   {
      return root == null;
   } // This ends isEmpty
   
   public void clear()
   {
      root = null;
   } // This ends clear
   
   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   } // This ends setRootNode
   
   protected BinaryNode<T> getRootNode()
   {
      return root;
   } // This ends getRootNode
   
   private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      root = new BinaryNode<>(rootData);
      
      if ((leftTree != null) && !leftTree.isEmpty())
         root.setLeftChild(leftTree.root);
      
      if ((rightTree != null) && !rightTree.isEmpty())
      {
         if (rightTree != leftTree)
            root.setRightChild(rightTree.root);
         else
            root.setRightChild(rightTree.root.copy());
      } // This ends if
      
      if ((leftTree != null) && (leftTree != this))
         leftTree.clear();
      
      if ((rightTree != null) && (rightTree != this))
         rightTree.clear();
   } // This ends initializeTree
   
   /** -------------------------------------------------------------------- */
   /** Task 1: Implement the 4 methods
    *     . In BinaryTree.java
    *          1. public void postorderTraverse();
    *          2. private void postorderTraverse(BinaryNode<T> node)
    *          3. public void postorderTraverse_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          4. public void postorderTraverse_binaryNodeMethod() */
   
   /** calls postorderTraverse(BinaryNode<T> node)
    * prints (using post-order traversal) all nodes in the "whole" tree */
   public void postorderTraverse()
   {
	   postorderTraverse(root);
   }
   
   /** A Recursive Method in the BinaryTree Class   
    * This prints (using post-order traversal) all nodes in the subtree rooted at this node.*/
   private void postorderTraverse(BinaryNode<T> node)
   {
	   if(node != null)
	   {
		   postorderTraverse(node.getLeftChild()); //recursively traverse through left subtree
		   postorderTraverse(node.getRightChild()); //recursively traverse through right subtree
		   System.out.print(node.getData()); //print data of each node
		   
		   //print comma and spacing for each printed node until the last node.
		   if(node != root)
			   System.out.print(", ");
	   }	   
   }
 
   /** The following calls postorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method   
    * This prints (using post-order traversal) all nodes in the "whole" tree */
   public void postorderTraverse_callBinaryNodeMethod()
   {
	   this.root.postorderTraverse_binaryNodeMethod();
   }
   
   /** -------------------------------------------------------------------- */
   /** Task 2: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getHeight_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          2. public int getHeight_binaryNodeMethod()*/
   
   /** This calls getHeight(BinaryNode<T> node)
   @return  The height of the "whole" tree */
   public int getHeight()
   {
	   return getHeight(root);
   } // This ends getHeight
   
   /** A Recursive Method in the BinaryTree Class  
    * Computes the height of the subtree rooted at this node.
   @return  The height of the subtree rooted at this node. */
   private int getHeight(BinaryNode<T> node)
   {
      int height = 0;
      if (node != null)
         height = 1 + Math.max(getHeight(node.getLeftChild()),
                               getHeight(node.getRightChild()));
      return height;
   } // This ends getHeight
   
   /** The following calls getHeight_binaryNodeMethod() which is a recursive binaryNode class method
    * Computes the height of the "whole" tree.
   @return  The height of the "whole" tree. */
   public int getHeight_callBinaryNodeMethod()
   {
	   return this.root.getHeight_binaryNodeMethod();
   } // This ends getHeight_callBinaryNodeMethod

   /** -------------------------------------------------------------------- */
   /** Task 3: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getNumberOfNodes()
    *          2. private int getNumberOfNodes(BinaryNode<T> node)*/
   
   /** This calls getNumberOfNodes(BinaryNode<T> node) 
   @return  The number of nodes in the "whole" tree */
   public int getNumberOfNodes()
   {
      return getNumberOfNodes(root);
   } // This ends getNumberOfNodes
   
   /** A Recursive Method in the BinaryTree Class   
    * This counts the nodes in the subtree rooted at this node.
   @return  The number of nodes in the subtree rooted at this node. */
   private int getNumberOfNodes(BinaryNode<T> node)
   {
      int leftNumber = 0;
	  int rightNumber = 0;
	  
	  if (node.getLeftChild() != null)
	     leftNumber = getNumberOfNodes(node.getLeftChild());
	  
	  if (node.getRightChild() != null)
	     rightNumber = getNumberOfNodes(node.getRightChild());
	  return 1 + leftNumber + rightNumber;  
   } // This ends getNumberOfNodes
   
   /** The following calls getNumberOfNodes_binaryNodeMethod() which is a recursive binaryNode class method
    * This counts the nodes in the "whole" tree
   @return  The number of nodes in the "whole" tree. */
   public int getNumberOfNodes_callBinaryNodeMethod()
   {
	   int numberOfNodes = 0;
	   if (root != null)
		   numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
	   return numberOfNodes;
   } // end getNumberOfNodes_callBinaryNodeMethod
   
} // end BinaryTree
