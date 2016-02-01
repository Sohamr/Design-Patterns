package studentRecordsBackup.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import studentRecordsBackup.bst.Node;
import studentRecordsBackup.bst.Tree;
import studentRecordsBackup.bst.TreeI;

public class BSTBuilder {
	private BufferedReader br = null;
	private FileReader fr = null;
	private TreeI mainTree = null;
	private Vector<TreeI> backUps = null;

	/**
	 * 
	 * @param file
	 *            - File object containing input file
	 * @param numBackups
	 *            - Number of backup trees to be created
	 */
	public BSTBuilder(File file, int numBackups) {
		
		try {
			fr = new FileReader(file);
			this.br = new BufferedReader(fr);
			mainTree = new Tree();
			backUps = new Vector<TreeI>();
			for (int i = 0; i < numBackups; i++) {
				TreeI t = new Tree();
				backUps.add((Tree) t);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);		
		} finally {
			
		}
		
	}

	/**
	 * Builds Main Tree and backup trees
	 */
	public void buildTree() {
		int bno = 0;
		String desc = null;
		mainTree = new Tree();

		try {
			String line = null;
			StringTokenizer st = null;
			if (br != null) {
				while ((line = br.readLine()) != null) {

					st = new StringTokenizer(line);
					if (st.countTokens() == 2) {
						bno = Integer.parseInt((st.nextToken()));
						desc = st.nextToken("\t");
						while (st.hasMoreTokens()) {
							desc += st.nextToken();
						}
					}

					// Create and insert node for main tree
					Node n = new Node(bno, desc, true);
					mainTree.insertNode(n);

					// Create node, register it to MainTree and insert in
					// respective backup tree.
					for (TreeI t : backUps) {
						Node n1 = new Node(bno, desc, false);
						n.registerObserver(n1);
						t.insertNode(n1);
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Error Reading line : "
					+ e.getLocalizedMessage());
			System.exit(1);
		} catch (NullPointerException e) {
			System.err.println("Error Reading line : "
					+ e.getLocalizedMessage());
			System.exit(1);
		} finally {

			// Close BufferedReader and FileReader
			if (null != br)
				try {
					br.close();
					br = null;
					if (null != fr) {
						fr.close();
						fr = null;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	/**
	 * Print all BST's using in order traversal
	 */
	public void printInOrder() {
		System.out.println("\nMain Records: ");
		mainTree.printTree();
		int i = 1;

		for (TreeI t : backUps) {
			System.out.println("\nBackup Records " + i++ + ": ");
			t.printTree();
		}
	}

	/**
	 * Print sum of all nodes in all BST's
	 */
	public void printSum() {
		int i = 1;
		System.out.println("\n Main BST Sum : " + mainTree.getSum());
		for (TreeI t : backUps) {
			System.out.println(" Backup BST" + i++ + " Sum : " + t.getSum());
		}
	}

	/**
	 * Updates all nodes in Main BST
	 * 
	 * @param value
	 *            - Value to increment BNumber
	 */
	public void updateMain(int value) {

		mainTree.updateBno(value);
	}
}