/**
 * This program groups similar files. Two files are similar if they share same words.
 */
import java.util.Scanner;
import java.nio.file.*;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileAnalyzer
{
	public static void main(String[] args)
	{
		System.out.println("Compares files in a directory compare\\ ");
		Scanner in = new Scanner(System.in);
		System.out.println("Please provide a threshold for similarity ([0..1]): <waiting for your input>"); 
		SimilarityComparator sc = new SimilarityComparator(in.nextDouble());
		System.out.println("Please provide a directory path: <waiting for your input>");
		String dir = in.next();
		FilePool fp = new FilePool(dir);
		sc.showSimilar(fp); 
	}
}
