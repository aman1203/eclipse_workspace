package person.zeng.tree;

import java.io.File;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * �ݹ���ϰ����˼�룺�����һ�μ�����ϴμ����й�ϵ�Ϳ��Կ���ʹ�õݹ�
 * @author Administrator
 *
 */
public class Test {
	//��¼�ƶ��Ĵ���
	static long count = 0;
	private static File file = new File("C:\\Users\\Administrator\\Desktop\\test");
	public static void main(String[] args) {
		String from = "A";
		String to = "C";
		String by = "B";
		//System.out.println(sum(100));
		//System.out.println(jiecheng(3));
		hanProblem(4,from,to,by);
		System.out.println(count);
		//delete(file);
	}
	/**
	 * ��1+2+3+...+n�ĺ�
	 */
	public static int sum(int n) {
		if(n == 1) {
			return 1;
		}else {
			return sum(n-1)+n;
		}
	}
	/**
	 * ��1*2*3*4*....n�Ļ�
	 * @param n
	 * @return
	 */
	public static int jiecheng(int n) {
		if(n == 1) {
			return 1;
		}else {
			return jiecheng(n-1)*n;
		}
	}
	/**
	 * ��ŵ���⣬��a,b,c�����������ƶ����ӣ�ÿ���ƶ�һ�������ӵ�˳���ܱ䣬�����ƶ���·�����ƶ��Ĵ���
	 * @return
	 */
	public static void hanProblem(int n,String from,String to,String by) {
		if(n==1) {
			move(from, to);
		}else {
			hanProblem(n-1,from,by,to);
			move(from,to);
			hanProblem(n-1,by,to,from);
		}
	}
	/**
	 * �ƶ�����
	 * @param from
	 * @param to
	 */
	public static void move(String from,String to) {
		count++;
		System.out.println(from+"->"+to);
	}

	/**
	 * �ݹ�ɾ���ļ���
	 */
	public static void delete(File file) {
		if (file == null && !file.exists()) {
			throw new RuntimeException("�ļ�·��������");
		}
		File[] files = file.listFiles();
		if (files == null || files.length == 0) {
			file.delete();
			return;
		}
		List<File> list = Arrays.asList(files);
		Map<Boolean, List<File>> map = list.stream().collect(Collectors.groupingBy(File::isFile));
		Optional<List<File>> option_file = Optional.ofNullable(map.get(true));
		Optional<List<File>> option_dir = Optional.ofNullable(map.get(false));
		Consumer<List<File>> consumer_file = (x) -> {
			x.stream().forEach(File::delete);
		};
		Consumer<List<File>> consumer_dir = (x) -> {
			x.stream().forEach((item)->{delete(item);item.delete();});
		};
		option_file.ifPresent(consumer_file);
		option_dir.ifPresent(consumer_dir);
	}
}
