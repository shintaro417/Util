/**
     * エラトステネスの篩
     * 「N 以下の整数の集合から、合成数を次々とふるい落とす」 という操作によって、最終的に素数のみを残す方法
     * @param N　探索する値の上限
     * @return 素数のみがtrueとなるboolean型の配列
     */
    public static boolean[] Eratosthenes(long N){
        boolean[] isPrime = new boolean[100001];
        Arrays.fill(isPrime,true);

        //0,1はあらかじめふるい落としておく
        isPrime[0] = false;
        isPrime[1] = false;

        //篩にかける
        for(int i = 2;i <= N;i++){
            //すでに合成数である場合は除外
            if(!isPrime[i]){
                continue;
            }

            //i以外のiの倍数から素数ラベルをはく奪
            //例えば2以外の2の倍数を全てふるい落とすという処理を行っている。
            for(int j = i * 2;j <= N;j += i){
                isPrime[j] = false;
            }
        }

        return isPrime;
    }
