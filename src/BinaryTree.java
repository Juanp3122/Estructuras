package Trees;


/*
# Binary Tree Data Structure.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
 */

/**
 * This class represents the behavior of Binary Trees
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class BinaryTree {

	BinaryTreeNode root = null; //

	/**
	 * 
	 */
	public BinaryTree() {}


	/**
	 * 
	 * @return
	 */
	public boolean isEmpty()
	{
		return root == null ? true : false;
	}


	/**
	 * 
	 * @param value
	 */
	public void insert(BinaryTreeNode node)
	{
		if(isEmpty())
		{
			root = node;
		}
		else
		{
			BinaryTreeNode temp = root;
			BinaryTreeNode parent = root;

			while(temp != null)
			{
				parent = temp;
				if(node.isLessThan(temp))
					temp = temp.getLeft();
				else
					temp = temp.getRight();
			}

			if(node.isLessThan(parent))
				parent.setLeft(node);
			else
				parent.setRight(node);
		}
	}


	/**
	 * 
	 * @param value
	 * @return
	 */
	public BinaryTreeNode search(BinaryTreeNode nodeToSearch)
	{
		BinaryTreeNode temp = root;

		while(temp != null)
		{

			if(temp.isEqual(nodeToSearch))
				break;
			else
				if(nodeToSearch.isLessThan(temp))
					temp = temp.getLeft();

				else
					temp = temp.getRight();
		}

		return temp;
	}


	/**
	 * 
	 * @param value
	 */
	public void delete(BinaryTreeNode nodeToDelete)
	{
		BinaryTreeNode temp= root;
		BinaryTreeNode parent=null;
		if(root.equals(nodeToDelete)) root=null;
		
		while(temp!=null) {

			if(temp.equals(nodeToDelete)) {
				if(isLeaf(temp)) {
					if(temp.isLessThan(parent)) {
						parent.setLeft(null);
					}
					else parent.setRight(null);
					
				}else if(oneChild(temp)){
					
					if(temp.getRight()!=null) {
						
						if(temp.isLessThan(parent))     parent.setLeft(temp.getRight());
						else
							parent.setRight(temp.getRight());
					}
					if(temp.getLeft()!=null) {
						if(temp.isLessThan(parent))     parent.setLeft(temp.getRight());
						else
							parent.setRight(temp.getLeft());
					}
					
				}
				else {
					
				}


			}
			if(nodeToDelete.isLessThan(temp)) {
				parent=temp;
				temp = temp.getLeft();
			}

			else {
				parent=temp;
				temp = temp.getRight();
			}




		}

	}


	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean isLeaf(BinaryTreeNode node)
	{
		return (node.getLeft() == null && node.getRight() == null) ? true : false;
	}


	/**
	 * 
	 * @param node
	 * @return
	 */
	public boolean oneChild(BinaryTreeNode node)
	{
		return (node.getLeft() != null && node.getRight() != null) ? false : true;
	}


	/**
	 * 
	 * @param node
	 */
	public void preorder(BinaryTreeNode node)
	{
		if(node != null)
		{
			System.out.print(node.toString() + " ");
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}


	/**
	 * 
	 * @param node
	 */
	public void postorder(BinaryTreeNode node)
	{
		if(node != null)
		{
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.print(node.toString() + " ");
		}

	}


	/**
	 * 
	 * @param node
	 */
	public void inorder(BinaryTreeNode node)
	{
		if(node != null)
		{
			inorder(node.getLeft());
			System.out.print (node.toString() + " ");
			inorder(node.getRight());
		}

	}
}