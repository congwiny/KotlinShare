public interface ChatBot {
    //Java 1.8 接口里可以声明静态方法，并且可以实现。
    static void greet(String username){
        System.out.println("Hello, "+username);
    }
}
