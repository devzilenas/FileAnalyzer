import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;

public class SimilarityComparator
{
	private double threshold;

	public SimilarityComparator(double threshold)
	{
		this.threshold = threshold;
	}

	public double getThreshold()
	{
		return threshold;
	}

	public boolean isSimilarWith(Dictionary a, Dictionary b)
	{
		return getThreshold() <= similarity(a,b);
	}

	/**
	 * I define similarity as not transitive. So if A is similar to B with 0.5 it is not defined that B is similar to A with 0.5 .
	 */
	public double similarity(Dictionary d1, Dictionary d2)
	{
		Dictionary s = d1.intersectWithOccurencies(d2);
		return (double)s.size() / d1.size();
	}

	public void showSimilar(FilePool fp) 
	{
		for (Map.Entry<String, Dictionary> e1 : fp.getFiles().entrySet())
		{
			String     fn1 = e1.getKey()  ;
			Dictionary d1  = e1.getValue();
			System.out.println("File " + fn1 + " is similar to files:");
			for (Map.Entry<String, Dictionary> e2 : fp.getFiles().entrySet())
			{
				String     fn2 = e2.getKey()  ;
				Dictionary d2  = e2.getValue();
				if (d1 != d2 && isSimilarWith(d1, d2))
				{
					System.out.print(fn2+",");
				}
			}
			System.out.println();
		}
	}
}
