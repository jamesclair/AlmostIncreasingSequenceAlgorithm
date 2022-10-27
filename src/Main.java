public class Main {
    public static boolean main(int[] sequence) {
        AlmostIncreasingSequenceValidator validator = new AlmostIncreasingSequenceValidator();
        return validator.validateAlmostIncreasingSequence(sequence);
    }
}