/**
	 * @param s
	 * @return String 大文字、小文字を反転した文字列を返す
	 */
	static String CaseReverse(String s) {
		StringBuilder sBuilder = new StringBuilder();
		for(int i = 0;i < s.length();i++) {
			char c = s.charAt(i);

			//文字が大文字か否か
			if(Character.isUpperCase(c)) {
				//32を足すと小文字になる
				c += 32;
				sBuilder.append(c);
			}else if(Character.isLowerCase(c)) {
				c -= 32;
				sBuilder.append(c);
			}else {
				sBuilder.append(c);
			}
		}

		return sBuilder.toString();
	}
