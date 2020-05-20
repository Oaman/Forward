# Forward
This project is for Study.
___
### Android学习路线
- 初级工程师：阅读官方文档+练习官方Demo
	- 技术要求
		- 四大组件使用
		- 如何布局
		- 简单的自定义View
		- 动画
	- 书籍推荐
		- 《第一行代码》
		-  《疯狂Android》
- 中级工程师：写文章要独立思考和有技术深度；阅读源码+自定义View+滑动冲突（View滑动原理）
	- 技术要求
		- AIDL：熟悉AIDL，理解其工作原理，懂transact和onTransact的区别；
		- Binder：从Java层大概理解Binder的工作原理，懂Parcel对象的使用；
		- 多进程：熟练掌握多进程的运行机制，懂Messenger、Socket等；
		- 事件分发：弹性滑动、滑动冲突等；
		- 玩转View：View的绘制原理、各种自定义View；
		- 动画系列：熟悉View动画和属性动画的不同点，懂属性动画的工作原理；
		- 懂性能优化、熟悉mat等工具
		- 懂点常见的设计模式
	- 推荐书籍
		- 《Android开发艺术探索》
		- 《Android群英传》

	- 高级工程师：
		- 技术要求
			- 了解SystemServer的启动过程
			- 了解主线程的消息循环模型
			- 了解AMS和PMS的工作原理
			- 能够回答问题”一个应用存在多少个Window？“
			- 了解四大组件的大概工作流程
			- Activity的启动模式以及异常情况下不同Activity的表现
			- Service的onBind和onReBind的关联
			- onServiceDisconnected(ComponentName className)和binderDied()的区别
			- AsyncTask在不同版本上的表现细节
			- 线程池的细节和参数配置
			- 熟悉设计模式，有架构意识
		- 书籍推荐
			- 《Android 源码设计模式解析与实战》
			- 《Android内核剖析》
___
### Android技能树
- 编码规范
- 版本控制
- 开发工具
- 签名打包
- Java
	- 集合框架
	- I/O流
- Android
	- 四大组件
	- 常用控件
	- View绘制
	- 事件分发机制
	- 动画
	- 进程间通信
