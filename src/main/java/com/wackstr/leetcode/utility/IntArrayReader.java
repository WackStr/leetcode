package com.wackstr.leetcode.utility;

import java.io.*;
import java.util.Arrays;

public class IntArrayReader {
    public static int[] readIntsFromResource(String resourceName) throws IOException {
        try (InputStream in = IntArrayReader.class.getClassLoader()
                .getResourceAsStream(resourceName)) {

            if (in == null) {
                throw new IOException("Resource not found: " + resourceName);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                var builder = new IntArrayBuilder();

                reader.lines()
                        .map(String::trim)
                        .filter(line -> !line.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .forEach(builder::add);

                return builder.toArray();
            }
        }
    }

    public static void main(String[] args) {
        try {
            int[] numbers = readIntsFromResource("numbers.txt");
            System.out.println(Arrays.toString(numbers));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static final class IntArrayBuilder {
        private int[] data = new int[1024];
        private int size = 0;

        void add(int value) {
            if (size == data.length) {
                data = Arrays.copyOf(data, data.length * 2);
            }
            data[size++] = value;
        }

        int[] toArray() {
            return Arrays.copyOf(data, size);
        }
    }
}
