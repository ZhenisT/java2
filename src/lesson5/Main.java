package lesson5;

public class Main {
    public static void main(String[] args) {
        final int size = 10000000;
        final int h = size / 2;

        firstThread(size);
        multiThread(h, size);

    }

    public static void firstThread(int size){
        long a = System.currentTimeMillis();
        fullSizeArr(size);
        System.out.println("Результат: "+(System.currentTimeMillis() - a));
    }

    public static void multiThread(int h, int size){
        long a = System.currentTimeMillis();
        float[] fullSizeArr = floatArray(size);
        halfSizeArr(h , fullSizeArr);
        System.out.println("Результат: "+(System.currentTimeMillis() - a));
    }

    private static void fullSizeArr(int size) {
        float[] fullSizeArr = floatArray(size);
        productMath(size, fullSizeArr);
        System.out.println("Первый просто бежит по массиву и вычисляет значения");
    }

    private static void halfSizeArr(int h, float[] fullSizeArr) {

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(fullSizeArr, 0, arr1, 0, h);
        System.arraycopy(fullSizeArr, h, arr2, 0, h);

        Thread t1 = new Thread(() -> {
            productMath(h, arr1);
        });

        Thread t2 = new Thread(() -> {
            productMath(h, arr2);
        });

        t1.start();
        t2.start();
        System.arraycopy(arr1, 0, fullSizeArr, 0, h);
        System.arraycopy(arr2, 0, fullSizeArr, h, h);

        System.out.println("Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один");
    }

    private static float[] floatArray(int size) {
        float[] fullSizeArr = new float[size];
        for (int i = 0; i < size; i++) {
            fullSizeArr[i] = 1;
        }
        return fullSizeArr;
    }

    private static void productMath(int size, float[] fullSizeArr) {
        for (int i = 0; i < size; i++) {
            fullSizeArr[i] = (float) (fullSizeArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }




}
