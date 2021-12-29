public static void dfs(int x,int y) {
		if(x < 0 || H <= x || y < 0 || W <= y || c[x][y] == '#') {
			return;
		}else if(c[x][y] == 'g') {
			ok = true;
			return;
		}
		if(reached[x][y]) {
			return;
		}

		reached[x][y] = true;

		dfs(x - 1, y);
		dfs(x + 1, y);
		dfs(x, y - 1);
		dfs(x, y + 1);
	}
