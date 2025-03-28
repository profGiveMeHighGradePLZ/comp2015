public class HeapSort {
    public static <V extends Comparable<V>> void asc(V[] data){
        V min = data[0];
        int index = 0;
        for(int i = 1;i< data.length;i++){
            if(min.compareTo(data[i])>0){
                index = i;
                min = data[i];
            }
        }
        swap(data,index,0);

        int lastNonLeafNodeIndex = data.length/2;
        for(int i = lastNonLeafNodeIndex;i>0;i--){
            percolatingdown(data,i, data.length-1);
        }

        int i = data.length-1;
        while(i>0){
            V max = data[1];
            data[1] = data[i];
            i--;
            percolatingdown(data,1,i);
            data[i+1] = max;
        }
    }



    public static <V extends Comparable<V>> void percolatingdown(V[] data, int c, int lastIdx){
        int l = c*2;
        int r = l+1;
        while(l <= lastIdx){
            if(r > lastIdx ||data[l].compareTo(data[r]) > 0){
                if( data[l].compareTo(data[c])>0){
                    swap(data,l,c);
                    c = l;
                }else {
                    break;
                }
            }else{
                if(data[r].compareTo(data[c])>0){
                    swap(data,r,c);
                    c = r;
                }else{
                    break;
                }
            }
            l = c*2;
            r = l+1;
        }
    }

    public static <V extends Comparable<V>> void swap(V[] data,int a,int b){
        V tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }


    public static void main(String[] args) {
        Integer[] data = {8,5,9,4,6,3,2};
        HeapSort.asc(data);
        for(Integer integer:data){
            System.out.println(integer);
        }
    }
}
