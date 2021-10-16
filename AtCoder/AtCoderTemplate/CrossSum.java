import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();

		//行
		int h = fs.nextInt();
		//列
		int w = fs.nextInt();

		int[][] a = new int[h][w];

		for(int i = 0;i < h;i++) {
			for(int j = 0;j < w;j++) {
				a[i][j] = fs.nextInt();
			}
		}
		//各行の合計
		int[] row = new int[h];
		//各列の合計
		int[] column = new int[w];

		for(int i = 0;i < h;i++) {
			for(int j = 0;j < w;j++) {
				row[i] += a[i][j];
				column[j] += a[i][j];
			}
		}

		int[][] ans = new int[h][w];

	    for(int i = 0;i < h;i++) {
	        for(int j = 0;j < w;j++) {
	        	ans[i][j] = row[i] + column[j] - a[i][j];
	        }
	    }

	    PrintWriter out = new PrintWriter(System.out);
	    for(int i = 0;i < h;i++) {
	    	for(int j = 0;j < w;j++) {
	    		if(j == w - 1) {
	    			out.println(ans[i][j]);
	    		}else {
	    			out.print(ans[i][j] + " ");
	    		}
	    	}
	    }

	    out.flush();
		fs.close();
	}

	/**
	 * 同じ列の合計値を求める。
	 * @param a 配列
	 * @param h 固定する行
	 * @param w 行数
	 * @return
	 */
	public static int calcWSum(int[][] a,int h,int w) {
		int sum = 0;
		for(int i = 0;i < w;i++) {
			sum += a[h][i];
		}

		return sum;
	}

	/**
	 * 同じ行の合計値を求める
	 * @param a
	 * @param w 固定する列
	 * @param h 行数
	 * @return
	 */
	public static int calcHSum(int[][] a,int w,int h) {
		int sum = 0;
		for(int i = 0;i < h;i++) {
			sum += a[i][w];
		}
		return sum;
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


