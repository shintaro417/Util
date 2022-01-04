import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Main {
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		int N = fs.nextInt();
		int Q = fs.nextInt();

		UnionFind uf = new UnionFind(N);

		for(int i = 0;i < Q;i++) {
			int P = fs.nextInt();
			int A = fs.nextInt();
			int B = fs.nextInt();

			if(P == 0) {
				uf.unite(A, B);
			}else {
				if(uf.same(A, B)) {
					out.println("Yes");
				}else {
					out.println("No");
				}
			}
		}

		out.flush();
		fs.close();
	}
	/**
	 * 組み合わせを実装する
	 * @param n
	 * @param r
	 * @return
	 */
	public static BigInteger calcCombination(BigInteger L, int r) {
        if (L.compareTo(BigInteger.ZERO) < 0 || r < 0) {
            throw new IllegalArgumentException("Arguments must be 0 and over.");
        }
        else if (L.compareTo(BigInteger.valueOf(r)) == 0 || r == 0) {
            return BigInteger.ONE;
        }
        else if (L.compareTo(BigInteger.valueOf(r)) < 0) {
            return BigInteger.ZERO;
        }
        else {
        	BigInteger result = BigInteger.ONE;
            for (int i = 1; i <= r; i++) {
            	BigInteger tempBigInteger = L.subtract(BigInteger.valueOf(i));
            	tempBigInteger = tempBigInteger.add(BigInteger.valueOf(1));
            	result = result.multiply(tempBigInteger).divide(BigInteger.valueOf(i));
                //result = result * (n - i + 1) / i;
            }
            return result;
        }
    }



	/**
	 * 最小公倍数を求める
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigInteger lcm(BigInteger a,BigInteger b) {
		BigInteger temp;
		BigInteger c = a;

		//c * bを計算する
		c = c.multiply(b);


		while((temp = a.remainder(b)) != BigInteger.ZERO){
			a = b;
			b = temp;
		}

		return c.divide(b);
	}

	public static int permission(int n) {
		int num = 1;
		for(int i = n;i >0 ;i--) {
			num *= i;
		}
		return num;
	}

	public static  void Sort2DArrayBasedOnColumnNumber (long[][] array, final int columnNumber){
        Arrays.sort(array, new Comparator<long[]>() {
            @Override
            public int compare(long[] first, long[] second) {
               if(first[columnNumber-1] > second[columnNumber-1]) return 1;
               else if(first[columnNumber - 1] == second[columnNumber - 1]) return 0;
               else return -1;
            }
        });
    }

	/**
	 * 順列の全探索をするプログラム
	 * 前提条件としては
	 * 要素の数は2より大きい
	 * 配列はソート済みであること
	 * @param arr 対象となる配列
	 * @return
	 */
	public static boolean nextPermutation(int[] arr) {
		//配列の長さ
	    int len = arr.length;
	    //arr[l] < arr[l + 1]を満たすlのうち最大のものを求める。?
	    int left = len - 2;
	    //arr[l] < arr[l + 1]を満たすlのうち最大のものを求める。?
	    while (left >= 0 && arr[left] >= arr[left+1]) left--;
	    //前提条件が崩れるからfalse
	    if (left < 0) return false;
	    //末尾から探索して初めて現れるarr[left]より大きい要素のインデックス
	    int right = len - 1;
	    //rightを探索する。
	    while (arr[left] >= arr[right]) right--;
	    //leftとrightを入れ替える。
	    { int t = arr[left]; arr[left] = arr[right];  arr[right] = t; }
	    left++;
	    right = len - 1;
	    //left + 1以降の順番を反転させる。
	    while (left < right) {
	      { int t = arr[left]; arr[left] = arr[right]; arr[right] = t; }
	      left++;
	      right--;
	    }
	    return true;
	  }

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

}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        // 初期化コンストラクタ
        this.parent = new int[n];
        this.rank = new int[n];

        // 最初はすべてが根
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * 要素の根を返す。
     * 経路圧縮付き。（1→3→2となっていて2をfindした際、1→3,2と木の深さを浅くする。）
     *
     * @param x
     * @return 要素xの根
     */
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            // 経路圧縮時はrank変更しない
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    /**
     * ２つの要素が同じ集合に属するかどうかを返す。
     * 根が同じかどうかを判定する。
     * @param x
     * @param y
     * @return 同じ集合であればtrue
     */
    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    /**
     * 要素xが属する集合と要素yが属する集合を連結する。
     * 木の高さ（ランク）を気にして、低い方に高い方をつなげる。（高い方の根を全体の根とする。）
     *
     * @param x
     * @param y
     */
    public void unite(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            // 属する集合が同じな場合、何もしない
            return;
        }

        // rankを比較して共通の根を決定する。
        // ※find時の経路圧縮はrank考慮しない
        if (rank[xRoot] > rank[yRoot]) {
            // xRootのrankのほうが大きければ、共通の根をxRootにする
            parent[yRoot] = xRoot;
        } else if (rank[xRoot] < rank[yRoot]) {
            // yRootのrankのほうが大きければ、共通の根をyRootにする
            parent[xRoot] = yRoot;
        } else {
            // rankが同じであれば、どちらかを根として、rankを一つ上げる。
            parent[xRoot] = yRoot;
            rank[xRoot]++;
        }
    }
}



class FastScanner{
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;
    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        }else{
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }
    private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
    private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
    public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while(isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    public long nextLong() {
        if (!hasNext()) throw new NoSuchElementException();
        long n = 0;
        boolean minus = false;
        int b = readByte();
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        if (b < '0' || '9' < b) {
            throw new NumberFormatException();
        }
        while(true){
            if ('0' <= b && b <= '9') {
                n *= 10;
                n += b - '0';
            }else if(b == -1 || !isPrintableChar(b)){
                return minus ? -n : n;
            }else{
                throw new NumberFormatException();
            }
            b = readByte();
        }
    }
    public int nextInt() {
        long nl = nextLong();
        if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
        return (int) nl;
    }
    public double nextDouble() { return Double.parseDouble(next());}

    public void close() {
    	try {
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
    }
}


