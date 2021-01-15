package Homework.OpsOnLists;

public class OpsOnLists {
    public static IntDoubleList reuniteLists(IntDoubleList[] arrayOfLists) {
	    IntDoubleList res = new IntDoubleList();
	    int sizeSum = 0;
	    for (int i=0; i<arrayOfLists.length; i++){
	        sizeSum += arrayOfLists[i].size();
        }
	    int index = 0;
	    int [] elems = new int[sizeSum];
        for (int i=0; i<arrayOfLists.length; i++){
            IntDoubleList curr = arrayOfLists[i];
            int size = curr.size();
            for (int j=0; j<size; j++){
                elems[index] = curr.get(j);
                index++;
            }
        }
        sortArr(elems);
        for (int i=0; i<elems.length; i++){
            res.append(elems[i]);
        }
        return res;
    }

    private static void sortArr(int[] arr) {
        for (int i=0; i<arr.length; i++){
            int index = i;
            int min = arr[i];
            for (int j=i; j<arr.length; j++){
                if (arr[j] < min){
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }
    }

    public static IntDoubleList partTheList(IntDoubleList list, int value) {
        int [] elems = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            elems[i] = list.get(i);
        }
        for (int i=1; i<elems.length; i++){
            if (elems[i] < value) {
                for (int j = i - 1; j > 0; j--) {
                    if (elems[j] > value){
                        int temp = elems[j];
                        elems[j] = elems[j + 1];
                        elems[j + 1] = temp;
                    }else{
                        break;
                    }
                }
            }
        }
        IntDoubleList res = new IntDoubleList();
        for (int i=0; i<elems.length; i++){
            res.append(elems[i]);
        }
        return res;
    }

    public static IntDoubleList mixedList(IntDoubleList list) {
        int size = list.size() / 2, index = 0;
        IntDoubleListElement head = list.getFirstElement();
        IntDoubleListElement tail = list.getLastElement();
        while (index < size){
            if (index % 2 == 1){
                IntDoubleListElement h1 = head;
                head.prev.next = tail;
                head.next.prev = tail;
                tail.prev.next = h1;
                tail.next.prev = h1;
            }
            head = head.next;
            tail = tail.prev;
            index++;
        }
        return list;
    }
}
