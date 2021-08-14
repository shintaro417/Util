import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//プロセス数
		int proccess = sc.nextInt();

		//各プロセスの最大処理時間
		int quontam = sc.nextInt();

		Queue<String> queue = new ArrayDeque<String>();
		Map<String,Integer>maps = new HashMap<String,Integer>();

		for(int i = 0;i < proccess;i++) {
			String name = sc.next();
			int time = sc.nextInt();

			maps.put(name,time);
			queue.add(name);
		}

		Proccess(queue, maps, quontam);
//		Set<String> keys = finishhMap.keySet();
//		for(String key : keys) {
//			System.out.format("%s %d\n",key,finishhMap.get(key));
//		}


		sc.close();
	}

	public static void Proccess(Queue<String> queue,Map<String, Integer>maps,int quontam) {
		//合計のプロセス処理時間
		int total = 0;
		while(true) {
			//先頭キューを取り出す
			String queueString = queue.poll();
			//mapに格納されている残り時間を取り出す
			int restTime = maps.get(queueString);

			if(restTime <= quontam) {//残り時間がquontamを切った場合
				//合計時間と残り時間をたす
				int finishTime = total + restTime;
				//合計時間に残り時間を足す
				total = finishTime;
				System.out.format("%s %d\n", queueString,finishTime);
			}else {
				//残り時間からquontamを引く
				restTime -= quontam;
				maps.replace(queueString, restTime);
				//キューの末尾に取り出したキューを追加する
				queue.add(queueString);
				//合計時間にプロセス時間をたす
				total += quontam;
			}
			if(queue.peek() == null) {
				break;
			}
		}
	}
}

