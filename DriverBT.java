import java.util.Scanner;

public class DriverBT 
{
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args)
	{	
		System.out.println("1st Testing Example:");
		BinaryTree<String> aTree = new BinaryTree<>();
		createTree1(aTree);
		
		System.out.print("(binaryTree) post-order: ");
		aTree.postorderTraverse();
		System.out.println();
		
		System.out.print("(binaryNode) post-order: ");
		aTree.postorderTraverse_callBinaryNodeMethod();
		System.out.println();
		
		System.out.println();
		
		System.out.println("(BinaryTree) Height of tree is " + aTree.getHeight());
		System.out.println("(BinaryNode) Height of tree is " + aTree.getHeight_callBinaryNodeMethod());
		
		System.out.println();
		
		System.out.println("(BinaryTree) # nodes of tree is " + aTree.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " + aTree.getNumberOfNodes_callBinaryNodeMethod());

		System.out.println("==========================================");
		System.out.println();
		
		System.out.println("2nd Testing Example:");
		BinaryTree<String> aTree2 = new BinaryTree<>();
		createTree2(aTree2);
		
		System.out.print("(binaryTree) post-order: ");
		aTree2.postorderTraverse();
		System.out.println();
		
		System.out.print("(binaryNode) post-order: ");
		aTree2.postorderTraverse_callBinaryNodeMethod();
		System.out.println();
		
		System.out.println();
		
		System.out.println("(BinaryTree) Height of tree is " + aTree2.getHeight());
		System.out.println("(BinaryNode) Height of tree is " + aTree2.getHeight_callBinaryNodeMethod());
		
		System.out.println();
		
		System.out.println("(BinaryTree) # nodes of tree is " + aTree2.getNumberOfNodes());
		System.out.println("(BinaryNode) # nodes of tree is " + aTree2.getNumberOfNodes_callBinaryNodeMethod());
		System.out.println();	
		
		System.out.print("Thank you for using our program :)");
		
		scan.close();
	}  // end main

	public static void createTree1(BinaryTree<String> tree)
	{ 
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);
		
      System.out.println("\nGiven Tree:\n");
      System.out.println("     A      ");
      System.out.println("   /   \\  ");
      System.out.println("  B     C  ");
      System.out.println(" / \\   /  ");
      System.out.println("D   E  F   ");
      System.out.println("        \\ ");
      System.out.println("         G ");
      System.out.println();
	} // end createTree
	
	/**-------------------------------------------------------------------- */
	/**Task 4: Create a tree case as shown in assignment 3*/
	public static void createTree2(BinaryTree<String> tree)
	{ 
		String[] leaves = new String[4];
		String[] nodes = new String[3];
		
		System.out.println("\nGiven Tree:\n");
		System.out.println("     root     ");
		System.out.println("    /   \\  ");
	    System.out.println("  leaf1   parent  ");
	    System.out.println("          /   \\");
	    System.out.println("      parent   parent ");
	    System.out.println("       /        /   \\");
	    System.out.println("    leaf2    leaf3   leaf4");
	    System.out.println();
		
		System.out.print("What do you want the root to be: ");
		String root = scan.nextLine();
		root = root.toUpperCase();
		
		for(int i = 0; i < leaves.length; i++)
		{
			System.out.print("(From left to right) What is the value of leaf number " + (i + 1) + ": ");
			String leaf = scan.nextLine();
			leaf = leaf.toUpperCase();		
			
			//skip first search because there will be no duplicates
			if(i != 0)
			{
				//search for duplicates
				for(int j = 0; j < leaves.length; j++)
				{
					while(leaf.equals(leaves[j]))
					{
						System.out.print(leaf + " already exists as a node, choose a different character: ");
						leaf = scan.nextLine();
						leaf = leaf.toUpperCase();
					}
				}
			}
			leaves[i] = leaf;
		}
		
		System.out.print("what is the parent node for " + leaves[1] + ": ");
		String node1 = scan.nextLine();
		node1 = node1.toUpperCase();
		
		//search for duplicates
		for(int i = 0; i < nodes.length; i++)
		{
			while(node1.equals(leaves[i]) || node1.equals(nodes[i]))
			{
				System.out.print(node1 + " already exists as a node, choose a different character: ");
				node1 = scan.nextLine();
				node1 = node1.toUpperCase();
			}
		}
		nodes[0] = node1;
		
		System.out.print("what is the parent node for " + leaves[2] + " and " +  leaves[3] + ": ");
		String node2 = scan.nextLine();
		node2 = node2.toUpperCase();
		
		//search for duplicates
		for(int i = 0; i < nodes.length; i++)
		{
			while(node2.equals(leaves[i]) || node2.equals(nodes[i]))
			{
				System.out.print(node2 + " already exists as a node, choose a different character: ");
				node2 = scan.nextLine();
				node2 = node2.toUpperCase();
			}
		}
		nodes[1] = node2;
		
		System.out.print("what is the parent node for " + nodes[0] + " and " +  nodes[1] + ": ");
		String node3 = scan.nextLine();
		node3 = node3.toUpperCase();
		
		//search for duplicates
		for(int i = 0; i < nodes.length; i++)
		{
			while(node2.equals(leaves[i]) || node3.equals(nodes[i]))
			{
				System.out.print(node3 + " already exists as a node, choose a different character: ");
				node3 = scan.nextLine();
				node3 = node3.toUpperCase();
			}
		}
		nodes[2] = node3;
		
		// Leaves
		BinaryTree<String> tree1 = new BinaryTree<>(leaves[0]);
		BinaryTree<String> tree2 = new BinaryTree<>(leaves[1]);
		BinaryTree<String> tree3 = new BinaryTree<>(leaves[2]);
		BinaryTree<String> tree4 = new BinaryTree<>(leaves[3]);

		// Subtrees:
		BinaryTree<String> tree5 = new BinaryTree<>(nodes[0], tree2, null);
		BinaryTree<String> tree6 = new BinaryTree<>(nodes[1], tree3, tree4);
		BinaryTree<String> tree7 = new BinaryTree<>(nodes[2], tree5, tree6);

		tree.setTree(root, tree1, tree7);
				
		System.out.println("\nGiven Tree:\n");
		System.out.println("    " + root + "     ");
		System.out.println("   / \\  ");
	    System.out.println("  " + leaves[0] + "   " + nodes[2] + "  ");
	    System.out.println("     / \\");
	    System.out.println("    " + nodes[0] + "   " + nodes[1] + " ");
	    System.out.println("   /   / \\");
	    System.out.println("  " + leaves[1] + "   " + leaves[2] + "   " + leaves[3] + "");
	    System.out.println();
	} // end createTree2
}  // end DriverBT
