package MutiThread;

public class demo01 {
	public static void main(String[] args) {
		//�����Զ����̶߳���
		MyThread mt = new MyThread("�µ��̣߳�");
		//�������߳�
		mt.start();
		//����������ִ��forѭ��
		for (int i = 0; i < 10; i++) {
			System.out.println("main�̣߳�"+i);
		}
	}
}