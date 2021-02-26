package task2101_bitwise_operations;

/*
Determine the network address

The task is pretty simple, but this way of formatting a String (line 30) is really convenient and worth saving.
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[4];
        for (int i = 0; i < result.length; i++)
            result[i] = (byte) (ip[i] & mask[i]);

        return result;
    }

    public static void print(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte number : bytes)
            result.append(String.format("%8s", Integer.toBinaryString(number & 0xFF)).replace(' ', '0')).append(" ");

        System.out.println(result.toString().trim());
    }
}
