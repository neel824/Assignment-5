import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public final class TwoDimRaggedArrayUtility
extends java.lang.Object
{
	TwoDimRaggedArrayUtility()
	{}
	/**
	 *  Reads from a file and returns a ragged array of doubles
	 * @param file file to read from
	 * @return array of doubles, null if empty
	 * @throws java.io.FileNotFoundException
	 */
	public static double[][] readFile(java.io.File file) throws java.io.FileNotFoundException
	{
	/*
	 * Reads from a file and returns a ragged array of doubles
 	   The maximum rows is 10 and the maximum columns for each row is 10
       Each row in the file is separated by a new line Each element in the row is separated by a space Suggestion: You need to know how many rows and how many columns there are for each row to create a ragged array. 
       1. Read the doubles from the file into a temporary array [10][10] of Strings which was initialized to nulls. 
       2. Find out how many rows there are (any row that has the first element != null is a valid row) 
       3. Create the array based on the num of rows, i.e. double[][]array = new double[#rows][]
       4. Determine the number of columns for the first row (any element != null is a valid element) 
       5. Create the first row, i.e. array[0] = new double[#columns] 
       6. Put the values from the temporary array into in the row (don't forget to convert from strings to doubles)
       7. Repeat for all rows
	 */
		int row;
		int col;
		//Both arrays to go and from string and double vice versa
		String[][] temporary = null;
		double [][] actualValues = null;
		//So it can actually READ the file 
		Scanner finder = new Scanner(file);
		Scanner eachLine;
		int max = 10;
		//Reads the doubles from the files
		if(finder.hasNextLine())
		{
			//satisfies #1
			temporary = new String[10][10];
			for(row = 0; row < max; row++)
			{
				for(col = 0; col < max; col++)
				{
					temporary[row][col] = null;
				}
			}
			row = 0;
			while(finder.hasNextLine())
			{
				eachLine = new Scanner(finder.nextLine());
				col = 0;
				while(eachLine.hasNextDouble())
				{
					temporary[row][col++] = Double.toString(eachLine.nextDouble());
				}
				row++;
			}
			row = 0;
			//Determines the number of columns 
			while(!(temporary[row][0] == null))
			{
				row++;
				actualValues = new double [row][];
				for(row = 0; row < actualValues.length; row++)
				{
					col = 0;
					while(!(temporary[row][col] == null))
					{
						col++;
						//array created based on rows
						actualValues[row] = new double[col];
						for(int i = 0; i < actualValues[row].length; i++)
						{
							//Reads each double and converts it to a string
							//Repeats for all rows
							actualValues[row][i] = Double.parseDouble(temporary[row][i]);
						}
					}
				}
			}
		}
		finder.close();
		return actualValues;
	   }
	/**
	 * Writes the array into the file
	 * @param data 2d array used to store and hold values 
	 * @param outputFile file to write to
	 * @throws java.io.FileNotFoundException
	 */
	public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException
	{
		int row;
		int col;
		PrintWriter writerFile = new PrintWriter(outputFile);
		for(row = 0; row < data.length; row++)
		{
			for( col = 0; col < data[row].length - 1; col++)
			{
				writerFile.print(data[row][col] + " ");	
			}	
			writerFile.println(data[row][col]);
		}
		writerFile.close();
	}
	/**
	 * Gets the Total of elements in array
	 * @param data 2d array used to hold memory
	 * @return total/sum of all the entire 2d array
	 */
	public static double getTotal(double[][] data)
	{
		double total = 0;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				total = total + data[row][col];
			}
		}
		return total;
	}
	/**
	 *  Gets the Average of elements in array
	 * @param data 2d array used to hold memory
	 * @return average of the array 
	 */
	public static double getAverage(double[][] data)
	{
		int num = 0;
		double sum = 0;
		
		for(int row  = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				sum = sum + data[row][col];
				num++;
			}
		}
		double average = sum / num;
		return average;
	}
	/**
	 *  Gets the Total of rows in array
	 * @param data 2d array used to hold memory
	 * @param row the row index 
	 * @return sum of all rows
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		double sum = 0;
		for(int col = 0; col < data[row].length; col++)
		{
			sum = sum + data[row][col];
		}
		return sum;
	}
	/**
	 * Gets the Total of columns in array
	 * @param data 2d array used to hold memory
	 * @param col the column index
	 * @return sum of all columns 
	 */
	public static double getColumnTotal(double[][] data, int col)
	{
		double sum = 0;
		for(int row = 0; row < data.length; row++)
		{
			if(data[row].length - 1 >= col)
			{
			sum = sum + data[row][col];
			}
		}
		return sum;
	}
	/**
	 * Gets the Highest value in rows
	 * @param data
	 * @param row
	 * @return the highest value in all of the rows
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		double highest = 0;
		for(int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] > highest)
			{
				 highest = data[row][i];
			}
		}
		return highest;
	}
	/**
	 * Gets the Highest index value in rows
	 * @param data 2d array used to hold memory
	 * @param row the row index
	 * @return the highest index value
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		int highestIndex = 0;
		for(int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] > data[row][highestIndex])
			{
				 highestIndex = i;
			}
		}
		return highestIndex;
	}
	/**
	 * Gets the Lowest value in the rows
	 * @param data 2d array used to hold memory
	 * @param row the column index
	 * @return the lowest value in the rows
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		double lowest = data[row][0];
		
		for(int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] < lowest)
			{
				 lowest = data[row][i];
			}
		}
		return lowest;
	}
	/**
	 *  Gets the Lowest index value in rows
	 * @param data 2d array used to hold memory
	 * @param row the row index
	 * @return the lowest index value in the rows
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		int lowestIndex = 0;
		
		for(int i = 0; i < data[row].length; i++)
		{
			if(data[row][i] < data[row][lowestIndex])
			{
				 lowestIndex = i;
			}
		}
		return lowestIndex;
	}
	/**
	 * Gets the Highest value in columns
	 * @param data 2d array used to hold memory
	 * @param col the column index
	 * @return the highest element in the columns of the array
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		double highest = 0;
		for(int row = 0; row < data.length; row++)
		{
			if(col <= data[row].length - 1 && data[row][col] > highest)
			{
				highest = data[row][col];
			}
		}
		return highest;
	}
	/**
	 *  Gets the Highest index value in columns
	 * @param data 2d array used to hold memory
	 * @param col the column index
	 * @return the index of the highest element
	 */
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		double value = -248000;
		int index = 0;
		for(int row = 0; row < data.length; row++)
		{
			for(int column = 0; column < data[row].length; column++)
			{
				if(column == col && data[row][col] > value)
				{
					//data[index] is saved as this row so it can be "noted" that this is where the highest index int the column is allocated
					index = row;
					value = data[row][col];
				}
			}
		}
		return index;
	}
	/** Gets the lowest value in the columns
	 *  Gets the Lowest value in column
	 * @param data 2d array used to hold memory
	 * @param col the column index
	 * @return lowest element in the column
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowest = data[0][col];
		for(int row = 0; row < data.length; row++)
		{
			if(col <= data[row].length - 1 && data[row][col] < lowest)
			{
				lowest = data[row][col];
			}
		}
		return lowest;
	}
	/**
	 * Gets the lowest column index value
	 * @param data 2d array used to hold memory
	 * @param col the column index
	 * @return the lowest index element
	 */
	public static int getLowestInColumnIndex(double[][] data,  int col)
	{
		double value = 248000;
		int index = 0;
		for(int row = 0; row < data.length; row++)
		{
			for(int column = 0; column < data[row].length; column++)
			{
				if(column == col && data[row][col] < value)
				{
					//data[index] is saved as this row so it can be "noted" that this is where the lowest index column is allocated as an int 
					index = row;
					value = data[row][col];
				}
			}
		}
		return index;
	}
	/**
	 * Gets the highest value in the array
	 * @param data 2d array used to hold memory
	 * @return highest element in the array
	 */
	public static double getHighestInArray(double[][] data)
	{
		int row = 0;
		int col = 0;
		double highest = 0;
		for(row = 0; row < data.length; row++)
		{
			for(col = 0; col < data[row].length; col++)
			{
				if(data[row][col] > highest)
				{
					highest = data[row][col];
				}
			}
		}
		return highest;
	}
	/**
	 * Gets the lowest value in the array
	 * @param data 2d array used to hold memory
	 * @return lowest element in the array
	 */
	public static double getLowestInArray(double[][] data)
	{
		int row = 0;
		int col = 0;
		double lowest = data[0][0];
		for(row = 0; row < data.length; row++)
		{
			for(col = 0; col < data[row].length; col++)
			{
				if(data[row][col] < lowest)
				{
					lowest = data[row][col];
				}	
			}
		}
		return lowest;
	}

}
