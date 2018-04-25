package com.basic.concurconcurrent;

public class ZhangFei extends Thread {

	@Override
	public void run() {
		this.say(50);
	}

	private void say(int i) {
		try {
			int a = 1;
			while (a < i) {
				System.out.println("第" + a + "遍，我是张飞！");
				Thread.sleep(100);
				if (a % 5 == 0) {
					System.out.println("我累了，休息三秒！");
					Thread.sleep(3000);
				}
				a++;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
