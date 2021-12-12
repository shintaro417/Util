/**
	 * 二分探索
	 * @param a 身長の配列
	 * @param x 身長の分岐点
	 * @param n 要素数
	 */
	public static int binarySerach(long[] a,int x,int n) {
		int ok = n;
		int ng = -1;
 
		//okとngの要素が必ず隣合う
		while(Math.abs(ok - ng) > 1) {
			int mid = (ok + ng) / 2;
			if(a[mid] >= x) {
				ok = mid;
			}else {
				ng = mid;
			}
		}
 
		return ok;
 
	}
 
