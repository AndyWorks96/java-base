package MutiThread;

public class MyThread extends Thread {
	//����ָ���߳����ƵĹ��췽��
		public MyThread(String name) {
			//���ø����String�����Ĺ��췽����ָ���̵߳�����
			super(name);
		}
		/**
		 * ��дrun��������ɸ��߳�ִ�е��߼�
		 */
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(getName()+"������ִ�У�"+i);
			}
		}
}
