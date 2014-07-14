public class WordStatistics
{
	public int occurencies;

	public WordStatistics()
	{
	}

	public void setOccurencies(int occurencies)
	{
		this.occurencies = occurencies;
	}

	public int getOccurencies()
	{
		return occurencies;
	}

	public int incOccurencies()
	{
		occurencies++;
		return occurencies;
	}
}
