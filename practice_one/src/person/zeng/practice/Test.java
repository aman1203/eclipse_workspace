package person.zeng.practice;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {
	private static Integer count = 10;
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		for(int i=0;i<count;i++) {
			Student s = new Student();
			s.setAge(i+10);
			s.setEnglish(i+50);
			s.setMath(i);
			s.setName("zengjie"+i);
			s.setSchool(i%2==0?"武汉中学":"杭州中学");
			list.add(s);
		}
		
		Optional<List<Student>> opt = Optional.ofNullable(list);
		//计算出杭州中学的平均分
		Consumer<List<Student>> consumer_avg = (x)->{
			double d = x.stream().collect(Collectors.groupingBy(Student::getSchool))
			.get("杭州中学").stream().collect(Collectors.averagingDouble(Student::getMath));
			System.out.println(d);
		};
		//按照总成绩从高到低排名
		Consumer<List<Student>> consumer_sort =(i)->{
			System.out.println(i.stream().sorted((y,x)->x.getEnglish()+x.getMath()-y.getMath()-y.getEnglish()).collect(Collectors.toList()));
		};
		//
		new Thread(()->System.out.println(12)).start();;
		opt.ifPresent(consumer_avg);
		opt.ifPresent(consumer_sort);
		List<Integer> list_test = new ArrayList<Integer>();
		for(int i=0;i<100;i++){
			list_test.add(i);
		}
		BitSet bs = new BitSet();
		bs.set(0, true);
	}
	
	static class Student{
		private String name;
		private Integer age;
		private String school;
		private Integer math;
		private Integer english;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getSchool() {
			return school;
		}
		public void setSchool(String school) {
			this.school = school;
		}
		public Integer getMath() {
			return math;
		}
		public void setMath(Integer math) {
			this.math = math;
		}
		public Integer getEnglish() {
			return english;
		}
		public void setEnglish(Integer english) {
			this.english = english;
		}
		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + ", school=" + school + ", math=" + math + ", english="
					+ english + "]";
		}
	}
}
