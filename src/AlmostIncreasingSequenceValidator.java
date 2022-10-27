public class AlmostIncreasingSequenceValidator {
    private int findFirstBadPair(int[] sequence) {
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] >= sequence[i + 1])
                return i;
        }
        return -1;
    }

    boolean validateAlmostIncreasingSequence (int[] sequence) {
        int indexOfBadPair = findFirstBadPair(sequence);
        if (indexOfBadPair == -1)
            return true;
        int[] sequenceWithFormerIndexRemoved = sequenceWithFormerIndexRemoved(sequence, indexOfBadPair);
        if (findFirstBadPair(sequenceWithFormerIndexRemoved) == -1)
            return true;
        int[] sequenceWithLaterIndexRemoved = sequenceWithLaterIndexRemoved(sequence, indexOfBadPair);
        if (findFirstBadPair(sequenceWithLaterIndexRemoved) == -1)
            return true;
        return false;
    }

    private int[] sequenceWithFormerIndexRemoved(int[] sequence, int indexOfBadPair) {
        if (indexOfBadPair == 0)
            return concatSequenceSlices(
                    getSequenceSlice(sequence, indexOfBadPair, indexOfBadPair),
                    getSequenceSlice(sequence, indexOfBadPair + 1, sequence.length)
            );
        return concatSequenceSlices(
                getSequenceSlice(sequence, indexOfBadPair - 1, indexOfBadPair),
                getSequenceSlice(sequence, indexOfBadPair + 1, sequence.length)
        );
    }

    private int[] sequenceWithLaterIndexRemoved(int[] sequence, int indexOfBadPair) {
        return concatSequenceSlices(
                getSequenceSlice(sequence, indexOfBadPair, indexOfBadPair + 1),
                getSequenceSlice(sequence, indexOfBadPair + 2, sequence.length)
        );
    }

    private int[] getSequenceSlice(int[] sequence, int startIndex, int endIndex) {
        int[] slice = Arrays.copyOfRange(sequence, startIndex, endIndex);
        return slice;
    }

    private int[] concatSequenceSlices(int[] array1, int[] array2) {
        return IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray();
    }
}
