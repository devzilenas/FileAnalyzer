import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.File;
import java.util.Collection;
import java.io.FileNotFoundException;

public class Dictionary
{
	private Map<String, Word> words;

	public Dictionary()
	{
		words = new LinkedHashMap<String, Word>();
	}

	public Dictionary(File source)
		throws FileNotFoundException
	{
		this();
		Scanner sc = new Scanner(source);
		String  s;
		Word    w;
		while (sc.hasNext())
		{
			s = sc.next();
			if (!contains(s))
			{
				add(s);
			}
			else
			{
				w = get(s);
				w.getStatistics().incOccurencies();
			}
		}
	}

	public Map<String, Word> getWords()
	{
		return words;
	}

	public void add(String s)
	{
		Word w = new Word(s); 
		getWords().put(s, w);
	}

	public Word get(Word word)
	{
		return get(word.getString());
	}

	public Word get(String str)
	{
		return getWords().get(str);
	}

	public boolean contains(String string)
	{
		return getWords().containsKey(string);
	}

	public boolean contains(Word word)
	{
		return contains(word.getString());
	}
	
	public Collection<Word> words()
	{
		return getWords().values();
	}

	public int diff(Dictionary b)
	{
		int diff = 0;
		for (Word w : b.words())
		{
			if (!contains(w))
			{
				diff++;
			}
		}
		return diff;
	}

	public Dictionary intersectWithOccurencies(Dictionary a)
	{
		Dictionary d = new Dictionary();
		for (Word w : a.words())
		{
			if (contains(w) && w.getOccurencies() == get(w).getOccurencies())
			{
				d.add(w.getString());
			}
		}
		return d;
	}
	
	public int size()
	{
		return getWords().size();
	}
}

