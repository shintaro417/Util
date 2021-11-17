public static int binarySearch(long[] a,long b,int q) {
		int left = 0;
		int right = a.length - 1;
		//右端のインデックス番号と左端のインデックス番号が隣接するまで
		while(right - left > 1) {
			//右端と左端の真ん中のインデックス番号
			int mid = (left+ right) / 2;
			//真ん中の要素とターゲットが等しい時
			if(a[mid] == b) {
				return (int) Math.abs(a[mid] - b);
			}else if(b < a[mid]) {//ターゲットが配列の真ん中の値より小さい場合
				//ターゲットの値は真ん中より左側にあるはずだから
				//右端の値を真ん中のインデックス番号にする
				right = mid;
			}else {//ターゲットが配列の真ん中の値より大きい場合
				//ターゲットの値は真ん中より右側にあるはず
				//左端の値を真ん中のインデックス番号にする。
				left = mid;
			}
		}
		int min = (int) Math.min(Math.abs(a[left] - b), Math.abs(a[right] - b));
		return min;
	}
