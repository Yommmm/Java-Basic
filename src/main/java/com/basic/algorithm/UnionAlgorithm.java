package com.basic.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类用ArrayList表示区间的集合,每一个元素表示一个区间 ArrayList中元素顺序为这些元素表示的区间按照在数轴上在顺序排列
 * 
 * @author Yom
 *
 */
public class UnionAlgorithm {

	/**
	 * 存放结果 集合
	 */
	private List<Interval> value = new ArrayList<>();

	/**
	 * 计算主方法
	 * 
	 * @param param
	 * @return
	 */
	public List<Interval> calc(Interval[] param) {
		Interval[] interval = check(param);
		if (interval == null || interval.length == 0)
			return null;
		if (value.size() == 0 && interval.length >= 1)
			value.add(interval[0]);
		for (int i = 1; i < interval.length; i++) {
			// 判断该区间的左端点在value中的位置
			int[] left_position = getPosition(value, 0, interval[i].getLeft());
			if (left_position[0] == 1) {
				// 1 左端点属于value的情况
				int[] right_position = getPosition(value, left_position[1], interval[i].getRight());
				if (right_position[0] == 1) {
					// 1.1 右端点也属于value
					if (left_position[1] == right_position[1])
						continue;

					((Interval) value.get(left_position[1]))
							.setRight(((Interval) value.get(right_position[1])).getRight());

					for (int j = left_position[1] + 1; j <= right_position[1]; j++) {
						value.remove(j);
					}
				} else {
					// 1.2右端点不属于value
					((Interval) value.get(left_position[1])).setRight(interval[i].getRight());
					for (int j = left_position[1] + 1; j < right_position[1]; j++) {
						value.remove(j);
					}
				}
			} else {
				// 2 左端点不属于value
				value.add(left_position[1], interval[i]);
				refresh(left_position[1]);

			}
		}

		return value;
	}

	public void refresh(int index) {
		Interval temp = (Interval) value.get(index);
		int[] index_right_position = getPosition(value, index + 1, temp.getRight());
		if (index_right_position[0] == 1) {
			Interval include_right = (Interval) value.get(index_right_position[1]);
			temp.setRight(include_right.getRight());

			for (int i = index + 1; i <= index_right_position[1]; i++) {
				value.remove(i);
			}
		} else if (index_right_position[0] == 0) {
			// 删除该区间内的所有区间
			for (int i = index + 1; i < index_right_position[1]; i++) {
				value.remove(i);
			}
		}
	}

	/**
	 * 在集合value中查找点point的位置 从序列号为from开始查找
	 * 
	 * 返回:为一个数组,包括两个值[type,index]
	 * 如果type=0,表示point点不在集合value中的任何一个区间内,该点在第index区间的前面
	 * 如果type=1,表示point点在集合value中的第index的元素区间内
	 * 
	 * (说明:type为0的特殊情况为该点在集合中最后一个区间的后面,此时
	 * 尽管value.get(value.size())并不存在,我们仍然把index赋值为value.size())
	 * 
	 * @param value
	 * @param from
	 * @param point
	 * @return
	 */
	public int[] getPosition(List<Interval> value, int from, int point) {
		if (from >= value.size())
			return new int[] { 0, value.size() };

		if (point < ((Interval) value.get(from)).getLeft()) {
			return new int[] { 0, from };
		}

		for (int i = from; i < value.size() - 1; i++) {
			Interval tmp = (Interval) value.get(i);
			if (tmp.isContain(point))
				return new int[] { 1, i };
			Interval tmpLater = (Interval) value.get(i + 1);
			if (point > tmp.getRight() && point < tmpLater.getLeft())
				return new int[] { 0, i + 1 };
		}

		// 比较最后一个区间
		Interval last = (Interval) value.get(value.size() - 1);
		if (last.isContain(point))
			return new int[] { 1, value.size() - 1 };
		else
			return new int[] { 0, value.size() };
	}

	/**
	 * 数组的检查, 数组元素右边的数不得小于右边的元素
	 * 
	 * @param duan
	 * @return
	 */
	public Interval[] check(Interval[] temp) {
		// :-不破坏参数原则
		Interval[] interval = new Interval[temp.length];
		for (int i = 0; i < interval.length; i++) {
			interval[i] = new Interval(temp[i]);
		}
		// :-
		int length = interval.length;
		for (int i = 0; i < interval.length; i++) {
			if (interval[i].getRight() < interval[i].getLeft()) {
				interval[i] = null;
				length--;
			}
		}
		Interval[] result = new Interval[length];
		int index = 0;
		for (int i = 0; i < interval.length; i++) {
			if (interval[i] != null) {
				result[index] = interval[i];
				index++;
			}
		}
		return result;
	}

	public List<Interval> getValue() {
		return value;
	}

	public static void main(String[] args) {
		UnionAlgorithm ua = new UnionAlgorithm();
		Interval d1 = new Interval(7, 9);
		Interval d2 = new Interval(5, 7);
		Interval d3 = new Interval(-1, 4);
		Interval d4 = new Interval(8, 10);
		Interval d5 = new Interval(10, 12);
		Interval d6 = new Interval(4, 1);
		Interval d7 = new Interval(8, 10);
		Interval d8 = new Interval(3, 14);
		Interval d9 = new Interval(15, 17);
		Interval c1 = new Interval(0, 4545);
		Interval c2 = new Interval(32, 54);
		Interval c3 = new Interval(123, 456);
		Interval c4 = new Interval(34, 54);
		Interval c5 = new Interval(12, 23);

		// Interval[] duan = { d1, d2, d3 };
		Interval[] duan = { d1, d3 };
//		Interval[] duan = { d1, d2, d3, d4, d5, d6, d7, d8, d9, c1, c2, c3, c4, c5 };

		long sc = System.currentTimeMillis();
		ua.calc(duan);
		sc = System.currentTimeMillis() - sc;

		System.out.println(ua.getValue() + "花费:" + sc);

	}
}

/**
 * 表示一个区间[left, right]
 * 
 * @author luoxian
 * @since Sep 5, 2008 4:48:15 PM
 * @version 1.0
 */
class Interval {
	private int left;
	private int right;

	public Interval(Interval interval) {
		this.left = interval.getLeft();
		this.right = interval.getRight();
	}

	public Interval(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public boolean isContain(int point) {
		if (point <= right && point >= left)
			return true;
		else
			return false;
	}

	public int getLeft() {
		return left;
	}

	public int getRight() {
		return right;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public String toString() {
		return "[" + left + " , " + right + "]";
	}
}