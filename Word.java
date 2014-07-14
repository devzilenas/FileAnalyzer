public class Word
{
	private WordStatistics statistics;
	private String str;

	public Word(String str)
	{
		this(str, 1);
	}

	public Word(String str, int occurencies)
	{
		this.str = str;
		statistics = new WordStatistics();
		getStatistics().setOccurencies(occurencies);
	} 

	public Word(Word word)
	{ 
		this(word.getString());
	}

	public String getString()
	{
		return str;
	}
	
	public int getOccurencies()
	{
		return getStatistics().getOccurencies();
	}

	public WordStatistics getStatistics()
	{
		return statistics;
	}
}
