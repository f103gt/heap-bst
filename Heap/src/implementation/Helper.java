package implementation;

import interfaces.Help;

public class Helper implements Help {
    int[] array;

    public Helper(int[] array) {
        this.array = array;
    }

    @Override
    public void swap(int i, int j) {
        int temp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = temp;
    }

    @Override
    public int[] resize() {
        int[] temp = new int[this.array.length * 2];
        System.arraycopy(this.array, 0, temp, 0, this.array.length);
        this.array = temp;
        return this.array;
    }
}
