package algo.otus.algorithm;

public class BitChessOperation {

    private static final int[] bits = new int[256];

    static {
        for (int i = 0; i < 256; i++) {
            bits[i] = bitCnt(i);
        }
    }

    public static long kingsMoveVar(long position) {
        long pos = (long) Math.pow(2, position);
        long lMask = pos & 0xfefefefefefefefel;
        long rMask = pos & 0x7f7f7f7f7f7f7f7fl;
        return lMask << 7 | pos << 8 | rMask << 9 |
                        lMask >> 1 | rMask << 1 |
                lMask >> 9 | pos >> 8 | rMask >> 7;
    }

    public static long horseMoveVar(long position) {
        long pos = (long) Math.pow(2, position);
        long l0Mask = pos & 0xfefefefefefefefel;
        long l1Mask = pos & 0xfcfcfcfcfcfcfcfcl;
        long r1Mask = pos & 0x3f3f3f3f3f3f3f3fl;
        long r0Mask = pos & 0x7f7f7f7f7f7f7f7fl;
        return l1Mask >> 10 | l1Mask << 6 | l0Mask << 15| l0Mask >> 17 | r0Mask << 17 | r0Mask >> 15 | r1Mask << 10 | r1Mask >> 6;
    }

    public static int bitCnt(long mask) {
        int count = 0;
        while (mask > 0) {
            count += (int) (mask & 1);
            mask >>= 1;
        }
        return count;
    }

    public static int bitCntDiff(long mask) {
        int count = 0;
        while (mask > 0) {
            count ++;
            mask &=  mask - 1;
        }
        return count;
    }

    public static int bitCntArray(long mask) {
        int count = 0;
        while (mask > 0) {
            count += bits[(int) (mask & 255)];
            mask >>= 8;
        }
        return count;
    }
}