- 网络
- 设计模式
- 应用架构
- 开源框架
___
### 原创系列博客
- Android框架层
	- Android Jetpack组件
		- [Android Jetpack架构组件（一）了解Android Jetpack](https://blog.csdn.net/oman001/article/details/104348915)
		- [Android Jetpack架构组件（二）Lifecycle使用篇](https://blog.csdn.net/oman001/article/details/104360514)
		- [Android Jetpack架构组件（三）Lifecycle原理篇](https://blog.csdn.net/oman001/article/details/104371450)
		- [Android Jetpack架构组件（四）LiveData使用篇](https://blog.csdn.net/oman001/article/details/104469779)
		- [Android Jetpack架构组件（五）LiveData原理篇](https://blog.csdn.net/oman001/article/details/104469779)
		- [Android Jetpack架构组件（六）ViewModel使用和源码篇](https://blog.csdn.net/oman001/article/details/104514711)
		- [Android Jetpack架构组件（七）Room使用篇](https://blog.csdn.net/oman001/article/details/104587140)
		- [Android Jetpack架构组件（八）WorkManager使用篇](https://blog.csdn.net/oman001/article/details/104592654)
		- [Android Jetpack架构组件（九）WorkManager源码篇](https://blog.csdn.net/oman001/article/details/104611799)
	- 深入理解四大组件 (未完待续)
		- [Activity启动流程源码分析](https://blog.csdn.net/oman001/article/details/103774364)
		- [Service流程源码分析(一) startService](https://blog.csdn.net/oman001/article/details/103794574)
		- [Service流程源码分析(二) bindService](https://blog.csdn.net/oman001/article/details/103789919)
	- 深入理解Context
		- [Application中Context的创建过程](https://blog.csdn.net/oman001/article/details/103788939)
		- [Activity中Context的创建过程](https://blog.csdn.net/oman001/article/details/103789093)
		- [Service中Context的创建过程](https://blog.csdn.net/oman001/article/details/103789136)
		- [Context使用的误区](https://blog.csdn.net/oman001/article/details/103789156)
	- 多线程和Handler机制源码分析
		- [Android Handler：手把手带你深入分析 Handler机制源码](https://blog.csdn.net/oman001/article/details/103827430)
		- [Android 多线程：AsyncTask的原理及其源码分析](https://blog.csdn.net/oman001/article/details/103838470)
		- [Java线程池讲解，仅此一篇就够了](https://blog.csdn.net/oman001/article/details/79175840)
		- [[Android源码解析] View.post到底干了啥](https://blog.csdn.net/oman001/article/details/103838243)
___
- Android应用层
	- 数据解析和泛型
		- [JSON三种数据解析方法](https://blog.csdn.net/oman001/article/details/79063278)
		- [Java泛型详解](https://blog.csdn.net/oman001/article/details/79052918)
	- Git工具使用
		- [Git的详细使用教程——三部曲](https://blog.csdn.net/oman001/article/details/80208632)
		- [Git详细使用三部曲(二)-进阶篇](https://blog.csdn.net/oman001/article/details/83218423)
	- 开源框架源码分析
		- [EventBus源码分析](https://blog.csdn.net/oman001/article/details/102733835)
	- 网络安全
		- [HTTPS：用故事告诉你我的“前世今生”](https://blog.csdn.net/oman001/article/details/79046486)
	- 性能优化
		- [Android性能优化(一) —— 布局优化](https://blog.csdn.net/oman001/article/details/78925097)
		- [Android性能优化(二)——内存泄漏](https://blog.csdn.net/oman001/article/details/78933642)
	- 事件分发机制
		- [Android事件分发机制源码解析(一)-View的事件分发机制](https://blog.csdn.net/oman001/article/details/76206973)
		- [Android事件分发机制源码解析(二)-ViewGroup的事件分发机制](https://blog.csdn.net/oman001/article/details/76229434)
	- 自定义控件
		- [自定义控件之水波纹效果](https://blog.csdn.net/oman001/article/details/78626804)
	- 动画
		- [Android的Gif动画加载](https://blog.csdn.net/oman001/article/details/77620273)
	- 跨进程通信
		- [Android跨进程(IPC)通信方式详解](https://blog.csdn.net/oman001/article/details/104870483)
	- 其它篇
		- [安卓扫描银行卡获取卡号信息](https://blog.csdn.net/oman001/article/details/77619976)
		- [Android二维码识别技术](Android二维码识别技术)
		- [Android O - java.lang.RuntimeException: An error occurred while executing doInBackground()](https://blog.csdn.net/oman001/article/details/103550495)
		- [DownloaderManager遇到的那些crash坑](https://blog.csdn.net/oman001/article/details/102791573)
		- [沉浸式状态栏底部的黑色矩形框问题](https://blog.csdn.net/oman001/article/details/102791379)
		- [CoordinatorLayout和RecyclerView嵌套滑动冲突解决](https://blog.csdn.net/oman001/article/details/102790469)
		- [Android有效避免程序OOM-图片压缩和三级缓存](https://blog.csdn.net/oman001/article/details/79060006)
___
- Java集合框架
 	- [Java集合框架](https://blog.csdn.net/oman001/article/details/104843676)
	 - [HashMap数据结构](https://blog.csdn.net/oman001/article/details/104752421)
	- [JVM结构和垃圾回收机制](https://blog.csdn.net/oman001/article/details/104782849)
- Java并发知识
	- [线程的实现本质上有几种方式](https://blog.csdn.net/oman001/article/details/105020213)
	- [Java线程的生命周期](https://blog.csdn.net/oman001/article/details/105039294)
	- [生产者消费者模式有哪几种常见的实现方式？](ttps://blog.csdn.net/oman001/article/details/105039303)
	- [wait/notify/notifyAll常见面试题解析](https://blog.csdn.net/oman001/article/details/105102761)
	- [synchronized关键字的几种使用方式比较](https://blog.csdn.net/oman001/article/details/105059069)
	- [volatile关键字的理解](https://blog.csdn.net/oman001/article/details/105020244)
- 设计模式
	- [设计模式——单例模式(创建型模式)](https://blog.csdn.net/oman001/article/details/100176742)
	- [设计模式——抽象工厂模式(创建型模式)](https://blog.csdn.net/oman001/article/details/100176426)
	- [设计模式——工厂方法模式(创建型模式)](https://blog.csdn.net/oman001/article/details/100175278)
	- [设计模式——建造者模式1(创建型模式)](https://blog.csdn.net/oman001/article/details/76026564)
	- [设计模式——建造者模式2(创建型模式)](https://blog.csdn.net/oman001/article/details/76033686)
	- [设计模式——观察者模式](https://blog.csdn.net/oman001/article/details/76056737)
	- [设计模式——装饰者模式](https://blog.csdn.net/oman001/article/details/76066741)
- 算法
	- [Java数组排序-冒泡排序](https://blog.csdn.net/oman001/article/details/76261189)
	- [Java数组排序-选择排序](https://blog.csdn.net/oman001/article/details/76263034)
	- [Java数组排序-插入排序](https://blog.csdn.net/oman001/article/details/76268743)
	- [Java数组-二分查找原理](https://blog.csdn.net/oman001/article/details/76268793)
- 计算机基础
	- [原码，反码，补码和进制的那些事](https://blog.csdn.net/oman001/article/details/104710312)
___
### 面试题
#### Java面试题
- 1 [Java泛型深度解析以及面试题?](https://blog.csdn.net/oman001/article/details/106033391)
	- 什么是泛型？使用泛型的好处？
	- 什么是泛型擦除机制？
	- `List<Object>， List<?>， List<String>，List原始类型 `四者之间的区别？
- 2 [Java注解的理解和应用场景?](https://blog.csdn.net/oman001/article/details/106041869)
- 3 [线程的实现本质上有几种方式?](https://blog.csdn.net/oman001/article/details/105020213)
- 4 [Java线程的生命周期](https://blog.csdn.net/oman001/article/details/105039294)
- 5 [wait/notify/notifyAll常见面试题解析](https://blog.csdn.net/oman001/article/details/105102761)
- 6 [synchronized关键字的几种使用方式比较](https://blog.csdn.net/oman001/article/details/105059069)
- 7 [volatile关键字的理解](https://blog.csdn.net/oman001/article/details/105020244)
- 8 锁分哪几类？
	> ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200521000604448.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L29tYW4wMDE=,size_16,color_FFFFFF,t_70)
- 9 CAS无锁编程的原理？有哪些问题？
	>当前的处理器基本都支持CAS()的指令，只不过每个厂家所实现的算法并不一样，每一个CAS操作过程都包含三个运算符：一个内存地址V，一个期望的值A和一个新值B，操作的时候如果这个地址上存放的值等于这个期望的值A，则将地址上的值赋为新值B，否则不做任何操作。
CAS的基本思路就是，如果这个地址上的值和期望的值相等，则给其赋予新值，否则不做任何事儿，但是要返回原值是多少。循环CAS就是在一个循环里不断的做cas操作，直到成功为止。
问题：1 ABA问题 ； 2 开销问题，长期的自旋不成功就会对CPU有消耗；3 3 只能保证一个共享变量的原子操作
- 10 ReentrantLock的实现原理。
	> 线程可以重复进入任何一个它已经拥有的锁所同步着的代码块，synchronized、ReentrantLock都是可重入的锁。在实现上，就是线程每次获取锁时判定如果获得锁的线程是它自己时，简单将计数器累积即可，每 释放一次锁，进行计数器累减，直到计算器归零，表示线程已经彻底释放锁。底层则是利用了JUC中的AQS来实现的。
- 11 AQS原理
	> 它是用来构建锁或者其他同步组件的基础框架，比如ReentrantLock、ReentrantReadWriteLock和CountDownLatch就是基于AQS实现的。它使用了一个int成员变量表示同步状态，通过内置的FIFO队列来完成资源获取线程的排队工作。它是CLH队列锁的一种变体实现。它可以实现2种同步方式：独占式，共享式。
AQS的主要使用方式是继承，子类通过继承AQS并实现它的抽象方法来管理同步状态，同步器的设计基于模板方法模式，所以如果要实现我们自己的同步工具类就需要覆盖其中几个可重写的方法，如tryAcquire、tryReleaseShared等等。
这样设计的目的是同步组件（比如锁）是面向使用者的，它定义了使用者与同步组件交互的接口（比如可以允许两个线程并行访问），隐藏了实现细节；同步器面向的是锁的实现者，它简化了锁的实现方式，屏蔽了同步状态管理、线程的排队、等待与唤醒等底层操作。这样就很好地隔离了使用者和实现者所需关注的领域。
在内部，AQS维护一个共享资源state，通过内置的FIFO来完成获取资源线程的排队工作。该队列由一个一个的Node结点组成，每个Node结点维护一个prev引用和next引用，分别指向自己的前驱和后继结点，构成一个双端双向链表。
- 12 [生产者消费者模式有哪几种常见的实现方式？](https://blog.csdn.net/oman001/article/details/105039303)
- 13 [Java集合框架](https://blog.csdn.net/oman001/article/details/104843676)
- 14 [HashMap数据结构](https://blog.csdn.net/oman001/article/details/104752421)
- 15 [ConcurrentHashMap的原理](https://mp.weixin.qq.com/s/i8US-ZyiCmVg2e6Wt1DaRw)
- 16 [类加载机制](https://blog.csdn.net/tonytfjing/article/details/47212291)
- 17 [JVM结构和垃圾回收机制](https://blog.csdn.net/oman001/article/details/104782849)
- 18 [I/O流](https://www.cnblogs.com/oubo/archive/2012/01/06/2394638.html)
- 19 应用程序安装流程
- 20 [设计模式的原则和23种设计模式了解](https://blog.csdn.net/oman001/article/details/100176742)
- 21 [四种排序算法](https://blog.csdn.net/oman001/article/details/76261189)
___
#### Android面试题
- 1 Activity生命周期
- 2 Fragment生命周期]
- 3 Android中几种数据存储方式?
- 4 [Android跨进程通信的方式有哪些?](https://blog.csdn.net/oman001/article/details/104870483)
- 5 Android动画
- 6 [Handler机制](https://blog.csdn.net/oman001/article/details/103827430)
- 7 View的绘制流程]
- 8 [View的事件分发机制](https://blog.csdn.net/oman001/article/details/76206973)
- 9 [内存泄漏和性能优化](https://blog.csdn.net/oman001/article/details/78933642)
- 10 [Binder机制](http://liuwangshu.cn/tags/Binder%E5%8E%9F%E7%90%86/)
- 11 SystemServer的启动过程
- 12 主线程的消息循环模型是什么？主线程为什么不会卡死？