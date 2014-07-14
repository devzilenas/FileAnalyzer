public class Test
{
	public static final double HALF  = 0.5;
	public static final String FILES = "files\\";
	public static void main(String[] args)
	{
		test1();
	}

	public static void test1()
	{
		SimilarityComparator sc = new SimilarityComparator(HALF); 
		FilePool fp = new FilePool(FILES);

		Dictionary apple    = fp.getDictionary("apple.txt");
		Dictionary banana   = fp.getDictionary("banana.txt"); 
		Dictionary kiwilime = fp.getDictionary("kiwilime.txt");
		Dictionary applebanana = fp.getDictionary("applebanana.txt");

		assert 1.0 == sc.similarity(
				fp.getDictionary("sim1.txt"),
				fp.getDictionary("sim2.txt")) : "Equal contents files should be similar";

		assert 1 == sc.similarity(apple, applebanana) : "Apple is similar with 1 similarity to apple,banana";

		assert 0.5 == sc.similarity(applebanana, apple) : "Apple,banana is similar with 0.5 similarity to apple";

		assert !sc.isSimilarWith(apple, banana) : "Apple and banana are not same";

		assert !sc.isSimilarWith(apple, kiwilime) : "Apple and kiwi,lime are not similar";

	}
}
