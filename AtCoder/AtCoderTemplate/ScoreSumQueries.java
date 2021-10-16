import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		//1年生の人数
		int n = fs.nextInt();

		//1組の累積和
		int[] first = new int[n];
		//2組の累積和
		int[] second = new int[n];


		for(int i = 0;i < n;i++) {
			//組
			int c = fs.nextInt();
			//得点
			int point = fs.nextInt();

			if(c == 1) {
				first[i] = point;
			}else {
				second[i] = point;
			}
		}

		int[] firstSum = new int[n + 1];
		int[] secondSum = new int[n + 1];

		for(int i = 1;i <=n;i++) {
			firstSum[i] =  firstSum[i - 1] + first[i - 1];
			secondSum[i] = secondSum[i - 1] + second[i - 1];

			//out.println(secondSum[i]);
		}

		//質問数
		int questions = fs.nextInt();

		for(int i = 0;i < questions;i++) {
			//左端
			int l = fs.nextInt();
			//右端
			int r = fs.nextInt();

			int answer1 = calcSum(firstSum, l, r);
			int answer2 = calcSum(secondSum, l, r);

			out.println(answer1 + " " + answer2);
		}
	    out.flush();
		fs.close();
	}

	static public int calcSum(int[] CumulativeSum,int left,int right) {
		int sum = 0;

		sum = CumulativeSum[right] - CumulativeSum[left - 1];

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


