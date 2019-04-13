package Strings;

import LinearDataStructures.List;
import java.io.*;
import java.util.Arrays;

/*
# Strings based on Character Lists.
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
 * This class represents the behavior of Strings based on Character Lists
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class StringAsList {

	private List string = new List();

	/**
	 * 
	 */
	public StringAsList()
	{
		string = new List();
	}

	/**
	 * 
	 * @param string_
	 */
	public StringAsList(char[] string_)
	{
		string = new List();

		for(int i = 0; i < string_.length; i++)
			string.insertAtEnd(new StringNode( string_[i] ));
	}


	/**
	 * 
	 * @param newString
	 */
	public void concatenate(StringAsList newString)
	{
		string.insertAtEnd( newString.string.head );
	}


	/**
	 * 
	 * @param regex
	 * @return
	 */
	public StringAsList substring(int beginIndex)
	{
		StringAsList subString = new StringAsList();
		subString.string = this.string.sublist(beginIndex);
		return subString;
	}
	
	
	public StringAsList[] split(StringAsList regex)
	{
		StringNode temp1= (StringNode)string.head;
		StringNode temp2= (StringNode)regex.string.head;
		int cuenta=0;
		int cuenta1=0;
		while(temp1!=null) {
			if(temp1.isEqual(temp2))
			{
				cuenta++;
				if(cuenta==regex.length())
				{ 
					
					
					cuenta1++;
					cuenta=0;
					temp2= (StringNode)regex.string.head;
					temp1=(StringNode) temp1.getNext();

				}
				else 
				{
					temp1=(StringNode)temp1.getNext();
					temp2=(StringNode)temp2.getNext();
				}
			}

			else
				temp1=(StringNode)temp1.getNext();
		}
		
		temp1= (StringNode)string.head;
		temp2= (StringNode)regex.string.head;
		int[]subS=new int[2+(cuenta1*2)];
		subS[subS.length-1]=string.length()-1;
		int index=1;
		while(temp1!=null) {
			
			if(temp1.isEqual(temp2))
			{
				cuenta++;
				if(cuenta==regex.length())
				{ 
					subS[index]=string.indexOf(temp1)-(regex.length()-1);
					subS[index+1]=string.indexOf(temp1)+1;
					index++;
					
					cuenta=0;
					temp2= (StringNode)regex.string.head;
					temp1=(StringNode) temp1.getNext();

				}
				else 
				{
					temp1=(StringNode)temp1.getNext();
					temp2=(StringNode)temp2.getNext();
				}
			}

			else
				temp1=(StringNode)temp1.getNext();
		}
		
		
		StringAsList[] response = new StringAsList[cuenta1+1];
		int a=0;
		int b=1;
		for (int i = 0; i < response.length; i++) {
			StringAsList fill= substring(subS[a],subS[b]);
			a+=2;
			b+=2;
			response[i]=fill;
		}
		System.out.println(Arrays.toString(subS));
		return response; 
	}


	/**
	 * 
	 * @param regex
	 * @return
	 */
	public boolean contains(StringAsList regex)
	{
		StringNode temp1= (StringNode)string.head;
		StringNode temp2= (StringNode)regex.string.head;
		int cuenta=0;
		boolean res= false;
		;
		while(temp1!=null) {
			if(temp1.isEqual(temp2))
			{
				cuenta++;
				if(cuenta==regex.length())
				{ 
					res=true;
					
					
					cuenta=0;
					temp2= (StringNode)regex.string.head;
					temp1=(StringNode) temp1.getNext();

				}
				else 
				{
					temp1=(StringNode)temp1.getNext();
					temp2=(StringNode)temp2.getNext();
				}
			}

			else
				temp1=(StringNode)temp1.getNext();
		}
		return res;
	}


	/**
	 * 
	 * @param beginIndex
	 * @return
	 */


	/**
	 * 
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public StringAsList substring(int beginIndex, int endIndex)
	{
		StringAsList subString = new StringAsList();
		subString.string = this.string.sublist(beginIndex, endIndex);
		return subString;
	}


	/**
	 * 
	 * @param regex
	 * @return
	 */
	public int indexOf(StringAsList regex)
	{
		StringNode temp1= (StringNode)string.head;
		StringNode temp2= (StringNode)regex.string.head;
		int cuenta=0;
		int res=0;
		while(temp1!=null) {
			if(temp1.isEqual(temp2))
			{
				cuenta++;
				if(cuenta==regex.length())
				{ 
					res=string.indexOf(temp1)-(regex.length()-1);
					
					
					cuenta=0;
					temp2= (StringNode)regex.string.head;
					temp1=(StringNode) temp1.getNext();

				}
				else 
				{
					temp1=(StringNode)temp1.getNext();
					temp2=(StringNode)temp2.getNext();
				}
			}

			else
				temp1=(StringNode)temp1.getNext();
		}
		return res;
	}


	/**
	 * 
	 * @param string_
	 * @return
	 */
	public boolean equals(StringAsList string_)
	{
		return this.string.equals( string_.string );
	}


	/**
	 * 
	 * @return
	 */
	public int length()
	{
		return this.string.length();
	}


	/**
	 * 
	 * @return
	 */
	public StringAsList reverse()
	{
		StringAsList reverse = new StringAsList();
		reverse.string = this.string.cloneList();
		reverse.string.reverse();

		return reverse;
	}


	/**
	 * 
	 * @return
	 */
	public boolean isPalindrome()
	{
		StringAsList temp= this.reverse();
		return string.isEqual(temp.string);
	}


	/**
	 * 
	 * @param anagramCandidate
	 * @return
	 */
	public boolean isAnagram(StringAsList anagramCandidate)
	{
		return false;
	}


	public void print()
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringNode temp = (StringNode)string.head;

		try 
		{
			while(temp != null)
			{
				bw.write(temp.character);
				temp = (StringNode)temp.getNext();
			}
			bw.flush();
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}
}