package kr.ac.jbnu.playmate.util;

import java.util.regex.Pattern;

public class StringUtil {
	public static boolean isContainSpecialCharacter(String str) {
		if(Pattern.matches("^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$",	str)) {
			return true;
		}
		
		return false;
	}
}
