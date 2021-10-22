import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		int n = fs.nextInt();

		//割る数
		long p = fs.nextLong();
		//余り
		long q = fs.nextLong();

		long[] a = new long[n];

		for(int i = 0;i < n;i++) {
			a[i] = fs.nextLong();
		}

		long ans = 0;

    //for文を使っても計算量的には間に合う
		for(int i = 0;i < n;i++) {
			for(int j = i + 1;j < n;j++) {
				for(int k = j + 1;k < n;k++) {
					for(int l = k + 1;l < n;l++) {
						for(int m = l + 1;m < n;m++) {
              //積を出した後に剰余を行うとオーバーフローになるので、剰余を分配して計算すること
							if(a[i] * a[j] % p * a[k] % p * a[l] % p * a[m] % p == q) {
								ans++;
							}
						}
					}
				}
			}
		}

		out.println(ans);
	    out.flush();
		fs.close();
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


