import java.util.*;

public class EnoughIsEnough {


    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        int index = 0;
        int occurrences = 0;
        List<Integer> element = new ArrayList<>();
        List<Integer> occurrence = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.println(maxOccurrences);
        System.out.println(maxOccurrences);
        System.out.println(maxOccurrences);
        System.out.println(maxOccurrences);
        System.out.println(maxOccurrences);

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




        List<Integer> result = new ArrayList<>();

        if (elements.length > 0) {
            if (maxOccur < maxOccurrences) {
                for (int i = 0; i < element.size(); i++) {
                    result.add(element.get(i));
                }
            } else if (count > 0) {
                if (maxOccurrences == 0) {
                    element.clear();
                } else {
                    int first = 0;
                    boolean isDeleted = false;
                    while (count > 0) {
                        int elem = element.get(first);
                        int delete = occurrence.get(first) - maxOccurrences;
                        int ind = element.size() - 1;
                        while (ind > 0) {
                            if (element.get(ind) == elem) {
                                while (delete > 0) {
                                    element.remove(ind);
                                    occurrence.remove(ind);
                                    isDeleted = true;
                                    delete--;
                                    break;
                                }
                            }
                            ind--;
                        }
                        if (isDeleted) {
                            first++;
                            count--;
                        } else {
                            first++;
                        }
                    }
                }
            }
        }


        int[] res = new int[element.size()];
        if (maxOccur > maxOccurrences || maxOccurrences == maxOccur) {
            for (int i = 0; i < element.size(); i++) {
                result.add(element.get(i));
            }



            if (elements.length > 0) {
                for (int i = 0; i < result.size(); i++) {
                    res[i] = result.get(i);
                }
            }
        }else if (maxOccur < maxOccurrences){
            res = elements;
        }

        System.out.println(Arrays.toString(res) + "res");

        return res;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{ 0, 3, 6, 6, 2, 3, 5, 6};
        deleteNth(arr,   0);
    }
}