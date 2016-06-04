package diff;

import java.util.ArrayList;

public class StringUtil {
	public static String mergeString(ArrayList<String> strarr){
		StringBuilder builder = new StringBuilder();
		while(!strarr.isEmpty()){
			builder.append(strarr.get(0));
			strarr.remove(0);
		}
		return builder.toString();
	}
}
