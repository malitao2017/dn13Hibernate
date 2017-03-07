package h2threadlocal;


/**
 * 模拟ThreadLocal 实现过程
 * OpenSessionInView 技术 和ThreadLocal 类
 * @author malitao
 *
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
		Some some = SomeFactory.getSome();
		System.out.println(some);
		fun();
	}
	
	public static void fun(){
		System.out.println("fun()...");
		Some s2 = SomeFactory.getSome();
		System.out.println(s2);
	}
}	

//Some 用于模拟session
class Some{}

//SomeFactory用于创建Some类（模拟sessionFactory）
class SomeFactory{
	/**
	 * 常规方式：每次出一个新对象
	 * @return
	 */
	/*public static Some getSome(){
		return new Some();
	}*/
	
	/**
	 * 修改方案1：根据每个线程创建一样的内容
	 *  然而，我们希望从 f()方法中拿到的 s2 对象和 mian()方法中创造的 s1 是同一个对象
		首先注意一点，f()方法和 main()方法同样都是在一个线程中，有相同的线程号。
		以当先线程 Id 为 key，创建了一个 Some 对象，在同一个线程中，利用 SomeFactory 得到
		的 Some 对象是同一个。
		叧有在丌同线程中，取到的对象才是丌同的。
	 */
	/*private static java.util.Map<Long, Some> map = new java.util.HashMap<Long, Some>();
	public static Some getSome(){
		Long threadid = Thread.currentThread().getId();
		Some some = map.get(threadid);
		if(some == null){
			some = new Some();
			map.put(threadid, some);
		}
		return some;
	}*/
	/**
	 * 修改方案2：线程单例
	 * 回到服务器中，叧要是服务器，每一个浏览器访问服务器时，服务器会为每个浏览器创建一个线
		假设 Some 就是 Session，如果使用这种机制获取 Session，当同一个用户浏览器丌论怎么调
		session 都是同一个（叧要在相同的线程中）。
		这种机制就叨做线程单例。
		线程单例的实现原理就是如上 SomeFactory 做的。
		ThreadLocal
		接下来继续回到 ThreadLocal
		ThradLocal 就相当亍 Map，叧丌过 key 是固定的，就是当前线程号。
	 */
	//ThreadLocal的key是写死的， 就是当前线程的ID
	private static ThreadLocal<Some> tl = new ThreadLocal<Some>();
	public static Some getSome(){
		Some some = tl.get();
		if(some == null){
			some = new Some();
			tl.set(some);
		}
		return some;
	}
	
}

	

