
public class NonameInnerClassThread {
	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run() {
				for(int i=0;i<20;i++){
					System.out.println(Thread.currentThread().getName()+"->"+i);
				}
			}
		}.start();
		//线程接口runnable
		Runnable r=new Runnable() {
			public void run() {
				for(int i=0;i<10;i++)
					System.out.println(Thread.currentThread().getName()+"->"+i+"work");
			}
		};
		new Thread(r).start();
	}
}
