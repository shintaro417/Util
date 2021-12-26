/**
	 *ABC 119 C を解くためのDFS
	 * @param i 何番目の竹を見ているか
	 * @param a 竹Aとして合成された長さ
	 * @param b 竹Bとして合成された長さ
	 * @param c 竹Cとして合成された長さ
	 * @return
	 */
	public static int dfs(int i,int a,int b,int c) {
    //Nは要素数
		if(i == N) {
			//A,B,Cはいずれも竹を一本は使っていないとだめ
			if(a == 0 || b == 0 || c == 0) {
				return 1000000;
			}
				//それぞれの合成後の竹における目標の長さと総和の差分
      //A,B,Cは目標となる竹の長さ
				return Math.abs(a - A) + Math.abs(b - B) + Math.abs(c - C);

		}

		//今ある竹を採用しない場合
		//この時点で変数minをセットする
		int min = dfs(i + 1, a, b, c);

		//chmin(a,b)は「aがbよりも大きければaをbで更新する。」
		//最小値を更新している。
		//aが0の時は最初に合成魔法が選ばれただけなので、合成魔法を使う必要がない
		//竹が選ばれるのが2回目であれば+10する
		if(min > dfs(i + 1, a + l[i], b, c) + (a > 0 ? 10 : 0)) {
			min = dfs(i + 1, a + l[i], b, c) + (a > 0 ? 10 : 0);
		}
		if(min > dfs(i + 1, a, b + l[i], c) + (b > 0 ? 10 : 0)) {
			min = dfs(i + 1, a, b + l[i], c) + (b > 0 ? 10 : 0);
		}
		if(min > dfs(i + 1, a, b, c + l[i]) + (c > 0 ? 10 : 0)) {
			min = dfs(i + 1, a, b, c + l[i]) + (c > 0 ? 10 : 0);
		}

		return min;
		}
