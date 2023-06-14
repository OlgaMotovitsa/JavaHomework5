
package task;

import java.util.*;
public class Phonebook2 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of entries in the phonebook:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter name ");
            String name = scanner.next();
            System.out.println("Enter phone number:");
            String phone = scanner.next();
            List<String> phones = phoneBook.get(name);
            if (phones == null) {
                phones = new ArrayList<>();
                phones.add(phone);
                phoneBook.put(name, phones);
            } else {
                phones.add(phone);
            }
        }

        List<Map.Entry<String, List<String>>> list = new ArrayList<>(phoneBook.entrySet());
        list.sort(new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });

        System.out.println("Phone book:");
        for (Map.Entry<String, List<String>> entry : list) {
            String name = entry.getKey();
            List<String> phones = entry.getValue();
            System.out.println(name + ": " + phones);
        }
    }
}