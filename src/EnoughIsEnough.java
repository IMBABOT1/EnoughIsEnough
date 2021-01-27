import java.util.*;

public class EnoughIsEnough {


    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        int index = 0;
        int occurrences = 0;
        List<Integer> element = new ArrayList<>();
        List<Integer> occurrence = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();


        System.out.println(Arrays.toString(elements) + "arr");

        for (int i = 0; i < elements.length; i++) {
            if (!map.containsKey(elements[i])) {
                map.put(elements[i], 1);
            } else if (map.containsKey(elements[i])) {
                map.put(elements[i], map.get(elements[i]) + 1);
            }
        }


        int count = 0;
        int value = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > maxOccurrences) {
                count++;
                value = m.getValue();
            }
        }


        while (index < elements.length) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[index] == elements[i]) {
                    occurrences++;
                }
            }
            element.add(elements[index]);
            occurrence.add(index, occurrences);
            index++;
            occurrences = 0;
        }
        int maxOccur = 0;
        if (elements.length > 0) {
            maxOccur = occurrence.get(0);
            for (int i = 0; i < occurrence.size(); i++) {
                if (maxOccur < occurrence.get(i)) {
                    maxOccur = occurrence.get(i);
                }
            }
        }


        HashSet<Integer> set = new HashSet<>();
        int temp = -1;
        while (temp < element.size() - 1) {
            temp++;
            if (occurrence.get(temp) > maxOccurrences) {
                set.add(element.get(temp));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : set){
           list.add(i);
        }

        for (int i = 0; i <list.size() ; i++) {
            for (int j = 0; j <list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int tem = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tem);
                }

            }
        }

        System.out.println(list);
//
//        List<Integer> result = new ArrayList<>();
//
//        if (elements.length > 0) {
//            if (maxOccur < maxOccurrences) {
//                for (int i = 0; i < element.size(); i++) {
//                    result.add(element.get(i));
//                }
//            } else if (count > 0) {
//                if (maxOccurrences == 0) {
//                    element.clear();
//                } else {
//                    int first = 0;
//                    boolean isDeleted = false;
//                    while (count > 0) {
//                        int elem = list.get(first);
//                        int delete = occurrence.get(set.first()) - maxOccurrences;
//                        int ind = element.size() - 1;
//                        while (ind > 0) {
//                            if (element.get(ind) == elem) {
//                                while (delete > 0) {
//                                    element.remove(ind);
//                                    occurrence.remove(ind);
//                                    isDeleted = true;
//                                    delete--;
//                                    break;
//                                }
//                            }
//                            ind--;
//                        }
//                        if (isDeleted) {
//                            first++;
//                            count--;
//                        } else {
//                            first++;
//                        }
//                    }
//                }
//            }
//        }
//
//
//        int[] res = new int[element.size()];
//        if (maxOccur > maxOccurrences || maxOccurrences == maxOccur) {
//            for (int i = 0; i < element.size(); i++) {
//                result.add(element.get(i));
//            }
//
//
//
//            if (elements.length > 0) {
//                for (int i = 0; i < result.size(); i++) {
//                    res[i] = result.get(i);
//                }
//            }
//        }else if (maxOccur < maxOccurrences){
//            res = elements;
//        }
//
//        System.out.println(Arrays.toString(res) + "res");
//
//        return res;

    return new int[]{};
    }




        public static void main(String[] args) {
        int[] arr = new int[]{ 1, 19, 15, 14, 17, 16, 16, 14, 23, 13, 16, 1, 1, 9, 22, 17, 21, 11, 18, 1, 17, 12, 13, 14};
        deleteNth(arr,   2);
    }
}
