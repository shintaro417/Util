public static  void Sort2DArrayBasedOnColumnNumber (long[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<long[]>() {
            @Override
            public int compare(long[] first, long[] second) {
               if(first[columnNumber-1] > second[columnNumber-1]) return 1;
               else if(first[columnNumber - 1] == second[columnNumber - 1]) return 0;
               else return -1;
            }
        });
    }
