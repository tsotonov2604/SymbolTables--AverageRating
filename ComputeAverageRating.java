package assignment1;
import algs4.*; 
/* 
* <Tsvety Sotonov>
*<Compute Average Rating>
*/

public class ComputeAverageRating 
{

    public static void fillRatings(BinarySearchST<String, Integer> ratingsTable)
    {
        ratingsTable.put("Outstanding", 6);
        ratingsTable.put("Excellent", 5);
        ratingsTable.put("Better", 4);
        ratingsTable.put("Average", 3);
        ratingsTable.put("Worse", 2);
        ratingsTable.put("Awful", 1);
        ratingsTable.put("Avoid", 0);

    }

    public static void main(String[] args) 
    {

        final String FILE_NAME = "a1ratings.txt";

        BinarySearchST<String, Integer> ratingsTable = new BinarySearchST<>();
        fillRatings(ratingsTable);

        StdIn.fromFile("data/" + FILE_NAME);
        String lines[] = StdIn.readAllStrings();

        int ratingSum = 0;
        int count = 0;

        for (String line : lines) 
        {

            String parts[] = line.split("\\s+");
        for (String rating : parts) 
        {
        	if (!rating.isEmpty()) 
        	{  
        		Integer result = ratingsTable.get(rating);
        		if (result != null) 
        		{ 
        			ratingSum += result;
        			count++;
        		}
                
            }
        	
         }

        }

        double averageRating = ratingSum / (double) count;
        System.out.printf("The average rating is %.2f.\n", averageRating);
    }

}