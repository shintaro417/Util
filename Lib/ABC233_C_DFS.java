/**
	 * 再帰関数を使った深さ優先探索
	 * @param pos 探索している現在位置
	 * @param seki 総積
	 */
//	public static void dfs(int pos,long seki) {
//		//探索している現在位置がNと等しい時、つまり終端まで来た時。
//		if(pos == N) {
//			//総積がxと等しい時
//			if(x == seki) {
//				ans++;
//			}
//			return;
//		}
//		for(long c : a[pos]) {
//			//cを掛けると現在の総積がxを上回る時
//			if(seki > x / c) {
//				continue;
//			}
//			//現在の探索位置を一つ前に進めて再帰関数を実行する。
//			dfs(pos + 1, seki * c);
//		}
//	}
