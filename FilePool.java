import java.util.Map;
import java.util.LinkedHashMap;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;
import java.nio.file.NotDirectoryException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FilePool
{
	private Map<String, Dictionary> files;

	public FilePool()
	{
		files = new LinkedHashMap<String, Dictionary>();
	}

	public FilePool(String dir)
	{ 
		this();
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir)))
		{
			for (Path entry : stream)
			{ 
				try 
				{
					add(entry);
				}
				catch (FileNotFoundException e)
				{
					System.out.println("File not found!"+e);
				}
			}
		}
		catch (NotDirectoryException e)
		{
			System.out.println("Not a directory!" + e);
		}
		catch (IOException e)
		{
			System.out.println("General IOException occured!" + e);
		}
	}

	public Map<String, Dictionary> getFiles()
	{
		return files;
	}

	public void setFiles(Map files)
	{
	}

	public Dictionary getDictionary(String filename)
	{
		Dictionary d = null;
		if (contains(filename))
		{
			d = (Dictionary)getFiles().get(filename);
		}
		return d;
	}

	public boolean contains(String name)
	{
		return getFiles().containsKey(name);
	}

	public void add(Path path)
		throws FileNotFoundException
	{ 
		File file = path.toFile();
		Dictionary d;
		if (!contains(file.getName()))
		{
			d = new Dictionary(file);
		}
		else
		{
			d = getDictionary(file.getName());
		}
		getFiles().put(file.getName(), d);
	}
}
