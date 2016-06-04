package Util;

import java.util.ArrayList;
/**
 * String���õ� Ȱ����.
 * @author ��ö��
 *
 */
public class StringUtil {
	/**
	 * ArrayList<String>�� �迭�� �ִ� ������ �ϳ��� �ս��ϴ�.
	 * 
	 * @param strarr
	 *            �ٲ� �迭����Ʈ
	 * @return ��ģ String
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
