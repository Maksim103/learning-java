package Tasks;

public class AsciiCharSequence implements CharSequence {
    private final byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(bytes.length);

        for (byte item: bytes) {
            result.append((char) item);
        }

        return result.toString();
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] bytesArray = new byte[end-start];

        int k = 0;
        for (int i = start; i < end; i++) {
            bytesArray[k] = bytes[i];
            k++;
        }

        return new AsciiCharSequence(bytesArray);
    }
}
