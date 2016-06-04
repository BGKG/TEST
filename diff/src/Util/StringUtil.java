package Util;

import java.util.ArrayList;
/**
 * String관련된 활용기능.
 * @author 임철우
 *
 */
public class StringUtil {
	/**
	 * ArrayList<String>의 배열에 있는 내용을 하나로 잇습니다.
	 * 
	 * @param strarr
	 *            바꿀 배열리스트
	 * @return 합친 String
	 */
	public static String mergeString(ArrayList<String> strarr) {
		ArrayList<String> temp = (ArrayList<String>)strarr.clone();
		StringBuilder builder = new StringBuilder();
		while (!temp.isEmpty()) {
			builder.append(temp.get(0));
			temp.remove(0);
		}
		return builder.toString();
	}
}
