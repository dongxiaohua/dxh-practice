
### 设计模式
#### 原则
1. OCP原则： 对扩展开放，对修改关闭。即当我们给类增加新功能的时候尽量不修改代码，或者尽可能少修改代码。

#### 单例模式
* 定义： 保证一个类只有一个实例，并且提供一个全局访问点
* 场景： 重量级的对象，不需要多个实例，如线程池，数据库连接池

1. 懒汉模式：延迟加载，只有在真正使用的时候才开始加载。demo -> LazySingletonService
    1. 线程安全
    2. 双重check的加锁优化
    3. 编译器(JIT)，CPU有可能对指令重排序，导致使用到尚未初始化的实例，volatile 保证了指令的有序性
    4. 
    ```java
    class LazySingleton {
      //volatile 保证共享变量在多线程之间的可见性和有序性，但不能保证原子性，需要借助synchronied这样的锁机制
      private volatile static LazySingleton instance;
    
      private LazySingleton() {
      }
      public static LazySingleton getInstance() {
        if (instance == null) {
          //在判断后加载，是为了防止多线程同时访问方法造成的性能问题以及多次实例化
          //此处并发访问还是寻在性能损耗
          synchronized (LazySingleton.class) {
            //加锁后再次判断，是为了防止不同线程各自进行了实例化
            if (instance == null) {
              instance = new LazySingleton();
              //字节码层面
              //CPU、JIT
              // 1. 分配空间
              // 后续操作可能不按既定顺序，而造成类似赋值却没有引用而被其他线程返回，造成异常，因此volatile保证了执行顺序
              // 2. 初始化
              // 3. 引用赋值
            }
          }
        }
        return instance;
      }
    }

    ```
    
2. 饿汉模式：类加载的 初始化阶段就完成了实例的加载。本质上就是借助jvm类加载机制，保证实例的唯一性。demo -> HungrySingletonService
    1. 类加载过程：
        1. 加载二进制数据到内存中，生成对应的Class数据结构
        2. 连接：a. 验证，b. 准备(给类的静态成员变量赋默认值)，c. 解析
        3. 初始化：给类的静态变量赋初值
    2. 只有在真正使用对应类的时候，才会触发初始化（如：当前类是启动类，即main函数所在类，直接进行new操作，访问静态属性，访问静态方法，用反射访问类，初始化一个类的子类等）
    3. 
    ```java
     /**
      * 饿汉模式
      */
     class HungrySingleton {
       private static HungrySingleton instance = new HungrySingleton();
       /**
        * 私有构造函数，不能在外部初始化
        */
       private HungrySingleton() {
       }
       /**
        * 全局访问点
        *
        * @return
        */
       public static HungrySingleton getInstance() {
         return instance;
       }
     }
    ```
    
3. 静态内部类 demo -> InnerClassSingletonService
    1. 本质上是利用 类的加载机制来保证线程安全
    2. 只有在实际使用的时候才会触发类的初始化，和懒汉加载是一种形式
    3.
    ```java
       class InnerClassSingleton {
         /**
          * 静态内部类，在调用getInstance才会初始化
          */
         private static class InnerClassHolder {
           private static InnerClassSingleton instance = new InnerClassSingleton();
         }
       
         /**
          * 私有构造函数 不能在外部初始化
          */
         private InnerClassSingleton() {
         }
         /**
          * 全局访问点
          *
          * @return
          */
         public static InnerClassSingleton getInstance() {
           return InnerClassHolder.instance;
         }
       }
    ```
    
4. 反射攻击实例
    ```
    //反射攻击
    //拿到构造函数
    Constructor<InnerClassSingleton> declaredConstrutor = InnerClassSingleton.class.getDeclaredConstructor();
        //设置accessible为true，拿到访问权
        declaredConstrutor.setAccessible(true);
        InnerClassSingleton innerClassSingleton = declaredConstrutor.newInstance();
    ```
    1. 静态内部类模式和饿汉模式加载单例，可通过在私有构造函数来判断预防反射攻击，懒汉模式无法预防
    
5. 枚举类型 
    1. 天然不支持反射创建对应实例，且有自己的反序列化机制
    2. 利用类加载机制保证线程安全
    
6. 序列化
    1. 可以利用指定方法来替换从反序列化流中的数据
    
#### 简单工厂模式
    1. 属于创建型模式，是工厂模式额一种。简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。简单工厂模式是工厂模式家族中最简单实用的模式。
    2. 简单工厂模式：定义了一个创建对象的类，有这个类来封装实例化对象的行为。
    3. 在软件开发中，当我们会用到大量的创建某种、某类或某批对象时，就会使用到工厂模式。

#### 工厂方法模式



#### 抽象工厂模式



#### 策略模式 Strategy
* 定义: 定义了算法族，分别封装起来，让他们之前可以互相替换，此模式的变化独立于算法的使用者。



#### 代理模式


#### 建造者模式