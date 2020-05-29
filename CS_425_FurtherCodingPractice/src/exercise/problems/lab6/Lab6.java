package exercise.problems.lab6;

public class Lab6 {

	public static void printHelloworld(int[] arr) {

		for (int number : arr) {
			if (number % 5 == 0 && number % 7 == 0) {
				System.out.println("Hello World!");
			} else if (number % 5 == 0) {
				System.out.println("Hello");
			} else if (number % 7 == 0) {
				System.out.println("World!");
			}

		}
	}

	public static int findSecondBiggestNumber(int[] arr) {

		int firstBiggestNumber = 0;

		int secondBiggestNumber = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				if (arr[i] > firstBiggestNumber) {
					secondBiggestNumber = firstBiggestNumber;
					firstBiggestNumber = arr[i];
				} } else {
					if (arr[i + 1] > firstBiggestNumber) {
						secondBiggestNumber = firstBiggestNumber;
						firstBiggestNumber = arr[i + 1];
					}
				}
			}
		
		return secondBiggestNumber;
	}
	

	public static void main(String[] args) {
		int[] numbers = { 1, 7, 10, 13, 15, 21, 35 };

		printHelloworld(numbers);
		
		System.out.println();
		System.out.println("############################################################################");
		
		System.out.println();
		System.out.println(findSecondBiggestNumber(numbers));
		
		
	}

}
