 /**
     * 繰り返し2乗法
     * @param x　基数
     * @param n　指数
     * @return int 計算結果
     */
    static long repeatPow(long x ,long n){
        long ans = 1;
        while(n > 0){
            if((n & 1) == 1){//フラグが立っていたら
                ans = ans * x % mod;
            }
            x = x * x % mod; //1周するたびにx,x ^ 2,x ^ 4となる。
            n >>= 1; //桁を一つ右にずらす
        }
        return ans % mod;
    }
