public class HashMap<K,V> {
    K[] keys = (K[]) new Object[10];
    V[] values = (V[]) new Object[10];
    int count = 0;
    int prime = 7;
    K deleted = (K) new Object();

    public void set(K k,V v){

        int index = getIndexOf(k);
        if(index >= 0){
            values[index] = v;
            return;
        }

        int collision = 0;
        do{
            index = getIndex(k,collision);
            collision++;
        }while(keys[index] != null && keys[index] != deleted);
        keys[index] = k;
        values[index] = v;
        count++;
    }
    private int getIndex(K k,int c){
        int code = Math.abs(k.hashCode());
        return (code + hash2(code)*c)%keys.length;
    }
    private int hash2(int code){
        return prime-code%prime;
    }

    public V search(K k){
        int index;
        int collisions = 0;
        do{
            index = getIndex(k,collisions);
            collisions++;
        }while (keys[index] != null && keys[index] != k);
        if(keys[index] == null){
            return null;
        }else{
            return values[index];
        }
    }
    public int getIndexOf(K k){
        int index;
        int collisions = 0;
        do{
            index = getIndex(k,collisions);
            collisions++;
        }while(keys[index]!=null && keys[index] != k);
        if(keys[index] == null){
            return -1;
        }else{
            return index;
        }
    }
    public void del(K k){
        int index = getIndexOf(k);
        if(index < 0){
            return;
        }
        keys[index] = deleted;
        values[index] = null;
        count--;
    }
}
