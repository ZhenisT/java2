package lesson5;

public class Main {
    public static void main(String[] args) {
        final int size = 1000000;
        final int h = size / 2;

        fullSizeArr(size);
        halfSizeArr(h, size);

    }

    public static void fullSizeArr(int size) {
        long a = System.currentTimeMillis();
        float[] fullSizeArr = new float[size];
        for (int i = 0; i < size; i++) {
            fullSizeArr[i] = 1;
        }
        for (int i = 0; i < size; i++) {
            fullSizeArr[i] = (float) (fullSizeArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Первый просто бежит по массиву и вычисляет значения");
        System.out.println("Результат: "+(System.currentTimeMillis() - a));
    }


    public static void halfSizeArr(int h, int size) {
        long a = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        float[] fullSizeArr = new float[size];
        for (int i = 0; i < size; i++) {
            fullSizeArr[i] = 1;
        }

        System.arraycopy(fullSizeArr, 0, arr1, 0, h);
        System.arraycopy(fullSizeArr, h, arr2, 0, h);


        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();
        System.arraycopy(arr1, 0, fullSizeArr, 0, h);
        System.arraycopy(arr2, 0, fullSizeArr, h, h);

        System.out.println("Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один");
        System.out.println("Результат: "+(System.currentTimeMillis() - a));
    }

}
