/*
 * Copyright (c) 2021, De Cock and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 *     Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *     Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *     Neither the name of De Cock or the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.decocks.sortinginjava;

import java.util.Arrays;

public class SortingInJava {


    public static void main(String[] args) {
        final int[] arrayBegin = new int[]{5, 6, 7, 2, 4, 1, 8,3,9,0};

        int[] array = new int[]{5, 6, 7, 2, 4, 1, 8,3,9,0};
        long startTime = System.nanoTime();
        bubbleSort(array);
        long endTime = System.nanoTime();
        System.out.print(Arrays.toString(arrayBegin)+ "to "+Arrays.toString(array));
        System.out.println(" Bubble Sort runtime: " + (endTime - startTime)+ " nanoseconds");

        for(int j=0; j<array.length; j++) { //back to original array
            array[j] = arrayBegin[j];
        }
        startTime = System.nanoTime();
        insertionSort(array);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(arrayBegin)+ "to "+Arrays.toString(array));
        System.out.println(" insertion Sort runtime: " + (endTime - startTime)+ " nanoseconds");

        for(int j=0; j<array.length; j++) { //back to original array
            array[j] = arrayBegin[j];
        }
        startTime = System.nanoTime();
        selectionSort(array);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(arrayBegin)+ "to "+Arrays.toString(array));
        System.out.println(" selection Sort runtime: " + (endTime - startTime)+ " nanoseconds");

        for(int j=0; j<array.length; j++) { //back to original array
            array[j] = arrayBegin[j];
        }
        startTime = System.nanoTime();
        heapSort(array);
        endTime = System.nanoTime();
        System.out.print(Arrays.toString(arrayBegin)+ "to "+Arrays.toString(array));
        System.out.println(" heap Sort runtime: " + (endTime - startTime)+ " nanoseconds");

    }


    public static void bubbleSort(int[] a) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i+1]) {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            // at this point we've exited, so j is either -1
            // or it's at the first element where current >= a[j]
            array[j+1] = current;
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            int temp = array[i];// swapping
            array[i] = min;
            array[minId] = temp;
        }
    }

    static void heapify(int[] array, int length, int i) {
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        int largest = i;

        // if the left child is larger than parent
        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // if the right child is larger than parent
        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // if a swap needs to occur
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }

    public static void heapSort(int[] array) {
        if (array.length == 0) return;

        // Building the heap
        int length = array.length;
        // we're going from the first non-leaf to the root
        for (int i = length / 2-1; i >= 0; i--)
            heapify(array, length, i);

        for (int i = length-1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }



}
