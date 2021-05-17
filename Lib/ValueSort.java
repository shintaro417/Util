import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Map<String, Integer> map = new HashMap<String, Integer>();

		for(int i = 0;i < n;i++) {
			String key = sc.next();
			int value = sc.nextInt();
			map.put(key, value);
		}

		List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());

		// 6. 比較関数Comparatorを使用してMap.Entryの値を比較する（降順）
        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
            //compareを使用して値を比較する
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                //降順
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });


        Entry<String, Integer> entry = list.get(1);

        System.out.println(entry.getKey());
		sc.close();
	}
}
