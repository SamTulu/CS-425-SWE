import service.IArrayFlattenerService;

import java.util.ArrayList;
import java.util.List;

public class ArrayReversor {
    private IArrayFlattenerService arrayFlattenerService;

    //    public static void main(String[] args) {
//        ArrayReversor arrayReversor = new ArrayReversor();
//                List<List<Integer>> arr2 =
//                Arrays.asList(new ArrayList<>(Arrays.asList(1,24,4)),
//                        new ArrayList<>(Arrays.asList(4,1,6)),
//                        new ArrayList<>(Arrays.asList(43,1,6,2,1)));
//        System.out.println(arrayReversor.reverseArray(arr2));
//    }
    public ArrayReversor(IArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public List<Integer> reverseArray(List<List<Integer>> arr) {

        if (arr == null) return null;
        return this.arrayFlattenerService.flattenArray(arr)
                .stream()
                .collect(ArrayList::new,
                        (list, e) -> list.add(0, e),
                        (list1, list2) -> list1.addAll(0, list2));
    }
}
