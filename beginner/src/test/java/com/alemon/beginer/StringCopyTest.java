package com.alemon.beginer;
/**
 * StringBuffer insert()实现
 * @author liuyanjie
 *
 */
public class StringCopyTest {
	private static void stringCopy(char[] src, int srcpos, char[] dest, int destpos, int length){
		for(int i = srcpos,j=destpos; i<=srcpos+length-1&&j<=destpos+length-1;i++,j++){
			System.out.println("i=" + i + ";j=" + j);
			dest[j]=src[i];
		}
		for(int k = 0;k<dest.length;k++){
			System.out.println(dest[k]);
		}
		
	}
	//字符串反转
	private static void reverse(String str){
		char[] s = str.toCharArray();
		char[] re = new char[s.length];
		int len = s.length;
		for(int i = 0;i<str.length();i++){
			re[--len] = s[i];
		}
		System.out.println(String.valueOf(re));
		/*StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());*/
	}
	public static void main(String[] args) {
		char[] source = new char[10];
		source[0]='a';
		source[1]='b';
		source[2]='c';
		source[3]='d';
		
		char[] dest = new char[2];
		dest[0]='e';
		dest[1]='f';
		int begin = 2;
	    StringCopyTest.stringCopy(source, 2, source, 4, 2);
	    StringCopyTest.stringCopy(dest, 0, source, 2, 2);
	    
	    StringCopyTest.reverse("i am a girl");
	}
}