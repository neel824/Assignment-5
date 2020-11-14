
public class HolidayBonus 
{
	/**
	 * Calculate the combined 
	 * @param data 2d array
	 * @param high store with the highest bonus categories
	 * @param low store with the lowest bonus categories
	 * @param other stores with bonuses in other categories
	 * 
	 * @return the holiday bonus for each store
	 */ 
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
	{
		int highestIndex = 0;
		int lowestIndex = 0; 
		double [] holidayBonus = new double[data.length];
		int col = data[0].length;
		
		for(int i = 0; i < data.length; i++)
		{
			//finds the length of columns for each highest bonus
			if(col < data[i].length)
			{
				col = data[i].length;
			}
		}
			int j = 0;
			
			for(j = 0; j < col; j++)
			{
				highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
				lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);
				
					 if(highestIndex == lowestIndex)
					{
						holidayBonus[highestIndex] +=  high;
					}
					 else if(!(highestIndex == lowestIndex))
					for(int row = 0; row < holidayBonus.length; row++)
				{
					if(row == highestIndex && data[row][j] > 0)
					{
						holidayBonus[row] = holidayBonus[row] + high;
					}
					else if (row == lowestIndex && data[row][j] > 0)
					{
						holidayBonus[row] = holidayBonus[row] + low;
					}
					else if (data[row].length > j && data[row][j] > 0)
					{
						holidayBonus[row] = holidayBonus[row] + other; 
					}
				}
				
			}
			return holidayBonus;
		}
	
	/**
	 * Calculate the total holiday bonus combined for each store
	 * @param data
	 * @param high
	 * @param low
	 * @param other
	 * @return the total holiday bonus
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
	{	
		double totalBonus = 0;
		
		double [] eachStoresBonus = calculateHolidayBonus(data, high, low, other);
		for(int i = 0; i < eachStoresBonus.length; i++)
		{
			totalBonus = totalBonus + eachStoresBonus[i];
		}
		return totalBonus;
	}
}
