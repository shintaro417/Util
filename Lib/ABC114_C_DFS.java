/**
	 * ABC 114 C問題を解いた時に使ったDFS
	 * @param cur
	 * @param use
	 */
	public static void dfs753(long cur,int use) {
    //Nは要素数
		if(cur > N) return; //ベースケース
    //booleanで管理しても良いけど、ビットで管理しても良い
		if(use == 0b111) {
			ans++;
		}

		//7を付け加える
		dfs753(cur * 10 + 7, use | 0b001);

		//5を付け加える
		dfs753(cur * 10 + 5, use | 0b010);

		//3を付け加える
		dfs753(cur * 10 + 3, use | 0b100);
	}
