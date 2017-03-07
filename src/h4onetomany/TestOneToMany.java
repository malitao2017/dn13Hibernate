package h4onetomany;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class TestOneToMany {
	
//	@Test
	/**
	 * 测试BigDecimal和BigInteger
	 */
	public void testBigDecimal(){
		/**
		 * 常规浮点型数值
		 * 缺点：不精确 ，结果：0.10000000000000009
		 */
		double money = 3.0;
		System.out.println("常规： "+(money-2.9));
		
		/**
		 * 使用大长度
		 * 当前计算机的内存有多大，BigInteger 就能表示多大的数字
		 * 注意：BigDecimal中初始化使用 "3.0" 不能使用 3.0
		 * 用法：ROUND_HALF_UP表示舍弃部分>=.5的情况向上近似
		 */
		BigDecimal one = new BigDecimal("1.0");
		BigDecimal moneyd = new BigDecimal("3.0");//不要使用3.0
		BigDecimal price = new BigDecimal("2.9");
		System.out.println("BigDecimal:　3-2.9=" + moneyd.subtract(price)+
				" 1/3= "+one.divide(moneyd, 5,BigDecimal.ROUND_HALF_UP));
		
		BigInteger n = BigInteger.valueOf(1);
		for(int i=2;i<=200;i++){
			n = n.multiply(BigInteger.valueOf(i));
		}
		System.out.println("BigInteger: " + n );
	}
	
	@Test
	public void testOTM(){
		
	}
	
	
	
}
