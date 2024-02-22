import java.util.Runnable.*;
import java.util.*;
// implementation without lamda
public interface Runnable{
  void run();
}
Thread t =new Threa(new Runnable(){
  public void run()
  {System.out.println("Hello Poppie:");}
});
//with lambda
Thread t= new Thread(()->System.out.println("Hello poppie"));


//another
public interface Callable<V>{
  V call();
}
ExecutorService executorservice=Executors.newCachedThreadPool();
Future<String>threadName=executorservice.submit(new Callable<String>(){
  @Override
  public String call()throws Exception{
    return Thread.currentThread().getName();
  }
});
//with lamdas
Future<String>threadname=executorservice.submit(()->Thread.currentThread().getName());

//GUI event handling
Button button =new Button ("Send");
button.setOnAction(new EventHandler<ActionEvent>(){
  label.setText("Sent!!:");}});
//lamda
button.setOnAction((ActionEvent event) ->label.setText("Sent!!:"));
  






                                                
